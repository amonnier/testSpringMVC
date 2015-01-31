/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author guillaume
 */
@Controller
@RequestMapping("book")
public class BookDetailsController {
    
    @Autowired
    private SearchService searchService;

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }
    
    @ModelAttribute("bookModel")
    public BookBean initializeModels() {
        return new BookBean();
    }

    @RequestMapping(value = "/{bookId}/show", method = RequestMethod.GET)
    public String getBookDetails(@PathVariable Integer bookId,
            @ModelAttribute("bookModel") BookBean bean, ModelMap map) {
        
        try {
            bean = searchService.findById(bookId);
            map.addAttribute("bookModel", bean);
        }catch(NoDataFoundException e){
            return "redirect:/index.do";
        }
        
        return "bookDetails";
    }
}
