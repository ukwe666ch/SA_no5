package com.sample.store.entity;
import java.sql.Date;
public class Order {
	private int order_id;
	private Date order_date;
	private String created_by;
	private int total_price;
	private String update_by;
	private String update_by_name;
	private Date updated_date;
	
	/*getter setter*/
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public String getUpdate_by_name() {
		return update_by_name;
	}
	public void setUpdate_by_name(String update_by_name) {
		this.update_by_name = update_by_name;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
}
