package com.wgsh.receipt.dto;

import java.util.List;

public class QueryResult<T> {
	
	private int count;
	
	private List<T> lists;
	
	public QueryResult() {
		super();
	}

	public QueryResult(int count, List<T> lists) {
		super();
		this.count = count;
		this.lists = lists;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}
	
	
	
	

}
