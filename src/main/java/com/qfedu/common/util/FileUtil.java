package com.qfedu.common.util;

import java.util.UUID;

public class FileUtil {
    //文件名命名
    public static String getFileName(String filename){
        if(filename.length()>50){
            filename=filename.substring(filename.length()-50);
        }
        return UUID.randomUUID().toString().replace("-","")+"_"+filename;
    }
}
