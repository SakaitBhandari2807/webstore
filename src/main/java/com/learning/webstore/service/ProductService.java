package com.learning.webstore.service;

import java.util.List;

import com.learning.webstore.domain.Product;

public interface ProductService {
	void updateAllStocks();
	List<Product> getAllProducts();
}
