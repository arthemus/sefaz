package org.sefaz.certificado;

import java.security.cert.CertificateException;

import org.apache.commons.httpclient.protocol.Protocol;

/**
 * Utilitários estáticos utilizar ao manusear um Certificado.
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class Certificado {

	/**
	 * Valida um certificado já instanciado.
	 * 
	 * @param certificadoDigital
	 * @throws CertificadoValidateException
	 * 		Caso o certificado esteja inválido, uma exceção será lançada.
	 */
	public static void validate(CertificadoDigital certificadoDigital)
			throws CertificadoValidateException {
		try {
			SocketProtocolFactory socketFactoryLocal = 
					new SocketProtocolFactory(
							certificadoDigital.getCertificate(), 
							certificadoDigital.getPrivateKey(), 
							certificadoDigital.getArquivoCacert());			
			Protocol protocol = new Protocol("https", socketFactoryLocal, 443);
			Protocol.registerProtocol("https", protocol);			
		} catch (CertificateException e) {
			throw new CertificadoValidateException(e.getMessage());
		}
	}
	
}
