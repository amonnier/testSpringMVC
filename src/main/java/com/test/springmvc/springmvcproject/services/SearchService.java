/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.services;

import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import java.util.List;

/**
 *
 * @author guillaume
 */
public interface SearchService {
    
    public List<BookBean> findByTitleLike(final String title) throws NoDataFoundException;
    public BookBean findById(final Integer id) throws NoDataFoundException;
    
}
