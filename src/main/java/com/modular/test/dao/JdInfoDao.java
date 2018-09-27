package com.modular.test.dao;

import org.apache.ibatis.annotations.Mapper;

import com.referenceResources.entity.JDInfoEntity;

@Mapper
public interface JdInfoDao {
	
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
