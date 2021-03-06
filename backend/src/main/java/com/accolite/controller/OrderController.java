package com.accolite.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Customer;
import com.accolite.model.CustomerOrder;
import com.accolite.model.Order;
import com.accolite.service.CustomerOrderService;
import com.accolite.service.CustomerService;

@RestController
public class OrderController {

	@CrossOrigin
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/createorder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "application/json") 
	public ResponseEntity<CustomerOrder> createOrder(@RequestBody Order order) throws Exception {
		System.out.println("Order: "+ order);
		CustomerOrder response = CustomerOrderService.createOrder(order);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getorders", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<List<Order>> getOrder(@RequestParam(name = "offset")  int offset, @RequestParam(name = "limit") int limit) throws Exception {
		List<Order> response = CustomerOrderService.getOrders(offset, limit);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
}
	
}
