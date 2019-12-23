/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.PermissaoGrupo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Leandro Laurindo
 */
public interface PermissaoGrupoService {
 
    PermissaoGrupo persistir(PermissaoGrupo permissaoGrupo);
    
     Optional<PermissaoGrupo> buscarPorIdPermGrupo(Integer idPermGrupo);
     
     List<PermissaoGrupo> listarPorFkPermissao(Integer fkPermissao);
     
     List<PermissaoGrupo> listarPorFkGrupo(Integer fkGrupo);
     
     Page<PermissaoGrupo> listarPorFkPermissao(Integer fkPermissao, PageRequest pageRequest);
     
     Page<PermissaoGrupo> listarPorFkGrupo(Integer fkGrupo,PageRequest pageRequest);
}
