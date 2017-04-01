package com.wgsh.receipt.entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Commodity {
	
	private Integer id;
	
	@Size(max=20,message="编码不能超过20个字符")
	private String code;
	
	@NotNull(message="名称不能为空")
	@Size(max=30,message="名称不能超过30个字符")
	private String name;
	
	@Size(max=200,message="备注不能超过200个字符")
	private String remark;;
	
	@Min(value=0,message="单价不能低于0")
	@Digits(fraction=2, integer = 6)
	private double unitPrice;	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

}
