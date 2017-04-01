package com.wgsh.receipt.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MessageResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean success = true;
	private String message = "";
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object result;
	
	public MessageResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public MessageResult() {
		super();
	}

	public MessageResult(boolean success, String message, Object result) {
		super();
		this.success = success;
		this.message = message;
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
	
	
	
	
	
	

}
