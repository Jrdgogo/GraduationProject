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
	
	public static String margeCmd(String cmd, String... args) {
		int index = 0, lastindex = 0;
		int i = 0;
		while (true) {
			if (i == args.length) {
				return cmd;
			}
			index = cmd.indexOf("{");
			if(index==-1)
				return cmd;
			lastindex = cmd.indexOf("}");
			cmd = cmd.replace(cmd.substring(index, lastindex + 1), args[i++]);
		}
	}
	
	public static String dateFormat(Date date,String pattern){
		DateFormat dateFormat=new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
	public static String dateFormat(Long date,String pattern){
		return dateFormat(new Date(date),pattern);
	}
	public static String dateFormat(Date date){
		return dateFormat(date,"yyyy-MM-dd HH:mm:ss");
	}
	public static String dateFormat(Long date){
		return dateFormat(new Date(date));
	}
}
