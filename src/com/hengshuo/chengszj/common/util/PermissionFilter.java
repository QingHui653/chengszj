package com.hengshuo.chengszj.common.util;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class PermissionFilter implements Filter  {
	
	Logger log =Logger.getLogger(PermissionFilter.class.getName());

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
    
	
	public final String AppName="libbench";
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
	
		
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		log.debug("request url="+httpRequest.getRequestURL());
		String url=httpRequest.getRequestURL().toString();
//		response。w
		HttpSession session = httpRequest.getSession();
		 
        //登录后才能进入下一步处理，否则直接进入错误提示页面
		 if (session.getAttribute("username") != null && session.getAttribute("userRole")!=null) {
			 Vector<String> userRightList=(Vector<String>)session.getAttribute("userRole");
			 if(url.contains(AppName)){
				 String[] appNameList=url.split(AppName);
				 if(appNameList[1].contains("?")){
					 String questionSignList[]=appNameList[1].split("?");
					
							 if(userRightList.contains( questionSignList[0])){
								  log.info("身份认证通过，进入下一步处理 ");
								  
						            chain.doFilter(request, response); 
							 } else {
								 
					        	 log.info("身份认证失败，直接返回");
					 
					        	 res.sendRedirect("web/common/info.jsp");
					 
					        }
							 
					 
				 }else{
					 
					 if(userRightList.contains(appNameList[1])){
						  log.info("身份认证通过，进入下一步处理 ");
						  
				            chain.doFilter(request, response); 
					 } else {
						 
			        	 log.info("身份认证失败，直接返回");
			 
			        	 res.sendRedirect("web/common/info.jsp");
			 
			        }
					 
				 }
			 }
			 
        if (session.getAttribute("username") != null && session.getAttribute("userRole")!=null) {
 
            log.info("身份认证通过，进入下一步处理 ");
 
            chain.doFilter(request, response);
 
        } else {
 
        	 log.info("身份认证失败，直接返回");
 
        	 res.sendRedirect("web/common/info.jsp");
 
        }
		 }else{
			 log.info("身份认证失败，直接返回");
			 
        	 res.sendRedirect("web/common/info.jsp");
		 }

        
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	
		
	}
	
	

}
