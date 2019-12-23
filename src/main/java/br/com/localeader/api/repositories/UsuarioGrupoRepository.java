/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.UsuarioGrupo;
import java.util.List;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
@Transactional(readOnly = true)
public interface UsuarioGrupoRepository extends CrudRepository<UsuarioGrupo, Integer> {
    
    UsuarioGrupo findByIdUsuGrupo(Integer idUsuGrupo);
    
    List<UsuarioGrupo> findByUsuarioFk(Integer usuarioFk);

    Page<UsuarioGrupo> findByUsuarioFk(Integer usuarioFk, Pageable pageable);

    List<UsuarioGrupo> findByGrupoFk(Integer grupoFk);

    Page<UsuarioGrupo> findByGrupoFk(Integer grupoFk, Pageable pageable);
}
