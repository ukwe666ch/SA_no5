package com.sample.store.entity;

public class OrderCorrect extends Order{
	private int order_correct_id;
	
	private String note;
	
	public int getOrder_correct_id() {
		return order_correct_id;
	}
	public void setOrder_correct_id(int order_correct_id) {
		this.order_correct_id = order_correct_id;
	}
	

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
}
