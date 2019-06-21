package com.learning.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.webstore.domain.Product;
import com.learning.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Map<String,Object> params = new HashMap<>();
		List<Product> results = jdbcTemplate.query("select * from products", params,new ProductMapper());
		return results;
	}
	
	private static final class ProductMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Product product = new Product(); 
            product.setProductId(rs.getString("ID")); 
            product.setProductName(rs.getString("NAME")); 
            product.setDescription(rs.getString("DESCRIPTION")); 
            product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE")); 
            product.setManufacturer(rs.getString("MANUFACTURER")); 
            product.setCategory(rs.getString("CATEGORY")); 
            product.setCondition(rs.getString("CONDITION")); 
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK")); 
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER")); 
            product.setDiscontinued(rs.getBoolean("DISCONTINUED")); 
			
			return product;
	    }
	}

	@Override
	public void updateStock(String productId, long noOfUnits) {
		// TODO Auto-generated method stub
		String query = "update products set UNITS_IN_STOCK=:units where id=:id";
		Map<String,Object> params = new HashMap<>();
		params.put("units",noOfUnits);
		params.put("id",productId);
		
		jdbcTemplate.update(query, params);
		
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		// TODO Auto-generated method stub
		String sql="select * from products where category=:category";
		Map<String,Object> params = new HashMap<>();
		params.put("category",category);
		return jdbcTemplate.query(sql,params, new ProductMapper());
	}

	@Override
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		String sql = "select * from products where CATEGORY IN(:categories) and MANUFACTURER IN(:brands)";
		return jdbcTemplate.query(sql,filterParams,new ProductMapper());
		
	}

	@Override
	public Product getProductByID(String productId) {
		// TODO Auto-generated method stub
		String sql = "select * from products where ID=:id";
		Map<String,Object> params = new HashMap<>();
		params.put("id",productId);
		return jdbcTemplate.queryForObject(sql,params,new ProductMapper());
		
	}

	@Override
	public List<Product> getProductByAllCriteria(String category, Map<String, List<String>> params, String brandName) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY IN (:category) and MANUFACTURER IN(:brands)";
		System.out.println("cate:"+category+" brand : "+brandName);
		Map<String,String> values = new HashMap<>();
		values.put("category",category);
		values.put("brands",brandName);
//		System.out.println(parms);
		List<Product>results= jdbcTemplate.query(sql,values,new ProductMapper());
		System.out.println(results);
		return results;
	}
		
}
