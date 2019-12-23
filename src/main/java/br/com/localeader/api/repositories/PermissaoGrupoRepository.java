/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.PermissaoGrupo;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
@Transactional(readOnly = true)

public interface PermissaoGrupoRepository extends CrudRepository<PermissaoGrupo, Integer> {
   
    PermissaoGrupo findByIdPermGrupo(Integer idPermGrupo);
    
    List<PermissaoGrupo> findByFkPermissao(Integer fkPermissao);

    Page<PermissaoGrupo> findByFkPermissao(Integer fkPermissao, Pageable pageable);

    List<PermissaoGrupo> findByFkGrupo(Integer fkGrupo);

    Page<PermissaoGrupo> findByFkGrupo(Integer fkGrupo, Pageable pageable);
}
