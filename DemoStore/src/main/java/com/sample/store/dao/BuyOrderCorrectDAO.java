package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.OrderCorrect;

//進貨單
public interface BuyOrderCorrectDAO {
	//新增
	public void insert(OrderCorrect aOrderCorrect);
	//修改
	public void update(OrderCorrect aOrderCorrect);
	//查詢
	//透過訂單編號、訂單日期查詢
	//依照1. 訂單編號　2. 訂單日期
	public List<OrderCorrect>getByOrder(OrderCorrect aOrderCorrect);
	
}
