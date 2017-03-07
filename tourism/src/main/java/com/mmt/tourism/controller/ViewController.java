package com.mmt.tourism.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mmt.tourism.pojo.City;
import com.mmt.tourism.pojo.JsonModel;
import com.mmt.tourism.pojo.Page;
import com.mmt.tourism.pojo.Province;
import com.mmt.tourism.pojo.View;
import com.mmt.tourism.pojo.ViewPoint;
import com.mmt.tourism.pojo.ViewRoute;
import com.mmt.tourism.pojo.ViewSetMenu;
import com.mmt.tourism.service.IViewPointService;
import com.mmt.tourism.service.IViewService;


@RestController
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	private IViewService viewService;
	@Autowired
	private IViewPointService viewPointService;
	
	@RequestMapping(value = "/addView.action",method=RequestMethod.POST)
	public Boolean logout(View view,@RequestParam(value = "photos", required = false) List<MultipartFile> photos) {
		return viewService.addView(view,photos);
	}
	@RequestMapping(value = "/findViews.action")
	public JsonModel<View> findViews(Page page) {
		return viewService.findViews(page);
	}
	
	@RequestMapping(value = "/findProvinces.action")
	public List<Province> findProvinces() {
		return viewService.findProvinces();
	}
	
	@RequestMapping(value = "/findCitiesByProvinceCode.action")
	public List<City> findCitiesByProvinceCode(@RequestParam(value="provinceCode",required=true)String provinceCode) {
		return viewService.findCitiesByProvinceCode(provinceCode);
	}
	@RequestMapping(value = "/addProvince.action")
	public Boolean addProvince(Province province) {
		return viewService.addProvince(province);
	}
	
	@RequestMapping(value = "/addCity.action")
	public Boolean addCity(City city) {
		return viewService.addCity(city);
	}
	
	@RequestMapping(value = "/addViewPoint.action")
	public Boolean addViewPoint(ViewPoint viewPoint, List<MultipartFile> photos){
		return viewPointService.addViewPoint(viewPoint, photos);
	}

	@RequestMapping(value = "/findViewPoints.action")
	public JsonModel<ViewPoint> findViewPoints(Page page){
		return viewPointService.findViewPoints(page);
	}
	
	@RequestMapping(value = "/addViewRoute.action")
	public Boolean addViewRoute(ViewRoute viewRoute,@RequestParam(value="point",required=true)List<String> routes){
		StringBuffer routesb=new StringBuffer();
		for(int i=0;i<routes.size();i++){
			routesb.append(routes.get(i));
			if(i<routes.size()-1)
				routesb.append("_");
		}
		viewRoute.setRoutes(routesb.toString());
		return viewPointService.addViewRoute(viewRoute);
	}
	
	@RequestMapping(value = "/findViewRoutes.action")
	public JsonModel<ViewRoute> findViewRoutes(String viewId,Page page){
		return viewPointService.findViewRoutes(viewId, page);
	}
	
	@RequestMapping(value = "/addViewSetMenu.action")
	public Boolean addViewSetMenu(ViewSetMenu viewSetMenu,@RequestParam(value="route",required=true)List<String> setmenus){
		StringBuffer setmenusb=new StringBuffer();
		for(int i=0;i<setmenus.size();i++){
			setmenusb.append(setmenus.get(i));
			if(i<setmenus.size()-1)
				setmenusb.append("_");
		}
		viewSetMenu.setSetmenus(setmenusb.toString());
		return viewPointService.addViewSetMenu(viewSetMenu);
	}
	
	@RequestMapping(value = "/findViewSetMenus.action")
	public JsonModel<ViewSetMenu> findViewSetMenus(String viewId,Page page){
		return viewPointService.findViewSetMenus(viewId, page);
	}
	
}
