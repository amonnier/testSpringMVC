/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import com.test.springmvc.springmvcproject.dv.beans.BookBean;
import com.test.springmvc.springmvcproject.exceptions.NoDataFoundException;
import com.test.springmvc.springmvcproject.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author guillaume
 */
@Controller
@RequestMapping(value="/welcome")
public class HelloController {
    
    @Autowired
    private SearchService service;
    
    @RequestMapping(value="/print",method = RequestMethod.GET)
    public String printWelcome(ModelMap model){
        model.addAttribute("message","Hello from spring MVC !");
        return "hello";
    }
    
    @RequestMapping(value="/SayHello", method= RequestMethod.GET)
    public String sayHelloToUser(ModelMap model){
        model.addAttribute("helloMessage","Hello you !");
        return "sayHello";
    }
    
    @RequestMapping("/book")
    public @ResponseBody BookBean getBeans(@RequestParam Integer id){
        System.out.println("id"+id);
        try{
            return service.findById(id);
        }catch(NoDataFoundException e){
            return new BookBean();
        }
    }
}
