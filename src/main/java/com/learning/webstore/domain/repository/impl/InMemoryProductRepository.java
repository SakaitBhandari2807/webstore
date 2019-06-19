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
}
