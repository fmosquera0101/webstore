package co.com.fredymosquera.webstore.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.fredymosquera.webstore.domain.CartItem;
import co.com.fredymosquera.webstore.repository.CartItemsRepository;

@Repository
public class CartItemsImpl implements CartItemsRepository{

	@Autowired
	DataSource dataSource;
	
	
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

}
