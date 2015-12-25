package com.hengshuo.chengszj.common.util;


/**
 * @author song Email:J2EE123@yeah.net
 * @date 2010-3-4 上午11:33:28
 * @vesion 图书馆集成系统(dlibs) 1.1
 * @类说明:
 */
public class PageInfo {

	private   String title;  //页面标题
	private String subTitle; //页面提示标题
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public PageInfo(String title, String subTitle) {
		this.title = title;
		this.subTitle = subTitle;
	}
	
}

