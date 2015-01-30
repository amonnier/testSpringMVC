/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dv.beans;

import java.util.List;

/**
 *
 * @author guillaume
 */
public class SearchBean {
    private String recherche;
    private List<BookBean> resultat;

    public String getRecherche() {
        return recherche;
    }

    public void setRecherche(String recherche) {
        this.recherche = recherche;
    }

    public List<BookBean> getResultat() {
        return resultat;
    }

    public void setResultat(List<BookBean> resultat) {
        this.resultat = resultat;
    }
    
}
