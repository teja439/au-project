package com.accolite.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accolite.model.Supplier;
import com.accolite.utils.Connection;

public class SupplierDAOImpl implements SupplierDAO {
	
	//@Override
	public Supplier save(Supplier supplier) {
		
		
		Session session = Connection.getSession();
		
		Transaction tx = session.beginTransaction();
	
		Supplier supplierData = new Supplier();
		
		supplierData.setSupplierId(supplier.getSupplierId());
		supplierData.setSupplierEmail(supplier.getSupplierEmail());
		supplierData.setSupplierAddress(supplier.getSupplierAddress());
		supplierData.setSupplierName(supplier.getSupplierName());
		supplierData.setSupplierPhone(supplier.getSupplierPhone());
		supplierData.setSupplierPincode(supplier.getSupplierPincode());

		
		
		 session.save(supplierData);
         tx.commit();
		
		return supplierData;
		
	}

	//@Override
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
