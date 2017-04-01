package com.wgsh.receipt.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wgsh.receipt.business.ICommodityBusiness;
import com.wgsh.receipt.entity.Commodity;
import com.wgsh.receipt.mapper.CommodityMapper;

@Service
public class CommodityBusinessImpl implements ICommodityBusiness {
	
	public static final Logger logger = LoggerFactory.getLogger(CommodityBusinessImpl.class);

	@Autowired
	private CommodityMapper mapper;

	@Override
	public int insert(Commodity entity) {
		return mapper.insert(entity);
	}

	@Override
	public int update(Commodity entity) {
		return mapper.update(entity);
	}

	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

	@Override
	public List<Commodity> select(String parameter, int start, int limit) {
		Map<String, Object> map = new HashMap<>();
		map.put("parameter", parameter);
		map.put("start", start);
		map.put("limit", limit);
		return mapper.select(map);
	}

	@Override
	public int count(String parameter) {
		return mapper.count(parameter);
	}

	
	

}
