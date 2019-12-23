/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.PermissaoGrupo;
import br.com.localeader.api.repositories.PermissaoGrupoRepository;
import br.com.localeader.api.services.PermissaoGrupoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class PermissaoGrupoServiceImpl implements PermissaoGrupoService{

    @Autowired
    private PermissaoGrupoRepository repository;
    @Override
    public PermissaoGrupo persistir(PermissaoGrupo permissaoGrupo) {
      return this.repository.save(permissaoGrupo);
    }

    @Override
    public Optional<PermissaoGrupo> buscarPorIdPermGrupo(Integer idPermGrupo) {
        return Optional.ofNullable(this.repository.findByIdPermGrupo(idPermGrupo));
    }

    @Override
    public List<PermissaoGrupo> listarPorFkPermissao(Integer fkPermissao) {
        return this.repository.findByFkPermissao(fkPermissao);
    }

    @Override
    public List<PermissaoGrupo> listarPorFkGrupo(Integer fkGrupo) {
        return this.repository.findByFkGrupo(fkGrupo);
    }

    @Override
    public Page<PermissaoGrupo> listarPorFkPermissao(Integer fkPermissao, PageRequest pageRequest) {
       return this.repository.findByFkPermissao(fkPermissao, pageRequest);
    }

    @Override
    public Page<PermissaoGrupo> listarPorFkGrupo(Integer fkGrupo, PageRequest pageRequest) {
       return this.repository.findByFkGrupo(fkGrupo, pageRequest);
    }
    
}
