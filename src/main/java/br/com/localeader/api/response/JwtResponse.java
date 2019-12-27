/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.response;

import java.io.Serializable;

/**
 *
 * @author Leandro Laurindo
 */
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -6208435932765165772L;

    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getJwttoken() {
        return jwttoken;
    }

}
