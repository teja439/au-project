package com.accolite.dao;

import java.util.List;


import com.accolite.model.CustomerOrder;
import com.accolite.model.Order;

public interface CustomerOrderDAO {
	
	public CustomerOrder save(Order order);
	
	public List<Order> list(int offset,int limit);

}
