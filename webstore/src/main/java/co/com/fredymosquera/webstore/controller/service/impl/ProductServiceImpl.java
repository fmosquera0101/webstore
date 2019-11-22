package co.com.fredymosquera.webstore.controller.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

	@Override
	public List<Product> getProductByCategory(String category) {
		return productRepository.getProductByCategory(category);
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filters) {
		return productRepository.getProductsByFilter(filters);
	}

	@Override
	public Product getProductById(String id) {
		return productRepository.getProductById(id);
	}

}
