/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadHabilitacao;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadHabilitacaoService {
    
    CadHabilitacao persistit(CadHabilitacao habilitacao);
    
    Optional<CadHabilitacao> buscarPorIdHabilitacao(Integer idHabilitacao);
    
    Optional<CadHabilitacao> buscarPorNumRegistro(String numRegistro);
    
    List<CadHabilitacao> listarPorDocumentoFk(Integer documentoFk);
}
