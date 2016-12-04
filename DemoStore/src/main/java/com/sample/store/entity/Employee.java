package com.sample.store.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Employee implements UserDetails{
	
	
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
		this.employee_type = "";
		this.employee_pwd = "";
	}
    public Employee(String employee_id, String employee_name, String employee_type, String employee_pwd) {
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_type = employee_type;
		this.employee_pwd = employee_pwd;
	}
    
    public Collection<GrantedAuthority> getAuthorities() {
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        //grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));
        //GrantedAuthorityImpl is deprecated;
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
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
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
    
    
}
