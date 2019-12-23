/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.UsuarioGrupo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Leandro Laurindo
 */
public interface UsuarioGrupoService {
    
    UsuarioGrupo persistir(UsuarioGrupo usuarioGrupo);
    
    Optional<UsuarioGrupo> buscarPorIdUsuGrupo(Integer idUsuGrupo);
    
    List<UsuarioGrupo> buscarPorUsuarioFk(Integer usuarioFk);
    
    List<UsuarioGrupo> buscarPorGrupoFk(Integer grupoFk);
    
    Page<UsuarioGrupo> buscarPorGrupoFk(Integer grupoFk, PageRequest pageRequest);
}
