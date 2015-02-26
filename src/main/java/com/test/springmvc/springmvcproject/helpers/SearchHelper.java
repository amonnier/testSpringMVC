/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.helpers;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guillaume
 */
public class SearchHelper {
    
    public static BookBean mapBookBoBeanToBookBean(final BookBoBean bobean){
        final BookBean bean = new BookBean();
        
        bean.setTitre(bobean.getTitre());
        bean.setDescription(bobean.getDescription());
        bean.setAuteur(bobean.getAuteur());
        bean.setEmplacement(bobean.getEmplacement());
        bean.setEmplacementCouverture(bobean.getEmplacementCouverture());
        bean.setIdentifiant(bobean.getId());
        bean.setNomLivre(bobean.getNomFichier());
        bean.setUploader(bobean.getUploader());
        bean.setCommentaires(CommentHelper.mapListCommentaireBoBeanToCommentaireBean(bobean.getCommentaire()));
        
        return bean;
    }

    public static List<BookBean> mapListBookBoBeanToBookBean(List<BookBoBean> bobeans){
        final List<BookBean> beans = new ArrayList<BookBean>();
        for(BookBoBean bobean : bobeans){
            beans.add(mapBookBoBeanToBookBean(bobean));
        }
        
        return beans;
    }
}
