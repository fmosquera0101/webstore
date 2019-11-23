package co.com.fredymosquera.webstore.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import co.com.fredymosquera.webstore.domain.Product;

public interface ProductRepository {

	public List<Product> getAllProducts();
	public Product getProductById(String productId);
	public List<Product> getProductByCategory(String category);
	public List<Product> getProductByBrand(String brand);
	public Set<Product> getProductsByFilter(Map<String, List<String>> filters);
	public List<Product> getProductosByManufacturer(String category, Map<String, List<String>> filters,
			String manufacturer);
}
