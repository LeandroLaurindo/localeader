/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadGrupo;
import br.com.localeader.api.model.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
public interface CadGrupoRepository extends CrudRepository<CadGrupo, Integer> {

    CadGrupo findByIdGrupo(Integer idGrupo);
    
    CadGrupo findByDsNome(String dsNome);
    
}
