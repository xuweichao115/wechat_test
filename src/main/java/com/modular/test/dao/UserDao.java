package com.modular.test.dao;

import com.modular.test.entity.UsersEntity;
import com.modular.test.form.UserForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserDao {

	List<UsersEntity> selectUserInfo(UserForm form);

	void updataUserInfo(UsersEntity user);
}
