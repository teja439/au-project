package com.accolite.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderProduct {
	
	@JoinColumn(name = "orderId")
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	private CustomerOrder customerOrder;
	
	private int productQuantity;
	
	@JoinColumn(name = "productId")
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
		
}
