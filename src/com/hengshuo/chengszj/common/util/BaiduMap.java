package com.hengshuo.chengszj.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hengshuo.chengszj.action.post.Postuser;
import com.hengshuo.chengszj.model.Helpmebuy;
import com.hengshuo.chengszj.model.Receipt;
import com.hengshuo.chengszj.model.User;
import com.hengshuo.chengszj.model.Userfree;

public class BaiduMap {
	/* *
	 *类名：BaiduMap
	 *lat1 第一个点的 纬度，
	 *lat2第二个点的纬度，
	 *lon1第一个点的经度，
	 *lon2第二个点的经度，
	 *返回 两点之间的距离 单位（KM）
	 */
	public static double getDistatce(double lat1, double lat2, double lon1,    double lon2) { 
        double R = 6371; 
        double distance = 0.0; 
        double dLat = (lat2 - lat1) * Math.PI / 180; 
        double dLon = (lon2 - lon1) * Math.PI / 180; 
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) 
                + Math.cos(lat1 * Math.PI / 180) 
                * Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2) 
                * Math.sin(dLon / 2); 
        distance = (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))) * R; 
        return distance; 
    }
	
	
	
	/* *
	 *方法名 getTopTen
	 *x  纬度，
	 *y  经度，
	 *返回   List离地点<X,Y>最近的十个点
	 */
	
	/* *
	 * 方法名 getTopTenx 纬度，y 经度，返回 List离地点<X,Y>最近的十个点
	 */

	public static ArrayList<Userfree> getTopTen(double x,double y,ArrayList<Userfree>  list){
		 ArrayList<Userfree>  user=null;
		 for(Userfree userfree:list){
			 String[] latAndLon=userfree.getWeizhi().split(",");
			 Double lat2=Double.parseDouble(latAndLon[0]);
			 Double lon2=Double.parseDouble(latAndLon[1]);
			 userfree.setJuli(BaiduMap.getDistatce(x, lat2, y, lon2)+"");
		 }
		 if(list.size()<=10){
			 return list;
		 }
		
		 if(list.size()>10){
			 
			 Collections.sort(list,new Comparator<Userfree>(){

				@Override
				public int compare(Userfree o1, Userfree o2) {
					if(Double.parseDouble(o1.getJuli())<Double.parseDouble(o2.getJuli())){
						return -1;
					}
					if(Double.parseDouble(o1.getJuli())>Double.parseDouble(o2.getJuli())){
						return 1;
					}else{
					// TODO Auto-generated method stub
					return 0;
					}
				}
				
				
				
			 }  );
			;
			 
			 
		 }
		 
		 user= new ArrayList<Userfree>(list.subList(0, 10));
		 return user;
		
		 }
	
	public static int getcount(double x,double y,List<User> list,Double km){
			int z=0;
		 for(User user:list){
			 String[] latAndLon=user.getWeizhi().split(",");
			 Double lat2=Double.parseDouble(latAndLon[0]);
			 Double lon2=Double.parseDouble(latAndLon[1]);
			 Double juli=BaiduMap.getDistatce(x, lat2, y, lon2);
			if (km>juli) {
				z++;
			}
		 }
		 return z;
		 }
	
	
	
	
	
	
	public static List<Helpmebuy> getjuli(List<Helpmebuy>  list){
		
		 for(Helpmebuy userfree:list){
			 String[] ss=userfree.getJingwei().split("\\|");
			 String[] latAndLon=ss[1].split(",");
			 Double lat2=Double.parseDouble(latAndLon[0]);
			 Double lon2=Double.parseDouble(latAndLon[1]);
			 String[] latAndLons=ss[0].split(",");
			 Double latx2=Double.parseDouble(latAndLons[0]);
			 Double lonx2=Double.parseDouble(latAndLons[1]);
			 Double juli=BaiduMap.getDistatce(latx2, lat2, lonx2, lon2);
			 userfree.setJingwei(String.valueOf(juli));
		 }
		 	return list;
		
		 }
	public static List<Receipt> getRejuli(List<Receipt>  list){
		
		 for(Receipt userfree:list){
				String[] ss=userfree.getJingwei().split("\\|");
			 String[] latAndLon=ss[1].split(",");
			 Double lat2=Double.parseDouble(latAndLon[0]);
			 Double lon2=Double.parseDouble(latAndLon[1]);
			 String[] latAndLons=ss[0].split(",");
			 Double latx2=Double.parseDouble(latAndLons[0]);
			 Double lonx2=Double.parseDouble(latAndLons[1]);
			 Double juli=BaiduMap.getDistatce(latx2, lat2, lonx2, lon2);
			 userfree.setJingwei(String.valueOf(juli));
		 }
		 	return list;
		
		 }
	
	
	public static List<Postuser> getListPostusers(double x,double y,List<Postuser>list){
		/*List<Postuser> list2=new ArrayList<Postuser>();*/
		 for(Postuser yuezhan:list){
			 String[] latAndLon=yuezhan.getWeizhi().split(",");
			 Double lat2=Double.parseDouble(latAndLon[0]);
			 Double lon2=Double.parseDouble(latAndLon[1]);
			 
			yuezhan.setWeizhi(BaiduMap.getDistatce(x, lat2, y, lon2)+"");
			/* //距离
			 juLiClass.setJuli();
			 list2.add(juLiClass);*/
		 }
		
		 return list;
		
		 }
	
	
	public static void main(String[] args) {
		ArrayList<Userfree> list = new ArrayList<Userfree>();
		for (int i = 0; i < 30; i++) {
			Userfree u = new Userfree();
			int x = 50 + i;
			int y = 115 + i;
			u.setWeizhi(x + "," + y);
			list.add(u);
		}
		List<Userfree> list2 = BaiduMap.getTopTen(28.220808, 112.90518, list);
		for (Userfree u : list2) {
			System.out.println(u.getJuli());
		}

}}
