package com.hengshuo.chengszj.model;

/**
 * Feekback entity. @author MyEclipse Persistence Tools
 */

public class Feekback implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String userid;
	private String time;
	private String accept;

	// Constructors

	/** default constructor */
	public Feekback() {
	}

	/** full constructor */
	public Feekback(String content, String userid, String time, String accept) {
		this.content = content;
		this.userid = userid;
		this.time = time;
		this.accept = accept;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAccept() {
		return this.accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

}