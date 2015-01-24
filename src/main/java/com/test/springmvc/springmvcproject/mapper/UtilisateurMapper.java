/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.mapper;

import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author guillaume
 */
public class UtilisateurMapper implements RowMapper<UtilisateurBean>{

    @Override
    public UtilisateurBean mapRow(ResultSet rs, int i) throws SQLException {
        final UtilisateurBean utilisateur = new UtilisateurBean();
        
        utilisateur.setUsertag(rs.getString("usertag"));
        utilisateur.setEmail(rs.getString("email"));
        utilisateur.setPassword(rs.getString("password"));
        
        return utilisateur;
    }
    
}
