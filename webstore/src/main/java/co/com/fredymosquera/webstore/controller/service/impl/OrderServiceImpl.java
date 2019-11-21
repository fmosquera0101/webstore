package co.com.fredymosquera.webstore.controller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.fredymosquera.webstore.controller.service.OrderService;
import co.com.fredymosquera.webstore.domain.Product;
import co.com.fredymosquera.webstore.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductRepository productRepository;
	@Override
	public void processOrder(String productId, int quantity) {
		Product product = productRepository.getProductById(productId);
		if(product.getUnitsInStock() < quantity){
			throw new IllegalArgumentException("Out of Stock. Available Unitsin stock"+ product.getUnitsInStock());
		}
		product.setUnitsInStock(product.getUnitsInStock() - quantity);
	}

}
