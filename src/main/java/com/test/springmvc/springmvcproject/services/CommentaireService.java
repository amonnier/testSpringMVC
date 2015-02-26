/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.services;

import com.test.springmvc.springmvcproject.dv.beans.CommentaireBean;

/**
 *
 * @author guillaume
 */
public interface CommentaireService {
    
    public void save(final CommentaireBean commentaire);
}
