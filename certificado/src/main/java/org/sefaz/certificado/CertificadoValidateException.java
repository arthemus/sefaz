package org.sefaz.certificado;

/**
 * Exceção para a criação e validação de Certificados Digitais.
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class CertificadoValidateException extends Exception {

	private static final long serialVersionUID = 1L;

	public CertificadoValidateException() {
		super();
	}

	public CertificadoValidateException(final String message) {
		super(message);
	}
}
