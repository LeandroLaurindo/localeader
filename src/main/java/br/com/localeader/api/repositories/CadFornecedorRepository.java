/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
@Transactional(readOnly = true)
public interface CadFornecedorRepository extends JpaRepository<CadFornecedor, Integer> {
    
    CadFornecedor findByIdFornecedor(Integer idFornecedor);    
    
}
