/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.services;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.dao.BookDAO;
import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.helpers.SearchHelper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guillaume
 */
@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    private BookDAO bookDAO;

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<BookBean> findByTitleLike(String title) throws NoDataFoundException{
        List<BookBoBean> livresTrouves = bookDAO.getByTitreLike(title);
        final List<BookBean> listeDvBeans = SearchHelper.mapListBookBoBeanToBookBean(livresTrouves);
        
        return listeDvBeans;
    }

    @Override
    public BookBean findById(Integer id) throws NoDataFoundException {
        final BookBoBean bobean = bookDAO.getById(id);
        
        final BookBean bean = SearchHelper.mapBookBoBeanToBookBean(bobean);
        return bean;
    }
    
    @Override
    public List<BookBean> findLastFiveUploaded() throws NoDataFoundException{
        final List<BookBoBean> listFiveLastBoBooks = bookDAO.getLastFiveUploadedBooks();
        final List<BookBean> listFiveLastBooks;
        
        listFiveLastBooks = SearchHelper.mapListBookBoBeanToBookBean(listFiveLastBoBooks);
        
        return listFiveLastBooks;
    }

}
