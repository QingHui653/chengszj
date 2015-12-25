package com.hengshuo.chengszj.common.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.opensymphony.xwork2.inject.Context;

public class NetworkTool {
	
	/**
	* getting  string content by URL.
	* @param url
	* @return
	* @throws Exception
	*/
	public static String getContent(String url) throws Exception{
	    StringBuilder sb = new StringBuilder();
	    
//	    HttpClient client = new DefaultHttpClient();
//	    HttpParams httpParams = client.getParams();
//	    HttpConnectionParams.setConnectionTimeout(httpParams, 10*1000);
//	    HttpConnectionParams.setSoTimeout(httpParams, 10*1000);
////	    url="http://www.baidu.com";
//	    HttpResponse response = client.execute(new HttpGet(url));
//	    HttpEntity entity = response.getEntity();
//	    if (entity != null) {
//	        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"), 8192);
//	        
//	        String line = null;
//	        while ((line = reader.readLine())!= null){
//	            sb.append(line + "\n");
//	        }
//	        reader.close();
//	    }
	    GetMethod getMethod=null;
		//生成 HttpClinet 对象并设置参数
		try {
			HttpClient httpClient = new HttpClient();
			// 设置 Http 连接超时 5s
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(
					1000*5);
			//生成 GetMethod 对象并设置参数
			getMethod = new GetMethod(url);
			// 设置 get 请求超时 10s
			getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 1000*5);
//			// 设置 get 请求超时 120s
//			getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 120000);
			// 设置请求重试处理3次
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler(0,true));
			
			int statusCode = httpClient.executeMethod(getMethod);
			byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
			sb.append(new String(responseBody));
			
		}catch(Exception e){
			e.printStackTrace();
//			e.getMessage();
		}
	    return sb.toString();
	} 
	
   
	
/*	public static void  main(String arg[]){
//		String url="http://www.baidu.com";
		String url="http://218.244.136.70:8888/sms.aspx?action=send&userid=1505&account=bbx&password=123456&mobile=13755179793&content=您好，您的验证码是T1459【百保箱】&sendTime=&extno=";
		try {
			System.out.println(getContent(url));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}*/
}
