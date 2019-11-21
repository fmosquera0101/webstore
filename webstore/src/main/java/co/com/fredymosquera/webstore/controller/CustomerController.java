package co.com.fredymosquera.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.fredymosquera.webstore.controller.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customers")
	public String getAllCustomer(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
}
