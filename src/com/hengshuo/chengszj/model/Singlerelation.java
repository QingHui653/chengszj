package com.hengshuo.chengszj.model;

/**
 * Singlerelation entity. @author MyEclipse Persistence Tools
 */

public class Singlerelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer receiptid;
	private String userid;
	private String time;

	// Constructors

	/** default constructor */
	public Singlerelation() {
	}

	/** full constructor */
	public Singlerelation(Integer receiptid, String userid, String time) {
		this.receiptid = receiptid;
		this.userid = userid;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReceiptid() {
		return this.receiptid;
	}

	public void setReceiptid(Integer receiptid) {
		this.receiptid = receiptid;
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

}