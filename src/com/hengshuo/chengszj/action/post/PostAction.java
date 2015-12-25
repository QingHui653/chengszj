package com.hengshuo.chengszj.action.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.jgroups.protocols.ring.RingNode;

import com.baidu.platform.comapi.map.p;
import com.hengshuo.chengszj.action.BaseAction;
import com.hengshuo.chengszj.action.buyrelation.BuyrelationAction;
import com.hengshuo.chengszj.common.page.PageSupport;
import com.hengshuo.chengszj.common.util.BaiduMap;
import com.hengshuo.chengszj.common.util.DateTimeUtil;
import com.hengshuo.chengszj.common.util.Define;
import com.hengshuo.chengszj.common.util.MessageHelper;
import com.hengshuo.chengszj.dao.BaseDao_S;
import com.hengshuo.chengszj.dao.impl.BaseDao_I;
import com.hengshuo.chengszj.model.Post;
import com.hengshuo.chengszj.model.Reply;
import com.hengshuo.chengszj.model.Tiezi;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.model.Userfree;
import com.hengshuo.chengszj.service.post.PostService;
import com.hengshuo.chengszj.service.reply.ReplyService;
import com.hengshuo.chengszj.service.user.UserService;

public class PostAction extends BaseAction implements RequestAware {
	private static final Logger log=Logger.getLogger(PostAction.class.getName());

	private PostService postService;
	private ReplyService replyService;
	private UserService userService;
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	private Integer id;
	private Integer postId;
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	private String title;
	private String content;
	private String time;
	private String userid;
	
	
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	 private MessageHelper messageHelper;
	 public MessageHelper getMessageHelper() {
		return messageHelper;
	}
	 public void setMessageHelper(MessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}
	 
	 /**
	  * 进入帖子
	  * @return
	  */
	/* public String tiezidetail(){
		 try {
			 Post post=postService.get(id);	
			
			 String names=userService.findUserByUserid(post.getUserid()).get(0).getName();
			 Tiezi tiezi=new Tiezi();
			 tiezi.setId(post.getId());
			 tiezi.setContent(post.getContent());
			 tiezi.setTime(post.getTime());
			 tiezi.setUserid(post.getUserid());
			 tiezi.setTitle(post.getTitle());
			 tiezi.setName(names);
			 request.put("post", tiezi);
			
			 request.put("userid", userid);
			 	Reply reply=new Reply();
			 	reply.setPostId(id);
		PageSupport<Reply> pageSupport= replyService.findPageByExampleAndOrder(reply, "id", "asc", getPageNo(), 10);
		request.put("pageSupport", pageSupport);
		List<Tiezi> listTiezis=new ArrayList<Tiezi>();
		List<Reply> replies=pageSupport.result;
		for(Reply R:replies){
			 Tiezi t=new Tiezi();
			 String N=userService.findUserByUserid(R.getUserid()).get(0).getName();
			t.setId(R.getId());
			t.setPostId(R.getPostId());
			t.setContent(R.getContent());
			t.setTime(R.getTime());
			t.setUserid(R.getUserid());
			t.setName(N);
			listTiezis.add(t);
		}
		request.put("listTiezis", listTiezis);
			 
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage(Define.F_MESSAGE);
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		 return "OK";
	 }
	 
	 */
	 
	 public String tiezidetail(){
		 try {
			 Post post=postService.get(id);	
			
			User user=userService.findUserByUserid(post.getUserid()).get(0);
			 Postuser postuser=new Postuser();
				postuser.setHeadphoto(user.getHeadphoto());
				postuser.setId(id);
			 	postuser.setName(user.getName());
			 	postuser.setTime(post.getTime());
				postuser.setContent(post.getContent());
				postuser.setImage(post.getImage());
			 	postuser.setZan(post.getZan());
			 	postuser.setNumber(post.getNumber());
			 	
			 	 request.put("P", postuser);
			
			
			 request.put("userid", userid);
			 String sqlString="SELECT p.id,u.userid,u.name,u.headphoto,p.content,p.time FROM USER u,reply p WHERE p.userid=u.userid AND p.PostID='"+id+"' ORDER BY p.id ASC";
			 PageSupport<Postuser> pageSupport=postService.findPageBySQL(sqlString, getPageNo(), 20, false);
				List list=pageSupport.result;
				List<Postuser> list2=new ArrayList<Postuser>();
			for (int i = 0; i < list.size(); i++) {
				Object[] objects=(Object[]) list.get(i);
				Postuser postuser2=new Postuser();
				postuser2.setId(Integer.parseInt(objects[0].toString()));
				postuser2.setUserid(objects[1].toString());
				postuser2.setName(objects[2].toString());
			if (objects[3]!=null) {
				postuser2.setHeadphoto(objects[3].toString());
				}
			postuser2.setContent(objects[4].toString());
			postuser2.setTime(objects[5].toString());
				list2.add(postuser2);
			}
			 
			request.put("list", list2);
			 request.put("pageSupport", pageSupport);
			 
			 /*Reply reply=new Reply();
			 	reply.setPostId(id);
		PageSupport<Reply> pageSupport= replyService.findPageByExampleAndOrder(reply, "id", "asc", getPageNo(), 10);
		request.put("pageSupport", pageSupport);
		List<Tiezi> listTiezis=new ArrayList<Tiezi>();
		List<Reply> replies=pageSupport.result;
		for(Reply R:replies){
			 Tiezi t=new Tiezi();
			 String N=userService.findUserByUserid(R.getUserid()).get(0).getName();
			t.setId(R.getId());
			t.setPostId(R.getPostId());
			t.setContent(R.getContent());
			t.setTime(R.getTime());
			t.setUserid(R.getUserid());
			t.setName(N);
			listTiezis.add(t);
		}
		request.put("listTiezis", listTiezis);*/
			 
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage(Define.F_MESSAGE);
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		 return "OK";
	 }
	 
	 
	 
	 public String XlistPost(){
		 try {
			String sqlString="SELECT p.id,u.userid,u.name,u.integral,u.sex,u.qianmin,u.weizhi,u.headphoto,p.content,p.share,p.image,p.zan,p.number,p.time FROM USER u,post p WHERE p.userid=u.userid ORDER BY p.time DESC"; 
			PageSupport<Postuser> pageSupport=postService.findPageBySQL(sqlString, getPageNo(), 2, false);
				List list=pageSupport.result;
			List<Postuser> list2=new ArrayList<Postuser>();
			log.debug(list.size());
			for (int i = 0; i < list.size(); i++) {
				Object[] objects=(Object[]) list.get(i);
				Postuser postuser=new Postuser();
				postuser.setId(Integer.parseInt(objects[0].toString()));
				postuser.setUserid(objects[1].toString());
				postuser.setName(objects[2].toString());
				postuser.setIntegral(Integer.parseInt(objects[3].toString()));
				postuser.setSex(objects[4].toString());
				if (objects[5]!=null) {
					postuser.setQianmin(objects[5].toString());
				}
			
				postuser.setWeizhi(objects[6].toString());
				if (objects[7]!=null) {
					postuser.setHeadphoto(objects[7].toString());
				}
				postuser.setContent(objects[8].toString());
				postuser.setShare(Integer.parseInt(objects[9].toString()));
				if (objects[10]!=null) {
					postuser.setImage(objects[10].toString());
				}
				postuser.setZan(Integer.parseInt(objects[11].toString()));
				postuser.setNumber(Integer.parseInt(objects[12].toString()));
				postuser.setTime(objects[13].toString());
				list2.add(postuser);
			}
			weizhi="28.22697,112.884706";
			String[] latAndLon=weizhi.split(",");
			 Double x=Double.parseDouble(latAndLon[0]);
			 Double y=Double.parseDouble(latAndLon[1]);
			 List<Postuser> list3=BaiduMap.getListPostusers(x, y, list2);
			 request.put("list", list3);
			 request.put("userid", userid);
			 request.put("pageSupport", pageSupport);
			log.debug(list3.size());
			
		 } catch (Exception e) {
			// TODO: handle exception
		}
		 	return "OK";
	 }
	 
	 
	 
	 
	 
	 /**
	  * 最新帖子列表
	  * @return
	  */
	 public String listPost(){
		 try {
		Post post=new Post();
		PageSupport<Post> pageSupport=postService.findPageByExampleAndOrder(post, "id", "desc", getPageNo(), 5);
		//request.put("pageSupport", pageSupport.result);
		List<Post> posts=pageSupport.result;
		List<Post> list=new ArrayList<Post>();
			for(Post s:posts){
				s.setContent(userService.findUserByUserid(s.getUserid()).get(0).getHeadphoto());
				list.add(s);
			}
			request.put("list", list);
		/*	User user=new User();
			PageSupport<User> pageSupports	=userService.findPageByExampleAndOrder(user, "id", "asc", getPageNo(), 4);
		
			request.put("users", pageSupports.result);*/
			
			request.put("userid", userid);
			
	String sqlString="select u.userid ,f.workPhoto,u.dizhi,u.weizhi,f.realName,u.dengrutime from User u,Freeexpress f where u.userid=f.userid and f.status=2";
	
	List userfrees=userService.findBySQL(sqlString,false);
	ArrayList<Userfree> uList=new ArrayList<Userfree>();
	for (int i = 0; i < userfrees.size(); i++) {
			Userfree userFree=new Userfree();
			Object[] objectArray=(Object[])userfrees.get(i);
			userFree.setUserid(String.valueOf(objectArray[0]));
			userFree.setWorkPhoto(String.valueOf(objectArray[1]));
			userFree.setDizhi(String.valueOf(objectArray[2]));
			userFree.setWeizhi(String.valueOf(objectArray[3]));
			userFree.setRealName(String.valueOf(objectArray[4]));
			userFree.setDengrutime(String.valueOf(objectArray[5]));
			uList.add(userFree);
	}
	
	String dizhiString=userService.findUserByUserid(userid).get(0).getWeizhi();
	 String[] latAndLon=dizhiString.split(",");
	 Double lat2=Double.parseDouble(latAndLon[0]);
	 Double lon2=Double.parseDouble(latAndLon[1]);
	ArrayList<Userfree> userfrees2=BaiduMap.getTopTen(lat2, lon2, uList);
	/*	Date a=	DateTimeUtil.parseDatetime("2015-08-28 18:31:06");
	Date b=	DateTimeUtil.parseDatetime("2015-08-31 17:31:06");
	int times=getIntervalDays(a, b);
	System.err.println(times);
	*/
	String time=DateTimeUtil.currentDatetime();
	ArrayList<Userfree> list3=new ArrayList<Userfree>();
	for(Userfree s:userfrees2){
		s.setDengrutime(DateTimeUtil.getliutime(time, s.getDengrutime()));
		list3.add(s);
	}

	request.put("users", list3);

			
	
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
	  * 发帖界面
	  * @return
	  */
	 public  String fatieUI(){
		 try {
			request.put("userid", userid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return "OK";
	 }
	 
	 
	 /**
	  * 发帖
	  * @return
	  */
	 public String tiezi(){
		 try {
			Post post=new Post();
			post.setUserid(userid);
			post.setTitle(title);
			post.setContent(content);
			post.setZan(0);
			post.setNumber(0);
			post.setShare(0);
			post.setTime(DateTimeUtil.currentDatetime());
			postService.save(post);
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage(Define.F_MESSAGE);
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		 return "OK";
	 }
	 
	 public  String Zan(){
		 try {
		Post post=postService.get(id);
		post.setZan(post.getZan()+1);
		postService.saveOrUpdate(post);
		 setMess("OK");
		} catch (Exception e) {
			 setMess("ERROR");
			log.error(Define.F_MESSAGE+e.getMessage());
		}
		 return "OK";
	 }
	 
	 
	 /**
	  * 回帖
	  * @return
	  */
	 public String huiTie(){
		 try {
		Reply reply=new Reply();
		reply.setPostId(id);
		reply.setTime(DateTimeUtil.currentDatetime());
		reply.setContent(content);
		reply.setUserid(userid);
		replyService.save(reply);
	Post post=postService.get(id);
	post.setNumber(post.getNumber()+1);
	postService.saveOrUpdate(post);
		
		} catch (Exception e) {
			MessageHelper mh = new MessageHelper();
	 		 mh.setResult(Define.F);
	 		 mh.setMessage(Define.F_MESSAGE);
	 		 setMessageHelper(mh);
	 		log.error(Define.F_MESSAGE+e.getMessage());
		}
		 return  "OK";
	 }
	 
	 
	 private Map<String , Object> request;
	@Override
	public void setRequest(Map arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}	
	private String weizhi;
	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	 
	 private String mess;
	 public void setMess(String mess) {
		this.mess = mess;
	}
	 public String getMess() {
		return mess;
	}
	 
}
