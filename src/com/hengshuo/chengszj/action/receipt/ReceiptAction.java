package com.hengshuo.chengszj.action.receipt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.aspectj.apache.bcel.generic.AALOAD;

import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.common.page.Base64;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.Arithmetic4Double;
import com.hengshuo.chengszj.common.util.BaiduMap;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.ImageUpload;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.model.Buyrelation;
import com.hengshuo.chengszj.model.Helpmebuy;
import com.hengshuo.chengszj.model.Integral;
import com.hengshuo.chengszj.model.Message;
import com.hengshuo.chengszj.model.Receipt;
import com.hengshuo.chengszj.model.Singlerelation;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.service.buyrelation.BuyrelationService;
import com.hengshuo.chengszj.service.helpmebuy.HelpmebuyService;
import com.hengshuo.chengszj.service.impl.receipt.ReceiptServiceI;
import com.hengshuo.chengszj.service.integral.IntegralService;
import com.hengshuo.chengszj.service.message.MessageService;
import com.hengshuo.chengszj.service.receipt.ReceiptService;
import com.hengshuo.chengszj.service.singlerelation.SinglerelationService;
import com.hengshuo.chengszj.service.user.UserService;

public class ReceiptAction extends BaseAction implements RequestAware {
	private static final Logger log=Logger.getLogger(ReceiptAction.class.getName());
	private ReceiptService receiptService;
	public void setReceiptService(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private HelpmebuyService helpmebuyService;
	public void setHelpmebuyService(HelpmebuyService helpmebuyService) {
		this.helpmebuyService = helpmebuyService;
	}
	private IntegralService integralService;
	public void setIntegralService(IntegralService integralService) {
		this.integralService = integralService;
	}
	private SinglerelationService service;
	public void setService(SinglerelationService service) {
		this.service = service;
	}
	private Integer singleid;
	public void setSingleid(Integer singleid) {
		this.singleid = singleid;
	}
	private String singleuserid;
	public void setSingleuserid(String singleuserid) {
		this.singleuserid = singleuserid;
	}
	
	private SinglerelationService singlerelationService;
	public void setSinglerelationService(
			SinglerelationService singlerelationService) {
		this.singlerelationService = singlerelationService;
	}
	private BuyrelationService buyrelationService;
	public void setBuyrelationService(BuyrelationService buyrelationService) {
		this.buyrelationService = buyrelationService;
	}
	private  MessageService messageService;
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	

	 private String files;
	 public void setFiles(String files) {
		this.files = files;
	}
	 private String pingjiatime;
	 public void setPingjiatime(String pingjiatime) {
		this.pingjiatime = pingjiatime;
	}
	 /**
	  * 接单人评价
	  */
	 public String jPingJiajson(){
		 try {
			Receipt receipt=receiptService.get(id);
			receipt.setJpingjia(new String(jpingjia.getBytes("iso8859-1"), "utf-8"));
			receiptService.saveOrUpdate(receipt);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage(Define.F_MESSAGE);
		 	  setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	 
	 
	/**
	 * 发单人评价返回json
	 * @return 
	 */
	public String pingJiajson(){
		try {
			Receipt receipt=receiptService.get(id);
			receipt.setFpingjia(new String(fpingjia.getBytes("iso8859-1"), "utf-8"));
			receipt.setStatus(Define.RECEIPT_STATUS_5);
			receipt.setPingjiatime(DateTimeUtil.currentDatetime());
			receiptService.saveOrUpdate(receipt);
			if (receipt.getPaymentType().equals(Define.PAY_TYPE_O)) {
				
				Singlerelation singlerelation=service.findByreceiptid(id);
				User user2=userService.findUserByUserid(singlerelation.getUserid()).get(0);
				Double balance=user2.getBalance();
				user2.setBalance(Arithmetic4Double.add(balance, receipt.getShippingCost().doubleValue()));
				userService.saveOrUpdate(user2);
			}
			
			
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
	 	   setMessageHelper(mh);
			} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage(Define.F_MESSAGE);
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}

	
	
	/**
	 * 
	 * 余额支付
	 * @param userid
	 * @param 支付的钱
	 */
	public String yuEPay(){
		try {
			MessageHelper mh = new MessageHelper();
			User user=userService.findUserByUserid(userid).get(0);
			Double money=user.getBalance();
			Receipt receipt=receiptService.get(id);
			Double reMoney=receipt.getShippingCost();
			if (money>reMoney) {
			    user.setBalance(Arithmetic4Double.sub(money, reMoney));
			    userService.saveOrUpdate(user);
			    receipt.setStatus(Define.RECEIPT_STATUS_2);
			    receiptService.saveOrUpdate(receipt);
		 		 mh.setResult(Define.S);
		 	}else {
		 		 mh.setResult(Define.F);
		 		 mh.setMessage("余额不足，支付失败");
			}
			 setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage(Define.F_MESSAGE);
	 		 setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	} 
	
	
	

	
	
	/**
	 * 我的发单 帮我送JSON
	 * @return 
	 */
	public  String jsonMyFaDan(){
		try {
			String query="from Receipt where userid=? ORDER BY id DESC";
			Object[] values={userid};
			List<Receipt> receipts2=receiptService.find(query, values);
			List<Receipt> receipts=new ArrayList<Receipt>();
		for (Receipt s:receipts2) {
			List<Singlerelation> b=service.Byreceiptid(s.getId());
			if (b.size()>0) {
				s.setUserid(b.get(0).getUserid());
			}else {
				s.setUserid(null);
			}
		
			receipts.add(s);
		}
		request.put("userid",userid);
		//List<Receipt> receiptss=BaiduMap.getRejuli(receipts);
	//request.put("receipts", receiptss);
	MessageHelper mh = new MessageHelper();
		mh.setResult(Define.S);
		mh.setList(receipts);
		
	 	  setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage(Define.F_MESSAGE);
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return  "OK";
	}
	
	
	
	
	/**
	 * 我的发单 帮我送
	 * @return 
	 */
	public  String myFaDan(){
		try {
			String query="from Receipt where userid=? ORDER BY id DESC";
			Object[] values={userid};
			List<Receipt> receipts2=receiptService.find(query, values);
			List<Receipt> receipts=new ArrayList<Receipt>();
		for (Receipt s:receipts2) {
			List<Singlerelation> b=service.Byreceiptid(s.getId());
			if (b.size()>0) {
				s.setTime(b.get(0).getTime());
				s.setUserid(b.get(0).getUserid());
			}else {
				s.setTime(null);
				s.setUserid(null);
			}
		
			receipts.add(s);
		}
		request.put("userid",userid);
		List<Receipt> receiptss=BaiduMap.getRejuli(receipts);
	request.put("receipts", receiptss);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage(Define.F_MESSAGE);
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return  "OK";
	}
	
	
	/**
	 * 帮我送单
	 * @return 
	 */
	public String listReceipt(){
		try {
			
			String query="from Receipt where status=? and currentCity=? ORDER BY time DESC";
			Object[] values={Define.RECEIPT_STATUS_2,new String(currentCity.getBytes("iso8859-1"), "utf-8")};
			List<Receipt> receipts	=receiptService.find(query, values);
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
			mh.setList(receipts);
			setMessageHelper(mh);
			
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage(Define.F_MESSAGE);
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}
	
	
	/**
	 * 修改订单
	 */
	public String updateReceipt(){
		try {
		Receipt receipt=receiptService.get(id);
		receipt.setShipper(shipper);
		receipt.setShipperPhone(shipperPhone);
		receipt.setConsignee(consignee);
		receipt.setConsigneePhone(consigneePhone);
		receipt.setTime(DateTimeUtil.currentDatetime());
		receiptService.saveOrUpdate(receipt);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage("修改失败");
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	

	/**
	 * 添加帮我送
	 * @return 
	 */
	public String addReceipt(){
		try {
			Receipt receipt=new Receipt();
			receipt.setUserid(userid);
			receipt.setPickupTime(pickupTime);
			receipt.setItemType(itemType);
			receipt.setItemName(itemName);
			receipt.setItemWeight(itemWeight);
			receipt.setItemValue(itemValue);
			receipt.setVehicle(vehicle);
			receipt.setCurrentCity(currentCity);
			receipt.setDeliveryPlace(deliveryPlace);
			receipt.setReceivingLand(receivingLand);
			receipt.setPremium(premium);
			receipt.setUnitprice(unitprice);
			receipt.setArea(area);
		
			receipt.setShippingCost(shippingCost);
			receipt.setFinishTime(finishTime);
			receipt.setShipper(shipper);
			receipt.setShipperPhone(shipperPhone);
			receipt.setJingwei(jingwei);
			receipt.setConsignee(consignee);
			receipt.setConsigneePhone(consigneePhone);
			receipt.setPaymentType(paymentType);
			receipt.setIdCard(idCard);
			receipt.setTextExplain(textExplain);
			if (voiceExplain!=null) {
				 String root = ServletActionContext.getServletContext().getRealPath(Define.IMAGES_RECEIPT);
				 	String  url="/"+userid+DateTimeUtil.toRandom(5)+".amr";
				 	Base64.GenerateFile(voiceExplain, root+url);
				 	receipt.setVoiceExplain(Define.IMAGES_RECEIPT+url);
			}
			receipt.setFlag(flag);
			receipt.setCompany(company);
			
			String time=DateTimeUtil.currentDatetime();
			receipt.setTime(time);
			
			if(itemPhoto!=null){
				/*String url=ImageUpload.imageupload(itemPhoto, Define.IMAGES_RECEIPT, userid,"Receipt");
				*/
			String url=ImageUpload.duoGeImage(itemPhoto, Define.IMAGES_RECEIPT, userid);
				receipt.setItemPhoto(url);
			}
			if (paymentType.equals(Define.PAY_TYPE_X)) {
				receipt.setStatus(Define.RECEIPT_STATUS_2);
				Message message=new Message();
				message.setContent("恭喜你成功发单帮我送,订单名称("+itemName+")");
				message.setTime(time);
				message.setUserid(userid);
				messageService.save(message);
				
				int jifen=3;
				
				Integral integral=new Integral();
				integral.setContent("成功发单帮我送,订单名称("+itemName+"),奖励3分");
				integral.setUserid(userid);
				integral.setTime(time);
				integral.setIntegral(jifen);
				integralService.save(integral);
				
				User user=userService.findUserByUserid(userid).get(0);
				int xjifen=user.getIntegral();
				user.setIntegral(xjifen+jifen);
				userService.saveOrUpdate(user);
				
			}
			else {
				receipt.setStatus(Define.RECEIPT_STATUS_1);
			}
			
			receiptService.save(receipt);
			
			
			
			
	
			List<Receipt> receipts=	receiptService.findReceipts(userid, time);
			Receipt receipt2=receipts.get(0);
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
			mh.setEntity(receipt2);
			mh.setMessage(receipt2.getId().toString());
		 	setMessageHelper(mh);
			
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage("发货失败");
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 客服介入取消
	 */
	public String kefuCancel(){
		try {
			
			Receipt receipt=receiptService.get(id);
			if (receipt.getPaymentType().equals(Define.PAY_TYPE_O)) {
				if(type.equals("J")){
					User user=userService.findUserByUserid(receipt.getUserid()).get(0);
				    user.setBalance(Arithmetic4Double.add(receipt.getShippingCost(), user.getBalance()));
					 userService.saveOrUpdate(user);
					}
			}
			if(type.equals("F")) {
				User user=userService.findUserByUserid(userid).get(0);
			    user.setBalance(Arithmetic4Double.add(receipt.getShippingCost(), user.getBalance()));
				userService.saveOrUpdate(user);
			}
			receipt.setStatus(Define.RECEIPT_STATUS_7);
			receiptService.saveOrUpdate(receipt);
			
			
			/*if(type.equals("J")){
			User user=userService.findUserByUserid(receipt.getUserid()).get(0);
		    user.setBalance(Arithmetic4Double.add(receipt.getShippingCost(), user.getBalance()));
			 userService.saveOrUpdate(user);
			}else {
				User user=userService.findUserByUserid(userid).get(0);
			    user.setBalance(Arithmetic4Double.add(receipt.getShippingCost(), user.getBalance()));
				userService.saveOrUpdate(user);
			}
			receipt.setStatus(Define.RECEIPT_STATUS_7);
			receiptService.saveOrUpdate(receipt);*/
			
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
			return "OK";
	}
	
	
	
	/**
	 * @param id 订单ID
	 *  @param cancel 取消原因
	 * 取消帮我送订单
	 * @return 
	 */
	public String quXiaoReceipt(){
		try {
			MessageHelper mh = new MessageHelper();
			Receipt receipt=receiptService.get(id);
		if (receipt.getStatus().equals(Define.RECEIPT_STATUS_2)) {
			receipt.setStatus(Define.RECEIPT_STATUS_6);
			receipt.setCancel(new String(cancel.getBytes("iso8859-1"), "utf-8"));
			receiptService.saveOrUpdate(receipt);
			if (receipt.getPaymentType().endsWith(Define.PAY_TYPE_O)) {
				//如果是在线支付成功了 退款到我的余额写个公用的参数
				/*userService.updateMoney(userid, receipt.getShippingCost().doubleValue());*/
				 User user=userService.findUserByUserid(receipt.getUserid()).get(0);
				 user.setBalance(Arithmetic4Double.add(receipt.getShippingCost(), user.getBalance()));
					userService.saveOrUpdate(user);
			}
			mh.setResult(Define.S);
		}else {
			receipt.setStatus(Define.RECEIPT_STATUS_6);
			receipt.setCancel(new String(cancel.getBytes("iso8859-1"), "utf-8"));
			receiptService.saveOrUpdate(receipt);
			mh.setResult(Define.S);
		}
			setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage("取消失败");
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	/**
	 *发单人留言
	 * 
	 */
	public String liuyan(){
		try {
	      Receipt receipt=receiptService.get(id);
	      receipt.setLiuyan(new String(liuyan.getBytes("iso8859-1"), "utf-8"));
	      receiptService.saveOrUpdate(receipt);
	      MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
		 	   setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage("留言失败");
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * @param id 订单ID
	 * 订单详情
	 * @return 
	 */
	public String detail(){
		try {
	Receipt receipt=	receiptService.get(id);
	MessageHelper mh = new MessageHelper();
	mh.setResult(Define.S);
	mh.setEntity(receipt);
 	   setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage(Define.F_MESSAGE);
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}
	
	/**
	 * @param id ui订单ID
	 * 订单详情
	 * @return 
	 */
	public String uiDetail(){
		try {
		Receipt receipt=receiptService.get(id);
		 request.put("receipt", receipt);
		} catch (Exception e) {
			
		log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}

	
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemWeight(Double itemWeight) {
		this.itemWeight = itemWeight;
	}
	public void setItemValue(Integer itemValue) {
		this.itemValue = itemValue;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}
	public void setReceivingLand(String receivingLand) {
		this.receivingLand = receivingLand;
	}
	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public void setPremium(Double premium) {
		this.premium = premium;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone = shipperPhone;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public void setTextExplain(String textExplain) {
		this.textExplain = textExplain;
	}
	public void setVoiceExplain(String voiceExplain) {
		this.voiceExplain = voiceExplain;
	}
	public void setItemPhoto(String itemPhoto) {
		this.itemPhoto = itemPhoto;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	public void setFpingjia(String fpingjia) {
		this.fpingjia = fpingjia;
	}
	public void setJpingjia(String jpingjia) {
		this.jpingjia = jpingjia;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	private String pickupTime;
	private String itemType;
	private String itemName;
	private Double itemWeight;
	private Integer itemValue;
	private String vehicle;
	private String area;
	private String currentCity;
	private String deliveryPlace;
	private String receivingLand;
	
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
	private String jingwei;
	private String liuyan;
	public void setArea(String area) {
		this.area = area;
	}
	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public void setJingwei(String jingwei) {
		this.jingwei = jingwei;
	}
	 private MessageHelper messageHelper;
	 public MessageHelper getMessageHelper() {
		return messageHelper;
	}
	 public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}

	 	private Map<String , Object> request;
	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	
}
