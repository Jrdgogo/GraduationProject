package com.mmt.tourism.util;

public class Page {
	//总的记录数
	private int totalNumber;
	//当前的页数
	private int currentPage=1;
	//总页数
	private int totalPage;
	//每页显示记录数
	private int pageNumber=20;
	//mysql分页语句：limit （currentPage-1）*dbNumber，dbNumber
	//limit第一个参数，第几条记录
	private int dbindex;
	//limit第二个参数，取几条记录(一般与显示数pageNumber相等)
	private int dbNumber;
	

	public void count(){
		//计算总页数
		int totalPageTemp=this.totalNumber/this.pageNumber;
		int mod=(this.totalNumber%this.pageNumber)==0?0:1;
		totalPageTemp+=mod;
		//保持数据合理性>=1
		if(totalPageTemp<=0)
			totalPageTemp=1;
		this.totalPage=totalPageTemp;
		
		//设置当前页数
		//合理性处理
		if(this.totalPage<this.currentPage)
			this.currentPage=this.totalPage;
		if(this.currentPage<=0)
			this.currentPage=1;
		//设置limit参数
		this.dbNumber=this.pageNumber;
		this.dbindex=(this.currentPage-1)*this.dbNumber;
	}


	public int getTotalNumber() {
		return totalNumber;
	}


	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		count();
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getDbindex() {
		return dbindex;
	}


	public void setDbindex(int dbindex) {
		this.dbindex = dbindex;
	}


	public int getDbNumber() {
		return dbNumber;
	}


	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}

	
}
