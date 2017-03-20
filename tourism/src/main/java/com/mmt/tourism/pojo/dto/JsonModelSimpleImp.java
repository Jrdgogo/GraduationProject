package com.mmt.tourism.pojo.dto;

import java.util.HashMap;
import java.util.Map;

public class JsonModelSimpleImp implements IJsonModel{

	private Map<String, Object> map=new HashMap<String, Object>();
	
	public Object put(String key,Object value){
		return map.put(key, value);
	}
	
	public Object get(String key){
		return map.get(key);
	}

	public Map<String, Object> getMap() {
		return map;
	}
	
}
