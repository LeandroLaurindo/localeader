/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadPermissao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
public interface CadPermissaoReposirory extends JpaRepository<CadPermissao, Integer> {

    CadPermissao findByIdPermissao(Integer idPermissao);
    
    CadPermissao findByDsPermissao(String dsPermissao);
}
