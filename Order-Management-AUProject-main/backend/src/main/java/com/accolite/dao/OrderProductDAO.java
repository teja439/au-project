package com.accolite.dao;

import com.accolite.model.OrderProduct;
import com.accolite.model.OrderProductDetails;

public interface OrderProductDAO {
	
	public OrderProduct save(OrderProductDetails orderproductdetails);

}
