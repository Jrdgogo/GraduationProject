package com.mmt.tourism.service;

import java.util.List;

import com.mmt.tourism.pojo.dto.JsonPageModel;
import com.mmt.tourism.pojo.dto.Page;
import com.mmt.tourism.pojo.po.Eat;
import com.mmt.tourism.pojo.po.TicketType;
import com.mmt.tourism.pojo.po.ViewDesc;
import com.mmt.tourism.pojo.po.ViewSetMenu;;

public interface IViewPointService {
	
	
	boolean addViewSetMenu(ViewSetMenu viewSetMenu);
	
	JsonPageModel<ViewSetMenu> findViewSetMenus(String viewId,Page page);

	Boolean addTicketType(TicketType type);

	List<TicketType> findAllTicketType();

	ViewSetMenu findViewSetMenusById(String menuid);

	ViewDesc findViewDescById(String id);

	TicketType findTicketTypeById(String id);

	List<Eat> findFoodByViewId(String viewid);

	Eat findFoodById(String id);


}
