package org.nfe.certificado;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.SocketFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

/**
 * Classe para registro do certificado digital, encapsulando regras de segurança e acesso. 
 * 
 * {@link http://www.javac.com.br/jc/posts/list/224-resolvendo-o-problema-4037-forbidden-para-certificado-a1-protocolsocketfactory.page}
 * 
 * @author arthemus
 * @since 29/07/2013
 */
public class SocketProtocolFactory implements ProtocolSocketFactory {

	private final X509Certificate certificate;
	private final PrivateKey privateKey;
	private final InputStream fileCacerts;
	
	private SSLContext ssl;	

	public SocketProtocolFactory(X509Certificate certificate, 
			PrivateKey privateKey, InputStream fileCacert) {
		this.certificate = certificate;
		this.privateKey = privateKey;
		this.fileCacerts = fileCacert;
	}

	@Override
	public Socket createSocket(String host, int port, InetAddress localAddress,
			int localPort, HttpConnectionParams params) throws IOException,
			UnknownHostException, ConnectTimeoutException {
		
		if (params == null)
			throw new IllegalArgumentException("Argumento 'params' não pode ser null");
		
		int timeout = params.getConnectionTimeout();
		
		SocketFactory socketfactory;		
		try {
			socketfactory = getSSLContext().getSocketFactory();
		} catch (CertificateException e1) {
			throw new UnknownHostException(e1.getMessage());
		}
		
		if (timeout == 0) 
			return socketfactory.createSocket(host, port, localAddress,	localPort);

		InetSocketAddress localaddr = new InetSocketAddress(localAddress, localPort);		
		InetSocketAddress remoteaddr = new InetSocketAddress(host, port);
		
		Socket socket = socketfactory.createSocket();
		socket.bind(localaddr);		
		try {
			socket.connect(remoteaddr, timeout);
		} catch (Exception e) {			
			throw new ConnectTimeoutException("Possível timeout de conexão.\nTente novamente mais tarde...", e);
		}

		return socket;
	}

	@Override
	public Socket createSocket(String host, int port, InetAddress clientHost, int clientPort) 
			throws IOException, UnknownHostException {
		try {
			return getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);
		} catch (CertificateException e) {
			throw new UnknownHostException(e.getMessage());
		}
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
		try {
			return getSSLContext().getSocketFactory().createSocket(host, port);
		} catch (CertificateException e) {
			throw new UnknownHostException(e.getMessage());
		}
	}
	
	private SSLContext createSSLContext() throws CertificateException {
		try {
			KeyManager[] keyManagers = createKeyManagers();
			TrustManager[] trustManagers = createTrustManagers();
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(keyManagers, trustManagers, null);
			return sslContext;
		} catch (KeyManagementException e) {
			throw new CertificateException("Senha de acesso ao certificado inválida!\n" + e.getMessage());
		} catch (KeyStoreException e) {
			throw new CertificateException("Senha de acesso ao certificado inválida!\n" + e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new CertificateException("Criptografia do certificado inválida!\n" + e.getMessage());
		} catch (CertificateException e) {
			throw new CertificateException("Certificado inválido!\n" + e.getMessage());
		} catch (IOException e) {
			throw new CertificateException("Arquivo do certificado não encontrado!\n" + e.getMessage());
		}
	}

	private SSLContext getSSLContext() throws CertificateException {
		if (ssl == null) 
			ssl = createSSLContext();
		return ssl;
	}

	public Socket createSocket(Socket socket, String host, int port, boolean autoClose) 
			throws IOException, UnknownHostException {
		try {
			return getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);
		} catch (CertificateException e) {
			throw new UnknownHostException(e.getMessage());
		}
	}

	public KeyManager[] createKeyManagers() {
		HSKeyManager keyManager = new HSKeyManager(certificate, privateKey);
		return new KeyManager[] { keyManager };
	}

	public TrustManager[] createTrustManagers() 
			throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		KeyStore trustStore = KeyStore.getInstance("JKS");
		trustStore.load(fileCacerts, "changeit".toCharArray());
		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		trustManagerFactory.init(trustStore);
		return trustManagerFactory.getTrustManagers();
	}
	
	/**
	 * 
	 * @author arthemus
	 * @since 05/08/2013
	 */
	class HSKeyManager implements X509KeyManager {

		private final X509Certificate certificate;
		private final PrivateKey privateKey;

		public HSKeyManager(X509Certificate certificate, PrivateKey privateKey) {
			this.certificate = certificate;
			this.privateKey = privateKey;
		}

		@Override
		public String chooseClientAlias(String[] arg0, Principal[] arg1, Socket arg2) {
			return certificate.getIssuerDN().getName();
		}

		@Override
		public String chooseServerAlias(String arg0, Principal[] arg1, Socket arg2) {
			return null;
		}

		@Override
		public X509Certificate[] getCertificateChain(String arg0) {
			return new X509Certificate[] { certificate };
		}

		@Override
		public String[] getClientAliases(String arg0, Principal[] arg1) {
			return new String[] { certificate.getIssuerDN().getName() };
		}

		@Override
		public PrivateKey getPrivateKey(String arg0) {
			return privateKey;
		}

		@Override
		public String[] getServerAliases(String arg0, Principal[] arg1) {
			return null;
		}
	}
}
