package com.hengshuo.chengszj.model;

/**
 * Receipt entity. @author MyEclipse Persistence Tools
 */

public class Receipt implements java.io.Serializable {

	// Fields

	private Integer id;
	private String pickupTime;
	private String itemType;
	private String itemName;
	private Double itemWeight;
	private Integer itemValue;
	private String vehicle;
	private String currentCity;
	private String area;
	private String deliveryPlace;
	private String receivingLand;
	private String jingwei;
	private Double unitprice;
	private Double premium;
	private Double shippingCost;
	private String finishTime;
	private String shipper;
	private String shipperPhone;
	private String consignee;
	private String consigneePhone;
	private String paymentType;
	private String idCard;
	private String textExplain;
	private String voiceExplain;
	private String itemPhoto;
	private String status;
	private String flag;
	private String company;
	private String fpingjia;
	private String jpingjia;
	private String userid;
	private String cancel;
	private String time;
	private String liuyan;
	private String pingjiatime;

	// Constructors

	/** default constructor */
	public Receipt() {
	}

	/** full constructor */
	public Receipt(String pickupTime, String itemType, String itemName,
			Double itemWeight, Integer itemValue, String vehicle,
			String currentCity, String area, String deliveryPlace,
			String receivingLand, String jingwei, Double unitprice,
			Double premium, Double shippingCost, String finishTime,
			String shipper, String shipperPhone, String consignee,
			String consigneePhone, String paymentType, String idCard,
			String textExplain, String voiceExplain, String itemPhoto,
			String status, String flag, String company, String fpingjia,
			String jpingjia, String userid, String cancel, String time,
			String liuyan, String pingjiatime) {
		this.pickupTime = pickupTime;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemWeight = itemWeight;
		this.itemValue = itemValue;
		this.vehicle = vehicle;
		this.currentCity = currentCity;
		this.area = area;
		this.deliveryPlace = deliveryPlace;
		this.receivingLand = receivingLand;
		this.jingwei = jingwei;
		this.unitprice = unitprice;
		this.premium = premium;
		this.shippingCost = shippingCost;
		this.finishTime = finishTime;
		this.shipper = shipper;
		this.shipperPhone = shipperPhone;
		this.consignee = consignee;
		this.consigneePhone = consigneePhone;
		this.paymentType = paymentType;
		this.idCard = idCard;
		this.textExplain = textExplain;
		this.voiceExplain = voiceExplain;
		this.itemPhoto = itemPhoto;
		this.status = status;
		this.flag = flag;
		this.company = company;
		this.fpingjia = fpingjia;
		this.jpingjia = jpingjia;
		this.userid = userid;
		this.cancel = cancel;
		this.time = time;
		this.liuyan = liuyan;
		this.pingjiatime = pingjiatime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPickupTime() {
		return this.pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemWeight() {
		return this.itemWeight;
	}

	public void setItemWeight(Double itemWeight) {
		this.itemWeight = itemWeight;
	}

	public Integer getItemValue() {
		return this.itemValue;
	}

	public void setItemValue(Integer itemValue) {
		this.itemValue = itemValue;
	}

	public String getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getCurrentCity() {
		return this.currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDeliveryPlace() {
		return this.deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
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

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getPremium() {
		return this.premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public Double getShippingCost() {
		return this.shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getShipper() {
		return this.shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getShipperPhone() {
		return this.shipperPhone;
	}

	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}

	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneePhone() {
		return this.consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTextExplain() {
		return this.textExplain;
	}

	public void setTextExplain(String textExplain) {
		this.textExplain = textExplain;
	}

	public String getVoiceExplain() {
		return this.voiceExplain;
	}

	public void setVoiceExplain(String voiceExplain) {
		this.voiceExplain = voiceExplain;
	}

	public String getItemPhoto() {
		return this.itemPhoto;
	}

	public void setItemPhoto(String itemPhoto) {
		this.itemPhoto = itemPhoto;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getLiuyan() {
		return this.liuyan;
	}

	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}

	public String getPingjiatime() {
		return this.pingjiatime;
	}

	public void setPingjiatime(String pingjiatime) {
		this.pingjiatime = pingjiatime;
	}

}