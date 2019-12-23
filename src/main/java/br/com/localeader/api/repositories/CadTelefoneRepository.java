/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadTelefone;
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
public interface CadTelefoneRepository extends JpaRepository<CadTelefone, Integer> {

    CadTelefone findByIdTelefone(Integer idTelefone);

    CadTelefone findByTelefone(String telefone);

    List<CadTelefone> findByUsuarioFk(Integer usuarioFk);

    Page<CadTelefone> findByUsuarioFk(Integer usuarioFk, Pageable pageable);

    List<CadTelefone> findByDocumentoFk(Integer documentoFk);

    Page<CadTelefone> findByDocumentoFk(Integer documentoFk, Pageable pageable);

}
