package org.sefaz.certificado.run;

import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

/**
 * {@link http://www.javac.com.br/jc/posts/list/915-dados-do-certificado-digital-a1-e-a3-repositorio-do-windows.page}
 * 
 * @author arthemus
 * 
 */
class ExibeDadosCertificadosDigitaisLocaisMain {

	static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {
		try {
			KeyStore keyStore = KeyStore.getInstance("Windows-MY", "SunMSCAPI");
			keyStore.load(null, null);
			Enumeration<String> al = keyStore.aliases();
			if (!al.hasMoreElements()) {
				info("Nenhum certificado instalado.");
				return;
			}	
			while (al.hasMoreElements()) {
				String alias = al.nextElement();
				info("--------------------------------------------------------");
				if (keyStore.containsAlias(alias)) {
					info("Emitido para........: " + alias);

					X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
					info("SubjectDN...........: " + cert.getSubjectDN().toString());
					info("Version.............: " + cert.getVersion());
					info("SerialNumber........: " + cert.getSerialNumber());
					info("SigAlgName..........: " + cert.getSigAlgName());
					info("Válido a partir de..: " + dateFormat.format(cert.getNotBefore()));
					info("Válido até..........: " + dateFormat.format(cert.getNotAfter()));
				} else {
					info("Alias doesn't exists : " + alias);
				}
			}
		} catch (Exception e) {
			error(e.toString());
		}
	}

	/**
	 * Info.
	 * 
	 * @param log
	 */
	private static void info(String log) {
		System.out.println("INFO: " + log);
	}

	/**
	 * Error.
	 * 
	 * @param log
	 */
	private static void error(String log) {
		System.out.println("ERROR: " + log);
	}
}
