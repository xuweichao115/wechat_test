package com.modular.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.referenceResources.entity.UsersEntity;

@Mapper
public interface UserDao {
	
	 public List<UsersEntity> selectUserInfo();
	 
	 public void updataUserInfo(UsersEntity user);
}
