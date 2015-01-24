/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.helpers;

import com.test.springmvc.springmvcproject.dv.beans.RegisterBean;
import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.dv.beans.LoginBean;

/**
 *
 * @author guillaume
 */
public class RegisterHelper {

    public static UtilisateurBean mapRegisterToUtilisateur(final RegisterBean bean) {
        final UtilisateurBean utilisateur = new UtilisateurBean();

        utilisateur.setEmail(bean.getEmail());
        utilisateur.setPassword(bean.getPassword());
        utilisateur.setUsertag(bean.getUsertag());

        return utilisateur;
    }

    public static UtilisateurBean mapLoginToUtilisateur(final LoginBean bean) {
        final UtilisateurBean utilisateur = new UtilisateurBean();

        utilisateur.setEmail(bean.getEmail());
        utilisateur.setPassword(bean.getPassword());

        return utilisateur;
    }
    
    public static LoginBean mapUtilisateurToLogin(final UtilisateurBean utilisateur){
        final LoginBean login= new LoginBean();
        login.setEmail(utilisateur.getEmail());
        login.setPassword(utilisateur.getPassword());
        
        return login;
    }
}
