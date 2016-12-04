package com.sample.store.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.dao.BuyFirmProductDAO;
import com.sample.store.entity.Firm;
import com.sample.store.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyFirmProductDAOImpl implements BuyFirmProductDAO{
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//新增商品
	public void insertProduct(Product aProduct) {
		String sql = "INSERT INTO product (product_id, product_name, product_category, product_price, firm_id) VALUES(?, ?, ?, ?,?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getProduct_id());
			smt.setString(2, aProduct.getProduct_name());
			smt.setString(3, aProduct.getProduct_category());
			smt.setInt(4, aProduct.getProduct_price());
			smt.setString(5, aProduct.getFirm_id());
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

	//修改商品
	public void updateProduct(Product aProduct) {
		String sql = "UPDATE product SET product_name=?, product_category=?, product_price=?, firm_id=? "
				+ "WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getProduct_name());
			smt.setString(2, aProduct.getProduct_category());
			smt.setInt(3, aProduct.getProduct_price());
			smt.setString(4, aProduct.getFirm_id());
			smt.setString(5, aProduct.getProduct_id());
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

	//刪除商品
	public void deleteProduct(Product aProduct) {
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

	//新增廠商
	public void insertFirm(Firm aFirm) {
		 String sql = "INSERT INTO firm (firm_id, firm_name, firm_rank) VALUES(?, ?, ?, ?)";
		 try{
			 conn = dataSource.getConnection();
			 smt = conn.prepareStatement(sql);
			 //先建立一個 SQL 語句並回傳一個 PreparedStatement 物件
			 smt.setString(1,aFirm.getFirm_id());//對應到第一個問號
			 smt.setString(2,aFirm.getFirm_name());//對應到第二個問號
			 smt.setString(3,"A");//對應到第三個問號(新增廠商預設為A及廠商)
			 smt.executeUpdate();//真正執行			
			 smt.close();
			 
		 }catch(SQLException e){
			 throw new RuntimeException(e);
		 }finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {}
				}
			}
		
	}

	//修改廠商
	public void updateFirm(Firm aFirm) {
		String sql = "UPDATE product SET firm_name=? "
				+ "WHERE firm_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aFirm.getFirm_name());//只能修改廠商名稱
			smt.setString(2, aFirm.getFirm_id());
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

	//列全部廠商
	public List<Firm> getFirmList() {
		String sql = "SELECT * FROM Firm";
		return getFirmList(sql);
	}
	public List<Firm> getFirmList(String sql){
		List<Firm> FirmList = new ArrayList<Firm>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Firm aFirm = new Firm();
				aFirm.setFirm_id(rs.getString("firm_id"));			
				aFirm.setFirm_name(rs.getString(" firm_name"));
				aFirm.setFirm_rank(rs.getString("firm_rank"));
				FirmList.add(aFirm);//List<Firm> FirmList = new ArrayList<Firm>();
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
		return FirmList;
	}

	//列ID搜尋廠商結果
	public Firm get(Firm aFirm) {
		String sql = "SELECT * FROM firm WHERE firm_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aFirm.getFirm_id());
			rs = smt.executeQuery();
			
			if(rs.next()){
				aFirm.setFirm_id(rs.getString("firm_id"));
				aFirm.setFirm_name(rs.getString("firm_name"));
				aFirm.setFirm_rank(rs.getString("firm_rank"));
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
		return aFirm;
	}

	//列全部商品
	public List<Product> getProductList() {
		String sql = "SELECT * FROM product";
		return getList(sql);
	}

	//列商品分類搜尋
	public Product getCategory(Product cProduct) {
		String sql = "SELECT * FROM  Product WHERE Product_category=?";
		try {//product_id, product_name, product_category, product_price, firm_id
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, cProduct.getProduct_category());
			rs = smt.executeQuery();
			if(rs.next()){
				cProduct.setProduct_id(rs.getString("product_id"));
				cProduct.setProduct_name(rs.getString("product_name"));
				cProduct.setProduct_category(rs.getString("product_category"));
				cProduct.setProduct_price(rs.getInt("product_price"));
				cProduct.setFirm_id(rs.getString("firm_id"));
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
		return cProduct;
	}
	//列廠商搜尋商品結果
	public Product getProductFirm(Product fProduct) {
		String sql = "SELECT * FROM  Product WHERE firm_id=?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, fProduct.getFirm_id());
			rs = smt.executeQuery();
			if(rs.next()){
				fProduct.setProduct_id(rs.getString("product_id"));
				fProduct.setProduct_name(rs.getString("product_name"));
				fProduct.setProduct_category(rs.getString("product_category"));
				fProduct.setProduct_price(rs.getInt("product_price"));
				fProduct.setFirm_id(rs.getString("firm_id"));
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
		return fProduct;
	}
	public List<Product> getList(String sql) {
		List<Product> productList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Product aProduct = new Product();
				aProduct.setProduct_id(rs.getString("product_id"));			
				aProduct.setProduct_name(rs.getString(" product_name"));
				aProduct.setProduct_category(rs.getString("product_category"));
				aProduct.setProduct_price(rs.getInt("product_price"));
				aProduct.setFirm_id(rs.getString("Firm_id"));
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
	//列ID搜尋商品結果
	public Product get(Product aProduct) {
		String sql = "SELECT * FROM product WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getProduct_id());
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
