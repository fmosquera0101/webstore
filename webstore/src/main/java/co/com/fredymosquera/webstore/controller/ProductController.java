package co.com.fredymosquera.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.fredymosquera.webstore.controller.service.ProductService;
import co.com.fredymosquera.webstore.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		
		return "products";
	}
	
	
}
