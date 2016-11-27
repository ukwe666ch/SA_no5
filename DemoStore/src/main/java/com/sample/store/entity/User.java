package com.sample.store.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
//GrantedAuthorityImpl is deprecated;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
 
    private static final long serialVersionUID = 1L;
 
    private String name;
    private String password;

    public User() {
        this.name = "";
        this.password = "";
    }
    
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
 
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
     
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        //grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));
        //GrantedAuthorityImpl is deprecated;
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
    }
 
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }
 
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return name;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
 
}