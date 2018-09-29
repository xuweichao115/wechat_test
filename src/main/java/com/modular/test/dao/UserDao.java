package com.modular.test.dao;

import java.util.List;

import com.modular.test.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {
	
	 public List<UsersEntity> selectUserInfo();
	 
	 public void updataUserInfo(UsersEntity user);
}
