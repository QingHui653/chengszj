package com.hengshuo.chengszj.action.onlinepayment;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.baidu.a.a.a.c;
import com.baidu.platform.comapi.map.s;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.action.post.PostAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.model.Onlinepayment;
import com.hengshuo.chengszj.model.Receipt;
import com.hengshuo.chengszj.service.onlinepayment.OnlinepaymentService;
import com.hengshuo.chengszj.service.receipt.ReceiptService;
import com.hengshuo.chengszj.service.user.UserService;

public class OnlinepaymentAction extends BaseAction implements RequestAware {
	private static final Logger log=Logger.getLogger(OnlinepaymentAction.class.getName());
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private ReceiptService receiptService;
	public void setReceiptService(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
	private OnlinepaymentService onPayService;
	public void setOnPayService(OnlinepaymentService onPayService) {
		this.onPayService = onPayService;
	}
	private String type;
	public void setType(String type) {
		this.type = type;
	}
	
	private String kstime;
	public void setKstime(String kstime) {
		this.kstime = kstime;
	}
	private String jstime;
	public void setJstime(String jstime) {
		this.jstime = jstime;
	}
	
	/**
	 * 后台查询支付成功的
	 * 
	 */
	public String paySucces(){
		try {
			if(type.equals("N")){
			Onlinepayment onlinepayment=new Onlinepayment();
			onlinepayment.setStatus(Define.YUER_S);
			PageSupport<Onlinepayment> pageSupport=onPayService.findPageByExampleAndOrder(onlinepayment, "id", "desc", getPageNo(), 10);
			request.put("pageSupport", pageSupport);
			List<Onlinepayment> list=pageSupport.result;
			request.put("list", list);
			
			  String queryStrings="SELECT SUM(money) FROM Onlinepayment WHERE status=?";
			  Object[] values={Define.YUER_S};
			  List  count=onPayService.find(queryStrings, values);
			  if (count.get(0)==null) {
				request.put("count", 0);
			  }else {
				request.put("count", count.get(0));
			  }
			
		}else {
			String	kstimes=kstime+" 00:00:00";
			String	jstimes=jstime+" 24:00:00";
				/*'2015-11-12 00:00:00'*/
				/*'2015-12-31 24:00:00'"
				 */			
			
				String queryStrings="SELECT SUM(money) FROM Onlinepayment WHERE status=? AND time BETWEEN ? AND ?";
				Object[] values={Define.YUER_S,kstimes,jstimes};
				List  count=onPayService.find(queryStrings, values);
				if (count.get(0)==null) {
					request.put("count", 0);
				}else {
					request.put("count", count.get(0));
				}
				request.put("kstime", kstime);
				request.put("jstime", jstime);
				
				String queryString="SELECT * FROM Onlinepayment WHERE status='S' AND time BETWEEN '"+kstimes+"' AND '"+jstimes+"' ORDER BY id DESC";
				PageSupport<Onlinepayment> oPageSupport=onPayService.findPageBySQL(queryString, getPageNo(), 10, false);
				List listOP=oPageSupport.result;
				List<Onlinepayment> list=new ArrayList<Onlinepayment>();
				for (int i = 0; i < listOP.size(); i++) {
					Object[] objects=(Object[]) listOP.get(i);
					Onlinepayment OLPMT=new Onlinepayment();
					OLPMT.setId(Integer.parseInt(String.valueOf(objects[0])));
					OLPMT.setMoney(Double.parseDouble(String.valueOf(objects[1])));
					OLPMT.setTime(String.valueOf(objects[2]));
					OLPMT.setUserid(String.valueOf(objects[3]));
					OLPMT.setOrderNumber(String.valueOf(objects[4]));
					OLPMT.setStatus(String.valueOf(objects[5]));
					OLPMT.setReceiptId(Integer.parseInt(String.valueOf(objects[6])));
					list.add(OLPMT);
				}
				request.put("list", list);
				request.put("pageSupport", oPageSupport);
			}
			request.put("type", type);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
 	return "OK";
	}
	
	
	
		public String downloadFile() {
		     return "OK";
		  }
		
		public  InputStream  getYuYinFile(){
			InputStream inputStream=null;
			try {	
				String a[]	=yuying.split("/");
		  		String url=ServletActionContext.getServletContext().getRealPath(Define.IMAGES_RW)+"/"; 
		  		String urlx=url+a[3];
			 log.debug(urlx);
			 inputStream = new FileInputStream(urlx);
					     	return inputStream;
					 
		} catch (Exception e) {
			log.error("111111111111");
			return  null;
		}
			
	}
		
		
	
		public  InputStream  getDownloadFile(){
			InputStream inputStream=null;
			try {	
			//String content=new String(fileFileName.getBytes("iso8859-1"), "utf-8"); 
			//String a[]	=content.split("/");
		
			String url=ServletActionContext.getServletContext().getRealPath("/images/apk")+"/"; 
			
			String urlx=url+"baituo.apk";
			 
			
			/*ServletActionContext.getResponse().setHeader("Content-Disposition","attachment;fileName=" +java.net.URLEncoder.encode(a[3],"UTF-8"));*/
			 inputStream = new FileInputStream(urlx);
					     	return inputStream;
		} catch (Exception e) {
			log.error("111111111111");
			return  null;
		}
			

	}
		
	
	public String yuying;
	public void setYuying(String yuying) {
		this.yuying = yuying;
	}
	
 	public String getYuying() {
  		if (yuying!=null) {
  			String a[]	=yuying.split("/");
			return a[3];
		}
  		else {
			return yuying;
		}
  		
		
	}
	
	
	
	public String fileFileName="baituo.apk";
	public int fileLength;
	public long getFileLength() {
		String url=ServletActionContext.getServletContext().getRealPath("/images/apk")+"/"; 
		String urlx=url+"baituo.apk";
		File f= new File(urlx);
		
		return f.length();
	}
	
	
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

}