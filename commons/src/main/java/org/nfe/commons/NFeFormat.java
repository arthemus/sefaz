package org.nfe.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author arthemus
 * @since 07/08/2013
 */
public enum NFeFormat {

	DATA("yyyy-MM-dd"),

	HORA("HH:mm:ss");

	private SimpleDateFormat simpleFormat;

	private NFeFormat(String formato) {
		this.simpleFormat = new SimpleDateFormat(formato);
	}

	public Date get(String data) {
		try {
			return simpleFormat.parse(data);
		} catch (ParseException e) {
			return null;
		}
	}
}
