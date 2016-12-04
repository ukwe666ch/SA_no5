package com.sample.store.entity;

public class OrderCorrect extends Order{
	
	private int order_correct_id;
	private String order_correct_note;
	private char order_correct_pay;
	
	//初始進貨單未付款
	public OrderCorrect() {
		super();
		this.order_correct_pay = 'N';
	}
	
	
	public int getOrder_correct_id() {
		return order_correct_id;
	}
	public void setOrder_correct_id(int order_correct_id) {
		this.order_correct_id = order_correct_id;
	}
	

	public String getOrder_correct_note() {
		return order_correct_note;
	}
	public void setOrder_correct_note(String note) {
		this.order_correct_note = note;
	}
	public char getOrder_correct_pay() {
		return order_correct_pay;
	}
	public void setOrder_correct_pay(char order_correct_pay) {
		this.order_correct_pay = order_correct_pay;
	}

	
}
