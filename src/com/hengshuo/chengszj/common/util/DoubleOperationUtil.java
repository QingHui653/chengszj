package com.hengshuo.chengszj.common.util;

import java.math.BigDecimal;

public class DoubleOperationUtil {
	  /**    
     *   提供精确的加法运算。    
     *   @param   v1   被加数    
     *   @param   v2   加数    
     *   @return   两个参数的和    
     */     
 
   public   static   double   add(double   v1,double   v2){     
           BigDecimal   b1   =   new   BigDecimal(Double.toString(v1));     
           BigDecimal   b2   =   new   BigDecimal(Double.toString(v2));     
           return   b1.add(b2).doubleValue();     
   }  
   
   /**    
    *   提供精确的乘法运算。    
    *   @param   v1   被乘数    
    *   @param   v2   乘数    
    *   @return   两个参数的积    
    */  
   public   static   double   mul(double   v1,double   v2){     
       BigDecimal   b1   =   new   BigDecimal(Double.toString(v1));     
       BigDecimal   b2   =   new   BigDecimal(Double.toString(v2));     
       return   b1.multiply(b2).doubleValue();     
}   
	
	
}
