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
import com.test.springmvc.springmvcproject.services.SearchService;
import com.test.springmvc.springmvcproject.services.UtilisateurService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/{bookId}/add", method = RequestMethod.POST)
    public String addComment(@PathVariable Integer bookId, HttpSession session,
            @Valid CommentaireBean commentaire, BindingResult results) {
        if (!results.hasErrors()) {
            //on ajoute l'utilisateur
            final UtilisateurBean utilisateur = (UtilisateurBean) session.getAttribute("utilisateur");
            if (null != utilisateur) {
                commentaire.setUtilisateur(utilisateur);
            }else{
                try{
                commentaire.setUtilisateur(utilisateurService.getById(ApplicationConstants.IDENTIFIANT_ANNONYME));
                }catch(NoDataFoundException e){
                    return "redirect:/404.do";
                }
            }
            try {
                final BookBean bean = searchService.findById(bookId);
                commentaire.setLivre(bean);
            }catch(NoDataFoundException e){
                return "redirect:/404.do";
            }
            System.out.println(commentaire.getCommentaire());
        }
        return "redirect:/book/"+bookId+"/show.do";
    }

}
