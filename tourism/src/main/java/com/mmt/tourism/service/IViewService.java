package com.mmt.tourism.service;

import java.util.List;

import com.mmt.tourism.pojo.City;
import com.mmt.tourism.pojo.JsonGroupModel;
import com.mmt.tourism.pojo.JsonModel;
import com.mmt.tourism.pojo.Page;
import com.mmt.tourism.pojo.Photo;
import com.mmt.tourism.pojo.Province;
import com.mmt.tourism.pojo.View;

public interface IViewService {
	
	boolean addView(View view, List<Photo> photos);

	JsonModel<View> findViews(Page page);

	List<Province> findProvinces();

	Boolean addProvince(Province province);
	
	List<City> findCitiesByProvinceCode(String provinceCode);

	Boolean addCity(City city);

	View getViewById(String viewId);

	City findCitybyCode(String code);

	JsonModel<View> findViewsByExample(View view, Page page);

	JsonGroupModel<City, View> findViewsByProvince(String provinceCode, Page page);

}
