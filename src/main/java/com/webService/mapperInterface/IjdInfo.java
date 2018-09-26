package com.webService.mapperInterface;

import com.webService.entity.JDInfoEntity;


public interface IjdInfo {
	
	/**
	 * 保存京东Token信息
	 * @param info
	 */
	public void insertJdInfo(JDInfoEntity info);
	
	/**
	 * 查询京东Token信息
	 * @return
	 */
	public JDInfoEntity findJdInf();
	
}
