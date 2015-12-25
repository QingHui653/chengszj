package com.hengshuo.chengszj.action.helpmebuy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.alipay.util.chongzhi.UtilDate;
import com.baidu.mapapi.utils.h;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.common.page.Base64;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.Arithmetic4Double;
import com.hengshuo.chengszj.common.util.BaiduMap;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
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
import com.hengshuo.chengszj.service.impl.helpmebuy.HelpmebuyServiceI;
import com.hengshuo.chengszj.service.integral.IntegralService;
import com.hengshuo.chengszj.service.message.MessageService;
import com.hengshuo.chengszj.service.user.UserService;

public class HelpmebuyAction extends BaseAction implements RequestAware {
	private static final Logger log=Logger.getLogger(HelpmebuyAction.class.getName());
	private HelpmebuyService helpmebuyService;
	public void setHelpmebuyService(HelpmebuyService helpmebuyService) {
		this.helpmebuyService = helpmebuyService;
	}
	private BuyrelationService buyrelationService;
	public void setBuyrelationService(BuyrelationService buyrelationService) {
		this.buyrelationService = buyrelationService;
	}
	private IntegralService integralService;
	public void setIntegralService(IntegralService integralService) {
		this.integralService = integralService;
	}
	
	private Integer buyid;
	public void setBuyid(Integer buyid) {
		this.buyid = buyid;
	}
	private String buyuserid;
	public void setBuyuserid(String buyuserid) {
		this.buyuserid = buyuserid;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private MessageService messageService;
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public String Hdetail(){
		try {
	Helpmebuy helpmebuy=helpmebuyService.get(id);
	request.put("helpmebuy", helpmebuy);
	/*request.put("userid", userid);*/
		} catch (Exception e) {
	
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
	Helpmebuy helpmebuy=helpmebuyService.get(id);
	MessageHelper mh = new MessageHelper();
	mh.setResult(Define.S);
	mh.setEntity(helpmebuy);
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
	 * 接单人评价
	 */
	public String jPjiajson(){
		try {
			Helpmebuy helpmebuy=helpmebuyService.get(id);
			helpmebuy.setJpingjia(new String(jpingjia.getBytes("iso8859-1"), "utf-8"));
			helpmebuyService.saveOrUpdate(helpmebuy);
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
	 * 发单人评价json
	 */
	public String pjiajson(){
		try {
			
			Helpmebuy helpmebuy=helpmebuyService.get(id);
			helpmebuy.setFpingjia(new String(fpingjia.getBytes("iso8859-1"), "utf-8"));
			helpmebuy.setPingjiatime(DateTimeUtil.currentDatetime());
			helpmebuy.setStatus(Define.HELPMEBUY_STATUS_5);
			helpmebuyService.saveOrUpdate(helpmebuy);
			
			if (helpmebuy.getPaymenttype().equals(Define.PAY_TYPE_O)) {
				
				Buyrelation buyrelation=buyrelationService.findByHelpid(id);
				User user2=userService.findUserByUserid(buyrelation.getUserid()).get(0);
				Double balance=user2.getBalance();
				user2.setBalance(Arithmetic4Double.add(balance, helpmebuy.getReward()));
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
	public String HyuEPay(){
		try {
			MessageHelper mh = new MessageHelper();
			User user=userService.findUserByUserid(userid).get(0);
			Double money=user.getBalance();
			Helpmebuy helpmebuy=helpmebuyService.get(id);
			Double reMoney=helpmebuy.getReward();
			if (money>reMoney) {
			    user.setBalance(Arithmetic4Double.sub(money, reMoney));
			    userService.saveOrUpdate(user);
			    helpmebuy.setStatus(Define.HELPMEBUY_STATUS_2);
			    helpmebuyService.saveOrUpdate(helpmebuy);
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
		 * 我的发单帮我买 JSON
		 * @return 
		 */
		public  String myFaDanJson(){
			try {
				
				String query="from Helpmebuy where userid=? and type=? ORDER BY id DESC";
				Object[] values={userid,type};
				List<Helpmebuy> helpmebuys=	helpmebuyService.find(query, values);
			
				
				List<Helpmebuy> receipts=new ArrayList<Helpmebuy>();
				for (Helpmebuy s:helpmebuys) {
					List<Buyrelation> b=buyrelationService.ByHelpid(s.getId());
					if (b.size()>0) {
						s.setTime(b.get(0).getTime());
						s.setUserid(b.get(0).getUserid());
					}else {
						s.setTime(null);
						s.setUserid(null);
					}
				
					receipts.add(s);
				}
				request.put("userid", userid);
				//List<Helpmebuy> helpmebuyss=BaiduMap.getjuli(helpmebuys);
			//request.put("receipts", helpmebuyss);	
				MessageHelper mh = new MessageHelper();
				mh.setResult(Define.S);
				mh.setList(helpmebuys);
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
	 * 我的发单帮我买
	 * @return 
	 */
	public  String myFaDan(){
		try {
			
			String query="from Helpmebuy where userid=? and type=? ORDER BY id DESC";
			Object[] values={userid,type};
			List<Helpmebuy> helpmebuys=	helpmebuyService.find(query, values);
		
			
			List<Helpmebuy> receipts=new ArrayList<Helpmebuy>();
			for (Helpmebuy s:helpmebuys) {
				List<Buyrelation> b=buyrelationService.ByHelpid(s.getId());
				if (b.size()>0) {
					s.setUserid(b.get(0).getUserid());
				}else {
					s.setUserid(null);
				}
			
				receipts.add(s);
			}
			request.put("userid", userid);
			List<Helpmebuy> helpmebuyss=BaiduMap.getjuli(helpmebuys);
		request.put("receipts", helpmebuyss);	
		
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
	 * 帮我买  单
	 * @return 
	 */
	public String listHelpmebuy(){
		try {
			
			String query="from Helpmebuy where status=? and type=? ORDER BY time DESC";
			Object[] values={Define.HELPMEBUY_STATUS_2,type};
			List<Helpmebuy> helpmebuys	=helpmebuyService.find(query, values);
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
			mh.setList(helpmebuys);
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
	 *发单人留言
	 * 
	 */
	public String liuyan(){
		try {
	      Helpmebuy helpmebuy=helpmebuyService.get(id);
	      helpmebuy.setLiuyan(liuyan);
	      helpmebuyService.saveOrUpdate(helpmebuy);
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
	 * 添加帮我买
	 * @return 
	 */
	public String addHelpmebuy(){
		try {
			Helpmebuy helpmebuy=new Helpmebuy();
			helpmebuy.setSendTime(sendTime);
			helpmebuy.setGoodsname(goodsname);
			helpmebuy.setPurchaseLand(purchaseLand);
			helpmebuy.setPurchaseAsk(purchaseAsk);
			helpmebuy.setReceivingLand(receivingLand);
			helpmebuy.setRemark(remark);
			if (yuying!=null) {
				 String root = ServletActionContext.getServletContext().getRealPath(Define.IMAGES_RW);
				 	String  url="/"+userid+DateTimeUtil.toRandom(5)+".amr";
				 	Base64.GenerateFile(yuying, root+url);
				 	helpmebuy.setYuying(Define.IMAGES_RW+url);
			}
			
			
			helpmebuy.setJingwei(jingwei);
			helpmebuy.setReward(reward);
			helpmebuy.setUserid(userid);
			helpmebuy.setArea(area);
			helpmebuy.setPaymenttype(paymenttype);
			helpmebuy.setCity(city);
			helpmebuy.setPhone(phone);
			helpmebuy.setType(type);
		
			String time=DateTimeUtil.currentDatetime();
			helpmebuy.setTime(time);
			
			if (paymenttype.equals(Define.PAY_TYPE_X)) {
				helpmebuy.setStatus(Define.HELPMEBUY_STATUS_2);
				
				Message message=new Message();
				Integral integral=new Integral();
				if (type.equals(Define.ONLINE_TYPE_H)) {
					if (goodsname!=null) {
						message.setContent("恭喜你成功发任务,任务名称("+goodsname+")");
						integral.setContent("成功发任务,任务名称("+goodsname+"),奖励3分");
					}else {
						message.setContent("恭喜你成功发语音任务");
						integral.setContent("恭喜你成功发语音任务,奖励3分");	
					}
					
				}else {
					if (goodsname!=null) {
					message.setContent("恭喜你成功发单办事,办事名称("+goodsname+")");
					integral.setContent("成功发单办事,办事名称("+goodsname+"),奖励3分");
					}
					else {
						message.setContent("恭喜你成功发语音办事");
						integral.setContent("恭喜你成功发语音办事,奖励3分");	
					}
				}
				message.setTime(time);
				message.setUserid(userid);
				messageService.save(message);
				int jifen=3;
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
				helpmebuy.setStatus(Define.RECEIPT_STATUS_1);
			}
			
			helpmebuyService.save(helpmebuy);
			
			
			 List<Helpmebuy> helpmebuys=helpmebuyService.findHelpmebuys(userid, time);
			Helpmebuy helpmebuy2=helpmebuys.get(0);
					
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
			mh.setEntity(helpmebuy2);
			setMessageHelper(mh);
			
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("发布失败");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	/**
	 * @param id 订单ID
	 *  @param cancel 取消原因
	 * 取消帮我买订单
	 * @return 
	 */
	public String quXiaoHelpmebuy(){
		try {
			MessageHelper mh = new MessageHelper();
			Helpmebuy helpmebuy=helpmebuyService.get(id);
		if (helpmebuy.getStatus().equals(Define.HELPMEBUY_STATUS_2)) {
			
		helpmebuy.setCancel(new String(cancel.getBytes("iso8859-1"), "utf-8"));
		helpmebuy.setStatus(Define.HELPMEBUY_STATUS_6);
		helpmebuyService.saveOrUpdate(helpmebuy);
		 if (helpmebuy.getPaymenttype().endsWith(Define.PAY_TYPE_O)) {
			//如果是在线支付成功了 退款到我的余额写个公用的参数
			/*userService.updateMoney(userid,helpmebuy.getReward());*/
			 User user=userService.findUserByUserid(helpmebuy.getUserid()).get(0);
			 user.setBalance(Arithmetic4Double.add(helpmebuy.getReward(), user.getBalance()));
				userService.saveOrUpdate(user);
		 }
			mh.setResult(Define.S);
		}else {
			helpmebuy.setCancel(new String(cancel.getBytes("iso8859-1"), "utf-8"));
			helpmebuy.setStatus(Define.HELPMEBUY_STATUS_6);
			helpmebuyService.saveOrUpdate(helpmebuy);
			
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
		return  "OK";
	}
	
	/**
	 * 修改订单
	 */
	/*public String updateHelpmebuy(){
		try {
			Helpmebuy helpmebuy= helpmebuyService.get(id);
			helpmebuy.setTime(DateTimeUtil.currentDatetime());
			helpmebuy.setPhone(phone);
			helpmebuyService.saveOrUpdate(helpmebuy);
			
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.F);
			mh.setMessage("修改失败");
		 	   setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public void setPurchaseLand(String purchaseLand) {
		this.purchaseLand = purchaseLand;
	}
	public void setPurchaseAsk(String purchaseAsk) {
		this.purchaseAsk = purchaseAsk;
	}
	public void setReceivingLand(String receivingLand) {
		this.receivingLand = receivingLand;
	}
	public void setReward(Double reward) {
		this.reward = reward;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setFpingjia(String fpingjia) {
		this.fpingjia = fpingjia;
	}
	public void setJpingjia(String jpingjia) {
		this.jpingjia = jpingjia;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String sendTime;
	private String goodsname;
	private String purchaseLand;
	private String purchaseAsk;
	private String receivingLand;
	private Double reward;
	private String userid;
	private String fpingjia;
	private String jpingjia;
	private String cancel;
	private String time;
	private String jingwei;
	private String city;
	private String area;
	private String paymenttype;
	private String liuyan;
	private String phone;
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setLiuyan(String liuyan) {
		this.liuyan = liuyan;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setArea(String area) {
		this.area = area;
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
	 private String type;
	 public void setType(String type) {
		this.type = type;
	}
	 private String remark;
		private String yuying;
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public void setYuying(String yuying) {
			this.yuying = yuying;
		}


	 private Map<String , Object> request;
	 
	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
}
