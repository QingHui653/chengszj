package com.hengshuo.chengszj.common.util;



import java.util.HashMap;
import java.util.Map;

/**
 * @author song Email:J2EE123@yeah.net
 * @date 2010-2-8 下午05:08:34
 * @类说明:数据库排序
 */
public class OrderEnum {
	//降序
	public static String DESC = "desc";
	//升序
	public static String ASC = "asc";
	 
	public Map<String,String> getOrder(){
		Map<String,String> result = new HashMap<String,String>();
		 result.put("desc", "降序");
		 result.put("asc", "升序");
		return result;
		
	}
}