package co.com.fredymosquera.webstore.controller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.fredymosquera.webstore.controller.service.CartService;
import co.com.fredymosquera.webstore.domain.Cart;
import co.com.fredymosquera.webstore.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart create(Cart Cart) {
		return cartRepository.create(Cart);
	}

	@Override
	public Cart read(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String cartId, Cart cart) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String cartId) {
		// TODO Auto-generated method stub

	}

}
