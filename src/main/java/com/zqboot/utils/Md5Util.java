package com.zqboot.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Util {

	/**
	 * 生成32位md5
	 * @param str
	 * @return
	 */
	public static String makeMD5(String str) {
		MessageDigest md;
		   try {   
		    // 生成一个MD5加密计算摘要   
		    md = MessageDigest.getInstance("MD5");
		    // 计算md5函数   
		    md.update(str.getBytes());   
		    // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符   
		    // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值   
		    String md5str = new BigInteger(1, md.digest()).toString(16);
		    return md5str;   
		   } catch (Exception e) {
		    e.printStackTrace();   
		   }   
		   return str;   
		}

	public static void main(String[] args) {
		String r = makeMD5("123456");
		System.out.println(r);
		System.out.println("e10adc3949ba59abbe56e057f20f883e".length());
	}
	
}
