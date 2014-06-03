package org.nfe.commons;

/**
 * Ambientes disponiveis na Sefaz em tempo de execução do sistema.
 * 
 * @author arthemus
 * @since 02/08/2013
 */
public enum Ambiente {

	HOMOLOGACAO("2"), PRODUCAO("1");

	private final String codigo;

	private Ambiente(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

}
