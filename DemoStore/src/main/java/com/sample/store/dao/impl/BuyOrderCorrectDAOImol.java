package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.dao.BuyOrderCorrectDAO;
import com.sample.store.entity.Order;
import com.sample.store.entity.OrderCorrect;

public class BuyOrderCorrectDAOImol extends BuyOrderDAOImpl implements BuyOrderCorrectDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public void insert(OrderCorrect aOrderCorrect) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderCorrect aOrderCorrect) {
		// TODO Auto-generated method stub
		
	}

	
	//透過訂單編號、訂單日期查詢
	//依照1. 訂單編號　2. 訂單日期
	@Override
	public List<OrderCorrect> getByOrder(OrderCorrect aOrderCorrect) {
		// TODO Auto-generated method stub
		String sql = "";
		return getList2(sql);
	}
	
	public List<OrderCorrect> getList2(String sql) {
		//新增一個list接到查詢後的list回傳
		List<OrderCorrect> OrderCorrectList = new ArrayList<OrderCorrect>();
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
				OrderCorrect aOrderCorrect = new OrderCorrect();
				//要加東西
				OrderCorrectList.add(aOrderCorrect);
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
		return OrderCorrectList;
	}

}
