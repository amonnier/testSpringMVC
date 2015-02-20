/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.services.UtilisateurService;
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
@RequestMapping("user")
public class ProfileController {

    @Autowired
    private UtilisateurService utilisateurService;

    public UtilisateurService getUserService() {
        return utilisateurService;
    }

    public void setUserService(UtilisateurService userService) {
        this.utilisateurService = userService;
    }
    
    @ModelAttribute("user")
    public UtilisateurBean initializeUser(){
        
        return new UtilisateurBean();
    }

    @RequestMapping(value = "/{userId}/show", method = RequestMethod.GET)
    public String showProfile(@PathVariable Integer userId, @ModelAttribute("user") UtilisateurBean bean,
            final ModelMap map) {
        //si on essaie d'accéder à l'utilisateur 2, impossible = compte anonyme, on redigire à l'accueil
        if(2 == userId){
            return "redirect:/index.do";
        }
        try{
        //recup utilisateur
        bean = utilisateurService.getById(userId);
        map.addAttribute("user",bean);
        }catch(NoDataFoundException e){
            return "redirect:/index.do";
        }
        return "/profile/show";
    }
}
