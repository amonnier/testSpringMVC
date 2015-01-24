/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.dao;

import com.test.springmvc.springmvcproject.bo.bean.UtilisateurBean;
import com.test.springmvc.springmvcproject.exceptions.DuplicatedEntryException;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.mapper.UtilisateurMapper;
import javax.sql.DataSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author guillaume
 */
//@Service
public class UtilisateurDAOImpl implements UtilisateurDAO {

    private DataSource dataSource;
    private JdbcTemplate template;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.template = new JdbcTemplate(ds);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void create(Integer id, String email, String password) {
        final String sql = "insert into utilisateur(id,email,password) values(?,?,?)";
        template.update(sql, id, email, password);
    }

    @Override
    public void create(String email, String password) {
        final String sql = "insert into utilisateur(email,password) values(?,?)";
        template.update(sql, email, password);
    }

    @Override
    public UtilisateurBean get(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UtilisateurBean get(String email) throws NoDataFoundException{
        final String sql = "select * from utilisateur where email=?";
        try {
            final UtilisateurBean found = template.queryForObject(sql,
                    new Object[]{email}, new UtilisateurMapper());

            return found;
        } catch (EmptyResultDataAccessException e) {
            throw new NoDataFoundException("Utilisateur non trouvé !");
        }

    }

    @Override
    public UtilisateurBean get(final UtilisateurBean utilisateur) throws NoDataFoundException {
        final String sql = "select * from utilisateur where email=? and password=?";
        try {
            final UtilisateurBean found = template.queryForObject(sql,
                    new Object[]{utilisateur.getEmail(), utilisateur.getPassword()}, new UtilisateurMapper());

            return found;
        } catch (EmptyResultDataAccessException e) {
            throw new NoDataFoundException("Utilisateur non trouvé !");
        }
    }

    @Override
    public void create(final UtilisateurBean utilisateur) throws DuplicatedEntryException {

        final String sql = "insert into utilisateur("
                + "usertag, email, password"
                + ")"
                + "values (?,?,?)";

        try {
            template.update(sql, utilisateur.getUsertag(), utilisateur.getEmail(), utilisateur.getPassword());
        } catch (DuplicateKeyException e) {
            throw new DuplicatedEntryException("Adresse email deja existante !");
        }
    }

}
