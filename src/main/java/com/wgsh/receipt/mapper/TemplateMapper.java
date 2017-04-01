package com.wgsh.receipt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wgsh.receipt.entity.Template;

public interface TemplateMapper {

	public int insert(Template entity);

	public int update(Template entity);

	public int delete(int id);

	public List<Template> select(@Param(value ="queryParam")String queryParam ,
			@Param(value ="start" )int start ,
			@Param(value ="limit")int limit);
	
	public int count(@Param(value ="queryParam")String queryParam);
	
}
