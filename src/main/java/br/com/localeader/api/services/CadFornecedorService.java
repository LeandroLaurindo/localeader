/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadFornecedor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadFornecedorService {

    CadFornecedor persistir(CadFornecedor fornecedor);
    
    CadFornecedor remover(CadFornecedor fornecedor);
    
    Optional<CadFornecedor> buscarPorId(Integer idFornecedor);
    
    List<CadFornecedor> listarTodos();
}
