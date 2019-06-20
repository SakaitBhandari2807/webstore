package com.learning.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.learning.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	void updateStock(String productId,long noOfUnits);
	List<Product> getAllProductsByCategory(String category);
	List<Product> getProductsByFilter(Map<String,List<String>> filterParams);
	Product getProductByID(String productId);
}
