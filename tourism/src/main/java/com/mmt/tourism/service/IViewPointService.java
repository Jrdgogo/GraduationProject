package com.mmt.tourism.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mmt.tourism.pojo.JsonModel;
import com.mmt.tourism.pojo.Page;
import com.mmt.tourism.pojo.ViewPoint;
import com.mmt.tourism.pojo.ViewRoute;
import com.mmt.tourism.pojo.ViewSetMenu;;

public interface IViewPointService {
	
	boolean addViewPoint(ViewPoint viewPoint, List<MultipartFile> photos);

	JsonModel<ViewPoint> findViewPoints(Page page);
	
	boolean addViewRoute(ViewRoute viewRoute);
	
	JsonModel<ViewRoute> findViewRoutes(String viewId,Page page);
	
	boolean addViewSetMenu(ViewSetMenu viewSetMenu);
	
	JsonModel<ViewSetMenu> findViewSetMenus(String viewId,Page page);

}
