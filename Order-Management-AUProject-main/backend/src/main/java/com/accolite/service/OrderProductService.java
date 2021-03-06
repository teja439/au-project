package com.accolite.service;

import com.accolite.dao.CustomerOrderDAOImpl;
import com.accolite.dao.OrderProductDAOImpl;
import com.accolite.model.CustomerOrder;
import com.accolite.model.Order;
import com.accolite.model.OrderProduct;
import com.accolite.model.OrderProductDetails;

public class OrderProductService {
	
public static OrderProduct createOrderProduct(OrderProductDetails orderproductdetails) {
		
		OrderProductDAOImpl orderProductImpl = new OrderProductDAOImpl();
		
		OrderProduct OrderProductData = orderProductImpl.save(orderproductdetails);
		
		return OrderProductData;
		
	}

}
