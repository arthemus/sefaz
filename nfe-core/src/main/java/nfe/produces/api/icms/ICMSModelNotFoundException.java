package nfe.produces.api.icms;

/**
 * Exceção quando a classe de ICMS da nota não for identificada.
 * 
 * @author arthemus
 * @since 13/12/2013
 */
public class ICMSModelNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ICMSModelNotFoundException() {
		super();
	}

	public ICMSModelNotFoundException(String message) {
		super(message);
	}

	public ICMSModelNotFoundException(Throwable cause) {
		super(cause);
	}

	public ICMSModelNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
