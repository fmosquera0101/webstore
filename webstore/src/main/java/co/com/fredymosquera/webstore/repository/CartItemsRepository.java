package co.com.fredymosquera.webstore.repository;

import java.util.Map;

import co.com.fredymosquera.webstore.domain.CartItem;

public interface CartItemsRepository {

	public int insertCartItems(int idCart, Map<String, CartItem> mapCartItems);
	public Map<String, CartItem> readCartItems(String idCart);
	public void delete(String idCart);
	
}
