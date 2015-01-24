/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.validator;

import com.test.springmvc.springmvcproject.dv.beans.RegisterBean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author guillaume
 */
public class RegisterValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return RegisterBean.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterBean bean = (RegisterBean) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, bean.getEmail(), "Email requis !");
    }   
}
