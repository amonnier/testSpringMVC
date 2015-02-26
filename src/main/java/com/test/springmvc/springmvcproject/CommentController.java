/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.constants.ApplicationConstants;
import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.dv.beans.CommentaireBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.services.CommentaireService;
import com.test.springmvc.springmvcproject.services.SearchService;
import com.test.springmvc.springmvcproject.services.UtilisateurService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private CommentaireService commentaireService;

    @RequestMapping(value = "/{bookId}/add", method = RequestMethod.POST)
    public String addComment(@PathVariable Integer bookId, HttpSession session,
            @Valid CommentaireBean commentaire, BindingResult results) {
        if (!results.hasErrors()) {
            //on ajoute l'utilisateur
            final UtilisateurBean utilisateur = (UtilisateurBean) session.getAttribute("utilisateur");
            if (null != utilisateur) {
                commentaire.setUtilisateur(utilisateur);
            } else {
                try {
                    commentaire.setUtilisateur(utilisateurService.getById(ApplicationConstants.IDENTIFIANT_ANNONYME));
                } catch (NoDataFoundException e) {
                    return "redirect:/404.do";
                }
            }
            try {
                final BookBean bean = searchService.findById(bookId);
                commentaire.setLivre(bean);
            } catch (NoDataFoundException e) {
                return "redirect:/404.do";
            }
            System.out.println(commentaire.getCommentaire());
            commentaireService.save(commentaire);
        }
        return "redirect:/book/" + bookId + "/show.do";
    }

    @RequestMapping(value = "/ajax/{bookId}/add", method = RequestMethod.POST)
    public ModelMap addCommentAjax(@PathVariable Integer bookId, @RequestParam String commentaireContent,
            @ModelAttribute("commentaireBean") CommentaireBean commentaire,HttpSession session
            ,HttpServletRequest request, ModelMap model) {
        commentaire.setCommentaire(commentaireContent);
        //on ajoute l'utilisateur
        final UtilisateurBean utilisateur = (UtilisateurBean) session.getAttribute("utilisateur");
        if (null != utilisateur) {
            commentaire.setUtilisateur(utilisateur);
        } else {
            try {
                commentaire.setUtilisateur(utilisateurService.getById(
                        ApplicationConstants.IDENTIFIANT_ANNONYME));
            } catch (NoDataFoundException e) {
            }
        }
        try {
            final BookBean bean = searchService.findById(bookId);
            commentaire.setLivre(bean);
        } catch (NoDataFoundException e) {
        }
        commentaireService.save(commentaire);
        model.addAttribute("bookModel", new BookBean());
        return model;
    }

}
