package com.sample.store.dao;

import java.util.List;
import com.sample.store.entity.Order;

//請購單要做什麼
public interface BuyOrderDAO {
		//新增請購單
		public void insert(Order aOrder);
		//修改請購單資料
		public void update(Order aOrder);
		//透過訂單編號、訂單日期查詢
		//依照1. 訂單編號　2. 訂單日期
		public List<Order>getByOrder(Order aOrder);
		
		//獲得所有請購單資料
		public List<Order> getOrderList();
}
