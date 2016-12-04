package com.sample.store.service;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sample.store.entity.User;

// you can use your own security manager to read account inform from database or other sources
// in spring-security.xml
// you need

//<authentication-manager>
//<authentication-provider user-service-ref="securityManager"/>
//</authentication-manager>
//<beans:bean id="securityManager" class="com.sample.store.service.SecurityManager"/>

public class SecurityManager implements UserDetailsService {
 
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("sa", "ilovesa"));
        userList.add(new User("ben", "12345"));
        for (int i = 0; i < userList.size(); i++) {
            User user = (User) userList.get(i);
            if (user.getUsername().equals(username))
                return user;
        }
        throw new UsernameNotFoundException("User " + username
                + " has no GrantedAuthority");
    }
}