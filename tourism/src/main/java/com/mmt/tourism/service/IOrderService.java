package com.mmt.tourism.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mmt.tourism.pojo.dto.IJsonModel;
import com.mmt.tourism.pojo.dto.JsonModelSimpleImp;
import com.mmt.tourism.pojo.dto.Page;
import com.mmt.tourism.pojo.po.User;
import com.mmt.tourism.pojo.po.UserAccount;

public interface IOrderService {

	Integer hasTicket(String setMenuId, Date date);

	Boolean cancelOrder(String orderId);

	Boolean bespeakOrder(UserAccount account, Date date, String orderId);

	Boolean alterOrder(String orderId, Date date);

	Boolean confirmOrder(UserAccount account,String orderId);
	
    Boolean defrayOrBuy(UserAccount account,BigDecimal money);

	BigDecimal orderPrice(String orderId);

	JsonModelSimpleImp addOrder(String userId, String setMenuId, Byte status, List<String> visitors_id, Date date);

	List<Map<String, Object>> orderList(User user, Page page, Byte type);

	Boolean defrayOrBuy(String userid,BigDecimal bigDecimal);

}
