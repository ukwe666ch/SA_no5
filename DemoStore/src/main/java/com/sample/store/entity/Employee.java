package com.sample.store.entity;
import java.util.ArrayList;
public class Employee {
	
	private static final long serialVersionUID = 1L;
	 
 

	private String employee_id;
    private String employee_name;
    private String employee_type;
    private String employee_pwd;
    //
    //
    public Employee() {
        this.employee_id = "";
       
        this.employee_name = "";
        this.employee_type ="";
        this.employee_pwd = "";
    }
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}
	public String getEmployee_pwd() {
		return employee_pwd;
	}
	public void setEmployee_pwd(String employee_pwd) {
		this.employee_pwd = employee_pwd;
	}
    
    
}
