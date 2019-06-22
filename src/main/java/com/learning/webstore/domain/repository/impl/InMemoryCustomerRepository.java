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

import com.learning.webstore.domain.Customer;
import com.learning.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String sql = "select * from customers";
		List<Customer> customers = jdbcTemplate.query(sql, new CustomerMapper());
		return customers;
	}
	
	private static final class CustomerMapper implements RowMapper<Customer>{

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("ID"));
			customer.setCustomerName(rs.getString("NAME"));
			customer.setCustomerAddress(rs.getString("ADDRESS"));
			customer.setNoOfOrdersMade(rs.getInt("NUMBER_OF_ORDERS_MADE"));
			
			return customer;
		}
		
	}

	@Override
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMERS (id,name,address,number_of_orders_made) VALUES(:id,:name,:address,:noOfOrders)";
		Map<String,Object> params = new HashMap<>();
		System.out.println(customer.getCustomerId());
		System.out.println(customer.getCustomerName());
		System.out.println(customer.getCustomerAddress());
		System.out.println(customer.getNoOfOrdersMade());
		params.put("name", customer.getCustomerName());
		params.put("id",customer.getCustomerId());
		params.put("address", customer.getCustomerAddress());
		params.put("noOfOrders",customer.getNoOfOrdersMade());
		System.out.println(params);
		jdbcTemplate.update(sql,params);
	}

	
	
}
