/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.bo.bean;

import java.util.Date;

/**
 *
 * @author guillaume
 */
public class CommentaireBoBean {

    private UtilisateurBean utilisateur;
    private BookBoBean livre;
    private String commentaire;
    private Date date_commentaire;

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public UtilisateurBean getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurBean utilisateur) {
        this.utilisateur = utilisateur;
    }

    public BookBoBean getLivre() {
        return livre;
    }

    public void setLivre(BookBoBean livre) {
        this.livre = livre;
    }

    public Date getDate_commentaire() {
        return date_commentaire;
    }

    public void setDate_commentaire(Date date_commentaire) {
        this.date_commentaire = date_commentaire;
    }
    
}
