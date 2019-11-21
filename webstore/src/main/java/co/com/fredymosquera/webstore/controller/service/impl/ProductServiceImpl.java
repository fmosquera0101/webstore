package co.com.fredymosquera.webstore.controller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.fredymosquera.webstore.controller.service.ProductService;
import co.com.fredymosquera.webstore.domain.Product;
import co.com.fredymosquera.webstore.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

}
