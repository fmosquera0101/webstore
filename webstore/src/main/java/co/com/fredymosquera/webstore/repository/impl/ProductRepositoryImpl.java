package co.com.fredymosquera.webstore.repository.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.fredymosquera.webstore.domain.Product;
import co.com.fredymosquera.webstore.exception.NoProductFoundException;
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
	private String getSelectSqlProductsByCategory() {
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
		sql.append("WHERE category = ?");
		return sql.toString();
	}
	private String getSelectSqlProductsByBrand() {
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
		sql.append("WHERE manufacturer = ?");
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
		if(null == product) {
			throw new NoProductFoundException("No product found with the productId: "+productId);
		}
		return product;
	}
	@Override
	public List<Product> getProductByCategory(String category) {
		Connection conn;
		ResultSet rs;
		PreparedStatement ps;
		List<Product> products = new ArrayList<>();
		try {
			conn  = dataSource.getConnection();
			ps = conn.prepareStatement(getSelectSqlProductsByCategory());
			int i = 1;
			ps.setString(i++, category);
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
	@Override
	public List<Product> getProductByBrand(String brand) {
		Connection conn;
		ResultSet rs;
		PreparedStatement ps;
		List<Product> products = new ArrayList<>();
		try {
			conn  = dataSource.getConnection();
			ps = conn.prepareStatement(getSelectSqlProductsByBrand());
			int i = 1;
			ps.setString(i++, brand);
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
	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filters) {
		Set<String> criteria = filters.keySet();
		Set<Product> products = new HashSet<>();
		if(criteria.contains("brand")) {
			for (String brand : filters.get("brand")) {
				products.addAll(getProductByBrand(brand));
			}
		
		}
		if(criteria.contains("category")) {
			for (String category : filters.get("category")) {
				products.addAll(getProductByCategory(category));
			}
		}
		return products;
	}
	@Override
	public List<Product> getProductosByManufacturer(String category, Map<String, List<String>> filters,
			String manufacturer) {
		Connection conn;
		ResultSet rs;
		PreparedStatement ps;
		List<Product> products = new ArrayList<>();
		try {
			
			conn  = dataSource.getConnection();
			
			
			Set<String> criteria = filters.keySet();
			String priceLow = null;
			String priceHigh = null;
			if(criteria.contains("low")) {
				priceLow = filters.get("low").get(0);
			}
			if(criteria.contains("high")) {
				priceHigh = filters.get("high").get(0);
			}
		
			
			
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
			sql.append("WHERE category = ? and manufacturer = ? ");
			
			if(StringUtils.isNotEmpty(priceLow) && StringUtils.isNotEmpty(priceHigh)) {
				sql.append("and unitPrice >= ? and unitPrice <= ? ");
			}else if(StringUtils.isNotEmpty(priceLow) && StringUtils.isEmpty(priceHigh)) {
				sql.append("and unitPrice <= ?");
			}else if(StringUtils.isEmpty(priceLow) && StringUtils.isNotEmpty(priceHigh)) {
				sql.append("and unitPrice >= ?");
			}
			
			ps = conn.prepareStatement(sql.toString());
			
			
			int i = 1;
			ps.setString(i++, category);
			ps.setString(i++, manufacturer);
			
			if(StringUtils.isNotEmpty(priceLow) && StringUtils.isNotEmpty(priceHigh)) {
				ps.setInt(i++, Integer.parseInt(priceLow));
				ps.setInt(i++, Integer.parseInt(priceHigh));
			}else if(StringUtils.isNotEmpty(priceLow) && StringUtils.isEmpty(priceHigh)) {
				ps.setInt(i++, Integer.parseInt(priceLow));
			}else if(StringUtils.isEmpty(priceLow) && StringUtils.isNotEmpty(priceHigh)) {
				ps.setInt(i++, Integer.parseInt(priceHigh));
			}
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
	@Override
	public int addProduct(Product product) {
		Connection conn;
		PreparedStatement ps;
		try {
			conn  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO ");
			sql.append("`webstore`.`products` ");
			sql.append("(`name`, ");
			sql.append("`unitPrice`, ");
			sql.append("`description`, ");
			sql.append("`manufacturer`, ");
			sql.append("`category`, ");
			sql.append("`unitsInStock`)");
			sql.append("VALUES (?, ?, ?, ?, ?, ?)");
			ps = conn.prepareStatement(sql.toString());
			int i = 1;
			ps.setString(i++, product.getName());
			ps.setInt(i++, product.getUnitPrice().intValue());
			ps.setString(i++, product.getDescription());
			ps.setString(i++, product.getManufacturer());
			ps.setString(i++, product.getCategory());
			ps.setInt(i++, (int)product.getUnitsInStock());
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return 0;
	}

}
