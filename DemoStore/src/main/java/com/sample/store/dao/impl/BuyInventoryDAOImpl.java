package com.sample.store.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sample.store.dao.BuyInventoryDAO;
import com.sample.store.entity.Inventory;


public class BuyInventoryDAOImpl implements BuyInventoryDAO{

	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//列全部庫存結果
	/*列出商品編號、商品名稱、商品分類、存貨數量
	排序依照商品編號由大至小*/
	public List<Inventory> getInventoryList() {
		String sql = "SELECT * FROM Inventory";
		return getList(sql);
	}

	//1.列商品ID搜尋庫存結果
	public Inventory getID(Inventory aInventory) {
		String sql = "SELECT product_id,product_name,product_category,inventory_amount "
				+ "FROM Inventory,Product "
				+ "WHERE Product.product_id=Inventory.product_id "
				+ "AND product_id =?"
				+ "ORDER BY product_id";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aInventory.getProduct_id());//商品ID(第一個問號)
			rs = smt.executeQuery();
			if(rs.next()){
				aInventory.setProduct_id(rs.getString("product_id"));//商品編號		
				aInventory.setProduct_name(rs.getString("product_name"));//商品名稱
				aInventory.setProduct_category(rs.getString("product_category"));//商品分類
				aInventory.setInventory_amount(rs.getInt("inventory_amount"));//存貨數量
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
		return aInventory;
	}

	//2.商品名稱關鍵字搜尋庫存結果
		public Inventory getName(Inventory nInventory) {
			String sql = "SELECT product_id,product_name,product_category,inventory_amount "
				+ "FROM Inventory,Product "
				+ "WHERE Product.product_id=Inventory.product_id "
				+ "AND product_name =?"
				+ "ORDER BY product_id";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setString(1, nInventory.getProduct_name());//商品名稱(第一個問號)
				rs = smt.executeQuery();
				if(rs.next()){
					nInventory.setProduct_id(rs.getString("product_id"));//商品編號		
					nInventory.setProduct_name(rs.getString("product_name"));//商品名稱
					nInventory.setProduct_category(rs.getString("product_category"));//商品分類
					nInventory.setInventory_amount(rs.getInt("inventory_amount"));//存貨數量
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
			return nInventory;
		}

	//3.列商品分類搜尋庫存結果
		public Inventory getCategory(Inventory cInventory) {
			String sql = "SELECT product_id,product_name,product_category,inventory_amount "
				+ "FROM Inventory,Product "
				+ "WHERE Product.product_id=Inventory.product_id "
				+ "AND product_category =?"
				+ "ORDER BY product_id";
			try {
				conn = dataSource.getConnection();
				smt = conn.prepareStatement(sql);
				smt.setString(1, cInventory.getProduct_category());//商品分類(第一個問號)
				rs = smt.executeQuery();
				if(rs.next()){
					cInventory.setProduct_id(rs.getString("product_id"));//商品編號		
					cInventory.setProduct_name(rs.getString("product_name"));//商品名稱
					cInventory.setProduct_category(rs.getString("product_category"));//商品分類
					cInventory.setInventory_amount(rs.getInt("inventory_amount"));//存貨數量
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
			return cInventory;
		}
		
	public List<Inventory> getList(String sql){
		List<Inventory> InventoryList = new ArrayList<Inventory>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){//Inventory aInventory
				Inventory aInventory = new Inventory();
				aInventory.setProduct_id(rs.getString("product_id"));//商品編號			
				aInventory.setProduct_name(rs.getString(" product_name"));//商品名稱
				aInventory.setProduct_category(rs.getString("product_category"));//商品分類
				aInventory.setInventory_amount(rs.getInt("inventory_amount"));//存貨數量
				InventoryList.add(aInventory);
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
		return InventoryList;
	}




	


	

}
