package co.com.fredymosquera.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.fredymosquera.webstore.controller.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/1100001/2")
	public String processOrder(Model model){
		orderService.processOrder("1100001", 2);
		return "redirect:/products";
	}

}
