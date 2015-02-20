/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.dv.beans.CommentaireBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.services.SearchService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
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
    public BookBean initializeBookModels() {
        return new BookBean();
    }
    
    @ModelAttribute("commentaireBean")
    public CommentaireBean initializeCommentaireModels(){
        return new CommentaireBean();
    }

    @RequestMapping(value = "/{bookId}/show", method = RequestMethod.GET)
    public String getBookDetails(@PathVariable Integer bookId,
            @ModelAttribute("bookModel") BookBean bean, ModelMap map) {

        try {
            bean = searchService.findById(bookId);
            map.addAttribute("bookModel", bean);
        } catch (NoDataFoundException e) {
            return "redirect:/index.do";
        }

        return "bookDetails";
    }

    @RequestMapping(value = "/{bookId}/get", method = RequestMethod.GET)
    public void getBook(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer bookId, @ModelAttribute("bookModel") BookBean bean) {
        try {
            final BookBean found = searchService.findById(bookId);
            final String url_totale_to_book = request.getServletContext().getRealPath(
                    found.getEmplacement().replaceAll(request.getContextPath(), ""));
            try {
                InputStream stream = new FileInputStream(url_totale_to_book);
                System.out.println(stream.toString());
                response.setHeader("Content-Disposition", "attachment;filename="+found.getNomLivre());
                IOUtils.copy(stream, response.getOutputStream());
            } catch (FileNotFoundException e ) {
            } catch (IOException e ) {
            }
        } catch (NoDataFoundException e) {
        }
    }
}
