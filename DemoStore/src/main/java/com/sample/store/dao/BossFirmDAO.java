package com.sample.store.dao;

import java.util.List;

import com.sample.store.entity.Firm;

/*依照1. 廠商編號　2. 廠商名稱關鍵字　3.廠商評等
列出廠商編號、廠商名稱、廠商評等
排序依照廠商編號由大至小*/
public interface BossFirmDAO {
	public void update(Firm aFirm);//修改廠商頻等
	public List<Firm> getList();//列全部廠商
	public Firm get(Firm aFirm);//1.列廠商ID搜尋結果
	public Firm getNameFirm(Firm nFirm);//2.廠商名稱關鍵字搜尋結果
	public Firm getRankFirm(Firm rFirm);//3.廠商評等搜尋結果
	
}
