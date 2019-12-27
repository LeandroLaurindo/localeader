/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadEmail;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadEmailService {
    /**
     * 
     * @param email
     * @return 
     */
    CadEmail persistir(CadEmail email);
    
    Optional<CadEmail> buscarPoIdEmail(Integer email);
    
    Optional<CadEmail> buscarPoEmail(String email);
    
    List<CadEmail> listarPorUsuarioFk(Integer usuarioFk);
    
    Page<CadEmail> listarPorUsuarioFk(Integer usuarioFk, PageRequest pageRequest);
}
