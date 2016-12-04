package com.sample.store.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sample.store.entity.Employee;
//import com.sample.store.entity.User;

// you can use your own security manager to read account inform from database or other sources
// in spring-security.xml
// you need

//<authentication-manager>
//<authentication-provider user-service-ref="securityManager"/>
//</authentication-manager>
//<beans:bean id="securityManager" class="com.sample.store.service.SecurityManager"/>

public class SecurityManager implements UserDetailsService {
	//@Autowired
			private DataSource dataSource;
			private Connection conn = null ;
			private ResultSet rs = null ;
			private PreparedStatement smt = null ;
			
			public void setDataSource(DataSource dataSource) {
				this.dataSource = dataSource;
			}
 
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
    	
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        //資料庫查詢匯入
        employeeList=getEmployeeList();
        for (int i = 0; i < employeeList.size(); i++) {
        	Employee employee = (Employee) employeeList.get(i);
            if (employee.getEmployee_name().equals(username))
                return employee;
        }
        throw new UsernameNotFoundException("User " + username
                + " has no GrantedAuthority");
//        ArrayList<User> userList = new ArrayList<User>();
//        userList.add(new User("sa", "ilovesa"));
//        userList.add(new User("ben", "12345"));
//        for (int i = 0; i < userList.size(); i++) {
//            User user = (User) userList.get(i);
//            if (user.getUsername().equals(username))
//                return user;
//        }
//        throw new UsernameNotFoundException("User " + username
//                + " has no GrantedAuthority");
    }
    
    	//獲得所有使用者資料
  		public ArrayList<Employee> getEmployeeList() {
  			// TODO Auto-generated method stub
  			//寫好sql指令
  			String sql = "SELECT * FROM Employee";
  			//丟到getlist去執行,然後回傳
  			return getList(sql);
  		}
  		
  		public ArrayList<Employee> getList(String sql) {
			//新增一個list接到查詢後的list回傳
			ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
			//will need this part later
			/*
			String sql = "SELECT * FROM article a "
					+ "JOIN article_category b ON a.articleCategoryID = b.articleCategoryID "
					+ "Employee BY articleID DESC";
			*/
			//執行sql查詢
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				rs = smt.executeQuery();
				while(rs.next()){
					Employee aEmployee = new Employee();
					aEmployee.setEmployee_id(rs.getString("Employee_id"));		
					aEmployee.setEmployee_name(rs.getString("Employee_name"));
					aEmployee.setEmployee_pwd(rs.getString("Employee_pwd"));
					//System.out.println(rs.getString("description"));
					aEmployee.setEmployee_type(rs.getString("Employee_type"));
					
					EmployeeList.add(aEmployee);
				}
				rs.close();
				smt.close();
	 
			} catch (SQLException e) {
				throw new RuntimeException(e);
	 
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {}
				}
			}
			return EmployeeList;
		}
}