package co.com.fredymosquera.webstore.repository;

import co.com.fredymosquera.webstore.domain.Order;

public interface OrderRepository {

	public Long saveOrder(Order order);
}
