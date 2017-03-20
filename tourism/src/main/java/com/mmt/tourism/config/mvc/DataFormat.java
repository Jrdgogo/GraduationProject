package com.mmt.tourism.config.mvc;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.mmt.tourism.pojo.vo.JsonConverter;
import com.mmt.tourism.util.GlobalUtil;

public class DataFormat implements Formatter<Date> {

	@Override
	public String print(Date object, Locale locale) {
		return GlobalUtil.timeFormat(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		String jsondate = "{\"date\":\"" + text + "\"}";
		return GlobalUtil.toJsonObject(JsonConverter.class, jsondate).getDate();
	}

}
