package com.hengshuo.chengszj.action.admin;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.aspectj.apache.bcel.generic.NEW;


import com.baidu.a.a.a.a;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.exception.Myexception;
import com.hengshuo.chengszj.model.Admin;
import com.hengshuo.chengszj.model.Backset;
import com.hengshuo.chengszj.service.admin.AdminService;
import com.hengshuo.chengszj.service.backset.BacksetService;
import com.hengshuo.chengszj.service.user.UserService;





public class AdminAction extends BaseAction implements SessionAware,RequestAware {
	private static Logger log = Logger.getLogger(AdminAction.class
			.getName());
	private String name;

	private String password;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private AdminService adminService;
	private BacksetService backsetService;
	public void setBacksetService(BacksetService backsetService) {
		this.backsetService = backsetService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	public String login(){
	try {
		List<Admin> Userlist = adminService.login(name);
		Admin user=Userlist.get(0);
		String psString=user.getPassword();
		if(psString.equals(password)){
		HttpSession session	=ServletActionContext.getRequest().getSession();
		session.setMaxInactiveInterval(30*60*8);
			session.setAttribute("user", user);
			System.out.println("OK");
			return "ok";
		}
		else{
			request.put("pass", "密码错误");
			return "errorq";
			}
		} catch (Exception e) {
		// TODO Auto-generated catch block
			request.put("error", "账号不存在");
			}
	return "errorq";

}
	public String loginUI(){
		return "OK";
		
	}
	
	//管理员添加UI
	public String addUI(){
		try {
			List<Backset> list=backsetService.findBacksetsByType(Define.BACKSET_TYPE_C);
			request.put("list", list);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "OK";
	}
	/**
	 * 添加管理员
	 * @return
	 */
	public String addAdmin(){
		try {
			Admin admin=new Admin();
			admin.setName(name);
			admin.setPassword(password);
			admin.setNickname(nickname);
			
			if (!type.endsWith("A")) {
				admin.setCity(city);
				if (!area.equals("")) {
					admin.setArea(area);
				}
				
			}
			admin.setType(type);
			admin.setPhone(phone);
			adminService.save(admin);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "OK";
		
	}
	
	//修改管理员界面
	public String updateAdminUI(){
		try {
			List<Backset> list=backsetService.findBacksetsByType(Define.BACKSET_TYPE_C);
			request.put("list", list);
			Admin admin=adminService.get(id);
			request.put("admin", admin);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "OK";
		
	}
	
	//
	public String deleteAdmin(){
		try {
			adminService.deleteByKey(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "OK";
	}
	
	
	//修改管理员界面
	public String updateAdmin(){
		try {
			Admin admin	=adminService.get(id);
			admin.setName(name);
			admin.setPassword(password);
			admin.setNickname(nickname);
			
			if (!type.endsWith("A")) {
				admin.setCity(city);
				if (!area.equals("")) {
					admin.setArea(area);
				}
				if (area.equals("")) {
					admin.setArea(null);
				}
				
			}else {
				admin.setCity(null);
				admin.setArea(null);
			}
			admin.setType(type);
			admin.setPhone(phone);
			adminService.saveOrUpdate(admin);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "OK";
		
	}
	
	
	
	
	
	//用户退出
 	public String exit(){
 		try {
 			ServletActionContext.getRequest().getSession().invalidate();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return "OK";
 	}
	
	
	
	public String findAdmin(){
		try {
			Admin admin=new Admin();
		PageSupport<Admin> pageSupport=adminService.findPageByExampleAndOrder(admin, "id", "asc", getPageNo(), 10);
			request.put("pageSupport",pageSupport);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE);
		}
			return "OK";
	}
	
	
	
	
	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	
	private Integer id;

	private String nickname;

	private String type;
	private String phone;
	private String city;
	private String area;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	
public void setName(String name) {
	this.name = name;
}
	
	
	public void setPassword(String password) {
		this.password = password;
	}

	
}