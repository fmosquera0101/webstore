package co.com.fredymosquera.webstore.repository.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.fredymosquera.webstore.domain.Cart;
import co.com.fredymosquera.webstore.repository.CartItemsRepository;
import co.com.fredymosquera.webstore.repository.CartRepository;

@Repository
public class CartRepositoryImpl implements CartRepository {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	CartItemsRepository cartItemsRepository;
	
	@Override
	public Cart create(Cart cart) {
		Connection conn;
		PreparedStatement ps;
		try {
			conn  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO `webstore`.`cart` (`grandtotal`) VALUES (?)");

			ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			int i = 1;
			ps.setInt(i++, cart.getGrandTotal().intValue());
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int idCart = rs.getInt(1);
				cartItemsRepository.insertCartItems(idCart, cart.geCartItems());
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return cart;
	}

	@Override
	public Cart read(String cartId) {
		Connection conn;
		ResultSet rs;
		PreparedStatement ps;
		Cart cart = null;
		try {
			conn  = dataSource.getConnection();
			String sqlQuery = "SELECT `idcart`, `grandtotal` FROM `webstore`.`cart` WHERE (`idcart` = ?)";
			ps = conn.prepareStatement(sqlQuery.toString());
			int i = 1;
			ps.setString(i++, cartId);
			rs = ps.executeQuery();
			while (rs.next()) {
				cart = new Cart();
				cart.setCartId(cartId);
				cart.setGrandTotal(new BigDecimal(rs.getInt("grandtotal")));
				cart.setCartItems(cartItemsRepository.readCartItems(cartId));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public void update(String cartId, Cart cart) {
		Connection conn;
		PreparedStatement ps;
		try {
			conn  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE `webstore`.`cartitems` SET `productid` = ?, `totalprice` = ? WHERE (`idcartitems` = ?)  ");

			ps = conn.prepareStatement(sql.toString());
			int i = 1;

			//ps.setInt(i++, cart.set);
			ps.setInt(i++, cart.getGrandTotal().intValue());
			ps.setInt(i++, Integer.parseInt(cart.getCartId()));
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

	@Override
	public void delete(String idCart) {
		Connection conn;
		PreparedStatement ps;
		try {
			cartItemsRepository.delete(idCart);
			conn  = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM `webstore`.`cart`  WHERE (`idcart` = ?)  ");
			ps = conn.prepareStatement(sql.toString());
			int i = 1;
			ps.setInt(i++, Integer.parseInt(idCart));
			ps.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
