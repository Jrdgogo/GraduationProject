package com.mmt.tourism.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.mmt.tourism.dao.PhotoMapper;
import com.mmt.tourism.pojo.dto.JsonPageModel;
import com.mmt.tourism.pojo.dto.Page;
import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.pojo.po.PhotoExample;
import com.mmt.tourism.pojo.po.View;
import com.mmt.tourism.util.GlobalUtil;

@Controller
@RequestMapping("/photo")
public class PhoneController {

	@Autowired
	private PhotoMapper photoMapper;
	
	private Logger logger = LoggerFactory.getLogger(PhoneController.class);

	@RequestMapping(value = "/getphotos.controller", method = RequestMethod.POST)
	@ResponseBody
	public JsonPageModel<Photo> getPhotos(@RequestParam(value = "viewCode") String code, Page page) {

		PhotoExample example = new PhotoExample();
		example.createCriteria().andCodeEqualTo(code);
		com.github.pagehelper.Page<View> pagehelperPage = PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Photo> photos = photoMapper.selectByExampleWithBLOBs(example);
		for (Photo photo : photos) {
			photo.setPhoto(null);
		}
		page.setPage(pagehelperPage, photos.size());

		JsonPageModel<Photo> model = new JsonPageModel<Photo>();
		model.setResult(photos);
		model.setPage(page);

		return model;
	}

	@RequestMapping(value = "/addphoto.controller", method = RequestMethod.POST)
	public String addPhoto(@RequestParam(value = "file") List<MultipartFile> multipartFiles,
			@RequestParam(value = "viewCode") String viewCode,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "pdesc", required = false) String pdesc) {
		
		for(int i=0;i<multipartFiles.size();i++){
			Photo photo=new Photo();
			MultipartFile multipartFile=multipartFiles.get(i);
			try {
				photo.setPhoto(multipartFile.getBytes());
				photo.setPdesc(pdesc);
				photo.setCode(viewCode);
				photo.setTitle(title);
				photo.setId(GlobalUtil.getModelID(Photo.class));
				photoMapper.insertSelective(photo);
			} catch (IOException e) {
				logger.error("一张图片:"+multipartFile.getName()+"丢失", e);
			}
		}
		return "admin/view/show";
	}

}
