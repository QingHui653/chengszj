package com.hengshuo.chengszj.common.page;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;

public class PageSupport<T> {
	public List result;                             //结果集
	public int pageSize=20;                            //每页条数
	public int startPage;                           //起始页
	     
	public int totalCount;                          //记录总数
	public int totalPages;                          //总页数
	
	public String actionUrl;  //分页的action路径
	
	public final static int  PAGE_SIZE=20;  //默认20条数据
	
	public String getActionUrl() {
		return actionUrl;
	}
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	
    public int nextPage;
	
	public int prePage;
	
	
	
	
	public int getNextPage() {
		return this.startPage+1;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrePage() {
		return this.startPage-1;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	
	
	public PageSupport(){
		
	}
	
	public PageSupport(int startPage){
		this.startPage=startPage;
	}
	
	public PageSupport(int startPage,int pageSize){
		
		this.startPage=startPage;
		System.out.print(this.startPage);
//		setStartPage(startPage);
		this.pageSize=pageSize;
	}
	
	public PageSupport(int startPage, int pageSize,Query query) {
		 ScrollableResults scrollableResults;
		this.startPage = startPage;
		this.pageSize = pageSize;
		try {
			scrollableResults = query.scroll();
			scrollableResults.last();
			if(scrollableResults.getRowNumber()>=0) {
				this.totalCount = scrollableResults.getRowNumber()+1;
			} else {
				this.totalCount = 0;
			}
			this.setTotalPages();
			query.setFirstResult((this.getStartPage()-1)*this.pageSize);
			query.setMaxResults(this.pageSize);
			this.setResult(query.list());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public PageSupport(int startPage, int pageSize,Criteria query) {
		this.startPage = startPage;
		this.pageSize = pageSize;
		ScrollableResults scrollableResults;
		try {
			scrollableResults = query.scroll();
			scrollableResults.last();
			if(scrollableResults.getRowNumber()>=0) {
				this.totalCount = scrollableResults.getRowNumber()+1;
			} else {
				this.totalCount = 0;
			}
			this.setTotalPages();
			query.setFirstResult((this.getStartPage()-1)*this.pageSize);
			query.setMaxResults(this.pageSize);
			this.setResult(query.list());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 返回查询结果集
	 * @return
	 */
	public List getResult() {
		return result;
	}
	
	/**
	 * 设置查询结果集
	 * @param result
	 */
	public void setResult(List result) {
		this.result = result;
	}
	
	/**
	 * 返回起始页
	 * @return
	 */
	public int getStartPage() {
		if(startPage <1) {
			startPage = 1;
		}
		if(totalPages!=0){
		if(startPage >totalPages) {
			startPage = totalPages;
		}
		}
		return startPage;
	}
	
	/**
	 * 返回记录总数
	 * @return
	 */
	public int getTotalCount() {
		return this.totalCount;
	}
	
	/**
	 * 返回页面大小
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	
	/**
	 * 判断是否为第一页
	 * @return
	 */
	public boolean isFirstPage() {
		return this.startPage == 1;
	}
	
	/**
	 * 判断是否有后一页
	 * @return
	 */
	public boolean hasNextPage() {
		return this.startPage < this.totalPages;
	}
	
	/**
	 * 判断是否有前一页
	 * @return
	 */
	public boolean hasPreviousePage() {
		return this.startPage < 1;
	}
	
	/**
	 * 设置总页数
	 *
	 */
	private void setTotalPages() {
		this.totalPages = this.totalCount/this.pageSize;
		if(this.totalPages*this.pageSize<this.totalCount) {
			totalPages ++;
		}
	}
	
	/**
	 * 返回总页数
	 * @return
	 */
	public int getTotalPages() {
		return this.totalPages;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setTotalPages();
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
