package com.modular.test.entity;

import com.base.BaseForm;

import lombok.Data;

@Data
public class UsersEntity extends BaseForm{
	private String name;
	private String passWord;
	private String ID;
	
}
