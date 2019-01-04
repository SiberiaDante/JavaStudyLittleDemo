package com.dante.mybatis.bean.entity;

public class Page {

	private int totalPage;
	private int currentPage;
	private int pageNum = 10;
	private int totaNum;
	private int dbIndex;
	private int dbNum;

	public void count() {
		int totalPageTemp = this.totaNum / this.pageNum;
		int plus = (this.totaNum % this.pageNum == 0) ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;
		if (this.currentPage <= 0) {
			this.currentPage = 1;
		}
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
		this.dbIndex = (this.currentPage - 1) * this.pageNum;
		this.dbNum = this.pageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotaNum() {
		return totaNum;
	}

	public void setTotaNum(int totaNum) {
		this.totaNum = totaNum;
		count();
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNum() {
		return dbNum;
	}

	public void setDbNum(int dbNum) {
		this.dbNum = dbNum;
	}

}
