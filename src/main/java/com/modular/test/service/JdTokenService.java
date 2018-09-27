package com.modular.test.service;

import com.referenceResources.entity.CallbackEntity;
import com.referenceResources.entity.JDInfoEntity;

public interface JdTokenService {

	/**
	 * 保存京东Token方法
	 * @return
	 */
	public CallbackEntity savaJDInfo();
	
	/**
	 * 查询京东Token方法
	 * @return
	 */
	public JDInfoEntity findJDInfo();
	
}
