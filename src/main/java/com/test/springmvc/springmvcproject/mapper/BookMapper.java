/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.mapper;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author guillaume
 */
public class BookMapper implements RowMapper<BookBoBean>{
    @Override
    public BookBoBean mapRow(ResultSet rs, int i) throws SQLException {
        final BookBoBean bean = new BookBoBean();
        bean.setAuteur(rs.getString("auteur"));
        bean.setDescription(rs.getString("description"));
        bean.setTitre(rs.getString("titre"));
        bean.setEmplacement(rs.getString("emplacement"));
        
        final UtilisateurBean uploader = new UtilisateurBean();
        uploader.setEmail(rs.getString("email"));
        uploader.setPassword(rs.getString("password"));
        uploader.setUsertag(rs.getString("usertag"));
        
        bean.setUploader(uploader);
        
        return bean;
    }
}
