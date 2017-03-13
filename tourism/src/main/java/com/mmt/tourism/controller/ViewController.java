package com.mmt.tourism.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.mmt.tourism.pojo.City;
import com.mmt.tourism.pojo.IJsonModel;
import com.mmt.tourism.pojo.JsonModel;
import com.mmt.tourism.pojo.Page;
import com.mmt.tourism.pojo.Photo;
import com.mmt.tourism.pojo.Province;
import com.mmt.tourism.pojo.View;
import com.mmt.tourism.pojo.ViewPoint;
import com.mmt.tourism.pojo.ViewRoute;
import com.mmt.tourism.pojo.ViewSetMenu;
import com.mmt.tourism.service.IViewPointService;
import com.mmt.tourism.service.IViewService;
import com.mmt.tourism.service.impl.ViewServiceImpl;

@RestController
@RequestMapping("/view")
public class ViewController {

	private Logger logger = LoggerFactory.getLogger(ViewServiceImpl.class);
	@Autowired
	private IViewService viewService;
	@Autowired
	private IViewPointService viewPointService;

	@RequestMapping(value = "/getAttr.action", method = RequestMethod.POST)
	public String getAttr(HttpSession attr) {
		Object viewId = attr.getAttribute("viewId");
		attr.removeAttribute("viewId");
		Object photoId = attr.getAttribute("photoId");
		attr.removeAttribute("photoId");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("viewId", viewId);
		jsonObject.put("photoId", photoId);
		return jsonObject.toJSONString();
	}

	@RequestMapping(value = "/addView.action", method = RequestMethod.POST)
	public ModelAndView addView(View view,
			@RequestParam(value = "photos", required = false) List<MultipartFile> multipartFiles, HttpSession attr) {
		List<Photo> photos = new ArrayList<Photo>(0);
		if (multipartFiles != null) {
			for (MultipartFile multipartFile : multipartFiles) {
				if(multipartFile.getSize()<=0)
					continue;
				Photo photo = new Photo();
				try {
					photo.setPhoto(multipartFile.getBytes());
				} catch (IOException e) {
					logger.error(view.getViewname() + "景区的风景图：" + multipartFile.getName() + "未保存", e);
					continue;
				}
				photos.add(photo);
			}
		}
		ModelAndView model_view = new ModelAndView("admin/view/viewFrame");
		if (viewService.addView(view, photos)) {
			attr.setAttribute("viewId", view.getId());
			if (!photos.isEmpty()) {
				String photoId = photos.get(new Random().nextInt(photos.size())).getId();
				attr.setAttribute("photoId", photoId);
			}
		}
		return model_view;
	}

	@RequestMapping(value = "/findViews.action")
	public JsonModel<View> findViews(Page page) {
		return viewService.findViews(page);
	}
	
	@RequestMapping(value = "/findViewsByExample.action")
	public IJsonModel findViewsByExample(@RequestParam(value = "provinceCode", required = false) String provinceCode,
			View view,Page page) {
		if(provinceCode!=null)
			return viewService.findViewsByProvince(provinceCode,page);
		return viewService.findViewsByExample(view,page);
	}

	@RequestMapping(value = "/getViewById.action")
	public View getViewById(@RequestParam(value = "viewId", required = true) String viewId) {
		return viewService.getViewById(viewId);
	}

	@RequestMapping(value = "/findProvinces.action")
	public List<Province> findProvinces() {
		return viewService.findProvinces();
	}

	@RequestMapping(value = "/findCitiesByProvinceCode.action")
	public List<City> findCitiesByProvinceCode(
			@RequestParam(value = "provinceCode", required = true) String provinceCode) {
		return viewService.findCitiesByProvinceCode(provinceCode);
	}

	@RequestMapping(value = "/addProvince.action")
	public Boolean addProvince(Province province) {
		return viewService.addProvince(province);
	}

	@RequestMapping(value = "/findCitybyCode.action")
	public City findCitybyCode(@RequestParam(value = "code", required = true) String code) {
		return viewService.findCitybyCode(code);
	}

	@RequestMapping(value = "/addCity.action")
	public Boolean addCity(City city) {
		return viewService.addCity(city);
	}

	@RequestMapping(value = "/addViewPoint.action")
	public Boolean addViewPoint(ViewPoint viewPoint, List<MultipartFile> photos) {
		return viewPointService.addViewPoint(viewPoint, photos);
	}

	@RequestMapping(value = "/findViewPoints.action")
	public JsonModel<ViewPoint> findViewPoints(Page page) {
		return viewPointService.findViewPoints(page);
	}

	@RequestMapping(value = "/addViewRoute.action")
	public Boolean addViewRoute(ViewRoute viewRoute,
			@RequestParam(value = "point", required = true) List<String> routes) {
		StringBuffer routesb = new StringBuffer();
		for (int i = 0; i < routes.size(); i++) {
			routesb.append(routes.get(i));
			if (i < routes.size() - 1)
				routesb.append("_");
		}
		viewRoute.setRoutes(routesb.toString());
		return viewPointService.addViewRoute(viewRoute);
	}

	@RequestMapping(value = "/findViewRoutes.action")
	public JsonModel<ViewRoute> findViewRoutes(String viewId, Page page) {
		return viewPointService.findViewRoutes(viewId, page);
	}

	@RequestMapping(value = "/addViewSetMenu.action")
	public Boolean addViewSetMenu(ViewSetMenu viewSetMenu,
			@RequestParam(value = "route", required = true) List<String> setmenus) {
		StringBuffer setmenusb = new StringBuffer();
		for (int i = 0; i < setmenus.size(); i++) {
			setmenusb.append(setmenus.get(i));
			if (i < setmenus.size() - 1)
				setmenusb.append("_");
		}
		viewSetMenu.setSetmenus(setmenusb.toString());
		return viewPointService.addViewSetMenu(viewSetMenu);
	}

	@RequestMapping(value = "/findViewSetMenus.action")
	public JsonModel<ViewSetMenu> findViewSetMenus(String viewId, Page page) {
		return viewPointService.findViewSetMenus(viewId, page);
	}

}
