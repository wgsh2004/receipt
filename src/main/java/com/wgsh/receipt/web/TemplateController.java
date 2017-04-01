package com.wgsh.receipt.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wgsh.receipt.business.ITemplateBusiness;
import com.wgsh.receipt.dto.MessageResult;
import com.wgsh.receipt.dto.QueryResult;
import com.wgsh.receipt.entity.Template;


/**
 * @author Administrator
 *
 */
@RestController
public class TemplateController {
	
	public static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	@Autowired
	ITemplateBusiness business;
	
	@RequestMapping(value="/template" ,method={RequestMethod.POST})
	@ResponseBody
	public MessageResult save(@Validated @RequestBody Template entity, BindingResult result) {	
		if(result.hasErrors()){
			List<ObjectError> listError = result.getAllErrors();
			StringBuffer sb = new StringBuffer();
			
			for(ObjectError error :listError){
				sb.append(error.getDefaultMessage());
				sb.append(",");
			}
			return new MessageResult(false, sb.toString());
		}else{
			if(entity .getId()>0){
				int count = business.update(entity);
				if(count>0){
					return new MessageResult(true, "修改模板信息成功");
				}else{
					return new MessageResult(false, "修改模板信息失败");
				}
			}else{
				int id = business.insert(entity);
				if(id>0){
					return new MessageResult(true, "添加模板信息成功");
				}else{
					return new MessageResult(false, "添加模板信息失败");
				}
			}
			
			
		}
	}
	
		
	@RequestMapping(value="/template/{id}" ,method={RequestMethod.DELETE})
	@ResponseBody
	public MessageResult del(@PathVariable(name="id") int id) {	
		int count = business.delete(id);
		if(count >0){
			return new MessageResult(true, "删除模板信息成功");
		}else{
			return new MessageResult(false, "删除模板信息失败");
		}
	}
	
	
	@RequestMapping(value="/template" ,method={RequestMethod.GET})
	@ResponseBody
	public MessageResult select(@RequestParam(name="queryParam") String queryParam,
			@RequestParam(name="start",defaultValue="1")Integer start,
			@RequestParam(name="limit",defaultValue="15")Integer limit
			) {	
		int count = business.count(queryParam);
		
		if(count >0){
			List<Template> list = business.select(queryParam, start, limit);
			QueryResult<Template> queryResult = new QueryResult<Template>(count,list);
			return new MessageResult(true, "查询模板信息成功", queryResult);
		}else{
			return new MessageResult(false, "查询模板信息失败", new QueryResult<Template>(0,new ArrayList<Template>()));
		}
	}
}
