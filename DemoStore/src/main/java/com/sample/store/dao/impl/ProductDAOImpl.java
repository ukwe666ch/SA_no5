package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;

//import com.mysql.jdbc.Statement;
import com.sample.store.entity.Product;
import com.sample.store.dao.ProductDAO;

//@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{
	//@Autowired
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Product aProduct) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO product (Category, Description, Inventory, ReorderPoint) VALUES(?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aProduct.getCategory());
			smt.setString(2, aProduct.getDesc());
			smt.setInt(3, aProduct.getInventory());
			smt.setInt(4, aProduct.getReorderPoint());
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

	public void delete(Product aProduct) {
		
		String sql = "DELETE FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getId());
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

	public void update(Product aProduct) {
		
		String sql = "UPDATE product SET Category=?, Description=?, Inventory=?, ReorderPoint=? "
				+ "WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aProduct.getCategory());
			smt.setString(2, aProduct.getDesc());
			smt.setInt(3, aProduct.getInventory());
			smt.setInt(4, aProduct.getReorderPoint());
			smt.setLong(5, aProduct.getId());
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
	
	public List<Product> getAvailableList() {
		String sql = "SELECT * FROM product WHERE Inventory > 0";
		return getList(sql);
	}
	

	public List<Product> getReorderList() {
		String sql = "SELECT * FROM product WHERE Inventory < ReorderPoint";
		return getList(sql);
	}

	public List<Product> getList() {
		String sql = "SELECT * FROM product";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<Product> getList(String sql) {
		
		List<Product> productList = new ArrayList<Product>();
		//will need this part later
		/*
		String sql = "SELECT * FROM article a "
				+ "JOIN article_category b ON a.articleCategoryID = b.articleCategoryID "
				+ "ORDER BY articleID DESC";
		*/
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Product aProduct = new Product();
				aProduct.setId(rs.getInt("productID"));			
				aProduct.setCategory(rs.getInt("category"));
				aProduct.setDesc(rs.getString("description"));
				//System.out.println(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
				productList.add(aProduct);
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
		return productList;
	}

	public Product get(Product aProduct) {
		
		String sql = "SELECT * FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				aProduct.setId(rs.getInt("productID"));
				aProduct.setCategory(rs.getInt("category"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
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
		return aProduct;
	}


}
