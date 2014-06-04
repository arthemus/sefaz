package org.sefaz.commons;

/**
 * Representação dos municipios brasileiros e das informações necessárias para
 * cada um deles no sistema da NF-e
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public interface Federacao {

	/**
	 * Descrição ou nome da unidade.
	 * 
	 * @return String
	 */
	String getDescricao();

	/**
	 * Código representativo no sistema da NF-e
	 * 
	 * @return int
	 */
	int getCodigo();

	/**
	 * Código IBGE da unidade.
	 * 
	 * @return int
	 */
	int getIbge();
}
