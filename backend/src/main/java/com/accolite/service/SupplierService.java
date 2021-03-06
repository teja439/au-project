package com.accolite.service;

import com.accolite.dao.SupplierDAOImpl;
import com.accolite.model.Supplier;

public class SupplierService {
public static Supplier createSupplier(Supplier supplier) {
		
		SupplierDAOImpl supplierDAOImpl = new SupplierDAOImpl();
		
		Supplier supplierData=supplierDAOImpl.save(supplier);
		return supplierData;
		
		
	}

}
