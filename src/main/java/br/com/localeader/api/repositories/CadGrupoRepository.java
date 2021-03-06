/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadGrupo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
public interface CadGrupoRepository extends JpaRepository<CadGrupo, Integer> {

    CadGrupo findByIdGrupo(Integer idGrupo);
    
    CadGrupo findByDsNome(String dsNome);

}
