/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dv.beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author guillaume
 */
public class BookBean {

    @NotNull
    @NotEmpty
    private String auteur;
    @NotNull
    @NotEmpty
    private String titre;
    @NotNull
    @NotEmpty
    private String description;
    private MultipartFile fichier;
    private MultipartFile couverture;
    private String emplacement;
    private String emplacementCouverture;
    private Integer identifiant;
    private String nomLivre;

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public MultipartFile getCouverture() {
        return couverture;
    }

    public void setCouverture(MultipartFile couverture) {
        this.couverture = couverture;
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

    public MultipartFile getFichier() {
        return fichier;
    }

    public void setFichier(MultipartFile fichier) {
        this.fichier = fichier;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public Integer getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Integer identifiant) {
        this.identifiant = identifiant;
    }

    public String getEmplacementCouverture() {
        return emplacementCouverture;
    }

    public void setEmplacementCouverture(String emplacementCouverture) {
        this.emplacementCouverture = emplacementCouverture;
    }

    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }
    
    @AssertTrue(message = "Fichier chargé invalide.")
    public boolean hasFileUploaded() {
        if (this.fichier.isEmpty()) {
            return false;
        }

        System.out.println("type de fichier : " + fichier.getContentType());
        return true;
    }

}
