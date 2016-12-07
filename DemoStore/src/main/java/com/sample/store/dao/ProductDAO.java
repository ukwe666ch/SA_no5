package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Product;


public interface ProductDAO {	
	
	public void insert(Product aProduct);
	public void delete(Product aProduct);
	public void update(Product aProduct);
	public List<Product> getList();//列全部
	//public List<Product> getReorderList();    用不到
	//public List<Product> getAvailableList();  用不到
	public List<Product> getCategoryList();//列分類搜尋
	public Product get(Product aProduct);//列ID搜尋結果
	

}
