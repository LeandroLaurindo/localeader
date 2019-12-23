/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.UsuarioGrupo;
import br.com.localeader.api.repositories.UsuarioGrupoRepository;
import br.com.localeader.api.services.UsuarioGrupoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class UsuarioGrupoServiceImpl implements UsuarioGrupoService{

    @Autowired
    private UsuarioGrupoRepository repository;
    
    @Override
    public UsuarioGrupo persistir(UsuarioGrupo usuarioGrupo) {
        return this.repository.save(usuarioGrupo);
     }

    @Override
    public Optional<UsuarioGrupo> buscarPorIdUsuGrupo(Integer idUsuGrupo) {
        return Optional.ofNullable(this.repository.findByIdUsuGrupo(idUsuGrupo));
    }

    @Override
    public List<UsuarioGrupo> buscarPorUsuarioFk(Integer usuarioFk) {
       return this.repository.findByUsuarioFk(usuarioFk);
    }

    @Override
    public List<UsuarioGrupo> buscarPorGrupoFk(Integer grupoFk) {
        return this.repository.findByGrupoFk(grupoFk);
    }
    
}
