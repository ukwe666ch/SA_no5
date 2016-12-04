package com.sample.store.entity;

public class Inventory extends Product{
	private int Product_Amount;
	
	public Inventory() {
		Product_Amount=0;
		// TODO Auto-generated constructor stub
	}

	public int getProduct_Amount() {
		return Product_Amount;
	}

	public void setProduct_Amount(int product_Amount) {
		Product_Amount = product_Amount;
	}
	
}
