/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject.exceptions;

/**
 *
 * @author guillaume
 */
public class DuplicatedEntryException extends Exception{
    
    final String message;
    public DuplicatedEntryException(String message){
        this.message = message;
    }
    
    @Override
    public String getMessage(){
        return this.message;
    }
    
}
