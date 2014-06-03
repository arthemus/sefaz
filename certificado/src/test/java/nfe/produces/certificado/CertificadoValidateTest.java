package nfe.produces.certificado;

import java.io.InputStream;
import java.security.cert.CertificateException;

import org.junit.Test;
import org.nfe.certificado.Certificado;
import org.nfe.certificado.CertificadoDigital;
import org.nfe.certificado.CertificadoDigitalLocal;
import org.nfe.certificado.CertificadoValidateException;

/**
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class CertificadoValidateTest {

	@Test(expected = CertificateException.class)
	public void testaUmCertificadoInvalidoPorSenhaIncorreta()
			throws CertificateException, CertificadoValidateException {

		final InputStream pathCertificado = this.getClass().getResourceAsStream("/certificado-invalido.pfx");

		// Senha errada, correta seria 'associacao'
		final String passwordCertificado = "123";

		final InputStream arquivoCacert = this.getClass().getResourceAsStream("/NFeCacerts");

		CertificadoDigital certificado;
		certificado = new CertificadoDigitalLocal(pathCertificado, passwordCertificado, arquivoCacert);
		Certificado.validate(certificado);
	}

	@Test
	public void testaCorretoDoCertificadoDeQualidade()
			throws CertificateException, CertificadoValidateException {

		final InputStream pathCertificado = this.getClass().getResourceAsStream("/certificado-invalido.pfx");
		final String passwordCertificado = "associacao";
		final InputStream arquivoCacert = this.getClass().getResourceAsStream("/NFeCacerts");

		CertificadoDigital certificado;
		certificado = new CertificadoDigitalLocal(pathCertificado, passwordCertificado, arquivoCacert);
		Certificado.validate(certificado);
	}
}
