package co.com.fredymosquera.webstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.fredymosquera.webstore.controller.service.CartService;
import co.com.fredymosquera.webstore.domain.Cart;

@Controller
@RequestMapping( value = "/cart")
public class CartController {
	@Autowired
	CartService cartService;
	@RequestMapping
	public String get(HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Cart cart = new Cart();
		cart.setCartId(sessionId);
		cartService.create(cart);
		return "redirect:/cart/"+sessionId;
	}
	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		return  "cart";
	}

}
