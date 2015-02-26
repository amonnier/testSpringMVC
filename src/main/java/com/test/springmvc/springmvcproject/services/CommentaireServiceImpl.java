/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.services;

import com.test.springmvc.springmvcproject.bo.bean.CommentaireBoBean;
import com.test.springmvc.springmvcproject.dao.CommentDAO;
import com.test.springmvc.springmvcproject.dv.beans.CommentaireBean;
import com.test.springmvc.springmvcproject.helpers.CommentHelper;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guillaume
 */
@Service
public class CommentaireServiceImpl implements CommentaireService{
    
    @Autowired
    private CommentDAO commentDAO;

    @Override
    public void save(CommentaireBean commentaire) {
        final CommentaireBoBean bean = CommentHelper.mapCommentaireBeanToBoBean(commentaire);
        final Date now = Calendar.getInstance().getTime();
        bean.setDate_commentaire(now);
        commentDAO.save(bean);
    }
    
    
}
