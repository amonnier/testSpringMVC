/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.helpers;

import com.test.springmvc.springmvcproject.bo.bean.CommentaireBoBean;
import com.test.springmvc.springmvcproject.dv.beans.CommentaireBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guillaume
 */
public class CommentHelper {

    public static CommentaireBoBean mapCommentaireBeanToBoBean(final CommentaireBean bean) {
        final CommentaireBoBean bobean = new CommentaireBoBean();

        bobean.setCommentaire(bean.getCommentaire());
        bobean.setLivre(BookHelper.mapBookBeanToBookBoBean(bean.getLivre()));
        bobean.setUtilisateur(bean.getUtilisateur());

        return bobean;
    }

    public static CommentaireBean mapCommentaireBoBeanToCommentaireBean(final CommentaireBoBean bobean) {
        final CommentaireBean bean = new CommentaireBean();
        bean.setCommentaire(bobean.getCommentaire());
        bean.setUtilisateur(bobean.getUtilisateur());
        bean.setLivre(BookHelper.mapBookBoBeanToBookBean(bobean.getLivre()));
        bean.setDate_commentaire(bobean.getDate_commentaire());

        return bean;
    }

    public static List<CommentaireBean> mapListCommentaireBoBeanToCommentaireBean(final List<CommentaireBoBean> listeBoBean) {
        final List<CommentaireBean> listeBeans = new ArrayList<CommentaireBean>();
        if (null != listeBoBean) {
            for (CommentaireBoBean bobean : listeBoBean) {
                listeBeans.add(mapCommentaireBoBeanToCommentaireBean(bobean));
            }
        }
        return listeBeans;
    }
}
