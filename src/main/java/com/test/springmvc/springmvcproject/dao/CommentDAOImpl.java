/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dao;

import com.test.springmvc.springmvcproject.bo.bean.CommentaireBoBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.mapper.CommentMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guillaume
 */
@Repository
public class CommentDAOImpl extends JdbcDaoSupport implements CommentDAO {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<CommentaireBoBean> getByBookId(Integer id) throws NoDataFoundException {
        List<CommentaireBoBean> commentaires;
        final String sql = "select cul.*,  u.id AS user_id,"
                + " u.usertag as user_usertag,"
                + " l.id as livre_id "
                + "from commentaire_utilisateur_livre cul" 
                + " join livre l on cul.id_livre = l.id " 
                + " join utilisateur u on cul.id_utilisateur = u.id "
                + "where cul.id_livre = ? "
                + "order by cul.date_commentaire DESC";

        try {
            commentaires = getJdbcTemplate().query(sql, new Object[]{id}, new CommentMapper());
        } catch (DataAccessException e) {
            commentaires = new ArrayList<CommentaireBoBean>();
//            throw new NoDataFoundException("Pas de commentaires pour ce livre.");
        }

        return commentaires;
    }

    @Override
    public void save(CommentaireBoBean bean) {
        final String sql = "insert into commentaire_utilisateur_livre"
                + "(id_utilisateur,id_livre,commentaire,date_commentaire) values (?,?,?,?)";
        
        getJdbcTemplate().update(sql, bean.getUtilisateur().getId(),
                bean.getLivre().getId(),
                bean.getCommentaire(),bean.getDate_commentaire());
    }
    
    

}
