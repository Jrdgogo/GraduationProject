package com.mmt.tourism.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmt.tourism.pojo.User;
import com.mmt.tourism.service.UserService;


@Controller
@RequestMapping("/home")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/logout.action")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	@ResponseBody
	@RequestMapping(value = "/getUserName.action")
	public String getUserName(HttpSession session,HttpServletRequest request) {
		User user=(User) session.getAttribute("User");
		return user.getUsername();
	}
	@ResponseBody
	@RequestMapping(value = "/getUserByName.action")
	public Boolean getUserByName(@RequestParam("username")String username) {
		return userService.getUserByName(username);
	}
	@ResponseBody
	@RequestMapping(value = "/activationUser.action")
	public String ActivationUser(@RequestParam("id")String id,@RequestParam("activeCode")String activeCode) {
		if(userService.ActivationUser(id,activeCode))
			return "用户已激活，请进入官网进行登录";
		return "用户激活失败";
	}
	
	@ResponseBody
	@RequestMapping(value = "/registerUser.action")
	public Integer RegisterUser(HttpSession session,@RequestParam("code")String code,@RequestParam("pwd")String pwd,User user) {
		String imgcode=(String) session.getAttribute("imgcode");
		//验证码错误
		if(imgcode==null||!imgcode.equals(code))
			return 2;
		//两次密码不一致
		if(!pwd.equals(user.getPassword()))
			return 3;
		//注册成功
		if(userService.RegisterUser(user))
			return 1;
		return 0;
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST ,path="/loginValidate.action")
	public Byte loginValidate(HttpServletRequest request,HttpServletResponse response,HttpSession session,User user) {
		User u=userService.getUserByName_Pwd(user);
		
		//用戶不存在
		if(u==null)
			return null;
		//用户未激活或已註銷
		if(!(u.getStatus()==1))
			return u.getStatus();
		
		//用戶登錄成功，設立cookie和session
		String userName=u.getUsername();
		String userPwd=u.getPassword();
		
		Cookie cookieName=new Cookie("userName", userName);
		cookieName.setMaxAge(60*60*24);
		cookieName.setPath("/");
		response.addCookie(cookieName);
		
		Cookie cookiePwd=new Cookie("userPwd", userPwd);
		cookiePwd.setMaxAge(60*60*24);
		cookiePwd.setPath("/");
		response.addCookie(cookiePwd);
		
		session.setAttribute("User", user);
		session.setMaxInactiveInterval(60*60);
		return u.getStatus();
	}
}
