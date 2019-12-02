package co.com.fredymosquera.webstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import co.com.fredymosquera.webstore.controller.service.ProductService;
import co.com.fredymosquera.webstore.domain.Product;
import co.com.fredymosquera.webstore.exception.NoProductFoundException;
import co.com.fredymosquera.webstore.exception.NoProductFoundUnderCategoryException;

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
		List<Product> products = productService.getProductByCategory(category);
		if(null == products || products.isEmpty()) {
			throw new NoProductFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
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
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProdcutForm(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model, HttpServletRequest request) {
		String[] suppressedFields = bindingResult.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: ");
		}
		
		if(bindingResult.hasErrors()) {
			return "addProduct";
		}
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory+"resources//images//product.png"));
			} catch (IOException e) {
				throw new RuntimeException("Product Image failed", e);
			}
		}
		productService.addProduct(product);
		return "redirect:/products";
	}
	
	@InitBinder
	public void initialsBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	
	@ExceptionHandler(NoProductFoundException.class)
	public ModelAndView errorHandler(HttpServletRequest request, NoProductFoundException noProductFoundException) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", noProductFoundException.getMessage());
		modelAndView.addObject("exception", noProductFoundException);
		modelAndView.addObject("url", request.getRequestURL()+"?"+request.getQueryString());
		modelAndView.setViewName("productNotFound");
		return modelAndView;
		
	}
	
	
}
