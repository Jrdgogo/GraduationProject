package com.mmt.tourism.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.mmt.tourism.pojo.Ticket;


public class GlobalUtil {
	

	public static final DateFormat datedf=new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat timedf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String get32bitString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public static String getModelID(Class<?> model){
		return md5(get32bitString(),model.getName());
	}
	public static String getTicketID(Date date){
		String uuid= getModelID(Ticket.class).substring(0,22);
		String dateString=datedf.format(date).replaceAll("-", "_");
		return uuid+dateString;
	}
	public static String getTicketID(long date) {
		return getTicketID(new Date(date));
	}
	public static String getTicketDate(String ticketId) {
		return ticketId.substring(22, 32);
	}
	public static String getUserID(String username,String password){
		return md5(username,password);
	}
	/**
	 * 参数1为原密码，参数2为盐值
	 */
	private static final Md5PasswordEncoder en = new Md5PasswordEncoder();
	public static String md5(String password,String solt){
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
	public static String timeFormat(Date date){
		return timedf.format(date);
	}
	public static String dateFormat(Date date){
		return datedf.format(date);
	}
	public static String timeFormat(Long date){
		return timeFormat(new Date(date));
	}
	public static String dateFormat(Long date){
		return dateFormat(new Date(date));
	}
	
}
