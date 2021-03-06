package com.mmt.tourism.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.mmt.tourism.pojo.po.User;
import com.mmt.tourism.pojo.po.UserAccount;
import com.mmt.tourism.service.UserService;


@Controller
@RequestMapping("/home")
public class LoginController {
	private static final int SESSION_OUTTIME=60*60*24;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/logout.action")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		
		Cookie cookieName=new Cookie("userName", "");
		cookieName.setMaxAge(0);
		cookieName.setPath("/");
		response.addCookie(cookieName);
		
		Cookie cookiePwd=new Cookie("userPwd", "");
		cookiePwd.setMaxAge(0);
		cookiePwd.setPath("/");
		response.addCookie(cookiePwd);
		
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
	@RequestMapping(value = "/activationUser.action",produces={"text/html;charset=UTF-8"})
	public String ActivationUser(@RequestParam("id")String id,@RequestParam("activeCode")String activeCode) {
		if(userService.ActivationUser(id,activeCode))
			return "用户已激活，请进入官网进行登录";
		return "用户激活失败";
	}
	@ResponseBody
	@RequestMapping(value = "/addAccount.action")
	public Boolean addAccount( @RequestParam("password")String password,
			@RequestParam(required=false,value="pwd")String pwd,HttpSession session) {
		UserAccount account=new UserAccount();
		account.setPassword(password);
		User user=(User) session.getAttribute("User");
		account.setUserid(user.getId());
		if(pwd==null)
			return userService.addAccount(account);
		
		return userService.changeAccount(account,pwd);
	}
	
	@ResponseBody
	@RequestMapping(value = "/owner.action")
	public Map<String, Object> owner(HttpSession session) {
		Map<String, Object> map=new HashMap<>();
		User user=(User) session.getAttribute("User");
		map.put("owner", user);
		
		UserAccount account=userService.getAccounts(user.getId()).get(0);
		map.put("account", account);
		
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/getAccountMoney.action")
	public Double getAccountMoney(HttpSession session) {
		User user=(User) session.getAttribute("User");
		
		UserAccount account=userService.getAccounts(user.getId()).get(0);
		
		return account.getMoney().doubleValue();
	}
	
	@ResponseBody
	@RequestMapping(value = "/registerUser.action")
	public Integer RegisterUser(HttpSession session,@RequestParam("code")String code,@RequestParam("pwd")String pwd,User user) {
		String imgcode=(String) session.getAttribute("imgcode");
		session.removeAttribute("imgcode");
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
	@RequestMapping(value="/loginValidate.action")
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
		cookieName.setMaxAge(SESSION_OUTTIME);
		cookieName.setPath("/");
		response.addCookie(cookieName);
		
		Cookie cookiePwd=new Cookie("userPwd", userPwd);
		cookiePwd.setMaxAge(SESSION_OUTTIME);
		cookiePwd.setPath("/");
		response.addCookie(cookiePwd);
		
		session.setAttribute("User", u);
		session.setMaxInactiveInterval(SESSION_OUTTIME);
		return u.getStatus();
	}
}
