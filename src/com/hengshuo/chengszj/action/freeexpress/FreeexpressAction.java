package com.hengshuo.chengszj.action.freeexpress;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.baidu.lbsapi.auth.i;
import com.baidu.platform.comapi.d.f;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.action.admin.AdminAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.ImageUpload;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.model.Admin;
import com.hengshuo.chengszj.model.Feekback;
import com.hengshuo.chengszj.model.Freeexpress;
import com.hengshuo.chengszj.model.Integral;
import com.hengshuo.chengszj.model.Message;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.service.freeexpress.FreeexpressService;
import com.hengshuo.chengszj.service.integral.IntegralService;
import com.hengshuo.chengszj.service.message.MessageService;
import com.hengshuo.chengszj.service.user.UserService;

public class FreeexpressAction extends BaseAction implements RequestAware,SessionAware {
	private static Logger log = Logger.getLogger(FreeexpressAction.class
			.getName());
	private FreeexpressService freeexpressService;
	public void setFreeexpressService(FreeexpressService freeexpressService) {
		this.freeexpressService = freeexpressService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private IntegralService integralService;
	public void setIntegralService(IntegralService integralService) {
		this.integralService = integralService;
	}
	private MessageService messageService;
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	 private MessageHelper messageHelper;
	 public MessageHelper getMessageHelper() {
		return messageHelper;
	}
	 public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}
	
	/**
	 * 申请自由快递人
	 * @return
	 */
	public String shenQin(){
		try {
			User user=userService.findUserByUserid(userid).get(0);
			
			Double blance=user.getBalance();
			String query="From Freeexpress where userid=?";
			Object[] values={userid,};
		List<Freeexpress> freeexpresses=freeexpressService.find(query, values);
	
		if (freeexpresses.size()>0) {
			Freeexpress freeexpress=freeexpresses.get(0);
			if (workPhoto!=null) {
				String  url=ImageUpload.imageupload(workPhoto, Define.IMAGES_USER, userid, "_workPhoto");
				freeexpress.setWorkPhoto(url);
				}
				freeexpress.setBalance(blance);
				freeexpress.setArea(area);
				freeexpress.setRealName(realName);
				freeexpress.setIdcard(idcard);
				freeexpress.setContact(contact);
				freeexpress.setContactPhone(contactPhone);
				if (positivePhoto!=null) {
					String  url=ImageUpload.imageupload(positivePhoto, Define.IMAGES_USER, userid, "_positivePhoto");
					freeexpress.setPositivePhoto(url);
				}
				if (positiveCard!=null) {
					String  url=ImageUpload.imageupload(positiveCard, Define.IMAGES_USER, userid, "_positiveCard");
					freeexpress.setPositiveCard(url);
				}
				if (conCard!=null) {
					String  url=ImageUpload.imageupload(conCard, Define.IMAGES_USER, userid, "_conCard");
					freeexpress.setConCard(url);
				}
				freeexpress.setInviting(inviting);
				freeexpress.setSingleTime(user.getCity());
			
				freeexpress.setSingleArea(user.getArea());
			
				freeexpress.setEducation(education);
				
				freeexpress.setOccupation(occupation);
				freeexpress.setCompany(company);
				freeexpress.setVehicle(vehicle);
				freeexpress.setStatus(Define.KUAIDIREN_STATUS_1);
				freeexpress.setUserid(userid);
				freeexpress.setTime(DateTimeUtil.currentDatetime());
				freeexpressService.saveOrUpdate(freeexpress);
			
			
				MessageHelper mh=new MessageHelper();
				mh.setResult(Define.S);
				 setMessageHelper(mh);
		}else {
				Freeexpress freeexpress=new Freeexpress();
				if (workPhoto!=null) {
				String  url=ImageUpload.imageupload(workPhoto, Define.IMAGES_USER, userid, "_workPhoto");
				freeexpress.setWorkPhoto(url);
				}
				freeexpress.setBalance(blance);
				freeexpress.setArea(area);
				freeexpress.setRealName(realName);
				freeexpress.setIdcard(idcard);
				freeexpress.setContact(contact);
				freeexpress.setContactPhone(contactPhone);
				if (positivePhoto!=null) {
					String  url=ImageUpload.imageupload(positivePhoto, Define.IMAGES_USER, userid, "_positivePhoto");
					freeexpress.setPositivePhoto(url);
				}
				if (positiveCard!=null) {
					String  url=ImageUpload.imageupload(positiveCard, Define.IMAGES_USER, userid, "_positiveCard");
					freeexpress.setPositiveCard(url);
				}
				if (conCard!=null) {
					String  url=ImageUpload.imageupload(conCard, Define.IMAGES_USER, userid, "_conCard");
					freeexpress.setConCard(url);
				}
				freeexpress.setInviting(inviting);
				freeexpress.setSingleTime(singleTime);
			
				freeexpress.setSingleArea(singleArea);
			
				freeexpress.setEducation(education);
				
				freeexpress.setOccupation(occupation);
				freeexpress.setCompany(company);
				freeexpress.setFlag(flag);
				freeexpress.setVehicle(vehicle);
				freeexpress.setStatus(Define.KUAIDIREN_STATUS_1);
				freeexpress.setUserid(userid);
				freeexpress.setTime(DateTimeUtil.currentDatetime());
				freeexpressService.save(freeexpress);
				
				MessageHelper mh=new MessageHelper();
				mh.setResult(Define.S);
				 setMessageHelper(mh);
		}
		
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("操作失败");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		
		return "OK";
	}
	
	/**
	 * 我的自由快递人判断T代表已经申请了，S代表未申请
	 * @return
	 */
	public String myFreeexpress(){
		try {
			String query="From Freeexpress where userid=?";
			Object[] values={userid,};
		List<Freeexpress> freeexpresses=freeexpressService.find(query, values);
			if (freeexpresses.size()>0) {
				Freeexpress f=freeexpresses.get(0);
				if (f.getStatus().equals(Define.KUAIDIREN_STATUS_3)) {
					MessageHelper mh=new MessageHelper();
					mh.setResult(Define.S);
					setMessageHelper(mh);
				}
				if (f.getStatus().equals(Define.KUAIDIREN_STATUS_2)) {
					MessageHelper mh=new MessageHelper();
					mh.setResult("T");
					mh.setList(freeexpresses);
					setMessageHelper(mh);
				}
				if (f.getStatus().equals(Define.KUAIDIREN_STATUS_1)) {
					MessageHelper mh=new MessageHelper();
					mh.setResult("Z");
					mh.setMessage("正在审核中");
					setMessageHelper(mh);
				}
			
			}else{
				MessageHelper mh=new MessageHelper();
				mh.setResult(Define.S);
				setMessageHelper(mh);
			}
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage("操作失败");
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 自由快递人未审核
	 * @return
	 */
	public String listW(){
		try {
		Admin admin	=(Admin) session.get("user");
			Freeexpress freeexpress=new Freeexpress();
			if (admin.getCity()!=null) {
				freeexpress.setSingleTime(admin.getCity());
			}
			if (admin.getArea()!=null) {
				freeexpress.setSingleArea(admin.getArea());
			}
			freeexpress.setStatus(Define.KUAIDIREN_STATUS_1);
		PageSupport<Freeexpress> pageSupport=freeexpressService.findPageByExampleAndOrder(freeexpress, "id", "desc", getPageNo(), 10);
			request.put("pageSupport", pageSupport);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 自由快递人列表
	 * @return
	 */
	public String listKuaiDiRen(){
		try {

			Admin admin	=(Admin) session.get("user");
			Freeexpress freeexpress=new Freeexpress();
			if (admin.getCity()!=null) {
				freeexpress.setSingleTime(admin.getCity());
			}
			if (admin.getArea()!=null) {
				freeexpress.setSingleArea(admin.getArea());
			}
			
			freeexpress.setStatus(Define.KUAIDIREN_STATUS_2);
		PageSupport<Freeexpress> pageSupport=freeexpressService.findPageByExampleAndOrder(freeexpress, "id", "desc", getPageNo(), 20);
			request.put("pageSupport", pageSupport);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	public String UIdetail(){
		try {
		Freeexpress freeexpress=freeexpressService.get(id);
		request.put("freeexpress", freeexpress);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	
	public String shenHe(){
		try {
			String time=DateTimeUtil.currentDatetime();
		Freeexpress freeexpress=freeexpressService.get(id);
			if (type.equals("S")) {
				freeexpress.setStatus(Define.KUAIDIREN_STATUS_2);
				User user=userService.findUserByUserid(userid).get(0);
				int integr=user.getIntegral();
				user.setIntegral(integr+10);
				user.setStatus("Y");
				userService.saveOrUpdate(user);
			
				
				Message message=new Message();
				message.setContent("恭喜你成为自由快递人");
				message.setUserid(userid);
				message.setTime(time);
				messageService.save(message);
				
				Integral integral=new Integral();
				integral.setContent("申请自由快递人成功");
				integral.setUserid(userid);
				integral.setTime(time);
				integral.setUserid(userid);
				integral.setIntegral(10);
				integralService.save(integral);
				
			
				
			}
			if (type.equals("F")) {
				freeexpress.setStatus(Define.KUAIDIREN_STATUS_3);
				Message message=new Message();
				message.setContent("申请自由快递人审核未通过");
				message.setUserid(userid);
				message.setTime(time);
				messageService.save(message);
			}
			freeexpressService.saveOrUpdate(freeexpress);
		
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return  "OK";
	}

	/**
	 * 修改自由快递人信息
	 * @param id
	 */
	public String updateFree(){
		try {
		Freeexpress freeexpress=freeexpressService.get(id);
		freeexpress.setRealName(realName);
		freeexpress.setIdcard(idcard);
		freeexpress.setContact(contact);
		freeexpress.setContactPhone(contactPhone);
		freeexpress.setArea(area);
		freeexpress.setSingleTime(singleTime);
		freeexpress.setSingleArea(singleArea);
		freeexpress.setCompany(company);
		freeexpress.setVehicle(vehicle);
		freeexpress.setOccupation(occupation);
		freeexpress.setEducation(education);
		freeexpress.setInviting(inviting);
		freeexpress.setStatus(status);
		freeexpressService.saveOrUpdate(freeexpress);
		} catch (Exception e) {
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		return "OK";
	}
	
	/**
	 * 删除自由快递人
	 * @param id
	 */
		public String deleteFree(){
			try {
				freeexpressService.deleteByKey(id);
			} catch (Exception e) {
				log.error("deleteFree"+Define.F_MESSAGE+e.getMessage());
			}
			return "OK";
		}
	
		/**
		 * 批量删除
		 * @param id
		 */
		public String deleteAllFree(){
	 		try {
	 			if(stringid.contains(","))
		 		{
		 		String[] ss=stringid.split(",");
		 		for(String s:ss){
		 			int id=Integer.parseInt(s);
		 			freeexpressService.deleteByKey(id);	
		 			}
		 		}
		 		else{
		 			int id=Integer.parseInt(stringid);
		 			freeexpressService.deleteByKey(id);	
				}
				
			} catch (Exception e) {
				
				log.error(Define.F_MESSAGE+e.getMessage());
			}
	 		
	 		return "OK";
	 	}
	 
		
		
		
		
	private String stringid;
	public void setStringid(String stringid) {
		this.stringid = stringid;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setWorkPhoto(String workPhoto) {
		this.workPhoto = workPhoto;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public void setPositivePhoto(String positivePhoto) {
		this.positivePhoto = positivePhoto;
	}
	public void setPositiveCard(String positiveCard) {
		this.positiveCard = positiveCard;
	}
	public void setConCard(String conCard) {
		this.conCard = conCard;
	}
	public void setInviting(String inviting) {
		this.inviting = inviting;
	}
	public void setSingleTime(String singleTime) {
		this.singleTime = singleTime;
	}
	public void setSingleArea(String singleArea) {
		this.singleArea = singleArea;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	private Integer id;
	private String workPhoto;
	private String area;
	private String realName;
	private String idcard;
	private String contact;
	private String contactPhone;
	private String positivePhoto;
	private String positiveCard;
	private String conCard;
	private String inviting;
	private String singleTime;
	private String singleArea;
	private String education;
	private String occupation;
	private String company;
	private String vehicle;
	private Double balance;
	private String status;
	private String userid;
	private Map<String, Object> request;
	private String types;
	private String flag;
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setTypes(String types) {
		this.types = types;
	}
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