package com.mmt.tourism.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.mmt.tourism.dao.EatMapper;
import com.mmt.tourism.dao.TicketTypeMapper;
import com.mmt.tourism.dao.ViewDescMapper;
import com.mmt.tourism.dao.ViewSetMenuMapper;
import com.mmt.tourism.pojo.dto.JsonPageModel;
import com.mmt.tourism.pojo.dto.Page;
import com.mmt.tourism.pojo.po.Eat;
import com.mmt.tourism.pojo.po.EatExample;
import com.mmt.tourism.pojo.po.EateryExample;
import com.mmt.tourism.pojo.po.TicketType;
import com.mmt.tourism.pojo.po.TicketTypeExample;
import com.mmt.tourism.pojo.po.ViewDesc;
import com.mmt.tourism.pojo.po.ViewDescExample;
import com.mmt.tourism.pojo.po.ViewSetMenu;
import com.mmt.tourism.pojo.po.ViewSetMenuExample;
import com.mmt.tourism.service.IViewPointService;
import com.mmt.tourism.util.GlobalUtil;

@Service
public class ViewPointServiceImpl implements IViewPointService{

	private Logger logger = LoggerFactory.getLogger(ViewPointServiceImpl.class);
 
	@Autowired
	private ViewSetMenuMapper viewSetMenuMapper; 
	@Autowired
	private TicketTypeMapper ticketTypeMapper; 
	@Autowired
	private ViewDescMapper viewDescMapper; 
	@Autowired
	private EatMapper eatMapper; 
	
	@Override
	@Transactional
	public boolean addViewSetMenu(ViewSetMenu viewSetMenu) {
		viewSetMenu.setId(GlobalUtil.getModelID(ViewSetMenu.class));
		
		return viewSetMenuMapper.insertSelective(viewSetMenu)!=0;
	}
	@Override
	public JsonPageModel<ViewSetMenu> findViewSetMenus(String viewId, Page page) {
		com.github.pagehelper.Page<ViewSetMenu> pagehelperPage=PageHelper.startPage(page.getPageNum(), page.getPageSize());
		ViewSetMenuExample example=new ViewSetMenuExample();
		example.createCriteria().andViewidEqualTo(viewId);
		List<ViewSetMenu> viewSetMenus=viewSetMenuMapper.selectByExampleWithBLOBs(example);
		page.setPage(pagehelperPage,viewSetMenus.size());
		JsonPageModel<ViewSetMenu> model=new JsonPageModel<ViewSetMenu>();
		model.setResult(viewSetMenus);
		model.setPage(page);
		return model;
	}
	@Override
	@Transactional
	public Boolean addTicketType(TicketType type) {
		type.setId(GlobalUtil.getModelID(TicketType.class));
		return ticketTypeMapper.insertSelective(type)>0;
	}
	@Override
	public List<TicketType> findAllTicketType() {
		return ticketTypeMapper.selectByExample(new TicketTypeExample());
	}
	@Override
	public ViewSetMenu findViewSetMenusById(String menuid) {
		return viewSetMenuMapper.selectByPrimaryKey(menuid);
	}
	@Override
	public ViewDesc findViewDescById(String id) {
		return viewDescMapper.selectByPrimaryKey(id);
	}
	@Override
	public TicketType findTicketTypeById(String id) {
		return ticketTypeMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Eat> findFoodByViewId(String viewid) {
		EatExample example=new EatExample();
		example.createCriteria().andViewidEqualTo(viewid);
		com.github.pagehelper.Page<ViewSetMenu> pagehelperPage=PageHelper.startPage(1, 8);
		return eatMapper.selectByExample(example);
	}
	@Override
	public Eat findFoodById(String id) {
		return eatMapper.selectByPrimaryKey(id);
	}

}
