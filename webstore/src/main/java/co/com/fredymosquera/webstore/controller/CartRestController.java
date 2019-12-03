package co.com.fredymosquera.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.com.fredymosquera.webstore.controller.service.CartService;
import co.com.fredymosquera.webstore.controller.service.ProductService;
import co.com.fredymosquera.webstore.domain.Cart;

@Controller
@RequestMapping("rest/cart")
public class CartRestController {

	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method  = RequestMethod.POST)
	public @ResponseBody  Cart createCart(@RequestBody Cart cart) {
		return cartService.create(cart);
	}
	
	@RequestMapping(value = "/{idCart}", method = RequestMethod.GET)
	public @ResponseBody Cart readCart(@PathVariable (value = "idCart") String idCart) {
		return cartService.read(idCart);
	}
	
	@RequestMapping(value = "/{idCart}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public  void deleteCart(@PathVariable (value = "idCart") String idCart) {
		cartService.delete(idCart);
	}
}
