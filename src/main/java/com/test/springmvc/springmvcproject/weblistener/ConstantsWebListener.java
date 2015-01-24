/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.weblistener;

import javax.el.ELContextEvent;
import javax.el.ELContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.jsp.JspFactory;

/**
 *
 * @author guillaume
 */
//@WebListener
public class ConstantsWebListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JspFactory.getDefaultFactory().getJspApplicationContext(sce.getServletContext()).addELContextListener(
                new ELContextListener() {

                    @Override
                    public void contextCreated(ELContextEvent ece) {
                        ece.getELContext().getImportHandler()
                                .importPackage("com.test.springmvc.springmvcproject.constants");
                    }
                }
        );
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
