package com.learning.webstore.domain.repository;

import java.util.List;

import com.learning.webstore.domain.Customer;

public interface CustomerRepository {
  List<Customer> getAllCustomers();
  void addCustomer(Customer customer);
}
