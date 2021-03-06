package com.accolite.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.accolite.model.Customer;
import com.accolite.utils.Connection;

public class CustomerDAOImpl implements CustomerDAO {

	public Customer save(Customer customer) {
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Customer customerData = new Customer();
		
//		customerData.setCustomerId(customer.getCustomerId());
//		customerData.setCustomerEmail(customer.getCustomerEmail());
//		customerData.setCustomerAddress(customer.getCustomerAddress());
//		customerData.setCustomerName(customer.getCustomerName());
//		customerData.setCustomerPhone(customer.getCustomerPhone());
//		customerData.setCustomerPincode(customer.getCustomerPincode());
		
		 session.save(customer);
         tx.commit();
		
		return customer;
		// TODO Auto-generated method stub

	}

public List<Customer> list(int offset, int limit) {
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.createSQLQuery("select * from Customer");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		
		System.out.println(limit + " " + offset);
		@SuppressWarnings("unchecked")
		
		List<Object[]> obj = query.getResultList();
	
		List<Customer> customers = new ArrayList<>();
		
		for(Object[] o : obj) {
			
			Customer customer = new Customer();
			
			customer.setCustomerId((int) o[0]);
			customer.setCustomerName((String) o[1]);
			customer.setCustomerPhone((String) o[2]);
			customer.setCustomerEmail((String) o[3]);
			customer.setCustomerAddress((String) o[4]);
			customer.setCustomerPincode((String) o[5]);
			
			customers.add(customer);
			
		}
		
		tx.commit();
		
		return customers;
		
		
	}


}
