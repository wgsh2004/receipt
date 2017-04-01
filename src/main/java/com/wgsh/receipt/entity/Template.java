package com.wgsh.receipt.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Template {
	
	private int id;
	
	@NotBlank(message="名称不能为空")
	@Size(max=30,message="名称不能超过30个字符")
	private String name;
	
	@NotBlank(message="内容不能为空")
	@Size(max=2000,message="备注不能超过2000个字符")
	private String content;;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
