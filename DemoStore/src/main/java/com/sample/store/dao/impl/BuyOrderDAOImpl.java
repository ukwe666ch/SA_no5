package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.dao.BuyOrderDAO;
import com.sample.store.entity.Employee;
import com.sample.store.entity.Order;


public class BuyOrderDAOImpl extends Employee implements BuyOrderDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Autowired
		private DataSource dataSource;
		private Connection conn = null ;
		private ResultSet rs = null ;
		private PreparedStatement smt = null ;
		
		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		@Override
		public void insert(Order aOrder) {
			// TODO Auto-generated method stub
			// remove first parameter when Id is auto-increment
			
			//新增請購單
			//更改Order資料表sql
		    String sql = "INSERT INTO Order (Order_date, created_by, total_price, update_by, update_by_name, updated_date) VALUES(?, ?, ?, ?, ?,?)";	
			try {
				conn = dataSource.getConnection();
				//更改Order資料表
				smt = conn.prepareStatement(sql);
				smt.setDate(1, aOrder.getOrder_date());
				smt.setString(2, aOrder.getCreated_by());
				smt.setInt(3, aOrder.getTotal_price());
				smt.setString(4, aOrder.getUpdate_by());
				smt.setString(5, aOrder.getUpdate_by_name());
				smt.setDate(6, aOrder.getUpdated_date());
				smt.executeUpdate();			
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
			
		}

		@Override
		//修改請購單資料
		public void update(Order aOrder) {
			// TODO Auto-generated method stub
			String sql = "UPDATE Order SET  total_price=?, update_by=?, update_by_name=?, updated_date=?"
					+ "WHERE Order_id = ?";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setInt(1, aOrder.getTotal_price());
				smt.setString(2, aOrder.getUpdate_by());
				smt.setString(3, aOrder.getUpdate_by_name());
				smt.setDate(4, aOrder.getUpdated_date());
				smt.executeUpdate();			
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
			
		}

		@Override
		//透過訂單編號、訂單日期查詢
		//依照1. 訂單編號　2. 訂單日期
		//待改
		
		public List<Order> getByOrder(Order aOrder) {
			// TODO Auto-generated method stub
			//寫好sql指令
			String sql = "SELECT * FROM order WHERE order_id ="+aOrder.getOrder_id()+"OR order_date="+aOrder.getOrder_date()+"ORDER BY order_date DESC";
			//丟到getlist去執行,然後回傳
			return getList(sql);
		}

		@Override
		//獲得所有請購單資料
		public List<Order> getOrderList() {
			// TODO Auto-generated method stub
			//寫好sql指令
			String sql = "SELECT * FROM Order ORDER BY order_date DESC";
			//丟到getlist去執行,然後回傳
			return getList(sql);
		}
		// make it a generic method for different conditions
		public List<Order> getList(String sql) {
			//新增一個list接到查詢後的list回傳
			List<Order> OrderList = new ArrayList<Order>();
			//will need this part later
			/*
			String sql = "SELECT * FROM article a "
					+ "JOIN article_category b ON a.articleCategoryID = b.articleCategoryID "
					+ "ORDER BY articleID DESC";
			*/
			//執行sql查詢
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				rs = smt.executeQuery();
				while(rs.next()){
					Order aOrder = new Order();
					aOrder.setOrder_id(rs.getInt("Order_id"));		
					aOrder.setOrder_date(rs.getDate("order_date"));
					aOrder.setCreated_by(rs.getString("created_by"));
					//System.out.println(rs.getString("description"));
					aOrder.setTotal_price(rs.getInt("total_price"));
					aOrder.setUpdate_by(rs.getString("update_by"));
					aOrder.setUpdate_by_name(rs.getString("update_by_name"));
					aOrder.setUpdated_date(rs.getDate("updated_date"));
					OrderList.add(aOrder);
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
			return OrderList;
		}
		
}
