package com.mmt.tourism.config.mvc;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.mmt.tourism.pojo.vo.JsonConverter;
import com.mmt.tourism.util.GlobalUtil;

public class DataConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		String jsondate = "{\"date\":\"" + arg0 + "\"}";
		return GlobalUtil.toJsonObject(JsonConverter.class, jsondate).getDate();
	}

}
