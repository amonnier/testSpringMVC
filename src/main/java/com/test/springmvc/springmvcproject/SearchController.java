/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.dv.beans.SearchBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.services.SearchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author guillaume
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    @ModelAttribute("searchBean")
    public SearchBean initialize(@RequestParam String recherche) {
        SearchBean bean = new SearchBean();
        bean.setRecherche(recherche);

        return bean;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getResult(@ModelAttribute("searchBean") SearchBean bean, ModelMap map) {
        System.out.println("It works !");
        System.out.println("recherche : " + bean.getRecherche());
        List<BookBean> resultat;
        try {
           resultat = searchService.findByTitleLike(bean.getRecherche());
           bean.setResultat(resultat);
        }catch(NoDataFoundException e){
            return "";
        }
        return "results";
    }
}
