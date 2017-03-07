package com.mmt.tourism.pojo;

import java.util.ArrayList;
import java.util.List;

public class JsonModel<T> {
	private Page page;
	private List<T> result=new ArrayList<T>();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	
	
}
