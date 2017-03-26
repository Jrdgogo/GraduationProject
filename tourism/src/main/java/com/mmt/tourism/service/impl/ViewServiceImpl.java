package com.mmt.tourism.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.mmt.tourism.dao.CityMapper;
import com.mmt.tourism.dao.PhotoMapper;
import com.mmt.tourism.dao.ProvinceMapper;
import com.mmt.tourism.dao.ViewMapper;
import com.mmt.tourism.pojo.dto.JsonGroupModel;
import com.mmt.tourism.pojo.dto.JsonPageModel;
import com.mmt.tourism.pojo.dto.Page;
import com.mmt.tourism.pojo.po.City;
import com.mmt.tourism.pojo.po.CityExample;
import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.pojo.po.Province;
import com.mmt.tourism.pojo.po.ProvinceExample;
import com.mmt.tourism.pojo.po.View;
import com.mmt.tourism.pojo.po.ViewExample;
import com.mmt.tourism.service.IViewService;
import com.mmt.tourism.util.GlobalUtil;

@Service
public class ViewServiceImpl implements IViewService {

	private Logger logger = LoggerFactory.getLogger(ViewServiceImpl.class);
	@Autowired
	private ViewMapper viewMapper;
	@Autowired
	private PhotoMapper photoMapper;
	@Autowired
	private ProvinceMapper provinceMapper;
	@Autowired
	private CityMapper cityMapper;

	@Override
	@Transactional
	public boolean addView(View view, List<Photo> photos) {
		view.setId(GlobalUtil.getModelID(View.class));
		view.setCode(view.getCitycode() + "_" + GlobalUtil.getCode(view.getViewname()));
		if (viewMapper.insertSelective(view) != 0) {
			for (Photo record : photos) {
				record.setId(GlobalUtil.getModelID(Photo.class));
				record.setCode(view.getCode());
				photoMapper.insertSelective(record);
			}
			return true;
		}
		return false;
	}

	@Override
	public JsonPageModel<View> findViews(Page page) {
		com.github.pagehelper.Page<View> pagehelperPage = PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<View> views = viewMapper.selectByExampleWithBLOBs(new ViewExample());

		page.setPage(pagehelperPage, views.size());

		JsonPageModel<View> model = new JsonPageModel<View>();
		model.setResult(views);
		model.setPage(page);

		return model;
	}

	@Override
	public List<Province> findProvinces() {
		return provinceMapper.selectByExample(new ProvinceExample());
	}

	@Override
	@Transactional
	public Boolean addProvince(Province province) {
		return provinceMapper.insertSelective(province) != 0;
	}

	@Override
	public List<City> findCitiesByProvinceCode(String provinceCode) {
		CityExample example = new CityExample();
		example.createCriteria().andProvincecodeEqualTo(provinceCode);
		return cityMapper.selectByExample(example);
	}

	@Override
	@Transactional
	public Boolean addCity(City city) {
		return cityMapper.insertSelective(city) != 0;
	}

	@Override
	public View getViewById(String viewId) {
		return viewMapper.selectByPrimaryKey(viewId);
	}

	@Override
	public City findCitybyCode(String code) {
		return cityMapper.selectByPrimaryKey(code);
	}

	@Override
	public JsonGroupModel<City, View> findViewsByProvince(String provinceCode, Page page) {
		int pageSize=page.getPageSize();
		int pageNum=page.getPageNum();
		
		CityExample cityExample = new CityExample();
		cityExample.createCriteria().andProvincecodeEqualTo(provinceCode);

		List<City> cities = cityMapper.selectByExample(cityExample);

		JsonGroupModel<City, View> groupModel = new JsonGroupModel<City, View>();

		if (cities != null) {
			for (City city : cities) {

				ViewExample example = new ViewExample();
				example.createCriteria().andCitycodeEqualTo(city.getCode());

				com.github.pagehelper.Page<View> pagehelperPage = PageHelper.startPage(pageNum,
						pageSize);
				List<View> views = viewMapper.selectByExampleWithBLOBs(example);
				if (views == null || views.isEmpty())
					continue;
				Page p=new Page();
				p.setPage(pagehelperPage, views.size());

				groupModel.putGroup(city, views, p);
			}
		}
		return groupModel;
	}

	@Override
	public JsonPageModel<View> findViewsByExample(View view, Page page) {

		JsonPageModel<View> model = new JsonPageModel<View>();

		ViewExample example = new ViewExample();
		setViewExample(view, example);

		com.github.pagehelper.Page<View> pagehelperPage = PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<View> views = viewMapper.selectByExampleWithBLOBs(example);
		
		page.setPage(pagehelperPage, views.size());

		model.setResult(views);
		model.setPage(page);
		return model;
	}

	
	private void setViewExample(View view, ViewExample example) {
		if (view == null)
			return;
		if (view.getId() != null)
			example.or().andIdEqualTo(view.getId());
		if (view.getViewname() != null)
			example.or().andViewnameEqualTo(view.getViewname());
		if (view.getCitycode() != null)
			example.or().andCitycodeEqualTo(view.getCitycode());
		if (view.getCode() != null)
			example.or().andCodeEqualTo(view.getCode());
		if (view.getViewkewwords() != null)
			example.or().andViewkewwordsEqualTo(view.getViewkewwords());
		if (view.getViewseason() != null)
			example.or().andViewseasonEqualTo(view.getViewseason());

	}

	@Override
	public Province getProvinceById(String code) {
		return provinceMapper.selectByPrimaryKey(code);
	}
}
