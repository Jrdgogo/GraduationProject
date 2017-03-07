package com.mmt.tourism.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.mmt.tourism.dao.CityMapper;
import com.mmt.tourism.dao.PhotoMapper;
import com.mmt.tourism.dao.ProvinceMapper;
import com.mmt.tourism.dao.ViewMapper;
import com.mmt.tourism.pojo.City;
import com.mmt.tourism.pojo.CityExample;
import com.mmt.tourism.pojo.JsonModel;
import com.mmt.tourism.pojo.Page;
import com.mmt.tourism.pojo.Photo;
import com.mmt.tourism.pojo.Province;
import com.mmt.tourism.pojo.ProvinceExample;
import com.mmt.tourism.pojo.View;
import com.mmt.tourism.pojo.ViewExample;
import com.mmt.tourism.service.IViewService;
import com.mmt.tourism.util.GlobalUtil;

@Service
public class ViewServiceImpl implements IViewService{

	
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
	public boolean addView(View view,List<MultipartFile> photos) {
		view.setId(GlobalUtil.getModelID(View.class));
		view.setCode(view.getCitycode()+"_"+GlobalUtil.getCode(view.getViewname()));
		if(viewMapper.insertSelective(view)!=0){
			
			for(MultipartFile photo:photos){
				Photo record=new Photo();
				record.setId(GlobalUtil.getModelID(Photo.class));
				record.setCode(view.getCode());
				try {
					record.setPhoto(photo.getBytes());
					photoMapper.insertSelective(record);
				} catch (IOException e) {
					logger.error("一张"+view.getViewname()+"景区图片保存失败:"+e.getMessage());
					continue;
				}
			}
			
			return true;
		}
		return false;
	}
	@Override
	public JsonModel<View> findViews(Page page) {
		com.github.pagehelper.Page<View> pagehelperPage=PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<View> views=viewMapper.selectByExampleWithBLOBs(new ViewExample());
		page.setPage(pagehelperPage,views.size());
		JsonModel<View> model=new JsonModel<View>();
		model.setResult(views);
		model.setPage(page);
		return model;
	}
	
	@Override
	public List<Province> findProvinces() {
		return provinceMapper.selectByExample(new ProvinceExample());
	}
	@Override
	public Boolean addProvince(Province province) {
		return provinceMapper.insertSelective(province)!=0;
	}
	@Override
	public List<City> findCitiesByProvinceCode(String provinceCode) {
		CityExample example=new CityExample();
		example.createCriteria().andProvincecodeEqualTo(provinceCode);
		return cityMapper.selectByExample(example);
	}
	@Override
	public Boolean addCity(City city) {
		return cityMapper.insertSelective(city)!=0;
	}

}
