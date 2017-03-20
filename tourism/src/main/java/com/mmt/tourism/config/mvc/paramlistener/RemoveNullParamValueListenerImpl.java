package com.mmt.tourism.config.mvc.paramlistener;

import java.util.HashSet;
import java.util.Set;

import com.mmt.tourism.filter.paramlistener.IParamValuesListener;

public class RemoveNullParamValueListenerImpl extends IParamValuesListener{

	@Override
	public String[] executeValue(String name, String[] values) {
		return removeNULLAndALikeParam(values);
	}
	
	//去重
	private String[] removeNULLAndALikeParam(String[] params) {
		Set<String> paramSet = new HashSet<String>();
		for (String s : params) {
			s = isNullRemoveN(s);
			if (s == null)
				continue;
			paramSet.add(s);
		}
		return paramSet.toArray(new String[paramSet.size()]);
	}
	
	// 去除非空+非空串
	private String isNullRemoveN(String s) {
		if (s == null || "".equals(s.trim()) || "null".equals(s.trim().toLowerCase())
				|| "undefined".equals(s.trim().toLowerCase()))
			return null;
		return s.trim();
	}
}
