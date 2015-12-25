package com.hengshuo.chengszj.service.jiekou;

import java.util.Random;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.common.util.Define;
import com.ruanwei.interfacej.SmsClientSend;

public class MessageService {
	private static Logger log = Logger.getLogger(MessageService.class
			.getName());
	
	/**
	 * 
	 * 注册验证码
	 * @return  rst表示失败，否则就是六位验证码
	 */
	public  String registerValidate(String userid){
		String rst=Define.F;
		String returnValue ="";
		String yanZhengMa="";
		
		try{
			
			yanZhengMa=toRandomliu();
			
			returnValue=SmsClientSend.sendSms("http://115.29.242.32:8888/sms.aspx", "384", "SHWL", "456789", userid, "您好，您的验证码是"+yanZhengMa+"【百托服务】");
			
			System.out.println(returnValue);
			if(returnValue.contains("ok")){
				rst=yanZhengMa;
			}
			else{
				return rst;
			}
		}catch(Exception e){
			log.error(returnValue+e.getMessage());
			return rst;
		}
		return rst;
		
	}
	
	/**
	 * 
	 * 注册激活码
	 * @return  rst表示失败，否则就是六位验证码
	 */
	public  String registerACCode(String phone){
		String rst=Define.F;
		String returnValue ="";
		String yanZhengMa="";
		
		try{
			
			yanZhengMa=toRandom();
			returnValue=	SmsClientSend.sendSms("http://218.244.136.70:8888/sms.aspx", "1505", "bbx", "123456", phone, "您好，您的激活码是"+yanZhengMa+"【百保箱】");
			System.out.println(returnValue);
			if(returnValue.contains("ok")){
				rst=yanZhengMa;
			}
			else{
				return rst;
			}
		}catch(Exception e){
			log.error(returnValue+e.getMessage());
			return rst;
		}
		return rst;
		
	}
	
	/**
	 * 
	 * 忘记密码
	 * @return  rst表示失败，否则就是六位验证码
	 */
	public  String wjiMiMa(String userid){
		String rst=Define.F;
		String returnValue ="";
		String yanZhengMa="";
		
		try{
			
			yanZhengMa=toRandomliu();
			returnValue=	SmsClientSend.sendSms("http://218.244.136.70:8888/sms.aspx", "1505", "bbx", "123456", userid, "您好，您的新密码是"+yanZhengMa+"【百保箱】");
			System.out.println(returnValue);
			if(returnValue.contains("ok")){
				rst=yanZhengMa;
			}
			else{
				return rst;
			}
		}catch(Exception e){
			log.error(returnValue+e.getMessage());
			return rst;
		}
		return rst;
		
	}
	
	
	
	
	public static String toRandom(){
		Random random = new Random();
		String result="";
		for(int i=0;i<9;i++){
		result+=random.nextInt(10);
			}
		
		return result;
	}
	public static String toRandomliu(){
		Random random = new Random();
		String result="";
		for(int i=0;i<6;i++){
		result+=random.nextInt(10);
			}
		
		return result;
	}
	 
}
