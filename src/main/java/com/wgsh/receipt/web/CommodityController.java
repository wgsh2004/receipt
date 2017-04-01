package com.wgsh.receipt.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wgsh.receipt.business.ICommodityBusiness;
import com.wgsh.receipt.dto.MessageResult;
import com.wgsh.receipt.dto.QueryResult;
import com.wgsh.receipt.entity.Commodity;


/**
 * @author Administrator
 *
 */
@RestController
public class CommodityController {
	
	public static final Logger logger = LoggerFactory.getLogger(CommodityController.class);

	@Autowired
	ICommodityBusiness business;
	
	@RequestMapping(value="/commodity" ,method={RequestMethod.POST})
	@ResponseBody
	public MessageResult add(@Valid @RequestBody Commodity entity, BindingResult result) {	
		if(result.hasErrors()){
			return new MessageResult(false, "添加商品信息出错",result.getAllErrors());
		}else{
			int id = business.insert(entity);
			if(id>0){
				return new MessageResult(false, "添加商品信息成功",id);
			}else{
				return new MessageResult(false, "添加商品信息失败");
			}
		}
	}
	
	@RequestMapping(value="/commodity" ,method={RequestMethod.PUT})
	@ResponseBody
	public MessageResult update(@Valid @RequestBody Commodity entity, BindingResult result) {	
		if(result.hasErrors()){
			return new MessageResult(false, "修改商品信息出错",result.getAllErrors());
		}else{
			int id = business.insert(entity);
			if(id>0){
				return new MessageResult(false, "修改商品信息成功",id);
			}else{
				return new MessageResult(false, "修改商品信息失败");
			}
		}
	}
	
	@RequestMapping(value="/commodity/{id}" ,method={RequestMethod.DELETE})
	@ResponseBody
	public MessageResult del(@PathVariable(name="id") int id) {	
		int count = business.delete(id);
		if(count >0){
			return new MessageResult(true, "删除商品信息成功");
		}else{
			return new MessageResult(false, "删除商品信息失败");
		}
	}
	
	
	@RequestMapping(value="/commodity" ,method={RequestMethod.GET})
	@ResponseBody
	public MessageResult select(@RequestParam(name="queryParam") String queryParam,
			@RequestParam(name="start",defaultValue="0")Integer start,
			@RequestParam(name="limit",defaultValue="0")Integer limit
			) {	
		int count = business.count(queryParam);
		
		if(count >0){
			List<Commodity> list = business.select(queryParam, start, limit);
			QueryResult<Commodity> queryResult = new QueryResult<Commodity>(count,list);
			return new MessageResult(true, "查询商品信息成功", queryResult);
		}else{
			return new MessageResult(false, "查询商品信息失败", new QueryResult<Commodity>(0,new ArrayList<Commodity>()));
		}
	}
}
