package com.mmt.tourism.config.mvc.paramlistener;

import org.apache.log4j.Logger;

import com.mmt.tourism.filter.paramlistener.IParamValuesListener;

public class ParamListenerSimpleImp extends IParamValuesListener{

	private static final Logger log=Logger.getLogger(ParamListenerSimpleImp.class);
	@Override
	public String[] executeValue(String name, String[] values) {
		if(values!=null){
		   StringBuffer buffer=new StringBuffer();
		    for(String value:values){
		    	buffer.append(value+";");
		    }
		    log.info("参数名："+name+"--->参数值："+buffer.toString());
		}else
			log.info("参数名："+name+"--->参数值："+values);
			
		return values;
	}

}
