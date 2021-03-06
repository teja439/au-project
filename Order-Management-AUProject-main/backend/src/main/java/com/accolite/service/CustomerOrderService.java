package com.accolite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accolite.dao.CustomerOrderDAOImpl;
import com.accolite.model.CustomerOrder;
import com.accolite.model.Order;

@Service
public class CustomerOrderService {
	
	public static CustomerOrder createOrder(Order order) {
		
		CustomerOrderDAOImpl customerOrderImpl = new CustomerOrderDAOImpl();
		
		CustomerOrder customerOrderData = customerOrderImpl.save(order);
		
		return customerOrderData;
		
	}
	
    public static List<Order> getOrders(int offset, int limit) {
		
		CustomerOrderDAOImpl customerorderDAOImpl = new CustomerOrderDAOImpl();
		
		List<Order> orders = customerorderDAOImpl.list(offset, limit);
		
		return orders;
		
}

}
