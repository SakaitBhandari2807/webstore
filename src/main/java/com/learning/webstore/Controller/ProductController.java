package com.learning.webstore.Controller;

import com.learning.webstore.domain.repository.ProductRepository;
import com.learning.webstore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStocks();
		return "redirect:/products";
	}
}
