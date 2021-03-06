package com.accolite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accolite.dao.CustomerDAOImpl;
import com.accolite.model.Customer;

@Service
public class CustomerService {
	
	public static Customer createCustomer(Customer customer) {
		
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		
		Customer customerData = customerDAOImpl.save(customer);
		
		return customerData;
		
	}

public static List<Customer> getCustomers(int offset, int limit) {
		
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		
		List<Customer> customers = customerDAOImpl.list(offset, limit);
		
		return customers;
		
}


}
