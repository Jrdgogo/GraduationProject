package com.mmt.tourism.pojo;

public class Page {
	
	private int pages;
	private long totalNum;
	
	private int pageNum=1;
	private int pageSize=10;
	
	private long startRow;
	private long endRow;
	
	
	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public long getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}


	public long getStartRow() {
		return startRow;
	}


	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}


	public long getEndRow() {
		return endRow;
	}


	public void setEndRow(long endRow) {
		this.endRow = endRow;
	}

	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}


	public void setPage(com.github.pagehelper.Page<?> pagehelperPage, int size) {
		setPages(pagehelperPage.getPages());
		setTotalNum(pagehelperPage.getTotal());
		
		setPageNum(pagehelperPage.getPageNum());
		setPageSize(size);
		
		setStartRow((pagehelperPage.getPageNum()-1)*pagehelperPage.getPageSize()+1);
		setEndRow((pagehelperPage.getPageNum()-1)*pagehelperPage.getPageSize()+size);
	}

}
