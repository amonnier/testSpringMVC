/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dv.beans;

import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;

/**
 *
 * @author guillaume
 */
public class CommentaireBean {

    private UtilisateurBean utilisateur;
    private BookBean livre;
    private String commentaire;

    public UtilisateurBean getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurBean utilisateur) {
        this.utilisateur = utilisateur;
    }

    public BookBean getLivre() {
        return livre;
    }

    public void setLivre(BookBean livre) {
        this.livre = livre;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
    
}
