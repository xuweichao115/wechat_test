package com.modular.test.form;

import com.base.BaseForm;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserForm extends BaseForm implements Serializable {
    private String userId;
}
