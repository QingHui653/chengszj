package com.hengshuo.chengszj.common.util;

import org.apache.struts2.ServletActionContext;



import com.alipay.util.zhuanz.UtilDate;
import com.hengshuo.chengszj.common.page.Base64;

public class ImageUpload {

	
		public  static String  imageupload(String file,String image_address,String userid,String houzui){
			 String root = ServletActionContext.getServletContext().getRealPath(image_address);
				//Base64.GenerateImage( file, root + "\\" +userid+ "heart.jpg");
			 Base64.GenerateImage( file, root + "\\" +userid+houzui+".jpg");
			 String 	url=image_address+"/"+userid+houzui+".jpg";
			
			 return url;
			 	//userb.setHeart(url);
			 }
		public static String duoGeImage(String file,String image_address,String userid){
			String root = ServletActionContext.getServletContext().getRealPath(image_address);			
			String url="";
				String[] ss=file.split("\\|");
					//String urlx=userb.getHonorphotos();
				for(int i = 0 ; i < ss.length ; i++ ){
						String time=DateTimeUtil.currentTime(); 
					
					String[]aa=time.split(":");
					String  times="";
					for (int a = 0; a < aa.length; a++) {
						if (a==0) {
							times+=aa[a];
						}else {
							times+=aa[a];
						}	
					}
					
					times+=UtilDate.getThree();
				
				
				Base64.GenerateImage(ss[i], root + "\\" +userid+"_"+times+".jpg");
				if (i==0) {
					url+=image_address+"/"+userid+"_"+times+".jpg";
				}else {
					url+="|"+image_address+"/"+userid+"_"+times+".jpg";	
				}
					
					
			}
				return url;	
		}
	
}

