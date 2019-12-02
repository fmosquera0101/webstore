package co.com.fredymosquera.webstore.domain;

import java.math.BigDecimal;

public class CartItem {

	private Product product;
	private int quantity;
	private BigDecimal totalPrice;
	
	public CartItem() {
		
	}
	public CartItem(Product product) {
		super();
		this.product = product;
		this.quantity = 1;
		this.totalPrice = product.getUnitPrice();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
