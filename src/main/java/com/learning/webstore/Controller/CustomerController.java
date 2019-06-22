package com.learning.webstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.webstore.domain.Customer;
import com.learning.webstore.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public String customersList(Model model) {
		model.addAttribute("customers",customerService.getAllCustomers());
		return "customers";
	}
	
	@RequestMapping(value="/customers/add",method=RequestMethod.GET)
	public String addCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("newCustomer",customer);
		return "addCustomer";
	}
	
	@RequestMapping(value="/customers/add",method=RequestMethod.POST)
	public String processAddCustomer(@ModelAttribute("newCustomer") Customer customer) {
		System.out.println(customer.getCustomerId());
		System.out.println(customer.getCustomerName());
		System.out.println(customer.getCustomerAddress());
		System.out.println(customer.getNoOfOrdersMade());
		customerService.addCustomer(customer);
		return "redirect:/customers";
	}
}
