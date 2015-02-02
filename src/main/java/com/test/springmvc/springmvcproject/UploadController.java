/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.exceptions.BookAlreadyExistsException;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.services.UploadService;
import com.test.springmvc.springmvcproject.services.UtilisateurService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author guillaume
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService service;

    @Autowired
    private UtilisateurService utilisateurService;

    public UploadService getService() {
        return service;
    }

    public void setService(UploadService service) {
        this.service = service;
    }

    public UtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getInitial(HttpSession session, ModelMap model) {
        final BookBean book = new BookBean();
        model.addAttribute("bookBean", book);
        return "upload/newBook";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addNewBook(final javax.servlet.http.HttpServletRequest request, @Valid BookBean bean, BindingResult result,
            ModelMap map, final HttpSession session) {
        if (result.hasErrors()) {
            return "upload/newBook";
        }
        final String contextRoot = request.getServletContext().getRealPath("");
        final String dossier_uploads = "uploads";
        final String url_to_book = contextRoot + "/" + dossier_uploads
                + "/" + bean.getAuteur();
        final String url_finale_livre = url_to_book + "/" + bean.getFichier().getOriginalFilename();
        final String url_finale_couverture = url_to_book+ "/" + bean.getCouverture().getOriginalFilename();
        //on ajoute l'emplacement final au bean book
        bean.setEmplacement(url_finale_livre);
        bean.setEmplacementCouverture(url_finale_couverture);
        final File livre = new File(url_finale_livre);
        final File couverture = new File(url_finale_couverture);
        try {
            livre.getParentFile().mkdirs();
            bean.getFichier().transferTo(livre);
            bean.getCouverture().transferTo(couverture);

            //recuperation de l'utilisateur
            UtilisateurBean utilisateur = (UtilisateurBean) session.getAttribute("utilisateur");
            //si pas d'utilisateur, on recupere l'anonyme
            if (null == utilisateur) {
                try {
                    utilisateur = utilisateurService.get("anonyme@anonyme.com");
                } catch (NoDataFoundException e) {
                    result.addError(new FieldError("BookBean", "fichier", "Une erreur interne est apparue."));
                }
            }
            //creation entree en base
            try {
                service.createEntry(bean, utilisateur);
            } catch (BookAlreadyExistsException e) {
                result.addError(new FieldError("BookBean", "fichier", "Livre deja existant"));
                return "upload/newBook";
            }
        } catch (IOException e) {
            result.addError(new FieldError("BookBean", "fichier", "Une erreur est survenue lors du transfert." + e.getMessage()));
            return "upload/newBook";
        }

        return "redirect:/index.do";
    }
}
