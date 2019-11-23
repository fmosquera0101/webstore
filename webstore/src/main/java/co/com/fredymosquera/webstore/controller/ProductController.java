package co.com.fredymosquera.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.fredymosquera.webstore.controller.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		
		return "products";
	}
	
	@RequestMapping("/all")
	public String all(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		
		return "products";
	}
	
	@RequestMapping("/{category}")
	public String getProductByCategory(Model model, @PathVariable("category") String category) {
		model.addAttribute("products", productService.getProductByCategory(category));
		return "products";
	}
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filters, Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filters));
		return "products";
	}
	
	@RequestMapping("product")
	public String getProductById(@RequestParam("id") String id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "product";
	}
	
	@RequestMapping("/{category}/{price}")
	public String getProductosByManufacturer(@PathVariable("category") String category, @MatrixVariable (pathVar = "price") Map<String, List<String>> filters,
			@RequestParam("manufacturer") String manufacturer, Model model) {
		model.addAttribute("products", productService.getProductosByManufacturer(category, filters, manufacturer));
		
		return "products";
	}
	
	
}
