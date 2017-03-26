package com.mmt.tourism.service;

import java.util.List;

import com.mmt.tourism.pojo.dto.JsonGroupModel;
import com.mmt.tourism.pojo.dto.JsonPageModel;
import com.mmt.tourism.pojo.dto.Page;
import com.mmt.tourism.pojo.po.City;
import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.pojo.po.Province;
import com.mmt.tourism.pojo.po.View;

public interface IViewService {
	
	boolean addView(View view, List<Photo> photos);

	JsonPageModel<View> findViews(Page page);

	List<Province> findProvinces();

	Boolean addProvince(Province province);
	
	List<City> findCitiesByProvinceCode(String provinceCode);

	Boolean addCity(City city);

	View getViewById(String viewId);

	City findCitybyCode(String code);

	JsonPageModel<View> findViewsByExample(View view, Page page);

	JsonGroupModel<City, View> findViewsByProvince(String provinceCode, Page page);

	Province getProvinceById(String code);

}
