package org.sefaz.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Formatos de conversão encontrados nos arquivos XML.
 * 
 * @author arthemus
 * @since 07/08/2013
 */
public enum SefazDataFormat {

	DATA("yyyy-MM-dd"),

	HORA("HH:mm:ss");

	private SimpleDateFormat simpleFormat;

	SefazDataFormat(String formato) {
		this.simpleFormat = new SimpleDateFormat(formato);
	}

	public Date get(String valor) {
		try {
			return simpleFormat.parse(valor);
		} catch (ParseException e) {
			return null;
		}
	}
}
