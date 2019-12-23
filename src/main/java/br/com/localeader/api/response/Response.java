/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro Laurindo
 */
public class Response<T> {

    private T data;

    private List<String> erros;

    public Response() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErros() {
        if(this.erros == null){
            this.erros = new ArrayList<>();
        }
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

}
