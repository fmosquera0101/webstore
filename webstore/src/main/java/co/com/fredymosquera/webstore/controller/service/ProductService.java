package co.com.fredymosquera.webstore.controller.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import co.com.fredymosquera.webstore.domain.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	public List<Product> getProductByCategory(String category);
	public Set<Product> getProductsByFilter(Map<String, List<String>> filters);
	public Product getProductById(String id);
}
