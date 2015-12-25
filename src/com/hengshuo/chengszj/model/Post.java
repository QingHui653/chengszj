package com.hengshuo.chengszj.model;

/**
 * Post entity. @author MyEclipse Persistence Tools
 */

public class Post implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private String time;
	private String userid;
	private Integer share;
	private Integer zan;
	private String image;
	private Integer number;

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** full constructor */
	public Post(String title, String content, String time, String userid,
			Integer share, Integer zan, String image, Integer number) {
		this.title = title;
		this.content = content;
		this.time = time;
		this.userid = userid;
		this.share = share;
		this.zan = zan;
		this.image = image;
		this.number = number;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getShare() {
		return this.share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public Integer getZan() {
		return this.zan;
	}

	public void setZan(Integer zan) {
		this.zan = zan;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}