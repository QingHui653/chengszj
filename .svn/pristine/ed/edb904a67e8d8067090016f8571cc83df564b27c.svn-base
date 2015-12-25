package com.hengshuo.chengszj.action;

import java.util.List;

import org.hibernate.ScrollableResults;

/*import cn.hengshuoframe.common.menu.Menu;*/

import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.common.util.PageInfo;
import com.opensymphony.xwork2.ActionSupport;


/*
 * Struts2 （其它Action继承它）基础Action 包括翻页属性封装，公共信息提示，继承ActionSupport等功能
 * @author song
 * @date 2009-7-1
 * @vesion 图书馆集成系统(dlibs) 1.1 
 *  
 */
public class BaseAction extends ActionSupport {
	private String badMessage; // 错误提示信息

	private String goodMessage; // 成功提示信息

	public String message; // 普通提示信息
	
	private MessageHelper messages; 

	private List result; // 结果集

	private int pageSize; // 每页条数

	private int pageNo; // 起始页

	private ScrollableResults scrollableResults;

	private int totalCount; // 记录总数

	private int totalPages; // 总页数
	
	private PageInfo pageInfo; //页面信息
	
	//private Menu menu; //页面菜单
	
	public String type; //多个action处理不通类型
	
	public String returnUrl;
	
	protected PageSupport pageSupport;
	
	public char isInit='n';  //是否action初始化 n=不是,y=是
	
	public String isUseAjax=""; //是否使用ajax
	
	

	

	public String getIsUseAjax() {
		return isUseAjax;
	}

	public void setIsUseAjax(String isUseAjax) {
		this.isUseAjax = isUseAjax;
	}

	public char getIsInit() {
		return isInit;
	}

	public void setIsInit(char isInit) {
		this.isInit = isInit;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}

	public ScrollableResults getScrollableResults() {
		return scrollableResults;
	}

	public void setScrollableResults(ScrollableResults scrollableResults) {
		this.scrollableResults = scrollableResults;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public String getBadMessage() {
		return badMessage;
	}

	public void setBadMessage(String badMessage) {
		this.badMessage = badMessage;
	}

	public String getGoodMessage() {
		return goodMessage;
	}

	public void setGoodMessage(String goodMessage) {
		this.goodMessage = goodMessage;
	}

	public PageSupport getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}

	public MessageHelper getMessages() {
		return messages;
	}

	public void setMessages(MessageHelper messages) {
		this.messages = messages;
	}

/*	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}*/

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

}