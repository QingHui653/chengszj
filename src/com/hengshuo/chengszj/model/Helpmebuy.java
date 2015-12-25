package com.hengshuo.chengszj.model;

/**
 * Helpmebuy entity. @author MyEclipse Persistence Tools
 */

public class Helpmebuy implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sendTime;
	private String goodsname;
	private String purchaseLand;
	private String purchaseAsk;
	private String city;
	private String area;
	private String paymenttype;
	private String phone;
	private String receivingLand;
	private String jingwei;
	private Double reward;
	private String userid;
	private String fpingjia;
	private String jpingjia;
	private String cancel;
	private String time;
	private String status;
	private String remark;
	private String yuying;
	private String liuyan;
	private String type;
	private String pingjiatime;

	// Constructors

	/** default constructor */
	public Helpmebuy() {
	}

	/** full constructor */
	public Helpmebuy(String sendTime, String goodsname, String purchaseLand,
			String purchaseAsk, String city, String area, String paymenttype,
			String phone, String receivingLand, String jingwei, Double reward,
			String userid, String fpingjia, String jpingjia, String cancel,
			String time, String status, String remark, String yuying,
			String liuyan, String type, String pingjiatime) {
		this.sendTime = sendTime;
		this.goodsname = goodsname;
		this.purchaseLand = purchaseLand;
		this.purchaseAsk = purchaseAsk;
		this.city = city;
		this.area = area;
		this.paymenttype = paymenttype;
		this.phone = phone;
		this.receivingLand = receivingLand;
		this.jingwei = jingwei;
		this.reward = reward;
		this.userid = userid;
		this.fpingjia = fpingjia;
		this.jpingjia = jpingjia;
		this.cancel = cancel;
		this.time = time;
		this.status = status;
		this.remark = remark;
		this.yuying = yuying;
		this.liuyan = liuyan;
		this.type = type;
		this.pingjiatime = pingjiatime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getPurchaseLand() {
		return this.purchaseLand;
	}

	public void setPurchaseLand(String purchaseLand) {
		this.purchaseLand = purchaseLand;
	}

	public String getPurchaseAsk() {
		return this.purchaseAsk;
	}

	public void setPurchaseAsk(String purchaseAsk) {
		this.purchaseAsk = purchaseAsk;
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

	public String getPaymenttype() {
		return this.paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReceivingLand() {
		return this.receivingLand;
	}

	public void setReceivingLand(String receivingLand) {
		this.receivingLand = receivingLand;
	}

	public String getJingwei() {
		return this.jingwei;
	}

	public void setJingwei(String jingwei) {
		this.jingwei = jingwei;
	}

	public Double getReward() {
		return this.reward;
	}

	public void setReward(Double reward) {
		this.reward = reward;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFpingjia() {
		return this.fpingjia;
	}

	public void setFpingjia(String fpingjia) {
		this.fpingjia = fpingjia;
	}

	public String getJpingjia() {
		return this.jpingjia;
	}

	public void setJpingjia(String jpingjia) {
		this.jpingjia = jpingjia;
	}

	public String getCancel() {
		return this.cancel;
	}

	public void setCancel(String cancel) {
		this.cancel = cancel;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getYuying() {
		return this.yuying;
	}

	public void setYuying(String yuying) {
		this.yuying = yuying;
	}

	public String getLiuyan() {
		return this.liuyan;
	}

	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPingjiatime() {
		return this.pingjiatime;
	}

	public void setPingjiatime(String pingjiatime) {
		this.pingjiatime = pingjiatime;
	}

}