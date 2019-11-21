package co.com.fredymosquera.webstore.repository;

import java.util.List;

import co.com.fredymosquera.webstore.domain.Product;

public interface ProductRepository {

	public List<Product> getAllProducts();
	public Product getProductById(String productId);
}
