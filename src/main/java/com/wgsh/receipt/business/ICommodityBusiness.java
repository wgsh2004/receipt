package com.wgsh.receipt.business;

import java.util.List;

import com.wgsh.receipt.entity.Commodity;

public interface ICommodityBusiness {
		
	public int insert(Commodity entity);

	public int update(Commodity entity);

	public int delete(int id);

	public List<Commodity> select(String parameter,int start,int limit);
	
	public int count(String parameter);
	

}
