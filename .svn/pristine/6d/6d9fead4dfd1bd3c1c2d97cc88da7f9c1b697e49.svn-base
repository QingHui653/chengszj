package com.hengshuo.chengszj.common.util;

public class ExceptionUtil {
	
	public static String getStackMsg(Exception e) {  
		  
        StringBuffer sb = new StringBuffer();  
        StackTraceElement[] stackArray = e.getStackTrace();  
        for (int i = 0; i < stackArray.length; i++) {  
            StackTraceElement element = stackArray[i];  
            sb.append(element.toString() + "\n");  
        }  
        return e.getMessage()+"____"+stackArray[2]+sb.toString();  
    }  
}	
