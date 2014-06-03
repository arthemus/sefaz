package org.nfe.certificado;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class CertificadoDigitalLocal implements CertificadoDigital {

	private final String senhaCertificado;
	private final InputStream arquivoCacert;
	
	private KeyStore ks;
	private String alias;

	public CertificadoDigitalLocal(InputStream arquivoCertificado, 
			String senhaCertificado, InputStream arquivoCacert) 
					throws CertificateException {		
		this.senhaCertificado = senhaCertificado;
		this.arquivoCacert = arquivoCacert;		
		buildKeys(arquivoCertificado, senhaCertificado);
	}

	private void buildKeys(InputStream arquivoCertificado, String senhaCertificado) 
			throws CertificateException {		
		try {				
			ks = KeyStore.getInstance("pkcs12");
			ks.load(arquivoCertificado, senhaCertificado.toCharArray());						
			Enumeration<String> aliasesEnum = ks.aliases();
			while (aliasesEnum.hasMoreElements()) {
				alias = aliasesEnum.nextElement();
				if (ks.isKeyEntry(alias))
					break;
			}		
		} catch (FileNotFoundException e) {
			throw new CertificateException("Arquivo de certificado não encontrado.\nErro: " + e.getMessage()); 
		} catch (KeyStoreException e) {
			throw new CertificateException("Senha do certificado inválida!\nErro: " + e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new CertificateException("Algoritimo de criptografia utilizado para o certificado não é válido.\nErro: " + e.getMessage());
		} catch (IOException e) {
			throw new CertificateException("Certificado inválido ou senha de acesso incorreta.\nErro: " + e.getMessage());
		}
	}

	@Override
	public X509Certificate getCertificate() throws CertificateException {
		try {
			return  (X509Certificate) ks.getCertificate(alias);
		} catch (KeyStoreException e) {
			throw new CertificateException("Problemas para gerar a chave de acesso do certificado.\n" + e.getMessage());
		}
	}

	@Override
	public PrivateKey getPrivateKey() throws CertificateException {
		try {
			return (PrivateKey) ks.getKey(alias, senhaCertificado.toCharArray());
		} catch (UnrecoverableKeyException e) {
			throw new CertificateException("Problemas para gerar a chave de acesso do certificado.\n" + e.getMessage());
		} catch (KeyStoreException e) {
			throw new CertificateException("Problemas para gerar a chave de acesso do certificado.\n" + e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new CertificateException("Problemas para gerar a chave de acesso do certificado.\n" + e.getMessage());
		}
	}

	@Override
	public InputStream getArquivoCavert() {
		return arquivoCacert;
	}

}
