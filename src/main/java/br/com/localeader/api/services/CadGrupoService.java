/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadGrupo;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadGrupoService {
    
    CadGrupo persistir(CadGrupo grupo);
    
    Optional<CadGrupo> buscarPorIdGrupo(Integer idGrupo);
    
    Optional<CadGrupo> buscarPorDsNome(String dsNome);
    
}
