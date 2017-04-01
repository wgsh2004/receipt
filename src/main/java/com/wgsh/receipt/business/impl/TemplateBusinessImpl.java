package com.wgsh.receipt.business.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wgsh.receipt.business.ITemplateBusiness;
import com.wgsh.receipt.entity.Template;
import com.wgsh.receipt.mapper.TemplateMapper;

@Service
public class TemplateBusinessImpl implements ITemplateBusiness {
	
	public static final Logger logger = LoggerFactory.getLogger(TemplateBusinessImpl.class);

	@Autowired
	private TemplateMapper mapper;

	@Override
	public int insert(Template entity) {
		return mapper.insert(entity);
	}

	@Override
	public int update(Template entity) {
		return mapper.update(entity);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public List<Template> select(String parameter, int start, int limit) {
		/*Map<String, Object> map = new HashMap<>();
		map.put("parameter", parameter);
		map.put("start", start);
		map.put("limit", limit);*/
		return mapper.select(parameter,(start -1) * limit,limit);
	}

	@Override
	public int count(String parameter) {
		return mapper.count(parameter);
	}

	
	

}
