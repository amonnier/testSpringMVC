/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dao;

import com.test.springmvc.springmvcproject.bo.bean.CommentaireBoBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import java.util.List;

/**
 *
 * @author guillaume
 */
public interface CommentDAO {
    
    public List<CommentaireBoBean> getByBookId(final Integer id) throws NoDataFoundException;
}
