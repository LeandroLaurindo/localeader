/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadFuncionarios;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadFuncionariosRepository extends JpaRepository<CadFuncionarios, Integer> {
    
    CadFuncionarios findByIdFuncionario(Integer idFuncionario);
   
}
