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
		
		setPages(pagehelperPage.getPages()<1?1:pagehelperPage.getPages());
		setTotalNum(pagehelperPage.getTotal());
		
		if(pageNum>pagehelperPage.getPageNum()){
			setPageNum(pagehelperPage.getPageNum()<1?1:pagehelperPage.getPageNum());
			overPage();
			return;
		}
		
		setPageNum(pagehelperPage.getPageNum()<1?1:pagehelperPage.getPageNum());
		setPageSize(size);
		
		Integer index=(pageNum-1)*pagehelperPage.getPageSize();
		setStartRow(pageSize<=0?0:(index+1));
		setEndRow(pageSize<=0?0:(index+pageSize));
	}


	private void overPage() {
		pageSize=0;
	    startRow=0;
	    endRow=0;
	}

}
