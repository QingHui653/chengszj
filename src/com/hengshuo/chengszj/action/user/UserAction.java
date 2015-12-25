package com.hengshuo.chengszj.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.baidu.platform.comapi.map.u;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.ImageUpload;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.model.Admin;
import com.hengshuo.chengszj.model.Integral;
import com.hengshuo.chengszj.model.Message;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.service.integral.IntegralService;
import com.hengshuo.chengszj.service.message.MessageService;
import com.hengshuo.chengszj.service.user.UserService;

public class UserAction extends BaseAction implements RequestAware,SessionAware {
	private static final Logger log=Logger.getLogger(UserAction.class.getName());
	private UserService userService;
	private MessageService messageService;
	private IntegralService integralService;
	public void setIntegralService(IntegralService integralService) {
		this.integralService = integralService;
	}
	private String userid;
	private String password;
	private String xpassword;
	private String dizhi;
	private String weizhi;
	private String qianmin;
	private String zhiye;
	private String ip;
	private String city;
	private String area;
	public void setCity(String city) {
		this.city = city;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setQianmin(String qianmin) {
		this.qianmin = qianmin;
	}
	public void setZhiye(String zhiye) {
		this.zhiye = zhiye;
	}
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	public void setXpassword(String xpassword) {
		this.xpassword = xpassword;
	}
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	private String verifycode;
	private String tixianPassword;
	private String headphoto;
	private String name;
	private Integer integral;
	private Double balance;
	private String creditrating;
	private String phone;
	private String status;
	private String type;
	public void setType(String type) {
		this.type = type;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void setCreditrating(String creditrating) {
		this.creditrating = creditrating;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}
	public void setTixianPassword(String tixianPassword) {
		this.tixianPassword = tixianPassword;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 private MessageHelper messageHelper;
	 public MessageHelper getMessageHelper() {
		return messageHelper;
	}
	 public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}
	
	
	
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 修改地址，位置
	 */
	public String updateWeiZhi(){
	try {
		String queryString="update User set weizhi='"+weizhi+"'where userid='"+userid+"'";
	int x=userService.bulkUpdate(queryString);
	if (x>0) {
		MessageHelper mh = new MessageHelper();
	 	mh.setResult(Define.S);
		setMessageHelper(mh);
	}else {
		MessageHelper mh = new MessageHelper();
	 	mh.setResult(Define.F);
	 	mh.setMessage("修改失败");
		setMessageHelper(mh);
	}
	} catch (Exception e) {
		log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 冻结资金
	 * 
	 */
/*	public String dongJieZiJin(){
		try {
		User user=userService.get(id);
		//user.setStatus(status)
		userService.saveOrUpdate(user);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}*/
	
	
	
	
	
	
	/**
	 * 查询余额
	 */
	public String findYuE(){
		try {
		Double yue=userService.findYuE(userid);
		 MessageHelper mh = new MessageHelper();
		 mh.setResult(Define.S);
		 mh.setMessage(yue.toString());
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
	 * 后台修改会员信息
	 */
	
	public String  updateUser(){
		try {
		User user=userService.get(id);
		//user.setUserid(userid);
		user.setName(name);
		user.setIntegral(integral);
		user.setBalance(balance);
		user.setCreditrating(creditrating);
		user.setPhone(phone);
		user.setZhiye(zhiye);
		user.setStatus(status);
		user.setQianmin(qianmin);
		userService.saveOrUpdate(user);
		request.put("user", user);
		
		Admin admin=(Admin) session.get("user");
		if (admin.getCity()!=null) {
			return "City";
		}
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 区域管理员
	 * 
	 */
	public String findCityAllUser(){
		try {
		Admin admin=(Admin) session.get("user");
			User user=new User();
			if (type.equals(Define.USER_STATUS_N)) {
				user.setStatus(Define.USER_STATUS_N);
			}else {
				user.setStatus(Define.USER_STATUS_Y);
			}
			user.setCity(admin.getCity());
			user.setArea(admin.getArea());
			
			
		PageSupport<User> pageSupport=userService.findPageByExampleAndOrder(user, "id", "desc", getPageNo(), 10);
		request.put("pageSupport", pageSupport);
		request.put("type", type);
		
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		if (type.equals(Define.USER_STATUS_N)) {
			return "OK";
		}else {
			return "Y";
		}
		
	}
	
	
	
	
	/**
	 * 后台会员详细信息
	 */
	public String  findUserDetail(){
		try {
			if (type.equals("D")) {  //订单查看详细
				User user=userService.findUserByUserid(userid).get(0);
				request.put("user", user);
					return "D";
			
			}else {
				User user=userService.get(id);
				request.put("user", user);
				request.put("type", type);
			}
			
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 后台会员信息
	 */
	public String  findAllUser(){
		try {
			
			User user=new User();
			if (type.equals(Define.USER_STATUS_N)) {
				user.setStatus(Define.USER_STATUS_N);
			}else {
				user.setStatus(Define.USER_STATUS_Y);
			}
		PageSupport<User> pageSupport=userService.findPageByExampleAndOrder(user, "id", "desc", getPageNo(), 10);
		request.put("pageSupport", pageSupport);
		request.put("type", type);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		if (type.equals(Define.USER_STATUS_N)) {
			return "OK";
		}else {
			return "Y";
		}
		
	}
	
	
	/**
	 * 查询快递人位置
	 */
	public String findWeiZhi(){
		try {
			List<User> users=userService.findUserByUserid(userid);
			User user=	users.get(0);
			String weizhi=user.getWeizhi();
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.S);
	 		 mh.setMessage(weizhi);
	 		 setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("获取位置失败");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 修改职业
	 */
	public String updateZhiye(){
		try {
		List<User> users=userService.findUserByUserid(userid);
		User user=	users.get(0);
		user.setZhiye(new String(zhiye.getBytes("iso8859-1"), "utf-8"));
		userService.saveOrUpdate(user);
		User user2= userService.get(user.getId());
		MessageHelper mh = new MessageHelper();
 		 mh.setResult(Define.S);
 		 mh.setEntity(user2);
 		 setMessageHelper(mh);
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
	 * 查询接单人的信息
	 * 
	 */
	public String  findkuaidi(){
		try {
			List<User> users=userService.findUserByUserid(userid);
			User user=	users.get(0);
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.S);
	 		 mh.setEntity(user);
	 		 setMessageHelper(mh);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("获取失败");
	 		 setMessageHelper(mh);
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	
	
	
	/**
	 * 修改签名
	 */
	public String updateQianmin(){
		try {
			List<User> users=userService.findUserByUserid(userid);
			User user=	users.get(0);
			user.setQianmin(new String(qianmin.getBytes("iso8859-1"), "utf-8"));
			userService.saveOrUpdate(user);
			User user2= userService.get(user.getId());
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.S);
	 		 mh.setEntity(user2);
	 		 setMessageHelper(mh);
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
	 * 修改昵称
	 * @return
	 */
	public String updateNiChen(){
		
		try {
			List<User> users=userService.findUserByUserid(userid);
			User user=	users.get(0);
			user.setName(new String(name.getBytes("iso8859-1"), "utf-8"));
			userService.saveOrUpdate(user);
			User user2= userService.get(user.getId());
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.S);
	 		 mh.setEntity(user2);
	 		 setMessageHelper(mh);
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
	 * 修改头像
	 * @return
	 */
	public String updateTouXian(){
		try {
			List<User> users=userService.findUserByUserid(userid);
			User user=	users.get(0);
			if (headphoto!=null) {
				String  url=ImageUpload.imageupload(headphoto, Define.IMAGES_USER, userid, "_headphoto");
				user.setHeadphoto(url);
				userService.saveOrUpdate(user);
				}
			User user2=userService.get(user.getId());
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.S);
	 		 mh.setEntity(user2);
	 		 setMessageHelper(mh);
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
	 * 修改登入密码
	 * @return
	 */
	public String dengRuMiMa(){
	try {
		List<User> users=userService.findUserByUserid(userid);
		User user=	users.get(0);
		String mima=user.getPassword();
		if (mima.equals(password)) {
			user.setPassword(xpassword);
			userService.saveOrUpdate(user);
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.S);
	 		 setMessageHelper(mh);
		}
		else {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("输入的旧密码错误");
	 		 setMessageHelper(mh);
		}
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
	 * 设置提现密码
	 * @return
	 */
	public String tiXiangMiMa(){
		try {
		List<User> users=userService.findUserByUserid(userid);
		User user=	users.get(0);
		String yzm=user.getVerifycode();
		String mima=user.getPassword();
		if (yzm.equals(verifycode)) {
			if (mima.equals(password)) {
				user.setTixianPassword(tixianPassword);
				userService.saveOrUpdate(user);
				
				MessageHelper mh = new MessageHelper();
		 		 mh.setResult(Define.S);
		 		 setMessageHelper(mh);
				
			}else {
				MessageHelper mh = new MessageHelper();
		 		 mh.setResult(Define.F);
		 		 mh.setMessage("登入密码错误");
		 		 setMessageHelper(mh);
			}
		}else {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("验证码错误");
	 		 setMessageHelper(mh);
		}
		
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("设置提现密码失败");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	
	
	/**
	 * 我的积分
	 * @param userid 用户登入的账号
	 * @return 
	 */
	public String jiFeng(){
		try {
			String query="from Integral where userid=? ";
			Object[] values={userid};
		List<Integral> integrals=integralService.find(query, values);
		
		MessageHelper mh = new MessageHelper();
		mh.setList(integrals);
		mh.setResult(Define.S);
	 	   setMessageHelper(mh);
			
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("获取信息失败");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		return  "OK";
	}
	
	
	/**
	 * 我的消息
	 * @param userid 用户登入的账号
	 * @return 
	 */
	
	public String myMessage(){
		try {
		String query="from Message where userid=? ORDER BY id DESC";
		Object[] values={userid};
		List<Message> messages=	messageService.find(query, values);
		
		request.put("messages", messages);
	/*	MessageHelper mh = new MessageHelper();
		mh.setList(messages);
		mh.setResult(Define.S);
	 	   setMessageHelper(mh);*/
	 	   
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("获取消息失败");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	
	

	/**
	 * 登入
	 * @param userid 用户登入的账号
	 *  @param password 用户密码
	 * @return 
	 */
	public String login(){
		try {
			List<User> users=userService.findUserByUserid(userid);
			User user=users.get(0);
			String mima=user.getPassword();
			if (mima.equals(password)) {
				user.setDengrutime(DateTimeUtil.currentDatetime());
				user.setDizhi(dizhi);
				user.setWeizhi(weizhi);
				user.setCity(city);
				user.setArea(area);
				HttpServletRequest request = ServletActionContext.getRequest();
				ip=request.getRemoteAddr();
				user.setIp(ip);
				userService.saveOrUpdate(user);
				MessageHelper mh = new MessageHelper();
				mh.setResult(Define.S);
				mh.setEntity(user);
			 	   setMessageHelper(mh);
			}else{
				MessageHelper mh = new MessageHelper();
		 		 mh.setResult(Define.F);
		 		 mh.setMessage("密码错误");
		 		 setMessageHelper(mh);
			}
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("账号不存在");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	
	
	
	/**
	 * 找回密码
	 * @param userid 用户登入的账号
	 *  @param password 用户新密码
	 * @param verifycode 输入的验证码
	 * @return 
	 */
	public String zhaohuimima(){
		try {
			List<User> users=userService.findUserByUserid(userid);
			User user=users.get(0);
			String VFcode=user.getVerifycode();
			if (VFcode.equals(verifycode)) {
			user.setPassword(password);	
			userService.saveOrUpdate(user);
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
		 	   setMessageHelper(mh);
			}else {
				 MessageHelper mh = new MessageHelper();
		 		 mh.setResult(Define.F);
		 		 mh.setMessage("验证码错误");
		 		 setMessageHelper(mh);
			}
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
	 * 注册
	 * @param userid 用户登入的账号
	 * @param verifycode 输入的验证码
	 * @return 
	 */
	public String Register(){
	try {
		List<User> users=userService.findUserByUserid(userid);
		User user=users.get(0);
		String VFcode=user.getVerifycode();
		String  jif=user.getCreditrating();
		if (jif==null) {
			if (VFcode.equals(verifycode)) {
				user.setPassword(password);
				user.setIntegral(15);
				user.setBalance(Double.valueOf(0));
				user.setPhone(userid);
				user.setCreditrating("10");
				user.setStatus("N");
				Message message=new Message();
				message.setUserid(userid);
				String time=DateTimeUtil.currentDatetime();
				message.setTime(time);
				message.setContent("恭喜你成为城市之间会员，获得15积分");
				messageService.save(message);
			
				Integral integral=new Integral();
				integral.setTime(time);
				integral.setIntegral(15);
				integral.setUserid(userid);
				integral.setContent("用户注册");
				integralService.save(integral);
				
				userService.saveOrUpdate(user);
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
		 	   setMessageHelper(mh);
			}else {
			 MessageHelper mh = new MessageHelper();
		 		mh.setResult(Define.F);
		 		mh.setMessage("验证码错误");
		 		setMessageHelper(mh);
			}
		}else {
			 MessageHelper mh = new MessageHelper();
		 		mh.setResult(Define.F);
		 		mh.setMessage("用户已被注册");
		 		setMessageHelper(mh);
			}
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
	 * 获取验证码
	 * @param userid 用户登入的账号
	 * @return 
	 */
	public String verifycode(){
		try {
	List<User> users=userService.findUserByUserid(userid);
	com.hengshuo.chengszj.service.jiekou.MessageService mService=new com.hengshuo.chengszj.service.jiekou.MessageService();
		String verifycode=mService.registerValidate(userid);
		
		if(verifycode.equals(Define.F)){
			 MessageHelper mh = new MessageHelper();
 			mh.setResult(Define.F);
 			 mh.setMessage(Define.F_MESSAGE);
 			 setMessageHelper(mh);
			}
		else {
			if (users.size()>0) {
			User user=users.get(0);
			user.setVerifycode(verifycode);
			userService.saveOrUpdate(user);
			}else {
				User user=new User();
				user.setUserid(userid);
				user.setVerifycode(verifycode);
				userService.save(user);
			}
			 MessageHelper mh = new MessageHelper();
	 			mh.setResult(Define.S);
	 			 setMessageHelper(mh);
			}
		} catch (Exception e) {
			 MessageHelper mh = new MessageHelper();
	 			 mh.setResult(Define.F);
	 			 mh.setMessage(Define.F_MESSAGE);
	 			 setMessageHelper(mh);
	 			 log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	
	private Map<String,Object> request;
	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	private Map<String,Object> session;
	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	

	
	
}
