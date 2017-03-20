package com.mmt.tourism.filter.paramlistener;

public interface IParamListener {

	String executeName(String name);
	String[] executeValue(String name,String[] values);
	boolean	 register();
}
