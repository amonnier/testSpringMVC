/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.constants;

/**
 *
 * @author guillaume
 */
public class MappingConstants {
    public static final String MAPPING_REGISTER = "/index/register";
    public static final String MAPPING_UPLOAD = "/upload";
    public static final String SUFFIXE_ACTION = ".do";
    
    public final static String ACTION_REGISTER = MAPPING_REGISTER+SUFFIXE_ACTION;
    public static final String ACTION_UPLOAD = MAPPING_UPLOAD+SUFFIXE_ACTION;
}
