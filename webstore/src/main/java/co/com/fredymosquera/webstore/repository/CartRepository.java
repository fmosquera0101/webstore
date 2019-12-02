package co.com.fredymosquera.webstore.repository;

import co.com.fredymosquera.webstore.domain.Cart;

public interface CartRepository {

	public Cart create(Cart cart);
	public Cart read(String cartId);
	public void update(String cartId, Cart cart);
	public void delete(String cartId);
	
}
