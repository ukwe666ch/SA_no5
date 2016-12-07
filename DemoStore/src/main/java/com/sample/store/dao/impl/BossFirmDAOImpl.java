package com.sample.store.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.store.dao.BossFirmDAO;
import com.sample.store.entity.Firm;

public class BossFirmDAOImpl implements BossFirmDAO{
	
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	//修改廠商頻等
	public void update(Firm aFirm) {
		String sql = "UPDATE product SET firm_rank=? "
				+ "WHERE firm_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aFirm.getFirm_rank());//只能修改廠商頻等
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

	@Override
	//列廠商ID搜尋庫存結果
	public Firm get(Firm aFirm) {
		String sql = "SELECT * FROM firm WHERE firm_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aFirm.getFirm_id());//廠商名稱(第一個問號)
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
	
	@Override
	//列全部廠商
	public List<Firm> getList() {
		String sql = "SELECT * FROM Firm ORDER BY Firm_id";
		return getFirmList(sql);
	}
	
	@Override
	//2.廠商名稱關鍵字搜尋結果
	public Firm getNameFirm(Firm nFirm) {
		String sql = "SELECT * FROM Firm WHERE  firm_name = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, nFirm.getFirm_name());//廠商名稱(第一個問號)
			rs = smt.executeQuery();
			if(rs.next()){
				nFirm.setFirm_id(rs.getString("firm_id"));
				nFirm.setFirm_name(rs.getString("firm_name"));
				nFirm.setFirm_rank(rs.getString("firm_rank"));
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
		return nFirm;
	}

	@Override
	//3.廠商評等搜尋結果
	public Firm getRankFirm(Firm rFirm) {
		String sql = "SELECT * FROM Firm WHERE  firm_rank = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, rFirm.getFirm_rank());//廠商評等(第一個問號)
			rs = smt.executeQuery();
			
			if(rs.next()){
				rFirm.setFirm_id(rs.getString("firm_id"));
				rFirm.setFirm_name(rs.getString("firm_name"));
				rFirm.setFirm_rank(rs.getString("firm_rank"));
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
		return rFirm;
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



}
