package com.hengshuo.chengszj.model;

/**
 * Buyrelation entity. @author MyEclipse Persistence Tools
 */

public class Buyrelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer helpMeId;
	private String userid;
	private String time;
	private String type;

	// Constructors

	/** default constructor */
	public Buyrelation() {
	}

	/** full constructor */
	public Buyrelation(Integer helpMeId, String userid, String time, String type) {
		this.helpMeId = helpMeId;
		this.userid = userid;
		this.time = time;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHelpMeId() {
		return this.helpMeId;
	}

	public void setHelpMeId(Integer helpMeId) {
		this.helpMeId = helpMeId;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}