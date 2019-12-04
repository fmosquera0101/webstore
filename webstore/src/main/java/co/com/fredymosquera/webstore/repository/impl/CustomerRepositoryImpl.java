package co.com.fredymosquera.webstore.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.fredymosquera.webstore.domain.Customer;
import co.com.fredymosquera.webstore.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

	@Override
	public List<Customer> getAllCustomer() {
		Customer customer = new Customer();
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		return customers;
	}

}
