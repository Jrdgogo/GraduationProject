package com.mmt.tourism.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.mmt.tourism.dao.PhotoMapper;
import com.mmt.tourism.dao.ViewMapper;
import com.mmt.tourism.dao.ViewPointMapper;
import com.mmt.tourism.dao.ViewRouteMapper;
import com.mmt.tourism.dao.ViewSetMenuMapper;
import com.mmt.tourism.pojo.JsonModel;
import com.mmt.tourism.pojo.Page;
import com.mmt.tourism.pojo.Photo;
import com.mmt.tourism.pojo.View;
import com.mmt.tourism.pojo.ViewPoint;
import com.mmt.tourism.pojo.ViewPointExample;
import com.mmt.tourism.pojo.ViewRoute;
import com.mmt.tourism.pojo.ViewRouteExample;
import com.mmt.tourism.pojo.ViewSetMenu;
import com.mmt.tourism.pojo.ViewSetMenuExample;
import com.mmt.tourism.service.IViewPointService;
import com.mmt.tourism.util.GlobalUtil;

@Service
public class ViewPointServiceImpl implements IViewPointService{

	private Logger logger = LoggerFactory.getLogger(ViewPointServiceImpl.class);
	@Autowired
	private ViewPointMapper viewPointMapper;
	@Autowired
	private ViewMapper viewMapper; 
	@Autowired
	private ViewRouteMapper viewRouteMapper; 
	@Autowired
	private ViewSetMenuMapper viewSetMenuMapper; 
	@Autowired
	private PhotoMapper photoMapper; 
	
	@Override
	public boolean addViewPoint(ViewPoint viewPoint, List<MultipartFile> photos) {
		View view=viewMapper.selectByPrimaryKey(viewPoint.getViewid());
		viewPoint.setId(GlobalUtil.getModelID(ViewPoint.class));
		viewPoint.setCode(view.getCode()+"_"+GlobalUtil.getCode(viewPoint.getViewpointname()));
		if(viewPointMapper.insertSelective(viewPoint)!=0){
			
			for(MultipartFile photo:photos){
				Photo record=new Photo();
				record.setId(GlobalUtil.getModelID(Photo.class));
				record.setCode(viewPoint.getCode());
				try {
					record.setPhoto(photo.getBytes());
					photoMapper.insertSelective(record);
				} catch (IOException e) {
					logger.error("一张"+viewPoint.getViewpointname()+"景点图片保存失败:"+e.getMessage());
					continue;
				}
			}
			
			return true;
		}
		return false;
	}
	@Override
	public JsonModel<ViewPoint> findViewPoints(Page page) {
		com.github.pagehelper.Page<ViewPoint> pagehelperPage=PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<ViewPoint> viewPoints=viewPointMapper.selectByExampleWithBLOBs(new ViewPointExample());
		page.setPage(pagehelperPage,viewPoints.size());
		JsonModel<ViewPoint> model=new JsonModel<ViewPoint>();
		model.setResult(viewPoints);
		model.setPage(page);
		return model;
	}
	
	@Override
	public boolean addViewRoute(ViewRoute viewRoute) {
		viewRoute.setId(GlobalUtil.getModelID(ViewRoute.class));
		return viewRouteMapper.insertSelective(viewRoute)!=0;
	}
	@Override
	public JsonModel<ViewRoute> findViewRoutes(String viewId, Page page) {
		com.github.pagehelper.Page<ViewRoute> pagehelperPage=PageHelper.startPage(page.getPageNum(), page.getPageSize());
		ViewRouteExample example=new ViewRouteExample();
		example.createCriteria().andViewidEqualTo(viewId);
		List<ViewRoute> viewRoutes=viewRouteMapper.selectByExample(example);
		page.setPage(pagehelperPage,viewRoutes.size());
		JsonModel<ViewRoute> model=new JsonModel<ViewRoute>();
		model.setResult(viewRoutes);
		model.setPage(page);
		return model;
	}
	@Override
	public boolean addViewSetMenu(ViewSetMenu viewSetMenu) {
		viewSetMenu.setId(GlobalUtil.getModelID(ViewSetMenu.class));
		return viewSetMenuMapper.insertSelective(viewSetMenu)!=0;
	}
	@Override
	public JsonModel<ViewSetMenu> findViewSetMenus(String viewId, Page page) {
		com.github.pagehelper.Page<ViewSetMenu> pagehelperPage=PageHelper.startPage(page.getPageNum(), page.getPageSize());
		ViewSetMenuExample example=new ViewSetMenuExample();
		example.createCriteria().andViewidEqualTo(viewId);
		List<ViewSetMenu> viewSetMenus=viewSetMenuMapper.selectByExample(example);
		page.setPage(pagehelperPage,viewSetMenus.size());
		JsonModel<ViewSetMenu> model=new JsonModel<ViewSetMenu>();
		model.setResult(viewSetMenus);
		model.setPage(page);
		return model;
	}

}
