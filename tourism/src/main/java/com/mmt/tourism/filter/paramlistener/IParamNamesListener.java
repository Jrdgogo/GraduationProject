package com.mmt.tourism.filter.paramlistener;

public abstract class IParamNamesListener implements IParamListener {

	@Override
	public String[] executeValue(String name, String[] values) {
		return values;
	}

	@Override
	public boolean register() {
		return true;
	}
	
}
