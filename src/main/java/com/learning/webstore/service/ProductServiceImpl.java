package com.learning.webstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.webstore.domain.Product;
import com.learning.webstore.domain.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void updateAllStocks() {
		// TODO Auto-generated method stub
		List<Product>products = productRepository.getAllProducts();
		
		for(Product product:products){
			if(product.getUnitsInStock()<500) {
				productRepository.updateStock(product.getProductId(), product.getUnitsInStock()+1000);
			}
		}
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.getAllProducts();
		
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.getAllProductsByCategory(category);
	}

	@Override
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return productRepository.getProductsByFilter(filterParams);
	}

	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepository.getProductByID(productId);
	}

	@Override
	public List<Product> getProductByCriteria(String category, Map<String, List<String>> params,
			String brandName) {
		// TODO Auto-generated method stub
		return productRepository.getProductByAllCriteria(category, params, brandName);
	}
	
	
	
	
}
