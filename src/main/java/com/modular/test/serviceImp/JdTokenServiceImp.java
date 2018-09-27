package com.modular.test.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modular.test.dao.JdInfoDao;
import com.modular.test.service.JdTokenService;
import com.referenceResources.entity.CallbackEntity;
import com.referenceResources.entity.JDInfoEntity;

@Service
public class JdTokenServiceImp implements JdTokenService{

	@Autowired
	JdInfoDao jdinfoDao;
	
	@Override
	public CallbackEntity savaJDInfo() {
	 
		return null;
	}

	@Override
	public JDInfoEntity findJDInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
