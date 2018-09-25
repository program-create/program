package com.qfedu.common.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.Key;

/**
 *@Author feri
 *@Date Created in 2018/8/13 15:50
 * 基于Shiro实现加解密
 */
public class ShiroEncryUtil {
private static final String salt="qfedujava";
    //MD5摘要
    public static String md5(String pass){
        SimpleHash simpleHash=new SimpleHash("MD5",pass,salt,128);
        return simpleHash.toString();
    }
    //Bas64  编码
    public static String Tobase64(byte[] data){
        return Base64.encodeToString(data);
    }
    //Base64 解码
    public static String base64To(String data){
        return Base64.decodeToString(data.getBytes());
    }
    //aes 秘钥
    public static Key createKey(){
        AesCipherService aesCipherService=new AesCipherService();
        aesCipherService.setKeySize(256);
        return aesCipherService.generateNewKey();
    }
    //AES 加密
    public static String aesEncode(Key key,String data){
        AesCipherService aesCipherService=new AesCipherService();
       return aesCipherService.encrypt(data.getBytes(),key.getEncoded()).toBase64();
    }
    //AES 解密
    public static String aesDecode(Key key,String data){
        AesCipherService aesCipherService=new AesCipherService();
        return new String(aesCipherService.decrypt(Base64.decode(data),key.getEncoded()).getBytes());
    }

}
