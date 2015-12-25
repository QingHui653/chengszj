package com.hengshuo.chengszj.action.buyrelation;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.baidu.a.a.a.a;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.action.singlerelation.SinglerelationAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.Arithmetic4Double;
import com.hengshuo.chengszj.common.util.BaiduMap;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.common.util.NetworkTool4Socket;
import com.hengshuo.chengszj.common.util.socket.Client4Web;
import com.hengshuo.chengszj.common.util.socket.Server;
import com.hengshuo.chengszj.model.Admin;
import com.hengshuo.chengszj.model.Buyrelation;
import com.hengshuo.chengszj.model.Helpmebuy;
import com.hengshuo.chengszj.model.Receipt;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.service.buyrelation.BuyrelationService;
import com.hengshuo.chengszj.service.helpmebuy.HelpmebuyService;
import com.hengshuo.chengszj.service.user.UserService;
import com.sun.org.apache.commons.digester.ObjectParamRule;

public class BuyrelationAction extends BaseAction implements RequestAware,SessionAware  {
	private static final Logger log=Logger.getLogger(BuyrelationAction.class.getName());

	private BuyrelationService buyrelationService;
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setBuyrelationService(BuyrelationService buyrelationService) {
		this.buyrelationService = buyrelationService;
	}
	 private MessageHelper messageHelper;
	 public MessageHelper getMessageHelper() {
		return messageHelper;
	}
	 public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}
	 private HelpmebuyService helpmebuyService;
	 public void setHelpmebuyService(HelpmebuyService helpmebuyService) {
		this.helpmebuyService = helpmebuyService;
	}
		private Integer id;
		public void setId(Integer id) {
			this.id = id;
		}
		public void setHelpMeId(Integer helpMeId) {
			this.helpMeId = helpMeId;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		private Integer helpMeId;
		private String userid;
		private String status;
		
		/**
		 * 后台发任务订单表
		 * 
		 */
			public String listHelpRW(){
				try {
				 Admin admin=(Admin) session.get("user");
				 Helpmebuy helpmebuy=new Helpmebuy();
				 if (admin.getCity()!=null) {
					helpmebuy.setCity(admin.getCity());
				}
				 if (admin.getArea()!=null) {
					helpmebuy.setArea(admin.getArea());
				}
				 helpmebuy.setType(status);
			PageSupport<Helpmebuy> pageSupport=helpmebuyService.findPageByExampleAndOrder(helpmebuy, "id", "desc", getPageNo(), 10);
				List<Helpmebuy> list=pageSupport.result;
				for(Helpmebuy H:list){
					List<Buyrelation> lBuyrelations=buyrelationService.ByHelpid(H.getId());
					if (lBuyrelations.size()>0) {
						H.setLiuyan(lBuyrelations.get(0).getUserid());
					}else {
						H.setLiuyan(null);
					}
					
				}
				request.put("pageSupport", pageSupport);
				request.put("list", list);
				request.put("status", status);
		
			
				} catch (Exception e) {
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
				      Helpmebuy helpmebuy=helpmebuyService.get(id);
				      helpmebuy.setStatus(Define.RECEIPT_STATUS_4);
				      helpmebuyService.saveOrUpdate(helpmebuy);
				      String time=DateTimeUtil.currentDatetime();
				  	try {
				  		String messsage="";
						if (type.equals(Define.ONLINE_TYPE_H)) {
							 messsage="你发的任务("+helpmebuy.getGoodsname()+")已送达,对方手机号码为:"+userid+"送达时间为:"+time.substring(0, 16);
								
						}else {
							 messsage="你发的办事("+helpmebuy.getGoodsname()+")已送达,对方手机号码为:"+userid+"送达时间为:"+time.substring(0, 16);
						}
						String mess="2|"+messsage;
					    Client4Web.startCient(Server.clientMap.get(helpmebuy.getUserid()), mess);
						
					} catch (Exception e) {
						log.error("发任务 送达消息出错-----");
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
		 * 我的接单  帮我买JSON
		 * @return 
		 */
			public String jiedanJSON(){
				try {
					String query="from Buyrelation where userid=? and type=? ORDER BY id DESC";
						Object[] values={userid,type};
					List<Buyrelation> buyrelations=	buyrelationService.find(query, values);
					List<Helpmebuy> helpmebuyss=new ArrayList<Helpmebuy>();
					for(Buyrelation s:buyrelations){
					Helpmebuy helpmebuy=helpmebuyService.get(s.getHelpMeId());
						helpmebuyss.add(helpmebuy);
						
					}
					MessageHelper mh = new MessageHelper();
					mh.setResult(Define.S);
					mh.setList(helpmebuyss);
					setMessageHelper(mh);
					/*List<Helpmebuy> helpmebuys=BaiduMap.getjuli(helpmebuyss);
					request.put("helpmebuys", helpmebuys);*/

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
			 * 客服介入取消
			 */
			public String kefuCancel(){
				try {
					
					Helpmebuy helpmebuy=helpmebuyService.get(id);
					if (helpmebuy.getPaymenttype().equals(Define.PAY_TYPE_O)) {
						if(type.equals("J")){
							User user=userService.findUserByUserid(helpmebuy.getUserid()).get(0);
						    user.setBalance(Arithmetic4Double.add(helpmebuy.getReward(), user.getBalance()));
							 userService.saveOrUpdate(user);
							}
					}
					if(type.equals("F")) {
						User user=userService.findUserByUserid(userid).get(0);
					    user.setBalance(Arithmetic4Double.add(helpmebuy.getReward(), user.getBalance()));
						userService.saveOrUpdate(user);
					}
					helpmebuy.setStatus(Define.RECEIPT_STATUS_7);
					helpmebuyService.saveOrUpdate(helpmebuy);
					
				} catch (Exception e) {
					log.error(Define.F_MESSAGE+e.getMessage());
				}
					return "OK";
			}
			
			
		
		
		/**
		 * 我的接单  帮我买
		 * @return 
		 */
		public String jiedan(){
			try {
		String query="from Buyrelation where userid=? ORDER BY id DESC";
			Object[] values={userid};
		List<Buyrelation> buyrelations=	buyrelationService.find(query, values);
		List<Helpmebuy> helpmebuyss=new ArrayList<Helpmebuy>();
		for(Buyrelation s:buyrelations){
		Helpmebuy helpmebuy=helpmebuyService.get(s.getHelpMeId());
			helpmebuyss.add(helpmebuy);
			
		}

		List<Helpmebuy> helpmebuys=BaiduMap.getjuli(helpmebuyss);
		request.put("helpmebuys", helpmebuys);

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
		 * 接帮我买单
		 * @return
		 */
		public String buyrelation(){
			try {
			Helpmebuy helpmebuy=helpmebuyService.get(helpMeId);
				String statu=helpmebuy.getStatus();
				if (statu.equals(Define.HELPMEBUY_STATUS_3)||statu.equals(Define.HELPMEBUY_STATUS_6)) {
					 MessageHelper mh = new MessageHelper();
			 		 mh.setResult("Y");
			 		 mh.setMessage("该订单已被接取");
			 		 setMessageHelper(mh);
				}else {
					helpmebuy.setStatus(Define.HELPMEBUY_STATUS_3);
					helpmebuyService.saveOrUpdate(helpmebuy);
					
					Buyrelation buyrelation=new Buyrelation();
						buyrelation.setHelpMeId(helpMeId);
						buyrelation.setUserid(userid);
						buyrelation.setType(helpmebuy.getType());
						String time=DateTimeUtil.currentDatetime();
						buyrelation.setTime(time);
						buyrelationService.save(buyrelation);
						log.debug("发任务接单---------");
						/*String messsage="";
						if (type.equals(Define.ONLINE_TYPE_H)) {
							if (helpmebuy.getGoodsname()!=null) {
								messsage="你发的任务("+helpmebuy.getGoodsname()+")已被接取,对方手机号码为:"+userid+"接取时间为:"+time.substring(0, 16);
							}else {
								messsage="你发的语音任务已被接取,对方手机号码为:"+userid+"接取时间为:"+time.substring(0, 16);
								
							}
							 	
						}else {
							if (helpmebuy.getGoodsname()!=null) {
								 messsage="你发的办事("+helpmebuy.getGoodsname()+")已被接取,对方手机号码为:"+userid+"接取时间为:"+time.substring(0, 16);
							}else {
								 messsage="你发的语音办事已被接取,对方手机号码为:"+userid+"接取时间为:"+time.substring(0, 16);
							}
						}
						String mess="2|"+messsage;
					    Client4Web.startCient(Server.clientMap.get(helpmebuy.getUserid()), mess);
						
						for(Map.Entry<String, Socket> entry:Server.clientMap.entrySet()){    
							 log.debug(entry.getKey()+"--->"+entry.getValue());    
			    		 }   */
						
						
						MessageHelper mh = new MessageHelper();
				 		 mh.setResult(Define.S);
				 		 setMessageHelper(mh);
				}
			} catch (Exception e) {
				MessageHelper mh = new MessageHelper();
		 		 mh.setResult(Define.F);
		 		 mh.setMessage("接单失败");
		 		 setMessageHelper(mh);
		 		 e.printStackTrace();
		 		log.error(Define.F_MESSAGE+e.getMessage());
			}
			return "OK";
		}
		
		private String type;
		public void setType(String type) {
			this.type = type;
		}
		private Map<String, Object> request;
		@Override
		public void setRequest(Map arg0) {
		this.request=arg0;
			
		}
		private Map<String, Object> session;
		@Override
		public void setSession(Map arg0) {
		this.session=arg0;
			
		}
	 
	 
}
