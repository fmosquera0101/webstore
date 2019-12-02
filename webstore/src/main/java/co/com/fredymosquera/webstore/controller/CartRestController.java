package co.com.fredymosquera.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
