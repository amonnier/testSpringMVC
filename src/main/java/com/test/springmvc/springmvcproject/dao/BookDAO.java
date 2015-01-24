/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dao;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import java.util.List;

/**
 *
 * @author guillaume
 */
public interface BookDAO {
    
    public void create(BookBoBean bean);
    
    public List<BookBoBean> getByTitre(final String titre);
    
    public List<BookBoBean> getByAuteur(final String auteur);
    
}
