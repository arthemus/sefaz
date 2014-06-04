package org.sefaz.certificado.run;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

/**
 * {@link http://www.javac.com.br/jc/posts/list/276-nfe-cte-verificando-a-validade-dos-certificados-digitais-a1.page}
 * 
 * @author arthemus
 * 
 */
class ExibiInformacoesCertificadoDigitalA1DefinidoMain {

	static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {
		try {
			String caminhoDoCertificadoDoCliente = "src/test/resources/certificado-invalido.pfx";
			String senhaDoCertificado = "associacao";
			KeyStore keystore = KeyStore.getInstance(("PKCS12"));
			keystore.load(new FileInputStream(caminhoDoCertificadoDoCliente), senhaDoCertificado.toCharArray());
			Enumeration<String> eAliases = keystore.aliases();
			while (eAliases.hasMoreElements()) {
				String alias = eAliases.nextElement();
				Certificate certificado = keystore.getCertificate(alias);
				info("Aliais: " + alias);
				X509Certificate cert = (X509Certificate) certificado;
				info(cert.getSubjectDN().getName());
				info("Válido a partir de..: " + dateFormat.format(cert.getNotBefore()));
				info("Válido até..........: " + dateFormat.format(cert.getNotAfter()));
			}
		} catch (Exception e) {
			error(e.toString());
		}
	}

	/**
	 * Error.
	 * 
	 * @param log
	 */
	private static void error(String log) {
		System.out.println("ERROR: " + log);
	}

	/**
	 * Info
	 * 
	 * @param log
	 */
	private static void info(String log) {
		System.out.println("INFO: " + log);
	}
}
