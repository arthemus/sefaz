package org.sefaz.commons.run;

import java.text.Normalizer;
import java.util.Scanner;

import org.sefaz.commons.Pais;

/**
 * Utilitário para gerar os dados da classe Enum {@link Pais}, imprimindo os dados dela no console.
 * 
 * @author arthemus
 * @since 02/08/2013 
 * @see Pais
 */
public class GeraClassePaisMain {

	private static Scanner scan;

	public static void main(String[] args) {		
		scan = new Scanner(GeraClassePaisMain.class.getResourceAsStream("/paises.txt"));			
		while (scan.hasNext()) {
			String item = scan.nextLine();			
			String novo = Normalizer.normalize(item, Normalizer.Form.NFD);  
			novo = novo.replaceAll("[^\\p{ASCII}]", "");
			System.out.println(novo.substring(5)
					.toUpperCase()
					.replaceAll("[^0-9A-Za-z\" \"]", "")
					.replace(" ", "_") 
					+ "(\"" + novo.substring(0, 4) + "\"," 
					+ " \"" + novo.substring(5).replaceAll(",", "") + "\"),");				
		}		
	}
}
