package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Firm;
import com.sample.store.entity.Product;

public interface BuyFirmProductDAO {

	public void insertProduct(Product aProduct);//新增商品
	public void updateProduct(Product aProduct);//修改商品
	public void deleteProduct(Product aProduct);//刪除商品
	public void insertFirm(Firm aFirm);//新增廠商
	public void updateFirm(Firm aFirm);//修改廠商
	public List<Firm> getFirmList();//列全部廠商
	public Firm get(Firm aFirm);//列ID搜尋廠商結果
	public List<Product> getProductList();//列全部商品
	public Product get(Product aProduct);//列ID搜尋商品結果
	public Product getCategory(Product cProduct);//列商品分類搜尋
	public Product getProductFirm(Product fProduct);//列廠商搜尋商品結果

}
