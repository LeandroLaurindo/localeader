/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadCliente;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadClienteService {
   CadCliente persistir(CadCliente cliente); 
   
    Optional<CadCliente> buscarPorRepresentanteLegal(Integer id);
    
    Optional<CadCliente> buscarPorVendedor(Integer id);
    
    Optional<CadCliente> buscarPorTabelaPreco(Integer id);
    
    Optional<CadCliente> buscarPorSegmento(Integer id);
    
    Optional<CadCliente> buscarPorClassificacao(Integer id);
    
    List<CadCliente>buscarPorDocumento(Integer id);
    
}
