package com.utility;

import net.sf.json.JSONObject;

public class TypeConversionUtility {
	
	
	// 转换成json格式
	public String ObjToJson(Object parameter) {
		String rep = JSONObject.fromObject(parameter).toString();
		return rep;
	}

}
