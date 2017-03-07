package com.mmt.tourism.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mmt.tourism.pojo.City;
import com.mmt.tourism.pojo.JsonModel;
import com.mmt.tourism.pojo.Page;
import com.mmt.tourism.pojo.Province;
import com.mmt.tourism.pojo.View;

public interface IViewService {
	
	boolean addView(View view, List<MultipartFile> photos);

	JsonModel<View> findViews(Page page);

	List<Province> findProvinces();

	Boolean addProvince(Province province);
	
	List<City> findCitiesByProvinceCode(String provinceCode);

	Boolean addCity(City city);

}
