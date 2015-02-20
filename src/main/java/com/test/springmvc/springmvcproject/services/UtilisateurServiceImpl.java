/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.services;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.dv.beans.RegisterBean;
import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.dao.BookDAO;
import com.test.springmvc.springmvcproject.dao.UtilisateurDAO;
import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.dv.beans.LoginBean;
import com.test.springmvc.springmvcproject.exceptions.DuplicatedEntryException;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.helpers.RegisterHelper;
import com.test.springmvc.springmvcproject.helpers.SearchHelper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author guillaume
 */
@Component
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private UtilisateurDAO utilisateurDao;
    
    @Autowired
    private BookDAO bookDAO;
   
    
    @Override
    public void create(Integer id, String email, String password) {
        utilisateurDao.create(id,email,password);
    }

    @Override
    public void create(String email, String password) {
        utilisateurDao.create(email, password);
    }

    @Override
    public void create(RegisterBean register) throws DuplicatedEntryException{
        try{
            UtilisateurBean utilisateur = RegisterHelper.mapRegisterToUtilisateur(register);
            utilisateurDao.create(utilisateur);
        }catch(DuplicatedEntryException e){
            throw e;
        }
    }

    @Override
    public UtilisateurBean get(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public UtilisateurBean get(String email) throws NoDataFoundException{
        UtilisateurBean utilisateur = null;
        try{
            utilisateur = utilisateurDao.get(email);
        }catch(NoDataFoundException e){
            throw e;
        }
        if(null==utilisateur){
            throw new NoDataFoundException("Utilisateur non trouvé");
        }
        return utilisateur;
    }
    
    @Override
    public UtilisateurBean get(final LoginBean login) throws NoDataFoundException{
        final UtilisateurBean utilisateur = RegisterHelper.mapLoginToUtilisateur(login);
        try{
            final UtilisateurBean found = utilisateurDao.get(utilisateur);
            
            if(null==found){
                throw new NoDataFoundException("Pas d'utilisateur trouve");
            }
            return found;
        }catch(NoDataFoundException e){
            throw e;
        }
    }    

    @Override
    public UtilisateurBean getById(final Integer id) throws NoDataFoundException {
        final UtilisateurBean bean;
        final List<BookBean> livresUploades;
        
        //recup utilisateur
        bean = utilisateurDao.getById(id);
        //recup livres uploades par l'utilisateur
        final List<BookBoBean> livresBoLivres = bookDAO.getByUserId(bean.getId());
        livresUploades = SearchHelper.mapListBookBoBeanToBookBean(livresBoLivres);
        
        bean.setListeLivres(livresUploades);
        
        return bean;
    }
    
}
