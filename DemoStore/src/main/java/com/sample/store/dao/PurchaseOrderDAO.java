package com.sample.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.sample.store.entity.Product;
import com.sample.store.entity.PurchaseOrder;


public interface PurchaseOrderDAO {	
	
	public void create(Product aProduct, int qty);
	public List<PurchaseOrder> getList();
	public int stockProduct(PurchaseOrder po) throws SQLException;
	

}
