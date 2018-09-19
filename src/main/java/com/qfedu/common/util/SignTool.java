package com.qfedu.common.util;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author Amos
 * 2018-9-19
 */
public class SignTool {

    public static boolean isContinuous(Date lastsignin){
        //得到time日期是在这年的第几天
        String now1 = String.format("%tj",new Date(System.currentTimeMillis()));
        String lastlogin = String.format("%tj",lastsignin);

        int day = Integer.valueOf(now1) - Integer.valueOf(lastlogin);
        if (day==1){
            return true;
        } else {
            return false;
        }
    }





    public static void main(String[] args) {
        try {
            String time = "2018-09-17 20:38:07";
            DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            Date date = fm.parse(time);
            Date date1 = new Date(System.currentTimeMillis());
            String str = String.format("%tj",date);//得到time日期是在这年的第几天
            String str1 = String.format("%tj",date1);
            System.out.println(str1+"-"+str+"=");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
