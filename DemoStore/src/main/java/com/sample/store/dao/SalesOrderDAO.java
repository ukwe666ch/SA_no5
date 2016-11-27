package com.sample.store.dao;

import java.sql.SQLException;
import java.util.List;

//import com.sample.store.entity.Product;
//import com.sample.store.entity.PurchaseOrder;


public interface SalesOrderDAO {	
	
	public int sellProduct(List<Long> pList) throws SQLException;


}
