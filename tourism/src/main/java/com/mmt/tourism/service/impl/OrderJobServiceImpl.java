package com.mmt.tourism.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.tourism.dao.OrderMapper;
import com.mmt.tourism.pojo.po.Order;
import com.mmt.tourism.pojo.po.OrderExample;
import com.mmt.tourism.service.IOrderJobService;
import com.mmt.tourism.service.IOrderService;
import com.mmt.tourism.util.GlobalUtil;
@Service(value="orderJob")
public class OrderJobServiceImpl implements IOrderJobService {

	@Autowired
	private IOrderService orderService;
	@Autowired
	private OrderMapper orderMapper;
	@Override
	public boolean cancelOrder() {
		Date cancelDate=new Date(new Date().getTime()-1000*60*30);
		OrderExample example=new OrderExample();
		example.createCriteria().andStatusEqualTo((byte)0).andCreatedateLessThanOrEqualTo(cancelDate);
		List<Order> orders=orderMapper.selectByExample(example);
		for(Order order:orders){
			if(!orderService.cancelOrder(order.getId()))
				return false;
		}
		return true;
	}
	@Override
	public boolean cancalBackOrder(){
		
		Date cancelDate=GlobalUtil.parse(GlobalUtil.dateFormat(new Date()), 0);
		OrderExample example=new OrderExample();
		example.createCriteria().andStatusEqualTo((byte)3).andCreatedateLessThan(cancelDate);
		List<Order> orders=orderMapper.selectByExample(example);
		for(Order order:orders){
			if(!orderService.cancelOrder(order.getId()))
				return false;
		}
		return true;
	}

}
