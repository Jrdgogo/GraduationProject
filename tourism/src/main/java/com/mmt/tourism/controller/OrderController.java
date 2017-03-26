package com.mmt.tourism.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmt.tourism.pojo.dto.IJsonModel;
import com.mmt.tourism.pojo.dto.JsonModelSimpleImp;
import com.mmt.tourism.pojo.dto.Page;
import com.mmt.tourism.pojo.po.User;
import com.mmt.tourism.pojo.po.UserAccount;
import com.mmt.tourism.pojo.po.Visitors;
import com.mmt.tourism.service.IOrderService;
import com.mmt.tourism.service.UserService;
import com.mmt.tourism.util.GlobalUtil;

@RestController
@RequestMapping("/order")
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private IOrderService orderService;
	@Autowired
	private UserService userService;


	@RequestMapping(method = { RequestMethod.POST }, value = "/hasTicket.action")
	public Integer hasTicket(@RequestParam(value = "setMenuId") String setMenuId,
			@RequestParam(value = "date") Date date) {
		return orderService.hasTicket(setMenuId, date);
	}

	@RequestMapping(method = { RequestMethod.POST }, value = "/confirmOrder.action")
	public Boolean confirmOrder(@RequestParam(value = "orderId") String orderId,
			@RequestParam(value = "password") String password,HttpSession session) {
		UserAccount account=getAccount(session, password);
		account.setPassword(password);
		return orderService.confirmOrder(account,orderId);
	}

	@RequestMapping(method = { RequestMethod.POST }, value = "/alterOrder.action")
	public Boolean alterOrder(@RequestParam(value = "orderId") String orderId,
			@RequestParam(value = "date") Date date) {
		return orderService.alterOrder(orderId, date);
	}

	@RequestMapping(method = { RequestMethod.POST }, value = "/bespeakOrder.action")
	public Boolean bespeakOrder(@RequestParam(value = "orderId") String orderId,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "date") Integer days,HttpSession session) {
		UserAccount account=getAccount(session, password);
		account.setPassword(password);
		return orderService.bespeakOrder(account,new Date(new Date().getTime()+1000*60*60*24*days),orderId);
	}

	@RequestMapping(method = { RequestMethod.POST }, value = "/cancelOrder.action")
	public Boolean cancelOrder(@RequestParam(value = "orderId") String orderId) {
		return orderService.cancelOrder(orderId);
	}
	
	@RequestMapping(method = { RequestMethod.POST }, value = "/orderPrice.action")
	public BigDecimal orderPrice(@RequestParam(value = "orderId") String orderId) {
		return orderService.orderPrice(orderId);
	}
	
	@RequestMapping( value = "/shop.action")
	public void shop(@RequestParam(value = "setMenuId") String setMenuId,HttpSession session) {
		session.setAttribute("setMenuId", setMenuId);
	}
	@RequestMapping(method = { RequestMethod.POST }, value = "/addOrder.action")
	public IJsonModel addOrder(HttpSession session,com.mmt.tourism.pojo.vo.Visitors visitorlist ,
			             @RequestParam(value = "date") Date date) {
		
		String setMenuId=(String) session.getAttribute("setMenuId");
		//session.removeAttribute("setMenuId");
		if(setMenuId==null)
			throw new RuntimeException("请先选择旅游项目！！！");
		User user = (User) session.getAttribute("User");
		List<Visitors> visitors=visitorlist.getVisitors();
		if(visitors.isEmpty())
			throw new RuntimeException("请先确定出行人！！！");
		for(Visitors visitor:visitors)
			visitor.setUserid(user.getId());
		
		List<String> visitors_id=userService.addVisitors(visitors);
	
		JsonModelSimpleImp imp=orderService.addOrder(user.getId(), setMenuId, new Byte((byte)0), visitors_id, date);
		return imp;
	}
	@RequestMapping(method = { RequestMethod.POST }, value = "/defrayOrBuy.action")
	public Boolean defrayOrBuy(HttpSession session,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "orderMoney") String money) {
		UserAccount account=getAccount(session, password);
		account.setPassword(password);
		return orderService.defrayOrBuy(account, new BigDecimal(money));
	}
	@RequestMapping(method = { RequestMethod.POST }, value = "/orderList.action")
	public List<Map<String, Object>> orderList(HttpSession session,Page page,
			@RequestParam(value = "type",required=false,defaultValue="1") Byte type) {
		User user=(User) session.getAttribute("User");
		return orderService.orderList(user,page,type);
	}

	private UserAccount getAccount(HttpSession session, String password) {
		User user=(User) session.getAttribute("User");
		List<UserAccount> accounts=userService.getAccounts(user.getId());
	
		for(UserAccount account:accounts){
			String pwd=GlobalUtil.md5(password, account.getId());
			if(account.getStatus()&&pwd.equals(account.getPassword()))
				return account;
		}
		throw new RuntimeException("无可用账户！！！");
	}
	
}
