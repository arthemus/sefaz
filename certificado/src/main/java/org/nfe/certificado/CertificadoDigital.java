package org.nfe.certificado;

import java.io.IOException;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Dados necessários para validar um certificado digital.
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public interface CertificadoDigital {

	/**
	 * 
	 * @return
	 */
	X509Certificate getCertificate() throws CertificateException;

	/**
	 * 
	 * @return
	 */
	PrivateKey getPrivateKey() throws CertificateException;;

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	InputStream getArquivoCavert();
}
