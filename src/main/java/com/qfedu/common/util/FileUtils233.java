/**  
* @Title: FileUtils233.java
* @Package com.qfedu.common.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Feri 
* @date 2018年5月29日  
* @version V1.0  
*/  
package com.qfedu.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**  
* @Title: FileUtils233.java
* @Package com.qfedu.common.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Feri  
* @date 2018年5月29日  
* @version V1.0  
* 文件工具类
*/
public class FileUtils233 {
	
	//创建文件夹 一个月一个文件夹
	public static File createDir(String dir) {
		//子文件名称：201805 201806
		String month=new SimpleDateFormat("yyyyMM").format(new Date());
		File dir1=new File(new File(dir).getParent(),"888");
		File dir2=new File(dir1,month) ;
		if(!dir2.exists()) {
			dir2.mkdirs();
		}
		return dir2;
	}
	//创建唯一名称 
	public static String createFileName(String fn) {
		if(fn.length()>30) {
			fn=fn.substring(fn.length()-30);
		}
		return UUID.randomUUID().toString()+"_"+fn;
	}
	public static File createDir(String root,String dir) {
		//子文件名称：201805 201806【按月份创建】
		String month=new SimpleDateFormat("yyyyMM").format(new Date());
		//【new File(root).getParent()】获取根目录
		//【month】时间动态文件夹---月份文件夹
		//【File.separator】分隔符
		//【dir】保存图片的子文件夹
		File dir1 = new File(new File(root).getParent(), month + File.separator + dir);
		//【exists()】是否存在	存在：true	不存在：false !:取反
		if(!dir1.exists()) {
			//【mkdirs()】建立一个新的子目录
			dir1.mkdirs();
		}
		return dir1;
	}

}
