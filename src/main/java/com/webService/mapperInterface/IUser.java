package com.webService.mapperInterface;

import java.util.List;

import com.webService.entity.UsersEntity;

public interface IUser {
	
	 public List<UsersEntity> selectUserInfo();
	 
	 public void updataUserInfo(UsersEntity user);
}
