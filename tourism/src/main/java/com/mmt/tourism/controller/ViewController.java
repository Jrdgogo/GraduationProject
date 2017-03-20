package com.mmt.tourism.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
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
import com.mmt.tourism.pojo.dto.IJsonModel;
import com.mmt.tourism.pojo.dto.JsonPageModel;
import com.mmt.tourism.pojo.dto.Page;
import com.mmt.tourism.pojo.po.City;
import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.pojo.po.Province;
import com.mmt.tourism.pojo.po.TicketType;
import com.mmt.tourism.pojo.po.View;
import com.mmt.tourism.pojo.po.ViewSetMenu;
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
	public JsonPageModel<View> findViews(Page page) {
		return viewService.findViews(page);
	}
	
	@RequestMapping(value = "/findViewsByExample.action")
	public IJsonModel findViewsByExample(@RequestParam(value = "provinceCode", required = false) String provinceCode,
			View view,Page page,HttpServletRequest request) {
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

	@RequestMapping(value = "/addViewSetMenu.action")
	public Boolean addViewSetMenu(ViewSetMenu viewSetMenu) {
		return viewPointService.addViewSetMenu(viewSetMenu);
	}

	@RequestMapping(value = "/findViewSetMenus.action")
	public JsonPageModel<ViewSetMenu> findViewSetMenus(String viewId, Page page) {
		return viewPointService.findViewSetMenus(viewId, page);
	}
	@RequestMapping(value = "/addTicketType.action")
	public Boolean addTicketType(TicketType type) {
		return viewPointService.addTicketType(type);
	}
	@RequestMapping(value = "/findAllTicketType.action")
	public List<TicketType> findAllTicketType() {
		return viewPointService.findAllTicketType();
	}

}
