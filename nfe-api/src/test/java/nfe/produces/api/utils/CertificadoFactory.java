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

	public static CertificadoDigital getCertificadoLocalValido() {
		FileInputStream caminhoDoCertificadoDoCliente = null;
		try {
			caminhoDoCertificadoDoCliente = new FileInputStream(new File("src/test/resources/certificado-valido.pfx"));
		} catch (FileNotFoundException e1) {			
			e1.printStackTrace();
		}
		String senhaDoCertificado = "sigma";
		FileInputStream arquivoCacertsGeradoTodosOsEstados = null;
		try {
			arquivoCacertsGeradoTodosOsEstados = new FileInputStream(new File("src/test/resources/NFeCacerts"));
		} catch (FileNotFoundException e1) {		
			e1.printStackTrace();
		}		
		CertificadoDigitalLocal certificado = null;
		try {
			certificado = new CertificadoDigitalLocal(caminhoDoCertificadoDoCliente, senhaDoCertificado, arquivoCacertsGeradoTodosOsEstados);
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
		String senhaDoCertificado = "associacao";
		FileInputStream arquivoCacertsGeradoTodosOsEstados = null;
		try {
			arquivoCacertsGeradoTodosOsEstados = new FileInputStream(new File("src/test/resources/NFeCacerts"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}				
		CertificadoDigitalLocal certificado = null;
		try {
			certificado = new CertificadoDigitalLocal(caminhoDoCertificadoDoCliente, senhaDoCertificado, arquivoCacertsGeradoTodosOsEstados);
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
		String senhaDoCertificado = "123";
		FileInputStream arquivoCacertsGeradoTodosOsEstados = null;
		try {
			arquivoCacertsGeradoTodosOsEstados = new FileInputStream(new File("src/test/resources/NFeCacerts"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}		
		CertificadoDigitalLocal certificado = null;
		try {
			certificado = new CertificadoDigitalLocal(caminhoDoCertificadoDoCliente, senhaDoCertificado, arquivoCacertsGeradoTodosOsEstados);
		} catch (CertificateException e) {
			e.printStackTrace();
		}
		return certificado;
	}
}
