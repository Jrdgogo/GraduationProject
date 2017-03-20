package com.mmt.tourism.config.mvc.paramlistener;

import java.util.ArrayList;
import java.util.List;

import com.mmt.tourism.filter.paramlistener.IParamListener;
import com.mmt.tourism.util.ErgodicClass;

public class IParamListenerFactory {

	private static List<IParamListener> listeners=new ArrayList<IParamListener>();
	

    public void factotyBuild(){
    	if(!listeners.isEmpty())
    		return;
    	List<IParamListener> iParamListeners=ErgodicClass.getAllBean(IParamListener.class);
    	for(IParamListener listener:iParamListeners){
    		if(listener.register())
    			listeners.add(listener);
    	}
    }

	public static List<IParamListener> getListeners() {
		List<IParamListener> iParamListeners=new ArrayList<IParamListener>(listeners);
		return iParamListeners;
	}
	
	
}
