/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.helpers;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.dv.beans.BookBean;

/**
 *
 * @author guillaume
 */
public class UploadHelper {
    
    public static BookBoBean mapBookBeanToBookBoBean(final BookBean bean){
        final BookBoBean boBean = new BookBoBean();
        
        boBean.setAuteur(bean.getAuteur());
        boBean.setDescription(bean.getDescription());
        boBean.setTitre(bean.getTitre());
        boBean.setEmplacement(bean.getEmplacement());
        
        return boBean;
    }
}
