package com.modular.test.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.referenceResources.entity.CallbackEntity;
import com.referenceResources.entity.JDInfoEntity;

@Controller
@RequestMapping("/JD")
public class JDToken{

	@RequestMapping("insertInfo.do")
	@ResponseBody
	public CallbackEntity savaJDInfo() throws Exception, IOException {
		return null;
	}
	
	
	@RequestMapping("findInfo.do")
	@ResponseBody
	public JDInfoEntity findJDInfo() {
		return null;
		
	}
}