package com.mmt.tourism.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.mmt.tourism.dao.OrderDetailMapper;
import com.mmt.tourism.dao.OrderMapper;
import com.mmt.tourism.dao.TicketMapper;
import com.mmt.tourism.dao.UserAccountMapper;
import com.mmt.tourism.dao.ViewSetMenuMapper;
import com.mmt.tourism.dao.VisitorsMapper;
import com.mmt.tourism.pojo.dto.JsonModelSimpleImp;
import com.mmt.tourism.pojo.po.Order;
import com.mmt.tourism.pojo.po.OrderDetail;
import com.mmt.tourism.pojo.po.OrderDetailExample;
import com.mmt.tourism.pojo.po.OrderExample;
import com.mmt.tourism.pojo.po.Ticket;
import com.mmt.tourism.pojo.po.TicketExample;
import com.mmt.tourism.pojo.po.User;
import com.mmt.tourism.pojo.po.UserAccount;
import com.mmt.tourism.pojo.po.UserAccountExample;
import com.mmt.tourism.pojo.po.View;
import com.mmt.tourism.pojo.po.ViewSetMenu;
import com.mmt.tourism.pojo.po.Visitors;
import com.mmt.tourism.service.IOrderService;
import com.mmt.tourism.util.GlobalUtil;

@Service
public class OrderServiceImpl implements IOrderService {

	private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	@Autowired
	private VisitorsMapper visitorsMapper;
	@Autowired
	private TicketMapper ticketMapper;
	@Autowired
	private ViewSetMenuMapper viewSetMenuMapper;
	@Autowired
	private UserAccountMapper userAccountMapper;

	/**
	 * 判断该旅行有没余票
	 */
	@Override
	public Integer hasTicket(String setMenuId, Date date) {
		TicketExample example = new TicketExample(GlobalUtil.ticketFormat(date));
		example.createCriteria().andSetmenuidEqualTo(setMenuId).andStatusEqualTo(false);
		return ticketMapper.countByExample(example);
	}

	private static final String errorOrderMsgOfNum = "尊敬的旅客，抱歉！该旅线 余票不足！请更改人数或日期;参观其余景区线路";
	private static final String errorOrderMsgOfSQL = "下单失败！请重新提交订单";

	/**
	 * 添加订单（未支付状态）
	 */
	@Override
	@Transactional
	public JsonModelSimpleImp addOrder(String userId, String setMenuId, Byte status, List<String> visitors_id,
			Date date) {
		List<Ticket> tickets = ticketStatusSell(setMenuId, visitors_id.size(), date);

		Order record = new Order();
		record.setId(GlobalUtil.getModelID(Order.class));
		record.setSetmenuid(setMenuId);
		record.setUserid(userId);
		record.setStatus(status);
		record.setOutdate(date);
		JsonModelSimpleImp model = new JsonModelSimpleImp();
		
		model.put("orderId", record.getId());
		ViewSetMenu menu = viewSetMenuMapper.selectByPrimaryKey(setMenuId);
		model.put("menuName", menu.getMenuname());
		
		record.setPrice(menu.getOrderprice().multiply(menu.getRebate()).multiply(new BigDecimal(visitors_id.size())));
		double money =record.getPrice().doubleValue();
		
		model.put("outlay", money);
		
		if (orderMapper.insertSelective(record) <= 0)
			new RuntimeException(errorOrderMsgOfSQL);

		for (int i = 0; i < visitors_id.size(); i++) {
			OrderDetail detail = new OrderDetail();
			detail.setId(GlobalUtil.getModelID(OrderDetail.class));
			detail.setOrderid(record.getId());
			String visitorId = visitors_id.get(i);
			detail.setVisitorid(visitorId);
			String ticketId = tickets.get(i).getId();
			detail.setTicketid(ticketId);
			if (orderDetailMapper.insertSelective(detail) <= 0)
				new RuntimeException(errorOrderMsgOfSQL);
		}
		return model;
	}

	/**
	 * 获取票数
	 */
	private List<Ticket> ticketStatusSell(String setMenuId, int size, Date date) {
		TicketExample example = new TicketExample(GlobalUtil.ticketFormat(date));
		example.createCriteria().andSetmenuidEqualTo(setMenuId).andStatusEqualTo(false);
		com.github.pagehelper.Page<View> pagehelperPage = PageHelper.startPage(1, size);
		List<Ticket> tickets = ticketMapper.selectByExample(example);
		if (tickets.size() < size) {
			new RuntimeException(errorOrderMsgOfNum);
		}
		for (Ticket ticket : tickets) {
			ticket.setStatus(true);
			if (ticketMapper.updateByPrimaryKeySelective(ticket) <= 0)
				new RuntimeException(errorOrderMsgOfNum);
		}
		return tickets;
	}

	/**
	 * 取消订单
	 */
	@Override
	@Transactional
	public Boolean cancelOrder(String orderId) {
		Order order = orderMapper.selectByPrimaryKey(orderId);
		if (order == null)
			throw new RuntimeException("订单不存在");
		if (order.getStatus().equals((byte) 4))
			throw new RuntimeException("订单已经取消");

		ticketStatusReset(orderId);

		if (order.getStatus().equals((byte) 0) || order.getStatus().equals((byte) 3)
				|| backOrderMoney(order.getUserid(), order.getId())) {
			order.setStatus((byte) 4);
			return orderMapper.updateByPrimaryKeySelective(order) > 0;
		}
		return false;
	}

	/**
	 * 旅票回归 未出售状态
	 */
	private void ticketStatusReset(String orderId) {
		OrderDetailExample example = new OrderDetailExample();
		example.createCriteria().andOrderidEqualTo(orderId);
		List<OrderDetail> details = orderDetailMapper.selectByExample(example);
		for (OrderDetail detail : details) {

			Ticket ticket = ticketMapper.selectByPrimaryKey(detail.getTicketid());
			ticket.setStatus(false);
			if (ticketMapper.updateByPrimaryKeySelective(ticket) <= 0)
				throw new RuntimeException("取消失败！,请重试！！！");
		}
	}

	/**
	 * 返还支付金额
	 */
	private boolean backOrderMoney(String userId, String orderid) {
		Order order=orderMapper.selectByPrimaryKey(orderid);
		BigDecimal price = order.getPrice();

		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUseridEqualTo(userId);
		List<UserAccount> accounts = userAccountMapper.selectByExample(example);
		for (UserAccount account : accounts) {
			if (!account.getStatus())
				continue;

			account.setMoney(account.getMoney().add(price));
			return userAccountMapper.updateByPrimaryKeySelective(account) > 0;
		}

		return false;
	}

	/**
	 * 订单预定
	 */
	@Override
	@Transactional
	public Boolean bespeakOrder(UserAccount account,Date date, String orderId) {
		Order record = orderMapper.selectByPrimaryKey(orderId);
		if (record == null)
			throw new RuntimeException("订单不存在！！");
		if (!record.getStatus().equals((byte) 0))
			throw new RuntimeException("该订单不允许预定！！！");
		if (date.after(new Date(record.getOutdate().getTime()-1000*60*60*24)))
			throw new RuntimeException("预定时间请在出行时间24小时之前！！！");
		BigDecimal money=record.getPrice();
		if(money.doubleValue()>0)
			money=money.multiply(new BigDecimal(-1));
		if (!defrayOrBuy(account, money.multiply(new BigDecimal(0.1))))
			throw new RuntimeException("支付失败");
		record.setStatus((byte) 3);
		record.setChangeStatus(false);
		record.setBespeakdate(date);
		return orderMapper.updateByPrimaryKeySelective(record) > 0;
	}

	/**
	 * 改签订单
	 */
	@Override
	@Transactional
	public Boolean alterOrder(String orderId, Date date) {

		Order record = orderMapper.selectByPrimaryKey(orderId);

		if (!(record.getChangeStatus()))
			throw new RuntimeException("改签票不支持再度改签！！！");
		if (!(record.getStatus().equals((byte) 1)))
			throw new RuntimeException("该票种未支付！！！");

		orderDetailStatusReHandle(orderId, record.getSetmenuid(), date);

		record.setStatus((byte) 2);
		record.setChangeStatus(false);

		return orderMapper.updateByPrimaryKeySelective(record) > 0;
	}

	/**
	 * 改签订单明细更变
	 */
	private void orderDetailStatusReHandle(String orderId, String setmenuid, Date date) {

		OrderDetailExample example = new OrderDetailExample();
		example.createCriteria().andOrderidEqualTo(orderId);
		List<OrderDetail> details = orderDetailMapper.selectByExample(example);
		List<Ticket> tickets = ticketStatusSell(setmenuid, details.size(), date);
		for (int i = 0; i < details.size(); i++) {
			OrderDetail detail = details.get(i);

			Ticket ticket = ticketMapper.selectByPrimaryKey(detail.getTicketid());
			ticket.setStatus(false);
			if (ticketMapper.updateByPrimaryKeySelective(ticket) <= 0)
				throw new RuntimeException("改签失败！,请重试！！！");

			detail.setTicketid(tickets.get(i).getId());
			if (orderDetailMapper.updateByPrimaryKeySelective(detail) <= 0)
				throw new RuntimeException("改签失败！,请重试！！！");
		}
	}

	/**
	 * 确认订单（已支付）
	 */
	@Override
	@Transactional
	public Boolean confirmOrder(UserAccount account, String orderId) {

		Order order = orderMapper.selectByPrimaryKey(orderId);
		BigDecimal money=order.getPrice();
		
		if(money.doubleValue()>0)
			money=money.multiply(new BigDecimal(-1));
		
		if (!defrayOrBuy(account, money))
			throw new RuntimeException("支付失败");
		order.setStatus((byte) 1);
		return orderMapper.updateByPrimaryKeySelective(order) > 0;
	}

	/**
	 * 订单价格
	 */
	@Override
	public BigDecimal orderPrice(String orderId) {
		OrderDetailExample example = new OrderDetailExample();
		example.createCriteria().andOrderidEqualTo(orderId);
		Integer properNum = orderDetailMapper.countByExample(example);

		Order order = orderMapper.selectByPrimaryKey(orderId);
		String setMenuId = order.getSetmenuid();

		BigDecimal price = viewSetMenuMapper.selectByPrimaryKey(setMenuId).getOrderprice();
		return price.multiply(new BigDecimal(properNum));
	}

	/**
	 * 支付金额
	 */
	@Override
	public Boolean defrayOrBuy(UserAccount account, BigDecimal money) {
		String userAccountId = account.getId();
		String password = account.getPassword();
		password = GlobalUtil.md5(password, userAccountId);
		account = userAccountMapper.selectByPrimaryKey(userAccountId);
		if (!account.getPassword().equals(password))
			throw new RuntimeException("支付密码错误！");
		account.setMoney(account.getMoney().add(money));
		if(account.getMoney().doubleValue()<0)
			throw new RuntimeException("支付余额不足！");
		return userAccountMapper.updateByPrimaryKeySelective(account) > 0;
	}

	@Override
	public List<Map<String, Object>> orderList(User user) {
		OrderExample example=new OrderExample();
		example.createCriteria().andUseridEqualTo(user.getId());
		List<Order> orders=orderMapper.selectByExample(example);
		List<Map<String, Object>> model=new ArrayList<>();
		
		for(Order order:orders){
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("order", order);
			ViewSetMenu menu=viewSetMenuMapper.selectByPrimaryKey(order.getSetmenuid());
			map.put("menu", menu);
			
			Byte status=order.getStatus();
			Boolean changestatus=order.getChangeStatus();
			List<String> op=new ArrayList<>();
			if(status==1){
				if(changestatus)
					op.add("改签");
				op.add("取消");
			}else if(status==2){
				op.add("取消");
			}else if(status==3){
				op.add("支付");
				op.add("取消");
			}else if(status==0){
				op.add("支付");
				op.add("预约");
				op.add("取消");
			}
			map.put("option", op);
		    OrderDetailExample detailExample=new OrderDetailExample();
		    detailExample.createCriteria().andOrderidEqualTo(order.getId());
		    List<Map<String, Object>> list=new ArrayList<>();
		    List<OrderDetail> details=orderDetailMapper.selectByExample(detailExample);
		    for(OrderDetail detail:details){
		    	Map<String, Object> detailmap=new HashMap<String, Object>();
		    	detailmap.put("orderDetail",detail);
		    	Visitors visitor= visitorsMapper.selectByPrimaryKey(detail.getVisitorid());
		    	detailmap.put("visitor",visitor);
		    	Ticket ticket=ticketMapper.selectByPrimaryKey(detail.getTicketid());
		    	
		    	detailmap.put("ticket",ticket);
		    	list.add(detailmap);
		    }
		    map.put("details", list);
		    model.add(map);
		}
		return model;
	}

}
