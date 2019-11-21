package co.com.fredymosquera.webstore.repository.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.fredymosquera.webstore.domain.Product;
import co.com.fredymosquera.webstore.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	DataSource dataSource;
	@Override
	public List<Product> getAllProducts() {
		Connection conn;
		ResultSet rs;
		PreparedStatement ps;
		List<Product> products = new ArrayList<>();
		try {
			conn  = dataSource.getConnection();
			ps = conn.prepareStatement(getSelectSqlProductos());
			rs = ps.executeQuery();
			while (rs.next()) {
				Product product = getProduct(rs);
				products.add(product);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	private Product getProduct(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setProductId(String.valueOf(rs.getInt("productId")));
		product.setName(rs.getString("name"));
		product.setUnitPrice(new BigDecimal(rs.getInt("unitPrice")));
		product.setDescription(rs.getString("description"));
		product.setManufacturer(rs.getString("manufacturer"));
		product.setCategory(rs.getString("category"));
		product.setUnitsInStock((long)rs.getInt("unitsInStock"));
		product.setUnitsInOrder((long)rs.getInt("unitsInOrder"));
		product.setDiscontinued(new Boolean(rs.getString("discontinued")));
		return product;
	}
	private String getSelectSqlProductos() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("productId, "); 
		sql.append("name, "); 
		sql.append("unitPrice, "); 
		sql.append("description, "); 
		sql.append("manufacturer, ");
		sql.append("category, "); 
		sql.append("unitsInStock, "); 
		sql.append("unitsInOrder, "); 
		sql.append("discontinued "); 
		sql.append("FROM webstore.products");
		return sql.toString();
	}
	private String getSelectSqlProductsById() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("productId, "); 
		sql.append("name, "); 
		sql.append("unitPrice, "); 
		sql.append("description, "); 
		sql.append("manufacturer, ");
		sql.append("category, "); 
		sql.append("unitsInStock, "); 
		sql.append("unitsInOrder, "); 
		sql.append("discontinued "); 
		sql.append("FROM webstore.products ");
		sql.append("WHERE productId = ?");
		return sql.toString();
	}
	@Override
	public Product getProductById(String productId) {
		Connection conn;
		ResultSet rs;
		PreparedStatement ps;
		Product product = null;
		try {
			conn  = dataSource.getConnection();
			ps = conn.prepareStatement(getSelectSqlProductsById());
			int i = 1;
			ps.setInt(i++, Integer.parseInt(productId));
			rs = ps.executeQuery();
			if (rs.next()) {
				product = getProduct(rs);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

}