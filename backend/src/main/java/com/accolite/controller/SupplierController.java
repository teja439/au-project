package com.accolite.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Supplier;
import com.accolite.service.SupplierService;

@RestController
public class SupplierController {
	
	@CrossOrigin
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/createsupplier", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "application/json") 
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) throws Exception {
		System.out.println("Supplier: "+ supplier);
		Supplier response = SupplierService.createSupplier(supplier);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	
}
