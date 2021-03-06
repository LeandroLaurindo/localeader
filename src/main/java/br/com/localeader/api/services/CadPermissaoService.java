/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadPermissao;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadPermissaoService {

    CadPermissao persistir(CadPermissao pessoa);

    Optional<CadPermissao> buscarPorId(Integer idPermissao);
    
    Optional<CadPermissao> buscarPorDsPermissao(String nome);

}
