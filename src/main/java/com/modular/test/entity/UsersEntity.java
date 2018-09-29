package com.modular.test.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsersEntity implements Serializable {
	private String name;
	private String passWord;
	private String id;
}
