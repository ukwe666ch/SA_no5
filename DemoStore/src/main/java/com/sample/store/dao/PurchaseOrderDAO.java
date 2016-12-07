package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Firm;
import com.sample.store.entity.PurchaseOrder;

//請購單要做什麼
public interface PurchaseOrderDAO {	
	//新增請購單
	public void insert(PurchaseOrder aPurchaseOrder);
	//更新請購單
	public void update(PurchaseOrder aPurchaseOrder);
	//刪除請購單
	public void delete(PurchaseOrder aPurchaseOrder);
	//查看所有請購單
	public List<PurchaseOrder> getAllList();
	//用請購單id查看請購單
	public PurchaseOrder get(PurchaseOrder aPurchaseOrder);
	//用廠商查看請購單
	public PurchaseOrder get(Firm aFirm);
	//用廠商查看含b級廠商請購單
	public PurchaseOrder getBFirm(Firm aFirm);
	
	
	

}
