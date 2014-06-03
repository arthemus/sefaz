package org.nfe.certificado;

import java.security.cert.CertificateException;

import org.apache.commons.httpclient.protocol.Protocol;

/**
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class Certificado {

	/**
	 * 
	 * @param certificadoDigital
	 * @throws CertificadoValidateException
	 */
	public static void validate(CertificadoDigital certificadoDigital)
			throws CertificadoValidateException {

		try {
			SocketProtocolFactory socketFactoryLocal = 
					new SocketProtocolFactory(
							certificadoDigital.getCertificate(), 
							certificadoDigital.getPrivateKey(), 
							certificadoDigital.getArquivoCavert());
			
			Protocol protocol = new Protocol("https", socketFactoryLocal, 443);
			Protocol.registerProtocol("https", protocol);
			
		} catch (CertificateException e) {
			throw new CertificadoValidateException(e.getMessage());
		}	
	}
}
