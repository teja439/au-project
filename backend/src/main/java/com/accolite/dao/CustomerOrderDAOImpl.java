package com.accolite.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accolite.model.Customer;
import com.accolite.model.CustomerOrder;
import com.accolite.model.Order;
import com.accolite.utils.Connection;

public class CustomerOrderDAOImpl implements CustomerOrderDAO {

	@Override
	public CustomerOrder save(Order order) {
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
		
		CustomerOrder customerOrderData = new CustomerOrder();
		
		int orderId = order.getCustomerId();
		
		Query query = session.createSQLQuery("select * from Customer WHERE customerId = :id");
		query.setParameter("id", orderId);
		@SuppressWarnings("unchecked")
		List<Object[]> obj = query.getResultList();
		Customer customer = new Customer();
		customer.setCustomerId((int) obj.get(0)[0]);
		customer.setCustomerName((String) obj.get(0)[1]);
		customer.setCustomerPhone((String) obj.get(0)[2]);
		customer.setCustomerEmail((String) obj.get(0)[3]);
		customer.setCustomerAddress((String) obj.get(0)[4]);
		customer.setCustomerPincode((String) obj.get(0)[5]);

		customerOrderData.setCustomer(customer);
		customerOrderData.setOrderId(order.getOrderId());
		customerOrderData.setOrderStatus(order.getOrderStatus());
	
		session.save(customerOrderData);
		tx.commit();
		
		return customerOrderData;
	}

	@Override
	public List<Order> list(int offset,int limit) {
         Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.createSQLQuery("select * from CustomerOrder");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		
		System.out.println(limit + " " + offset);
		@SuppressWarnings("unchecked")
		
		List<Object[]> obj = query.getResultList();
	
		List<Order> orders = new ArrayList<>();
		
		for(Object[] o : obj) {
			
			Order order = new Order();
			
			order.setCustomerId((int)o[0]);
			order.setOrderId((int) o[2]);
			order.setOrderStatus((String) o[1]);
			
			orders.add(order);
			
		}
		
		tx.commit();
		
		return orders;
		
	}}