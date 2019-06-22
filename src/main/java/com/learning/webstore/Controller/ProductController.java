package com.learning.webstore.Controller;


import com.learning.webstore.domain.Product;
import com.learning.webstore.service.ProductService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("market")
class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@InitBinder
	public void InitialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId","productName","unitPrice","description","manufacturer","category","unitsInStock","condition");
	}
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStocks();
		return "redirect:/market/products";
	}
	
	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model,
			@PathVariable("category") String productCategory) {
		model.addAttribute("products",productService.getAllProductsByCategory(productCategory));
		return "products";
	}
	
	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(@MatrixVariable(pathVar="params") Map<String,
			List<String>> filterParams,Model model) {
		model.addAttribute("products",productService.getProductsByFilter(filterParams));
		return "products";
	}
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId,Model model) {
		model.addAttribute("product",productService.getProductById(productId));
		return "product";
	}
	
	@RequestMapping("/products/{category}/{price}")
	public String getProductByAllCriteria(Model model,
			@PathVariable("category") String category,
			@MatrixVariable(pathVar="price") Map<String,List<String>> params,
			@RequestParam("brand") String brandName) {
//		System.out.println("params"+params);
		model.addAttribute("products",productService.getProductByCriteria(category,params,brandName));
		return "products";
	}
	
	@RequestMapping(value="/products/add",method=RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("newProduct",product);
		return "addProduct";
	}
	
	@RequestMapping(value="/products/add",method=RequestMethod.POST)
	public String processAddnewProductForm(@ModelAttribute("newProduct") Product product,BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		   if (suppressedFields.length > 0) {
		      throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		   }
		productService.addProduct(product);
		return "redirect:/market/products";
	}
	
}
