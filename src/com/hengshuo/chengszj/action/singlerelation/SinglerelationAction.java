package com.hengshuo.chengszj.action.singlerelation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.BaiduMap;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.common.util.NetworkTool4Socket;
import com.hengshuo.chengszj.common.util.socket.Client4Web;
import com.hengshuo.chengszj.common.util.socket.Server;
import com.hengshuo.chengszj.model.Admin;
import com.hengshuo.chengszj.model.Receipt;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.service.freeexpress.FreeexpressService;
import com.hengshuo.chengszj.service.receipt.ReceiptService;
import com.hengshuo.chengszj.service.singlerelation.SinglerelationService;
import com.hengshuo.chengszj.service.user.UserService;
import com.hengshuo.chengszj.model.Singlerelation;

public class SinglerelationAction extends BaseAction implements RequestAware,SessionAware{
	private static final Logger log=Logger.getLogger(SinglerelationAction.class.getName());
	private Integer id;
	private SinglerelationService service;
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setService(SinglerelationService service) {
		this.service = service;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setReceiptid(Integer receiptid) {
		this.receiptid = receiptid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private Integer receiptid;
	private String userid;
	private String status;
	 private MessageHelper messageHelper;
	 public MessageHelper getMessageHelper() {
		return messageHelper;
	}
	 public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}
		private ReceiptService receiptService;
		public void setReceiptService(ReceiptService receiptService) {
			this.receiptService = receiptService;
		}
		private FreeexpressService fService;
		public void setfService(FreeexpressService fService) {
			this.fService = fService;
		}
		
		
		
		/**
		 * 后台帮我送发单表
		 * 
		 */
		public String listReceipt(){
			try {
				
			Admin admin	=(Admin) session.get("user");
			Receipt receipt=new Receipt();
				if (admin.getCity()!=null) {
					receipt.setCurrentCity(admin.getCity());
				}
				if (admin.getArea()!=null) {
					receipt.setArea(admin.getArea());
				}
				PageSupport<Receipt> pageSupport=receiptService.findPageByExampleAndOrder(receipt, "id", "desc", getPageNo(), 10);
				List<Receipt> lReceipts=pageSupport.result;
				for(Receipt R:lReceipts){
				List<com.hengshuo.chengszj.model.Singlerelation> sisList=service.Byreceiptid(R.getId());
				if (sisList.size()>0) {
					R.setLiuyan(sisList.get(0).getUserid());//把接单人放进经message字段了
					//R.setJingwei(sisList.get(0).getTime());//把时间放进经纬度字段了
				}else {
					R.setLiuyan(null);
				}
			}
			request.put("pageSupport", pageSupport);
			request.put("list", lReceipts);
			} catch (Exception e) {
				log.error(Define.F_MESSAGE+e.getMessage());
			}
			 return "OK";
		}
		
		/**
		 * 我的接单  帮我送JSON
		 * @return 
		 */
		public String jsonJieDan(){
			 try {
		String query="from Singlerelation where userid=? ORDER BY id DESC";
		Object [] values={userid};
		List<com.hengshuo.chengszj.model.Singlerelation> singlerelations=service.find(query, values); 
		
		List<Receipt> receiptss=new ArrayList<Receipt>();
		
	/*	com.hengshuo.chengszj.model.Singlerelation singlerelation=new com.hengshuo.chengszj.model.Singlerelation();
		singlerelation.setUserid(userid);
		PageSupport<com.hengshuo.chengszj.model.Singlerelation> pageSupport=service.findPageByExampleAndOrder(singlerelation, "id", "desc", getPageNo(), 1000);
		List<com.hengshuo.chengszj.model.Singlerelation> singlerelations=pageSupport.getResult();
	*/
		for (com.hengshuo.chengszj.model.Singlerelation s:singlerelations) {
			Receipt receipt	= receiptService.get(s.getReceiptid());
			receiptss.add(receipt);
		}
		
		//List<Receipt> receipts=BaiduMap.getRejuli(receiptss);
		//request.put("receipts", receipts);
		//request.put("userid", userid);
			MessageHelper mh = new MessageHelper();
				mh.setResult(Define.S);
				mh.setList(receiptss);
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
		 * 我的接单  帮我送
		 * @return 
		 */
	 public String jiedan(){
		 try {
	String query="from Singlerelation where userid=? ORDER BY id DESC";
	Object [] values={userid};
	List<com.hengshuo.chengszj.model.Singlerelation> singlerelations=service.find(query, values); 
	
	List<Receipt> receiptss=new ArrayList<Receipt>();
	
/*	com.hengshuo.chengszj.model.Singlerelation singlerelation=new com.hengshuo.chengszj.model.Singlerelation();
	singlerelation.setUserid(userid);
	PageSupport<com.hengshuo.chengszj.model.Singlerelation> pageSupport=service.findPageByExampleAndOrder(singlerelation, "id", "desc", getPageNo(), 1000);
	List<com.hengshuo.chengszj.model.Singlerelation> singlerelations=pageSupport.getResult();
*/
	for (com.hengshuo.chengszj.model.Singlerelation s:singlerelations) {
		Receipt receipt	= receiptService.get(s.getReceiptid());
		receiptss.add(receipt);
	}
	
	List<Receipt> receipts=BaiduMap.getRejuli(receiptss);
	request.put("receipts", receipts);
	request.put("userid", userid);
	/*
		  MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
			mh.setList(receipts);
			setMessageHelper(mh);*/
		 
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
	  * 已送达 接单人操作
	  * @param userid  单id
	  */
	 public String send(){
		 try {
		      Receipt receipt=receiptService.get(id);
		      receipt.setStatus(Define.RECEIPT_STATUS_4);
		      receiptService.saveOrUpdate(receipt);
		      String time=DateTimeUtil.currentDatetime();
		     try {
		    	 
		    	 String messsage="你发的帮我送("+receipt.getItemName()+")已送达,对方手机号码为:"+userid+"送达时间为:"+time.substring(0, 16);
				 String mess="1|"+messsage+"|"+receipt.getUserid()+"|"+receiptid;
				 Client4Web.startCient(Server.clientMap.get(receipt.getUserid()), mess);
			} catch (Exception e) {
				log.error("---帮我送 送达消息出问题");
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
		 * 接单关系
		 * @return 
		 */
	 public String Singlerelation(){
		 try {
			 Receipt receipt= receiptService.get(receiptid);
				String statuss=receipt.getStatus();
				boolean b=fService.checkKuaiDi(userid, receipt.getCompany());
				if (!receipt.getCompany().equals(Define.KUAIDI_TONGCHENG)) {
					if (!b) {
						 MessageHelper mh = new MessageHelper();
				 		 mh.setResult("Y");
				 		 mh.setMessage("你不符合此单的快递要求");
				 		 setMessageHelper(mh);
				 		 return "OK";
					}
					
				}
				
			if (statuss.equals(Define.RECEIPT_STATUS_6)||statuss.equals(Define.RECEIPT_STATUS_3)) {
				 MessageHelper mh = new MessageHelper();
		 		 mh.setResult("Y");
		 		 mh.setMessage("该订单已被接取");
		 		 setMessageHelper(mh);
			 }
			 else{
			 receipt.setStatus(Define.RECEIPT_STATUS_3);
			receiptService.saveOrUpdate(receipt);
				
			 com.hengshuo.chengszj.model.Singlerelation singlerelation=new  com.hengshuo.chengszj.model.Singlerelation();
			 singlerelation.setReceiptid(receiptid);
			 String time=DateTimeUtil.currentDatetime();
			 singlerelation.setTime(time);
			 singlerelation.setUserid(userid);
			 service.save(singlerelation);
			 log.debug("帮我买接单---------");
			 //发送消息
		/*	 String messsage="你发的接派送("+receipt.getItemName()+")已被接取,对方手机号码为:"+userid+"接取时间为:"+time.substring(0, 16);
			 String mess="1|"+messsage+"|"+receipt.getUserid()+"|"+receiptid;
			 log.debug("帮我买接单11111111111---------"+receipt.getUserid());
			 Client4Web.startCient(Server.clientMap.get(receipt.getUserid()), mess);
			
			log.debug("帮我买接单结束---------");*/
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.S);
	 		 setMessageHelper(mh);
			 }
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("接单失败");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		 return "OK";
	 }
	 
	 private Map<String, Object> request;
		@Override
		public void setRequest(Map arg0) {
			// TODO Auto-generated method stub
			this.request=arg0;
		}
		 private Map<String, Object> session;
		@Override
		public void setSession(Map arg0) {
			this.session=arg0;
			
		}
	
	
	
	
}
