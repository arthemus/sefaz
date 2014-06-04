package org.sefaz.certificado;

import java.io.InputStream;
import java.security.cert.CertificateException;

import org.junit.Before;
import org.junit.Test;
import org.sefaz.certificado.Certificado;
import org.sefaz.certificado.CertificadoDigital;
import org.sefaz.certificado.CertificadoValidateException;
import org.sefaz.certificado.DefaultCertificadoDigital;

/**
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class CertificadoValidateTest {

	private InputStream arquivoCacert;

	@Before
	public void setUp() {
		this.arquivoCacert = this.getClass().getResourceAsStream("/NFeCacerts");
	}
	
	@Test(expected = CertificateException.class)
	public void testaUmCertificadoInvalidoComSenhaIncorreta()
			throws CertificateException, CertificadoValidateException {

		InputStream pathCertificado = this.getClass().getResourceAsStream("/certificado-invalido.pfx");

		// Senha errada, correta seria 'associacao'
		String passwordCertificado = "123";
		
		CertificadoDigital certificado;
		certificado = new DefaultCertificadoDigital(pathCertificado, passwordCertificado, arquivoCacert);
		
		Certificado.validate(certificado);
	}

	@Test
	public void testaCorretoDoCertificadoDeQualidade()
			throws CertificateException, CertificadoValidateException {

		InputStream pathCertificado = this.getClass().getResourceAsStream("/certificado-invalido.pfx");
		
		String passwordCertificado = "associacao";

		CertificadoDigital certificado;
		certificado = new DefaultCertificadoDigital(pathCertificado, passwordCertificado, arquivoCacert);
		
		Certificado.validate(certificado);
	}
	
}
