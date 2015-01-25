/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import com.test.springmvc.springmvcproject.dv.beans.RegisterBean;
import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.dv.beans.LoginBean;
import com.test.springmvc.springmvcproject.exceptions.DuplicatedEntryException;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.services.UtilisateurService;
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
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UtilisateurService utilisateurService;

    public UtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String connexion(@Valid LoginBean loginbean,
            BindingResult result, HttpSession session, ModelMap model) {
        try {
            final UtilisateurBean utilisateur = utilisateurService.get(loginbean);
            if (utilisateur != null) {
                session.setAttribute("IsConnected", true);
                session.setAttribute("utilisateur", utilisateur);
                return "index";
            } else {
                throw new NoDataFoundException("Utilisateur non trouvé !");
            }
        } catch (NoDataFoundException e) {
            result.addError(new FieldError("LoginBean", "email", e.getMessage()));
            return "index";
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getIndex(ModelMap model) {
        LoginBean loginbean = new LoginBean();
        model.addAttribute("loginBean", loginbean);
        return "index";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(ModelMap model) {

        RegisterBean rb = new RegisterBean();

        model.addAttribute("registerBean", rb);

        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(HttpSession session, ModelMap model,
            @Valid RegisterBean bean,
            BindingResult result) {

        if (!result.hasErrors()) {
            System.out.println("Pas d'erreurs !!");
            session.setAttribute("email_utilisateur", bean.getEmail());
            try {
                utilisateurService.create(bean);
            } catch (DuplicatedEntryException e) {
                result.addError(new FieldError("RegisterBean", "email", e.getMessage()));
                return "register";
            }
        } else {
            System.out.println("erreur presentes dans la validation : " + result.toString());
            return "register";
        }

        return "redirect:/index.do";
    }

    @RequestMapping(value = "invalidate", method = RequestMethod.GET)
    public String invalidateSession(HttpSession session, ModelMap map) {

        session.invalidate();
        return "redirect:/index.do";
    }
}
