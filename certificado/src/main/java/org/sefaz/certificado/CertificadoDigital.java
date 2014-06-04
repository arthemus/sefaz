package org.sefaz.certificado;

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
	 * Chave de acesso ao certificado.
	 * 
	 * @return
	 */
	PrivateKey getPrivateKey() throws CertificateException;;

	/**
	 * Instancia do arquivo {@link NFeCacerts} encontrado no diretório resouces
	 * do projeto.
	 * 
	 * @return
	 * @throws IOException
	 */
	InputStream getArquivoCacert();
}
