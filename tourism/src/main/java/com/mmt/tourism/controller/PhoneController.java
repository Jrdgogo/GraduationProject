package com.mmt.tourism.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmt.tourism.dao.PhotoMapper;
import com.mmt.tourism.pojo.po.Photo;
import com.mmt.tourism.pojo.po.PhotoExample;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	
	@Autowired
	private PhotoMapper photoMapper;

	@RequestMapping(value = "/getPhones.controller", method = RequestMethod.POST)
	public List<String> getPhones(@RequestParam(value = "viewCode") String code) {
         
		PhotoExample example=new PhotoExample();
		example.createCriteria().andCodeEqualTo(code);
		List<Photo> photos=photoMapper.selectByExample(example);
		
		List<String> photoids=new ArrayList<>();
		for(Photo photo:photos){
			photoids.add(photo.getId());
		}
		return photoids;
	}

}
