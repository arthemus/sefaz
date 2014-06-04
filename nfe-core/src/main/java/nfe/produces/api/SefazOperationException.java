package nfe.produces.api;

/**
 * Exceção padrão para problemas durante uma execução da Sefaz ou erro
 * relacionado a nota fiscal eletrônica.
 * 
 * @author arthemus
 * @since 05/08/2013
 */
public class SefazOperationException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String ERROR_DEFAULT = "Problemas durante a execução de um serviço da Sefaz!\nAnálise a mensagem de erro e se necessário, entre em contato com a equipe de Suporte da Softland Sistemas.\nErro: ";
	
	public SefazOperationException() {
		super();
	}

	public SefazOperationException(String message) {
		super(ERROR_DEFAULT + message);
	}
}
