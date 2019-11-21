package co.com.fredymosquera.webstore.controller.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.fredymosquera.webstore.controller.service.CustomerService;
import co.com.fredymosquera.webstore.domain.Customer;
import co.com.fredymosquera.webstore.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomer();
	}

}
