package co.com.fredymosquera.webstore.exception;



public class NoProductFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5943122894879846621L;
	
	private String message;

	public NoProductFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
