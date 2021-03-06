package com.wgsh.receipt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wgsh.receipt.entity.Commodity;

public interface CommodityMapper {

	public int insert(Commodity entity);

	public int update(Commodity entity);

	public int delete(int id);

	public List<Commodity> select(@Param(value ="queryParam")String queryParam ,
			@Param(value ="start" )int start ,
			@Param(value ="limit")int limit);
	
	public int count(@Param(value ="queryParam")String queryParam);
	
}
