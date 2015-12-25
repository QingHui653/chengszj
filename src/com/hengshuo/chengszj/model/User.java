package com.hengshuo.chengszj.model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userid;
	private String password;
	private String name;
	private String tixianPassword;
	private Integer integral;
	private Double balance;
	private String creditrating;
	private String phone;
	private String headphoto;
	private String verifycode;
	private String dizhi;
	private String weizhi;
	private String dengrutime;
	private String status;
	private String qianmin;
	private String zhiye;
	private String ip;
	private String city;
	private String area;
	private String sex;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userid, String password, String name,
			String tixianPassword, Integer integral, Double balance,
			String creditrating, String phone, String headphoto,
			String verifycode, String dizhi, String weizhi, String dengrutime,
			String status, String qianmin, String zhiye, String ip,
			String city, String area, String sex) {
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.tixianPassword = tixianPassword;
		this.integral = integral;
		this.balance = balance;
		this.creditrating = creditrating;
		this.phone = phone;
		this.headphoto = headphoto;
		this.verifycode = verifycode;
		this.dizhi = dizhi;
		this.weizhi = weizhi;
		this.dengrutime = dengrutime;
		this.status = status;
		this.qianmin = qianmin;
		this.zhiye = zhiye;
		this.ip = ip;
		this.city = city;
		this.area = area;
		this.sex = sex;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTixianPassword() {
		return this.tixianPassword;
	}

	public void setTixianPassword(String tixianPassword) {
		this.tixianPassword = tixianPassword;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getCreditrating() {
		return this.creditrating;
	}

	public void setCreditrating(String creditrating) {
		this.creditrating = creditrating;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHeadphoto() {
		return this.headphoto;
	}

	public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}

	public String getVerifycode() {
		return this.verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getDizhi() {
		return this.dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getWeizhi() {
		return this.weizhi;
	}

	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}

	public String getDengrutime() {
		return this.dengrutime;
	}

	public void setDengrutime(String dengrutime) {
		this.dengrutime = dengrutime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQianmin() {
		return this.qianmin;
	}

	public void setQianmin(String qianmin) {
		this.qianmin = qianmin;
	}

	public String getZhiye() {
		return this.zhiye;
	}

	public void setZhiye(String zhiye) {
		this.zhiye = zhiye;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}