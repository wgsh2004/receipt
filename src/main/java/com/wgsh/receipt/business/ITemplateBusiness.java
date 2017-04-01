package com.wgsh.receipt.business;

import java.util.List;

import com.wgsh.receipt.entity.Template;

public interface ITemplateBusiness {
		
	public int insert(Template entity);

	public int update(Template entity);

	public int delete(int id);

	public List<Template> select(String parameter,int start,int limit);
	
	public int count(String parameter);
	

}
