package com.learning.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

	
}
