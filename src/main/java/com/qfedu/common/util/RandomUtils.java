package com.qfedu.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

//随机数 工具类
public class RandomUtils {
	//随机生成激活码
	public static String createActive(){
		return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
	}
	//获取时间
	public static String getTime(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
	}

}
