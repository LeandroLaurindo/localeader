/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadCliente;
import br.com.localeader.api.model.CadEndereco;
import java.util.List;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
@Transactional(readOnly = true)
public interface CadEnderecoRepository extends JpaRepository<CadEndereco, Integer> {
    
    CadEndereco findByIdEndereco(Integer id);
    
    List<CadEndereco> findByUsuarioFk(Integer usuarioFk);

    Page<CadEndereco> findByUsuarioFk(Integer usuarioFk, Pageable pageable);

    List<CadEndereco> findByDocumentoFk(Integer documentoFk);

    Page<CadEndereco> findByDocumentoFk(Integer integer, Pageable pageable);
}
