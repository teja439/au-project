package com.accolite.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accolite.model.Customer;
import com.accolite.model.CustomerOrder;
import com.accolite.model.OrderProduct;
import com.accolite.model.OrderProductDetails;
import com.accolite.model.Product;
import com.accolite.utils.Connection;

public class OrderProductDAOImpl implements OrderProductDAO {
	
	@Override
	public OrderProduct save(OrderProductDetails orderProductdetails) {
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
		
		OrderProduct orderProductData = new OrderProduct();
		
		int orderId = orderProductdetails.getOrderId();
		int productId= orderProductdetails.getProductId();
		
		
		Query query = session.createSQLQuery("select * from CustomerOrder WHERE orderId = :id");
		query.setParameter("id", orderId);
		@SuppressWarnings("unchecked")
		List<Object[]> obj = query.getResultList();
		CustomerOrder customerOrder = new CustomerOrder();
		
		
		
		
		Query query2 = session.createSQLQuery("select * from Customer WHERE customerId = :id");
		query2.setParameter("id", obj.get(0)[2]);
		@SuppressWarnings("unchecked")
		List<Object[]> obj1 = query2.getResultList();
		Customer customer = new Customer();
		customer.setCustomerId((int) obj1.get(0)[0]);
		customer.setCustomerName((String) obj1.get(0)[1]);
		customer.setCustomerPhone((String) obj1.get(0)[2]);
		customer.setCustomerEmail((String) obj1.get(0)[3]);
		customer.setCustomerAddress((String) obj1.get(0)[4]);
		customer.setCustomerPincode((String) obj1.get(0)[5]);
		
	
	
		customerOrder.setOrderStatus((String)obj.get(0)[1]);
		customerOrder.setOrderId((int)obj.get(0)[0]);
		customerOrder.setCustomer(customer);
		
//		customer.setCustomerId((int) obj.get(0)[0]);
//		customer.setCustomerName((String) obj.get(0)[1]);
//		customer.setCustomerPhone((String) obj.get(0)[2]);
//		customer.setCustomerEmail((String) obj.get(0)[3]);
//		customer.setCustomerAddress((String) obj.get(0)[4]);
//		customer.setCustomerPincode((String) obj.get(0)[5]);
//		
		
		
		//////////////////////////////////////////////////////////
		
		Query query1 = session.createSQLQuery("select * from Product WHERE productId = :id");
		query1.setParameter("id", productId);
		@SuppressWarnings("unchecked")
		List<Object[]> obj2 = query1.getResultList();
		Product product=new Product();
		
		product.setProductId((int)obj2.get(0)[0]);
		product.setProductAvailable((String)obj2.get(0)[1]);
		product.setProductcostPrice((String)obj2.get(0)[2]);
		product.setProductIncoming((String)obj2.get(0)[3]);
		product.setProductName((String)obj2.get(0)[4]);
		product.setProductOnHand((String)obj2.get(0)[5]);
		product.setProductOutgoing((String)obj2.get(0)[6]);

		product.setProductSellingPrice((String)obj2.get(0)[7]);

		orderProductData.setProduct(product);
		orderProductData.setProductQuantity(orderProductdetails.getProductQuantity());		
		orderProductData.setCustomerOrder(customerOrder);
		
		session.save(orderProductData);
		tx.commit();
		

		return orderProductData;
	}

//	@Override
//	public OrderProduct save(Order order) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
