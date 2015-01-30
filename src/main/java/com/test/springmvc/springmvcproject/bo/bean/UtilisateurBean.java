/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.bo.bean;

import java.io.Serializable;

/**
 *
 * @author guillaume
 */
public class UtilisateurBean implements Serializable{

    private Integer id;
    private String usertag;
    private String email;
    private String password;

    public UtilisateurBean() {

    }

    public UtilisateurBean(final String usertag, final String email, final String password) {
        this.usertag = usertag;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
