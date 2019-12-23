/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadCliente;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
public interface CadClienteRepository extends JpaRepository<CadCliente, Integer> {

    CadCliente findByRepresentanteLegalFk(Integer representanteLegalFk);

    CadCliente findByVendedorFk(Integer vendedorFk);

    CadCliente findByTabelaPrecoFk(Integer tabelaPrecoFk);

    CadCliente findBySegmentoFk(Integer segmentoFk);
    
    CadCliente findByClassificacaoFk(Integer classificacaoFk);

    List<CadCliente> findByDocumentoFk(Integer documentoFk);

    Page<CadCliente> findByDocumentoFk(Integer documentoFk, Pageable pageable);

}
