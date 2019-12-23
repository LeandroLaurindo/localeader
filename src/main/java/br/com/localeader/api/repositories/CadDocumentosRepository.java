/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadDocumentos;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
@Transactional(readOnly = true)

public interface CadDocumentosRepository extends JpaRepository<CadDocumentos, Integer> {

    CadDocumentos findByCnpj(String cnpj);
    
    CadDocumentos findByCpf(String cpf);
    
    CadDocumentos findByUsuarioFk(Integer usuarioFk);

    List<CadDocumentos> findByPessoaFk(Integer pessoaFk);

    Page<CadDocumentos> findByPessoaFk(Integer pessoaFk, Pageable pageable);
}
