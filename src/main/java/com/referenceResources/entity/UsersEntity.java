package com.referenceResources.entity;

import com.base.BaseForm;

import lombok.Data;

@Data
public class UsersEntity extends BaseForm<UsersEntity>{
	private String name;
	private String passWord;
	private String ID;
	
}
