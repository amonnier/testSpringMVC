/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dao;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import java.util.List;

/**
 *
 * @author guillaume
 */
public interface BookDAO {
    
    public void create(BookBoBean bean);
    
    public List<BookBoBean> getByTitreLike(final String titre) throws NoDataFoundException;
    
    public List<BookBoBean> getByAuteur(final String auteur);
    
    public BookBoBean getById(final Integer id) throws NoDataFoundException;
    
}
