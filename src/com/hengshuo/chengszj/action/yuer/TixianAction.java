package com.hengshuo.chengszj.action.yuer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.alipay.config.zhuanzhan.AlipayConfig;
import com.alipay.util.httpClient.HttpProtocolHandler;
import com.alipay.util.httpClient.HttpRequest;
import com.alipay.util.httpClient.HttpResponse;
import com.alipay.util.httpClient.HttpResultType;
import com.alipay.util.zhuanz.AlipaySubmit;
import com.alipay.util.zhuanz.UtilDate;
import com.baidu.platform.comapi.map.w;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.action.user.UserAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.Arithmetic4Double;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.common.util.NetworkTool;
import com.hengshuo.chengszj.model.Recharge;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.model.Withdrawals;
import com.hengshuo.chengszj.service.recharge.RechargeService;
import com.hengshuo.chengszj.service.user.UserService;
import com.hengshuo.chengszj.service.withdrawals.WithdrawalsService;

public class TixianAction extends BaseAction implements RequestAware {
	private static final Logger log=Logger.getLogger(TixianAction.class.getName());

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
	
	//服务器异步通知页面路径
			String notify_url = "";
			//需http://格式的完整路径，不允许加?id=123这类自定义参数

			//付款账号
			//String email = "3153457354@qq.com";
			String email = "city361@189.cn";
			//必填

			//付款账户名
			//String account_name = "湖南恒硕科技有限公司";
			String account_name = "汕头市珊瑚网络科技有限公司";
			//必填，个人支付宝账号是真实姓名公司支付宝账号是公司名称

			//付款当天日期
			String pay_date = UtilDate.getDate();
			//必填，格式：年[4位]月[2位]日[2位]，如：20100801

			//批次号
			String batch_no = UtilDate.getOrderNum()+UtilDate.getThree();
			//必填，格式：当天日期[8位]+序列号[3至16位]，如：201008010000001

			//付款总金额
			/*String batch_fee = new String(request.getParameter("WIDbatch_fee").getBytes("ISO-8859-1"),"UTF-8");
			*///必填，即参数detail_data的值中所有金额的总和

			//付款笔数
			String batch_num ="1";
			//必填，即参数detail_data的值中，“|”字符出现的数量加1，最大支持1000笔（即“|”字符出现的数量999个）

			//付款详细数据
		//	String detail_data = new String(request.getParameter("WIDdetail_data").getBytes("ISO-8859-1"),"UTF-8");
			//必填，格式：流水号1^收款方帐号1^真实姓名^付款金额1^备注说明1|流水号2^收款方帐号2^真实姓名^付款金额2^备注说明2....
			
	
	
	
	public String urltest(){
		try {

			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "batch_trans_notify");
	        sParaTemp.put("partner", AlipayConfig.partner);
	        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
			sParaTemp.put("notify_url", notify_url);
			sParaTemp.put("email", email);
			sParaTemp.put("account_name", account_name);
			sParaTemp.put("pay_date", pay_date);
			sParaTemp.put("batch_no", batch_no);
			sParaTemp.put("batch_fee", String.valueOf(money));
			sParaTemp.put("batch_num", batch_num);
			name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
			String detail_data="流水号1^"+cardNumber+"^"+name+"^"+money+"^"+"城市之间提现审核";
			sParaTemp.put("detail_data", detail_data);
		String sPara = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
		String cString=	NetworkTool.getContent(sPara);
		if (cString!=null||!cString.equals("")) {
			Withdrawals withdrawals=new Withdrawals();
			withdrawals.setMoney(money);
			withdrawals.setUserid(userid);
			withdrawals.setName(name);
			withdrawals.setCardNumber(cardNumber);
			withdrawals.setStatus(Define.YUER_Z);
			withdrawals.setTime(DateTimeUtil.currentDatetime());	
			withdService.save(withdrawals);
		}
		
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
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
	 */
	public String tiXian(){
		try {
	/*		
		List<User> users=userService.findUserByUserid(userid);	
			User user=users.get(0);
	
		Double balance=user.getBalance();
		user.setBalance(Arithmetic4Double.sub(balance, money));
		userService.saveOrUpdate(user);*/
		

		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "batch_trans_notify");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("email", email);
		sParaTemp.put("account_name", account_name);
		sParaTemp.put("pay_date", pay_date);
		sParaTemp.put("batch_no", batch_no);
		sParaTemp.put("batch_fee", String.valueOf(money));
		sParaTemp.put("batch_num", batch_num);
		name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		String detail_data="流水号1^"+cardNumber+"^"+name+"^"+money+"^"+"城市之间提现审核";
		sParaTemp.put("detail_data", detail_data);
	String sPara = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
	String cString=	NetworkTool.getContent(sPara);
	if (cString!=null||!cString.equals("")) {
		Withdrawals withdrawals=new Withdrawals();
		withdrawals.setMoney(money);
		withdrawals.setUserid(userid);
		withdrawals.setName(name);
		withdrawals.setCardNumber(cardNumber);
		withdrawals.setStatus(Define.YUER_Z);
		withdrawals.setTime(DateTimeUtil.currentDatetime());	
		withdService.save(withdrawals);
		MessageHelper mh = new MessageHelper();
		 mh.setResult(Define.S);
		 setMessageHelper(mh);
		}else {
		
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("提现审核异常");
	 		 setMessageHelper(mh);
		}
	} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		mh.setMessage("提现审核异常");
	 		 setMessageHelper(mh);
	 	 log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}

	
	/**
	 * 提现审核程序
	 */
	
	
	public String shenhez(){
		try {
			List<User> users=userService.findUserByUserid(userid);	
			User user=users.get(0);
		Withdrawals withdrawals=withdService.get(id);
		Double mone=withdrawals.getMoney();
		if (types.equals(Define.YUER_F)) {
			withdrawals.setStatus(Define.YUER_F);
		}
		if (types.equals(Define.YUER_S)) {
			withdrawals.setStatus(Define.YUER_S);
			Double balance=user.getBalance();
			user.setBalance(Arithmetic4Double.sub(balance, mone));
			userService.saveOrUpdate(user);
		}
	
		withdService.saveOrUpdate(withdrawals);
		
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "OK";
	}
	
	/**
	 * 提现审核
	 */
	public String shenhe(){
		try {
			Withdrawals withdrawals=new Withdrawals();
			withdrawals.setStatus(Define.YUER_Z);
		PageSupport<Withdrawals> pageSupport=withdService.findPageByExampleAndOrder(withdrawals, "id", "desc", getPageNo(), 10);
			request.put("pageSupport",pageSupport);
		} catch (Exception e) {
			// TODO: handle exception
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

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	private Double money;
	private String userid;
	private String cardNumber;
	private String name;
	private String types;
	public void setTypes(String types) {
		this.types = types;
	}
	public void setName(String name) {
		this.name = name;
	}

		private Map<String, Object> request;
	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
}
