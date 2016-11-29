package com.sample.store.entity;

public class OrderProduct extends Order{
	private int order_product_id;
	
	private String product_id;
	private String product_name;
	private String product_amount;
	private String product_price;
	private String firm_id;
	private String firm_name;
	private String firm_rank;
	
	public int getOrder_product_id() {
		return order_product_id;
	}
	public void setOrder_product_id(int order_product_id) {
		this.order_product_id = order_product_id;
	}
	
	
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(String product_amount) {
		this.product_amount = product_amount;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
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

	
}
