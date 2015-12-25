package com.hengshuo.chengszj.common.page;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class Base64 {
	
	 public static boolean GenerateFile(String imgStr, String savedImagePath) {  
	        // 文件字节数组字符串数据为空  
	        if (imgStr == null)   
	            return false;  
	        BASE64Decoder decoder = new BASE64Decoder();  
	        try {  
	            // Base64解码  
	            byte[] b = decoder.decodeBuffer(imgStr);  
	            for (int i = 0; i < b.length; ++i) {  
	                {// 调整异常数据  
	                if (b[i] < 0)   
	                    b[i] += 256;  
	                }  
	            }  
	            // 生成文件  
	            // String sangImageStr = "D:/My Documents/ip.jpg" ;  // 要生成文件的路径.  
	            OutputStream out = new FileOutputStream(savedImagePath);  
	            out.write(b);  
	            out.flush();  
	            out.close();  
	            return true;  
	        } catch (Exception e) {  
	            return false;  
	        }  
	    } 
	
	
	
		//user图片保存地址

	public static String encodeImgageToBase64(File imageFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		
		ByteArrayOutputStream outputStream = null;
		
		try {
		
		BufferedImage bufferedImage = ImageIO.read(imageFile);
		
		outputStream = new ByteArrayOutputStream();
		
		ImageIO.write(bufferedImage, "jpg", outputStream);
	
		} catch (MalformedURLException e1) {
		
		e1.printStackTrace();
	
		} catch (IOException e) {
	
		e.printStackTrace();
	
		}
	
		// 对字节数组Base64编码

		BASE64Encoder encoder = new BASE64Encoder();
	
		return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
	
		}
	
	
	
	
	
	
	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片  
		
		if (imgStr == null)
		 // 图像数据为空  	
		return false; 
		
		BASE64Decoder decoder = new BASE64Decoder();  
		OutputStream out =null;
		try {  
		// Base64解码  
		byte[] bytes = decoder.decodeBuffer(imgStr);  
		for (int i = 0; i < bytes.length; ++i) {  
		if (bytes[i] < 0) {// 调整异常数据  
		bytes[i] += 256;  
			}  
		}  
		// 生成jpeg图片  
		out= new FileOutputStream(imgFilePath);  
		out.write(bytes);  
		out.flush();
		return true;  
		} catch (Exception e) {  
		return false;  
		}  
		finally{
			
			try {
				if(out!=null)
				{
				
				out.close(); 
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		}
		} 
	
}
