/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro Laurindo
 */
@RestController("/")
public class MainController {
    
    public String index() {
        return "index";
    }
    
}
