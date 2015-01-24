/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.services;

import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.exceptions.BookAlreadyExistsException;

/**
 *
 * @author guillaume
 */
public interface UploadService {
    public void createEntry(final BookBean bean, final UtilisateurBean ubean) throws BookAlreadyExistsException;
}
