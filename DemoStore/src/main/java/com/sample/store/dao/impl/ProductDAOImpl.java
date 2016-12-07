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
		//新增產品(非新廠商)
		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO product (product_id, product_name, product_category, product_price) VALUES(?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getProduct_id());
			smt.setString(2, aProduct.getProduct_name());
			smt.setString(3, aProduct.getProduct_category());
			smt.setInt(4, aProduct.getProduct_price());
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
		
		String sql = "DELETE FROM product WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getProduct_id());
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
		//修改商品
		String sql = "UPDATE product SET product_name=?, product_category=?, product_price=? "
				+ "WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getProduct_name());
			smt.setString(2, aProduct.getProduct_category());
			smt.setInt(3, aProduct.getProduct_price());
			
			smt.setString(4, aProduct.getProduct_id());
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
	/*
	//Inventory �o���
	public List<Product> getAvailableList() {//庫存
		String sql = "SELECT * FROM Inventory WHERE product_amount > 0";
		return getList(sql);
	}
	

	public List<Product> getReorderList() {//庫存
		String sql = "SELECT * FROM Inventory WHERE Inventory < 10";
		return getList(sql);
	}
	 */
	public List<Product> getCategoryList() {//以產品分類
		String sql = "SELECT * FROM  Product WHERE Product_category=?";
		return getList(sql);
	}
	
	public List<Product> getList() {//product的內容
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
		try {//product_id, product_name, product_category, product_price
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Product aProduct = new Product();
				aProduct.setProduct_id(rs.getString("product_id"));			
				aProduct.setProduct_name(rs.getString(" product_name"));
				aProduct.setProduct_category(rs.getString("product_category"));
				aProduct.setProduct_price(rs.getInt("product_price"));
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

	public Product get(Product aProduct) {//product_id, product_name, product_category, product_price
		//列ID搜尋結果
		String sql = "SELECT * FROM product WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);

			rs = smt.executeQuery();
			if(rs.next()){
				aProduct.setProduct_id(rs.getString("product_id"));
				aProduct.setProduct_name(rs.getString("product_name"));
				aProduct.setProduct_category(rs.getString("product_category"));
				aProduct.setProduct_price(rs.getInt("product_price"));
			
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
