/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dao;

import com.test.springmvc.springmvcproject.bo.bean.BookBoBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.mapper.BookMapper;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guillaume
 */
@Repository
public class BookDAOImpl extends JdbcDaoSupport implements BookDAO {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void create(BookBoBean bean) {
        final String query = " insert into livre(uploader, titre, auteur,description, emplacement,emplacement_couverture) "
                + "values (?,?,?,?,?,?)";

        getJdbcTemplate().update(query,
                bean.getUploader().getId(), bean.getTitre(),
                bean.getAuteur(),
                bean.getDescription(),
                bean.getEmplacement(),
                bean.getEmplacementCouverture());
    }

    @Override
    public List<BookBoBean> getByTitreLike(String titre) throws NoDataFoundException {
        final String query = "select "
                + "livre.*, "
                + "utilisateur.usertag, "
                + "utilisateur.email, "
                + "utilisateur.password "
                + "from livre "
                + "join utilisateur "
                + "on utilisateur.id = livre.uploader "
                + "where UPPER(livre.titre) like UPPER(?)";
        List<BookBoBean> listeLivres = null;

        final String titreAvecPcents = "%" + titre + "%";
        try {
            listeLivres = getJdbcTemplate().query(query, new Object[]{titreAvecPcents}, new BookMapper());
        } catch (EmptyResultDataAccessException e) {

            throw new NoDataFoundException("Aucun livre trouvé pour ce titre");
        }
        return listeLivres;
    }

    @Override
    public List<BookBoBean> getByAuteur(String auteur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BookBoBean getById(Integer id) throws NoDataFoundException{
        final String sql = "select livre.*, "
                + "utilisateur.usertag, "
                + "utilisateur.email, "
                + "utilisateur.password "
                + "from livre "
                + "join utilisateur "
                + "on utilisateur.id = livre.uploader "
                + "where livre.id = ?";

        final BookBoBean bobean;
        try{
            bobean = getJdbcTemplate().queryForObject(sql, new Object[]{id}, new BookMapper());
        }catch(EmptyResultDataAccessException e){
            throw new NoDataFoundException("Pas de données trouvées");
        }
        
        return bobean;
    }

}
