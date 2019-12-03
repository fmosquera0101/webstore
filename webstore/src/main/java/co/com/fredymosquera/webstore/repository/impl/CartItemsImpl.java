package co.com.fredymosquera.webstore.repository.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.fredymosquera.webstore.domain.CartItem;
import co.com.fredymosquera.webstore.domain.Product;
import co.com.fredymosquera.webstore.repository.CartItemsRepository;
import co.com.fredymosquera.webstore.repository.ProductRepository;

@Repository
public class CartItemsImpl implements CartItemsRepository{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public int insertCartItems(int idCart, Map<String, CartItem> mapCartItems) {
		
		Connection conn;
		PreparedStatement ps;
		try {
			conn  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO `webstore`.`cartitems` (`idcart`, `productid`, `quantity`, `totalprice`) VALUES (?, ?, ?, ?)");

			ps = conn.prepareStatement(sql.toString());
			int i = 1;
			for (CartItem cartItem : mapCartItems.values()) {
				ps.setInt(i++, idCart);
				ps.setInt(i++, Integer.parseInt(cartItem.getProduct().getProductId()));
				ps.setInt(i++, cartItem.getQuantity());
				ps.setInt(i++, cartItem.getTotalPrice().intValue());
				ps.executeUpdate();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return 0;
		
	}


	@Override
	public Map<String, CartItem> readCartItems(String idCart) {

		
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		Map<String, CartItem> cartItems = new HashMap<>();
		try {
			conn  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ci.idcart , ci.idcartitems, ci.productid, ci.quantity, ci.totalprice FROM webstore.cartitems ci WHERE  ci.idcart = ?");

			ps = conn.prepareStatement(sql.toString());
			int i =1;
			ps.setInt(i++, Integer.parseInt(idCart));
			rs = ps.executeQuery();
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setQuantity(rs.getInt("ci.quantity"));
				Product product = productRepository.getProductById(rs.getString("ci.productid"));
				cartItem.setProduct(product);
				cartItem.setTotalPrice(new BigDecimal(rs.getInt("ci.quantity")));
				cartItems.put(product.getProductId(), cartItem);
				
			}

			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return cartItems;
		
	
	}


	@Override
	public void delete(String idCart) {

		Connection conn;
		PreparedStatement ps;
		try {
			conn  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM `webstore`.`cartitems`  WHERE (`idcart` = ?)  ");

			ps = conn.prepareStatement(sql.toString());
			int i = 1;
			ps.setInt(i++, Integer.parseInt(idCart));
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
		
	}

}
