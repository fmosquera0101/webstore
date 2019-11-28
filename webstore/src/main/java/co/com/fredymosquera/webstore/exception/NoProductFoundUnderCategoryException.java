package co.com.fredymosquera.webstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found uder this category")
public class NoProductFoundUnderCategoryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4861555562500120709L;
	

}
