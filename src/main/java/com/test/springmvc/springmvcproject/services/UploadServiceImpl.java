/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.services;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.dao.BookDAO;
import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.exceptions.BookAlreadyExistsException;
import com.test.springmvc.springmvcproject.helpers.UploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guillaume
 */
@Service
public class UploadServiceImpl implements UploadService{
    
    @Autowired
    private BookDAO bookDAO;

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    @Override
    public void createEntry(BookBean bean, final UtilisateurBean ubean) throws BookAlreadyExistsException {
        final BookBoBean bobean = UploadHelper.mapBookBeanToBookBoBean(bean);
        bobean.setUploader(ubean);
        
        bookDAO.create(bobean);
    }
    
}
