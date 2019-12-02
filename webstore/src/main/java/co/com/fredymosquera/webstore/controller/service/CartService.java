package co.com.fredymosquera.webstore.controller.service;

import org.springframework.stereotype.Service;

import co.com.fredymosquera.webstore.domain.Cart;

public interface CartService {

	public Cart create(Cart cart);
	public Cart read(String cartId);
	public void update(String cartId, Cart cart);
	public void delete(String cartId);
}
