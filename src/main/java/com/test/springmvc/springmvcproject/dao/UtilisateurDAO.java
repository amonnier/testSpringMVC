/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dao;

import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.exceptions.DuplicatedEntryException;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;

/**
 *
 * @author guillaume
 */
public interface UtilisateurDAO {

    public void create(final Integer id, final String email, final String password);

    public void create(final String email, final String password);

    public void create(final UtilisateurBean utilisateur) throws DuplicatedEntryException;

    public UtilisateurBean get(final String email, final String password);
 
    public UtilisateurBean get(final String email) throws NoDataFoundException;

    public UtilisateurBean get(final UtilisateurBean utilisateur) throws NoDataFoundException;
}
