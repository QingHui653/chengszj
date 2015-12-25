package com.hengshuo.chengszj.common.util;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.hengshuo.chengszj.action.feekback.FeekbackAction;

/*
 *  socket 通信工具类 
 * 
 * */
public class NetworkTool4Socket {
	private static final Logger log=Logger.getLogger(NetworkTool4Socket.class.getName());
	
	
	/**
	 *  发送socket 通信
	 *  @param host 服务器ip地址
	 *  @param port 端口号
	 * 
	 **/
	public void  sendMessage(String host,int port ,String message){
		
		    //与服务端建立连接  
		      Socket client=null;
		      Writer writer=null;
		      try{
		       client = new Socket(host, port);  
		    //建立连接后就可以往服务端写数据了  
		      writer = new OutputStreamWriter(client.getOutputStream());  
	          writer.write(message);  
		      writer.flush();//写完后要记得flush  
		      
		      }catch(Exception e){
		    	  log.error("sendMessage error:"+e.getMessage());
//		    	  e.printStackTrace();
		      }finally{
	           try {
				writer.close();
				client.close(); 
			} catch (IOException e) {
				 log.error("close sendMessage error:"+e.getMessage());
				// TODO Auto-generated catch block
//				e.printStackTrace();
			
			}  
		      }
	}
	 

	
}
