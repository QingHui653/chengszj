package com.hengshuo.chengszj.action.yuer;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.alipay.config.chongzhi.AlipayConfig;
import com.alipay.util.chongzhi.AlipayNotify;
import com.alipay.util.chongzhi.AlipaySubmit;
import com.alipay.util.chongzhi.UtilDate;
import com.baidu.mapapi.utils.h;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.action.user.UserAction;
import com.hengshuo.chengszj.common.util.Arithmetic4Double;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.common.util.NetworkTool;
import com.hengshuo.chengszj.model.Helpmebuy;
import com.hengshuo.chengszj.model.Integral;
import com.hengshuo.chengszj.model.Message;
import com.hengshuo.chengszj.model.Onlinepayment;
import com.hengshuo.chengszj.model.Receipt;
import com.hengshuo.chengszj.model.Recharge;
import com.hengshuo.chengszj.model.Singlerelation;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.model.Withdrawals;
import com.hengshuo.chengszj.service.helpmebuy.HelpmebuyService;
import com.hengshuo.chengszj.service.integral.IntegralService;
import com.hengshuo.chengszj.service.message.MessageService;
import com.hengshuo.chengszj.service.onlinepayment.OnlinepaymentService;
import com.hengshuo.chengszj.service.receipt.ReceiptService;
import com.hengshuo.chengszj.service.recharge.RechargeService;
import com.hengshuo.chengszj.service.singlerelation.SinglerelationService;
import com.hengshuo.chengszj.service.user.UserService;
import com.hengshuo.chengszj.service.withdrawals.WithdrawalsService;

public class MyyuerAction extends BaseAction implements RequestAware {
	private static final Logger log=Logger.getLogger(MyyuerAction.class.getName());

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private RechargeService rechargeService;
	public void setRechargeService(RechargeService rechargeService) {
		this.rechargeService = rechargeService;
	}
	private WithdrawalsService withdService;
	public void setWithdService(WithdrawalsService withdService) {
		this.withdService = withdService;
	}
	private HelpmebuyService helpmebuyService;
	public void setHelpmebuyService(HelpmebuyService helpmebuyService) {
		this.helpmebuyService = helpmebuyService;
	}
	private ReceiptService receiptService;
	public void setReceiptService(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
	private SinglerelationService singlerelationService;
	public void setSinglerelationService(
			SinglerelationService singlerelationService) {
		this.singlerelationService = singlerelationService;
	}
	private IntegralService integralService;
	public void setIntegralService(IntegralService integralService) {
		this.integralService = integralService;
	}
	private OnlinepaymentService onlinepaymentService;
	public void setOnlinepaymentService(
			OnlinepaymentService onlinepaymentService) {
		this.onlinepaymentService = onlinepaymentService;
	}
	
	public String urltest(){
		try {
			String url="https://www.baidu.com/";
		String cString=	NetworkTool.getContent(url);
		log.debug("111111111"+cString+"1111111");
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 微信支付
	 * @param 单的ID  支付类型 paymentType
	 */
	public  String wxPay(){
		try {
		Double money=userService.findUserByUserid(userid).get(0).getBalance();
		MessageHelper mh = new MessageHelper();
		 mh.setResult(Define.S);
		 mh.setMessage(String.valueOf(money));
		 setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 setMessageHelper(mh);
		}
		return "OK";
	}
	
	
	
	
	
	
	/**
	 * 查询金额
	 * @return
	 */
	public  String jiner(){
		try {
		Double money=userService.findUserByUserid(userid).get(0).getBalance();
		MessageHelper mh = new MessageHelper();
		 mh.setResult(Define.S);
		 mh.setMessage(String.valueOf(money));
		 setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 setMessageHelper(mh);
		}
		return "OK";
	}
	
	
	/**
	 * 提现记录
	 * @return 
	 */
	public String tiXianJiLu(){
		try {
			String query="from Withdrawals where userid=? ORDER BY id DESC ";
			Object[] values={userid};
		List<Withdrawals> list=withdService.find(query, values);
			request.put("list", list);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	
	/**
	 * 提现
	 * @return 
	 *//*
	public String tiXian(){
		try {
			
		List<User> users=userService.findUserByUserid(userid);	
			User user=users.get(0);
		Withdrawals withdrawals=new Withdrawals();
		withdrawals.setMoney(money);
		withdrawals.setUserid(userid);
		//withdrawals.setBank(bank);
		//withdrawals.setBank(new String(bank.getBytes("iso8859-1"), "utf-8"));
		//withdrawals.setAccountHolder(new String(accountHolder.getBytes("iso8859-1"), "utf-8"));
		withdrawals.setTime(DateTimeUtil.currentDatetime());	
		withdrawals.setCardNumber(cardNumber);
		
		withdService.save(withdrawals);
		Double balance=user.getBalance();
		user.setBalance(Arithmetic4Double.sub(balance, money));
		userService.saveOrUpdate(user);
		
		MessageHelper mh = new MessageHelper();
		 mh.setResult(Define.S);
		 setMessageHelper(mh);
		
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("提现失败");
	 		 setMessageHelper(mh);
	 	 log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}*/
	
	
	
	
	/**
	 * 充值记录
	 * @return 
	 */
	public String chongZhiJiLu(){
		try {
			String query="from Recharge where userid=? and status=? ORDER BY id DESC ";
			Object[] values={userid,Define.YUER_S};
		List<Recharge> list=rechargeService.find(query, values);
			request.put("list", list);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	
	
	
	/**
	 * 充值成功
	 * @return 
	 */
	
	public String chongZhiCheck(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
		
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			//商户订单号

			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//支付宝交易号

			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
		
			//交易金额
			String total_fee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");
			
			
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			
			//计算得出通知验证结果
			boolean verify_result = AlipayNotify.verify(params);
			
			if(verify_result){
				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
					log.debug("订单号"+out_trade_no+"交易金额"+total_fee);
					
					String query="from Recharge where orderNumber=?";
					Object[] values={out_trade_no};
					Recharge list=rechargeService.find(query, values).get(0);
					if (list.getStatus().equals(Define.YUER_F)) {
						list.setStatus(Define.YUER_S);
						rechargeService.saveOrUpdate(list);
						
						List<User> users=userService.findUserByUserid(list.getUserid());
						  User user= users.get(0);
						  Double balance=user.getBalance();
						  user.setBalance(Arithmetic4Double.add(balance, Double.valueOf(total_fee)));
						  userService.saveOrUpdate(user);
						  request.setAttribute("Result", "S");
						 
						 /* MessageHelper mh = new MessageHelper();
						  mh.setMessage("充值成功");
						  mh.setResult(Define.S);
							 setMessageHelper(mh);*/
					}else {
						  request.setAttribute("Result", "Y");
						/*MessageHelper mh = new MessageHelper();
				 		 mh.setResult(Define.F);
				 		 mh.setMessage("订单已处理过了");
				 		 setMessageHelper(mh);*/
						}
					}
			
			}else{
				  request.setAttribute("Result", "F");
				/*//该页面可做页面美工编辑
				log.debug("失败1111111111111111");
				MessageHelper mh = new MessageHelper();
		 		 mh.setResult(Define.F);
		 		 mh.setMessage("操作异常");
		 		 setMessageHelper(mh);*/
			}	
			
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}
	
	
	/**
	 * 充值
	 * @return 
	 */
	public String chongZhi(){
		try {
		
			Recharge recharge=new Recharge();
			recharge.setMoney(money);
			recharge.setTime(DateTimeUtil.currentDatetime());
			recharge.setType(type);
			recharge.setUserid(userid);
			String orderNumber=UtilDate.getOrderNum()+UtilDate.getThree();
			recharge.setOrderNumber(orderNumber);
			recharge.setStatus(Define.YUER_F);
			rechargeService.save(recharge);
			
		/*
		 * 成功之后才能执行
		 *  List<User> users=userService.findUserByUserid(userid);
		  User user= users.get(0);
		  Double balance=user.getBalance();
		  user.setBalance(Arithmetic4Double.add(balance, money));
		  userService.saveOrUpdate(user);*/
		  
		  
		  Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "alipay.wap.create.direct.pay.by.user");
	        sParaTemp.put("partner", AlipayConfig.partner);
	        sParaTemp.put("seller_id", AlipayConfig.seller_id);
	        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
			sParaTemp.put("payment_type", payment_type);
			sParaTemp.put("notify_url", notify_url);
			sParaTemp.put("return_url", return_url);
			//商户唯一订单号
			sParaTemp.put("out_trade_no", orderNumber);
			sParaTemp.put("subject", subject);
			//付款金额
			sParaTemp.put("total_fee", String.valueOf(money));
			sParaTemp.put("show_url", show_url);
			sParaTemp.put("body", body);
			sParaTemp.put("it_b_pay", it_b_pay);
			sParaTemp.put("extern_token", extern_token);
		
		  
		  String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		 
		  request.put("sHtmlText", sHtmlText);
		 
		
		
			
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("充值失败");
	 		 setMessageHelper(mh);
	 		 log.error(Define.F_MESSAGE+e.getMessage());
		}
		return  "OK";
	}
	
	
	
	/**
	 * 帮我送 付款
	 */
	public String receiptFukuan(){
		try {
			String subject="帮我送 支付宝付款";
			Onlinepayment onlinepayment=new Onlinepayment();
			if (type.equals(Define.ONLINE_TYPE_R)) {
				Receipt receipt=receiptService.get(id);
				onlinepayment.setMoney(money);
				onlinepayment.setReceiptId(receipt.getId());
				onlinepayment.setUserid(receipt.getUserid());
				if (status.equals("BG")) {
				onlinepayment.setType(Define.ONLINE_TYPE_RBG);
				}else {
					onlinepayment.setType(Define.ONLINE_TYPE_R);
				}
			}else {
				if(type.equals(Define.ONLINE_TYPE_H)) {
					subject="发任务 支付宝付款";
					if (status.equals("BG")) {
						onlinepayment.setType(Define.ONLINE_TYPE_HBG);
						}else {
						onlinepayment.setType(Define.ONLINE_TYPE_H);
						}
					
				}else {
					subject="办事 支付宝付款";
					if (status.equals("BG")) {
						onlinepayment.setType(Define.ONLINE_TYPE_BBG);
						}else {
							onlinepayment.setType(Define.ONLINE_TYPE_B);
						}
					
				}
				
				Helpmebuy helpmebuy=helpmebuyService.get(id);
				onlinepayment.setMoney(money);
				onlinepayment.setReceiptId(helpmebuy.getId());
				onlinepayment.setUserid(helpmebuy.getUserid());
				
			}
			onlinepayment.setStatus(Define.YUER_F);
			
			onlinepayment.setTime(DateTimeUtil.currentDatetime());
			
			String orderNumber=UtilDate.getOrderNum()+UtilDate.getThree();
			onlinepayment.setOrderNumber(orderNumber);
		
			onlinepaymentService.save(onlinepayment);
			
		
		  
			
			
			//页面跳转同步通知页面路径
			//String return_url = "http://115.28.58.245:8080/chengszj/receiptOK.action";
			String return_url = "http://192.168.1.203:8080/chengszj/receiptOK.action";
			//String return_url = "http://115.28.58.245:80/chengszj/receiptOK.action";
			
			
			
			Map<String, String> sParaTemp = new HashMap<String, String>();
				sParaTemp.put("service", "alipay.wap.create.direct.pay.by.user");
		        sParaTemp.put("partner", AlipayConfig.partner);
		        sParaTemp.put("seller_id", AlipayConfig.seller_id);
		        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
				sParaTemp.put("payment_type", payment_type);
				sParaTemp.put("notify_url", notify_url);
				sParaTemp.put("return_url", return_url);
				//商户唯一订单号
				sParaTemp.put("out_trade_no", orderNumber);
				sParaTemp.put("subject", subject);
				//付款金额
				sParaTemp.put("total_fee", String.valueOf(money));
				sParaTemp.put("show_url", show_url);
				sParaTemp.put("body", body);
				sParaTemp.put("it_b_pay", it_b_pay);
				sParaTemp.put("extern_token", extern_token);
			
			  
			  String sHtmlText = AlipaySubmit.buildRequest2(sParaTemp,"get","确认");
			 
			  request.put("sHtmlText", sHtmlText);
			
		} catch (Exception e) {
	 		 log.error(Define.F_MESSAGE+"付款失败"+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 帮我送付款成功	
	 * @return
	 */
	public String ReceiptOK(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
		
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//
			//商户订单号

			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

			//支付宝交易号

			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
		
			//交易金额
			String total_fee = new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8");
			
			
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

			//获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
			
			//计算得出通知验证结果
			boolean verify_result = AlipayNotify.verify(params);
			
			if(verify_result){
				if(trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")){
					//判断该笔订单是否在商户网站中已经做过处理
						//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
						//如果有做过处理，不执行商户的业务程序
					log.debug("订单号"+out_trade_no+"交易金额"+total_fee);
					
					String query="from Onlinepayment where orderNumber=?";
					Object[] values={out_trade_no};
					Onlinepayment list=onlinepaymentService.find(query, values).get(0);
					if (list.getStatus().equals(Define.YUER_F)) {
						list.setStatus(Define.YUER_S);
						onlinepaymentService.saveOrUpdate(list);
						User user=userService.findUserByUserid(list.getUserid()).get(0);
						/*  user.setBalance(0.0);
						 userService.saveOrUpdate(user);*/
						int jifen=3;
						int integrals=user.getIntegral();
						user.setIntegral(integrals+jifen);
						String time=DateTimeUtil.currentDatetime();
						if (list.getType().equals(Define.ONLINE_TYPE_R)) {
							Receipt receipt=receiptService.get(list.getReceiptId());
							receipt.setStatus(Define.RECEIPT_STATUS_2);
							receipt.setTime(time);
							receiptService.saveOrUpdate(receipt);
							
							Message message=new Message();
							message.setContent("恭喜你成功发单帮我送,订单名称("+receipt.getItemName()+")");
							message.setTime(time);
							message.setUserid(receipt.getUserid());
							messageService.save(message);
							
							Integral integral=new Integral();
							integral.setContent("成功发单帮我送,订单名称("+receipt.getItemName()+"),奖励3分");
							integral.setUserid(receipt.getUserid());
							integral.setTime(time);
							integral.setIntegral(jifen);
							integralService.save(integral);
						}
						if (list.getType().equals(Define.ONLINE_TYPE_RBG)) {
							
						Receipt receipt=receiptService.get(list.getReceiptId());
							receipt.setStatus(Define.RECEIPT_STATUS_2);
							receiptService.saveOrUpdate(receipt);
							
							user.setBalance(0.0);
							
							Message message=new Message();
							message.setContent("恭喜你成功发单帮我送,订单名称("+receipt.getItemName()+")");
							message.setTime(time);
							message.setUserid(receipt.getUserid());
							messageService.save(message);
							
							Integral integral=new Integral();
							integral.setContent("成功发单帮我送,订单名称("+receipt.getItemName()+"),奖励3分");
							integral.setUserid(receipt.getUserid());
							integral.setTime(time);
							integral.setIntegral(jifen);
							integralService.save(integral);
						}
						else {
							Helpmebuy helpmebuy=helpmebuyService.get(list.getReceiptId());
							helpmebuy.setStatus(Define.HELPMEBUY_STATUS_2);
							helpmebuy.setTime(time);
							helpmebuyService.saveOrUpdate(helpmebuy);
							
							Integral integral=new Integral();
							Message message=new Message();
						
							
							if (list.getType().equals(Define.ONLINE_TYPE_H)){
								if (helpmebuy.getGoodsname()!=null) {
									message.setContent("恭喜你成功发任务,任务名称("+helpmebuy.getGoodsname()+")");
									integral.setContent("成功发任务,任务名称("+helpmebuy.getGoodsname()+"),奖励3分");
								}else {
									message.setContent("恭喜你成功发语音任务");
									integral.setContent("恭喜你成功发语音任务,奖励3分");	
								}
								
							}
							if (list.getType().equals(Define.ONLINE_TYPE_HBG)){							
									user.setBalance(0.0);
								
								if (helpmebuy.getGoodsname()!=null) {
									message.setContent("恭喜你成功发任务,任务名称("+helpmebuy.getGoodsname()+")");
									integral.setContent("成功发任务,任务名称("+helpmebuy.getGoodsname()+"),奖励3分");
								}else {
									message.setContent("恭喜你成功发语音任务");
									integral.setContent("恭喜你成功发语音任务,奖励3分");	
								}
								
							}
							
							if (list.getType().equals(Define.ONLINE_TYPE_BBG)){							
								user.setBalance(0.0);
							
								if (helpmebuy.getGoodsname()!=null) {
									message.setContent("恭喜你成功发单办事,办事名称("+helpmebuy.getGoodsname()+")");
									integral.setContent("成功发单办事,办事名称("+helpmebuy.getGoodsname()+"),奖励3分");
									}
								else {
										message.setContent("恭喜你成功发语音办事");
										integral.setContent("恭喜你成功发语音办事,奖励3分");	
									}
							
							}
							if (list.getType().equals(Define.ONLINE_TYPE_B)){	
								if (helpmebuy.getGoodsname()!=null) {
								message.setContent("恭喜你成功发单办事,办事名称("+helpmebuy.getGoodsname()+")");
								integral.setContent("成功发单办事,办事名称("+helpmebuy.getGoodsname()+"),奖励3分");
								}
								else {
									message.setContent("恭喜你成功发语音办事");
									integral.setContent("恭喜你成功发语音办事,奖励3分");	
								}
								}
							
							
							message.setTime(time);
							message.setUserid(helpmebuy.getUserid());
							messageService.save(message);
							
							integral.setUserid(helpmebuy.getUserid());
							integral.setTime(time);
							integral.setIntegral(jifen);
							integralService.save(integral);
						}
							
							userService.saveOrUpdate(user);
						
					request.setAttribute("Result", "S");
						
					}else {
						  request.setAttribute("Result", "S");
					
						}
					}
			
			}else{
				  request.setAttribute("Result", "F");
				
			}	
			
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}
	
	
	
	
	
	 private MessageHelper messageHelper;
	 public MessageHelper getMessageHelper() {
		return messageHelper;
	}
	 public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	private Double money;
	private String type;
	private String time;
	private String userid;
	private String bank;
	private String accountHolder;
	private String cardNumber;
	
	//支付类型
	String payment_type = "1";
	//必填，不能修改
	//服务器异步通知页面路径
	String notify_url = "";
	//需http://格式的完整路径，不能加?id=123这类自定义参数

	//页面跳转同步通知页面路径
	//String return_url = "http://192.168.1.203:8080/chengszj/CheckResult.action";
	
	//String return_url = "http://115.28.58.245:8080/chengszj/CheckResult.action";
	String return_url = "http://115.28.58.245:80/chengszj/CheckResult.action";
	//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
	
	//订单名称
	String subject="充值";
	//商品展示地址
	//String show_url="http://192.168.1.203:8080/chengszj";
	//String show_url="http://115.28.58.245:8080/chengszj";
	String show_url="http://115.28.58.245:80/chengszj/index.jsp";
	
	//付款金额
	private String total_fee;
	//订单描述
	private String body;
	//超时时间
	private	String it_b_pay;
	
	//钱包token
	private	String extern_token;
	
	
	public void setExtern_token(String extern_token) {
		this.extern_token = extern_token;
	}
	
	public void setIt_b_pay(String it_b_pay) {
		this.it_b_pay = it_b_pay;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	private MessageService messageService;
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	private String status;
	public void setStatus(String status) {
		this.status = status;
	}
		private Map<String, Object> request;
	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
}
