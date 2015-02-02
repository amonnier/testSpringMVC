/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.bo.bean;

/**
 *
 * @author guillaume
 */
public class BookBoBean {

    private Integer id;
    private String auteur;
    private String titre;
    private String description;
    private String emplacement;
    private String emplacementCouverture;
    private UtilisateurBean uploader;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmplacementCouverture() {
        return emplacementCouverture;
    }

    public void setEmplacementCouverture(String emplacementCouverture) {
        this.emplacementCouverture = emplacementCouverture;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public UtilisateurBean getUploader() {
        return uploader;
    }

    public void setUploader(UtilisateurBean uploader) {
        this.uploader = uploader;
    }

}
