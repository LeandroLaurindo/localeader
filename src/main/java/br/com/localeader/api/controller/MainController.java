/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Leandro Laurindo
 */
@RestController
@CrossOrigin
public class MainController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/user" , method = RequestMethod.GET)
    public ModelAndView userIndex() {
        return new ModelAndView("user/index");
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }
    
    @RequestMapping(value = "/access-denied" , method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("/error/access-denied");
    }
}
