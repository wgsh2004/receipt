package com.wgsh.receipt.mapper;

import java.util.List;
import java.util.Map;

import com.wgsh.receipt.entity.Commodity;

public interface CommodityMapper {

	public int insert(Commodity entity);

	public int update(Commodity entity);

	public int delete(int id);

	public List<Commodity> select(Map<String ,Object> map);
	
	public int count(String parameter);
	
}
