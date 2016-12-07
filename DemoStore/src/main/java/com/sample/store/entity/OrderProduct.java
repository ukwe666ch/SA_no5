package com.sample.store.entity;
import java.util.ArrayList;

//import com.sample.store.entity.Order;
import com.sample.store.entity.Product;
public class OrderProduct{
	private int order_product_id;
	private int order_id;
	private String product_name;
	private int product_amount;
	private int product_price;
	
	//private ArrayList<Product> productList = new ArrayList<Product>();
	private String firm_id;
	private String firm_name;
	private String firm_rank;
	
	public int getOrder_product_id() {
		return order_product_id;
	}
	public void setOrder_product_id(int order_product_id) {
		this.order_product_id = order_product_id;
	}
	
	
	
	public String getFirm_id() {
		return firm_id;
	}
	public void setFirm_id(String firm_id) {
		this.firm_id = firm_id;
	}
	public String getFirm_name() {
		return firm_name;
	}
	public void setFirm_name(String firm_name) {
		this.firm_name = firm_name;
	}
	public String getFirm_rank() {
		return firm_rank;
	}
	public void setFirm_rank(String firm_rank) {
		this.firm_rank = firm_rank;
	}
//	public ArrayList<Product> getProductList() {
//		return productList;
//	}
//	public void addProductList(Product aProduct){
//		productList.add(aProduct);
//	}
//	public void setProductList(ArrayList<Product> productList) {
//		this.productList = productList;
//	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	
}
