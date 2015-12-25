package com.ruanwei.interfacej;

import com.ruanwei.tool.SmsClientAccessTool;

public class Test {

	public static String url = "http://218.244.136.70:8888/sms.aspx";
	public static String userid = "1505";
	public static String account = "bbx";
	public static String password = "123456";
	public static String checkWord = "这个字符串中是否包含了屏蔽字";

	public static void main(String[] args) {

//		keyword();
		// overage();
		
		
	String rst=	SmsClientSend.sendSms("http://218.244.136.70:8888/sms.aspx", "1505", "bbx", "123456", "13755179793", "您好，您的验证码是T1450【百保箱】");
	   System.out.println(rst);
	}

	public static void keyword() {

		String keyword = SmsClientKeyword.queryKeyWord(url, userid, account,
				password, checkWord);
		System.out.println(keyword);
	}

	public static void overage() {

		String overage = SmsClientOverage.queryOverage(url, userid, account,
				password);
		System.out.println(overage);
	}

	public static void test() {
		String send = SmsClientAccessTool.getInstance().doAccessHTTPPost(
				"http://118.145.30.35/sms.aspx", "action=send&userid=1505&account=bbx&password=123456&mobile=13755179793&content=您好，您的验证码是T1459【百保箱】&sendTime=&extno=", "utf-8");
		System.out.println(send);
	}
}
