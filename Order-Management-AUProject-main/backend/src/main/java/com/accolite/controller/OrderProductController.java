package com.accolite.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.OrderProduct;
import com.accolite.model.OrderProductDetails;
import com.accolite.service.OrderProductService;

@RestController
public class OrderProductController {
	
	@CrossOrigin
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/createorderproduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "application/json") 
	public ResponseEntity<OrderProduct> createOrderProduct(@RequestBody OrderProductDetails orderproduct) throws Exception {
		//System.out.println("Order: "+ order);
		OrderProduct response = OrderProductService.createOrderProduct(orderproduct);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
