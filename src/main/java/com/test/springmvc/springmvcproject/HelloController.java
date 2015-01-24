/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.springmvc.springmvcproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author guillaume
 */
@Controller
@RequestMapping(value="/welcome")
public class HelloController {
    
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
}
