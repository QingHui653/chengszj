package com.hengshuo.chengszj.action.feekback;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;

import com.baidu.platform.comapi.map.m;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.model.Feekback;
import com.hengshuo.chengszj.model.Integral;
import com.hengshuo.chengszj.model.Message;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.service.feekback.FeekbackService;
import com.hengshuo.chengszj.service.impl.feekback.FeekbackServiceI;
import com.hengshuo.chengszj.service.integral.IntegralService;
import com.hengshuo.chengszj.service.message.MessageService;
import com.hengshuo.chengszj.service.user.UserService;

public class FeekbackAction extends BaseAction implements RequestAware {
	private static final Logger log=Logger.getLogger(FeekbackAction.class.getName());
		private FeekbackService feekbackService;
		private UserService userService;
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		public void setFeekbackService(FeekbackService feekbackService) {
			this.feekbackService = feekbackService;
		}
		 private MessageHelper messageHelper;
		 public MessageHelper getMessageHelper() {
			return messageHelper;
		}
		 public void setMessageHelper(MessageHelper messageHelper) {
			this.messageHelper = messageHelper;
		}
		private Integer id;
		private String content;
		private String userid;
		private String accept;
		
		
		/**
		 * 反馈建议界面
		 * @return 
		 */
		public String feekbackUI(){
			request.put("userid", userid);
			return "OK";
		}
		
		
		/**
		 * 反馈建议
		 * @return 
		 */
		public String feekback(){
			try {
			Feekback feekback=new Feekback();
			feekback.setUserid(userid);
			feekback.setTime(DateTimeUtil.currentDatetime());
			feekback.setContent(new String(content.getBytes("iso8859-1"), "utf-8")); 
			feekback.setAccept(Define.ACCEPT_0);
			feekbackService.save(feekback);
			MessageHelper mh = new MessageHelper();
			mh.setResult(Define.S);
		 	   setMessageHelper(mh);
			} catch (Exception e) {
				MessageHelper mh = new MessageHelper();
				mh.setResult(Define.F);
				mh.setMessage("反馈失败");
			 	   setMessageHelper(mh);
				log.error(Define.F_MESSAGE+e.getMessage());
			}
			return "OK";
		}
		
		
		public String list(){
			try {
				Feekback feekback=new Feekback();
				feekback.setAccept(Define.ACCEPT_0);
			PageSupport<Feekback> pageSupport=feekbackService.findPageByExampleAndOrder(feekback, "id", "desc", getPageNo(), 10);
			request.put("pageSupport", pageSupport);
			} catch (Exception e) {
				log.error(Define.F_MESSAGE+e.getMessage());
			}
			return "OK";
		}
		
		public String tongguo(){
			try {
			User user=userService.findUserByUserid(userid).get(0);
			Feekback feekback=feekbackService.get(id);
			if (types.equals("S")) {
				feekback.setAccept(Define.ACCEPT_1);
				int fengshu=user.getIntegral();
				user.setIntegral(fengshu+50);
				userService.saveOrUpdate(user);
				
				Integral integral=new Integral();
				integral.setTime(DateTimeUtil.currentDatetime());
				integral.setUserid(userid);
				integral.setContent("反馈建议被采纳获得50分");
				integral.setIntegral(50);
				integralService.save(integral);
			}
			if (types.equals("F")) {
				feekback.setAccept(Define.ACCEPT_2);
			}
			feekbackService.saveOrUpdate(feekback);
			} catch (Exception e) {
				log.error(Define.F_MESSAGE+e.getMessage());
			}
			return "OK";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		private IntegralService integralService;
		public void setIntegralService(IntegralService integralService) {
			this.integralService = integralService;
		}
		private String types;
		public void setTypes(String types) {
			this.types = types;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public void setAccept(String accept) {
			this.accept = accept;
		}
		
		
		private Map<String , Object> request;
		
		@Override
		public void setRequest(Map arg0) {
			// TODO Auto-generated method stub
			this.request=arg0;
		}
		
		
}
