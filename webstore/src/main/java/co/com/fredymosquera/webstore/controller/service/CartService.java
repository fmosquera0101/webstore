package co.com.fredymosquera.webstore.controller.service;

import co.com.fredymosquera.webstore.domain.Cart;

public interface CartService {

	public Cart create(Cart cart);
	public Cart read(String idCart);
	public void update(String idCart);
	public void delete(String idCart);
}
