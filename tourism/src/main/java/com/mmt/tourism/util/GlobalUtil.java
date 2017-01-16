package com.mmt.tourism.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;


public class GlobalUtil {
	

	public static DateFormat datedf=new SimpleDateFormat("yyyy-MM-dd");
	public static DateFormat timedf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String get32bitString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static String getUserID(String username,String password){
		String uuid= md5(username,password).substring(0,23);
		String date=datedf.format(new Date()).replaceAll("-", "");
		return uuid+"_"+date;
	}
	/**
	 * 参数1为原密码，参数2为盐值
	 */
	public static String md5(String password,String solt){
		Md5PasswordEncoder en = new Md5PasswordEncoder();
		return en.encodePassword(password.toLowerCase(), solt.toLowerCase());
		
	}
}
