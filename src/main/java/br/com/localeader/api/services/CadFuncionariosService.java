/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadFuncionarios;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadFuncionariosService {
    
    CadFuncionarios persistir(CadFuncionarios cadFuncionarios);
    
    CadFuncionarios remover(CadFuncionarios cadFuncionarios);
    
    Optional<CadFuncionarios> buscarPorId(Integer idFuncionario);
    
    List<CadFuncionarios> listarTodos();
}
