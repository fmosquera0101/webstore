package co.com.fredymosquera.webstore.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String cartId;
	private Map<String, CartItem> cartItems;
	private BigDecimal grandTotal;
	
	public Cart(String cartId, Map<String, CartItem> mapCartItems, BigDecimal grandTotal) {
		super();
		this.cartId = cartId;
		this.cartItems = mapCartItems;
		this.grandTotal = grandTotal;
	}
	public Cart() {
		super();
		this.cartItems = new HashMap<>();
		this.grandTotal = new BigDecimal(0);
	}
	public Cart(String cartId) {
		super();
		this.cartId = cartId;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public Map<String, CartItem> geCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<String, CartItem> mapCartItems) {
		this.cartItems = mapCartItems;
	}
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}
	public void addCartItem(CartItem item) {
		String productIdString = item.getProduct().getProductId();
		if(cartItems.containsKey(productIdString)) {
			CartItem existingCartItem = cartItems.get(productIdString);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(productIdString, existingCartItem);
		}else {
			cartItems.put(productIdString, item);
		}
		updateGrandTotal();
		
	}
	public void removeCartItem(CartItem item) {
		String productIdString = item.getProduct().getProductId();
		cartItems.remove(productIdString);
		updateGrandTotal();
	}
	private void updateGrandTotal() {
		grandTotal = new BigDecimal(0);
		for (CartItem item : cartItems.values()) {
			grandTotal = grandTotal.add(item.getTotalPrice());
			
		}
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((grandTotal == null) ? 0 : grandTotal.hashCode());
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (grandTotal == null) {
			if (other.grandTotal != null)
				return false;
		} else if (!grandTotal.equals(other.grandTotal))
			return false;
		if (cartItems == null) {
			if (other.cartItems != null)
				return false;
		} else if (!cartItems.equals(other.cartItems))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItems=" + cartItems + ", grandTotal=" + grandTotal + "]";
	}
	
	
	
	
}
