package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Inventory;

/*依照1. 商品編號　2. 商品名稱關鍵字　3.商品分類
列出商品編號、商品名稱、商品分類、存貨數量
排序依照商品編號由大至小
*/
public interface BuyInventoryDAO {
	public List<Inventory> getInventoryList();//列全部庫存結果
	public Inventory getID(Inventory aInventory);//1.列商品ID搜尋庫存結果
	public Inventory getName(Inventory nInventory);//2.商品名稱關鍵字搜尋庫存結果
	public Inventory getCategory(Inventory cInventory);//3.列商品分類搜尋庫存結果
	
	
}
