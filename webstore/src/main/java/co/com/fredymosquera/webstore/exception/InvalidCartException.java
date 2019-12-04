package co.com.fredymosquera.webstore.exception;

public class InvalidCartException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2521527445108192066L;
	
	private String cartId;

	public InvalidCartException(String cartId) {
		super();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}
	
	

}
