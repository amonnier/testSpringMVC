/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.mapper;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.bo.bean.CommentaireBoBean;
import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author guillaume
 */
public class CommentMapper implements RowMapper<CommentaireBoBean>{

    @Override
    public CommentaireBoBean mapRow(ResultSet rs, int i) throws SQLException {
        final CommentaireBoBean commentaire = new CommentaireBoBean();
        commentaire.setCommentaire(rs.getString("commentaire"));
        
        final UtilisateurBean utilisateur = new UtilisateurBean();
        utilisateur.setId(rs.getInt("user_id"));
        utilisateur.setUsertag(rs.getString("user_usertag"));
        commentaire.setUtilisateur(utilisateur);
        
        final BookBoBean livre = new BookBoBean();
        livre.setId(rs.getInt("livre_id"));
        commentaire.setLivre(livre);

        return commentaire;
    }
}
