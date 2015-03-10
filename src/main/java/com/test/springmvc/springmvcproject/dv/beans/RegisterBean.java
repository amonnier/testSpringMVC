/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dv.beans;

import javax.validation.constraints.AssertTrue;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 * @author guillaume
 */
@Component
public class RegisterBean {

    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Length(min = 3, max = 15)
    private String password;
    @NotEmpty
    private String passwordConfirmation;
    @NotEmpty
    private String usertag;

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getUsertag() {
        return usertag;
    }

    public void setUsertag(String usertag) {
        this.usertag = usertag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @AssertTrue()
    private boolean isValid() {
        if (null != this.password && !StringUtils.isEmpty(this.password)) {
            return this.password.equals(this.passwordConfirmation);
        } else {
            return true;
        }
    }
}
