package nfe.produces.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.cert.CertificateException;

import org.nfe.certificado.CertificadoDigital;
import org.nfe.certificado.CertificadoDigitalLocal;

/**
 * 
 * @author arthemus
 * @since 06/08/2013
 */
public class CertificadoFactory {

	private static final String SENHA_VALIDA = "sigma";
	private static final String SENHA_INVALIDA = "associacao";

	public static CertificadoDigital getCertificadoLocalValido() {
		FileInputStream caminhoDoCertificadoDoCliente = null;
		try {
			caminhoDoCertificadoDoCliente = new FileInputStream(new File("src/test/resources/certificado-valido.pfx"));
		} catch (FileNotFoundException e1) {			
			e1.printStackTrace();
		}		
		FileInputStream arquivoCacertsGeradoTodosOsEstados = null;
		try {
			arquivoCacertsGeradoTodosOsEstados = new FileInputStream(new File("src/test/resources/NFeCacerts"));
		} catch (FileNotFoundException e1) {		
			e1.printStackTrace();
		}		
		CertificadoDigitalLocal certificado = null;
		try {
			certificado = new CertificadoDigitalLocal(caminhoDoCertificadoDoCliente, SENHA_VALIDA, arquivoCacertsGeradoTodosOsEstados);
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return certificado;
	}
	
	public static CertificadoDigital getCertificadoLocalInvalido() {
		FileInputStream caminhoDoCertificadoDoCliente = null;
		try {
			caminhoDoCertificadoDoCliente = new FileInputStream(new File("src/test/resources/certificado-invalido.pfx"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}		
		FileInputStream arquivoCacertsGeradoTodosOsEstados = null;
		try {
			arquivoCacertsGeradoTodosOsEstados = new FileInputStream(new File("src/test/resources/NFeCacerts"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}				
		CertificadoDigitalLocal certificado = null;
		try {
			certificado = new CertificadoDigitalLocal(caminhoDoCertificadoDoCliente, SENHA_INVALIDA, arquivoCacertsGeradoTodosOsEstados);
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return certificado;
	}
	
	public static CertificadoDigital getCertificadoLocalComSenhaErrada() {
		FileInputStream caminhoDoCertificadoDoCliente = null;
		try {
			caminhoDoCertificadoDoCliente = new FileInputStream(new File("src/test/resources/certificado-invalido.pfx"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String senhaErradaDoCertificado = "123";
		FileInputStream arquivoCacertsGeradoTodosOsEstados = null;
		try {
			arquivoCacertsGeradoTodosOsEstados = new FileInputStream(new File("src/test/resources/NFeCacerts"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}		
		CertificadoDigitalLocal certificado = null;
		try {
			certificado = new CertificadoDigitalLocal(caminhoDoCertificadoDoCliente, senhaErradaDoCertificado, arquivoCacertsGeradoTodosOsEstados);
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return certificado;
	}
}
