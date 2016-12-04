package com.sample.store.entity;

public class Product {
    private String product_id;
    private String product_name;
    private String product_category;
    private int product_price;
    private String firm_id;
    
    public String getFirm_id() {
		return firm_id;
	}
    public void setFirm_id(String firm_id) {
		this.firm_id = firm_id;
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
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
    

    /* getters and setters */
   
}//Product
