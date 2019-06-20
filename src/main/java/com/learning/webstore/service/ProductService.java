package com.learning.webstore.service;

import java.util.List;
import java.util.Map;

import com.learning.webstore.domain.Product;

public interface ProductService {
	void updateAllStocks();
	List<Product> getAllProducts();
	List<Product> getAllProductsByCategory(String category);
	List<Product> getProductsByFilter(Map<String,List<String>> filterParams);
}
