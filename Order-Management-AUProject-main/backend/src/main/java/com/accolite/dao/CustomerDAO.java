package com.accolite.dao;

import java.util.List;

import com.accolite.model.Customer;

public interface CustomerDAO {
	
	public Customer save(Customer customer);
	
	public List<Customer> list(int offset, int limit);


}
