/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadServicos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadServicosService {
    
    
    CadServicos persistir(CadServicos cadServicos);
    
    CadServicos remover(CadServicos cadServicos);
    
    Optional<CadServicos> buscarPorId(Integer idServico);
    
    Optional<CadServicos> buscarPorNomeServico(String servico);
    
    Optional<CadServicos> buscarPorCodServico(Integer codigoServico);
    
    Optional<CadServicos> buscarPorTipoServico(String tipoServico);

    Optional<CadServicos> buscarPorDescricao(String descricao);
    
     List<CadServicos> listarTodos();
}
