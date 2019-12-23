/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadPermissao;
import br.com.localeader.api.repositories.CadPermissaoReposirory;
import br.com.localeader.api.services.CadPermissaoService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadPermissaoServiceImpl implements CadPermissaoService{
    
    private static final Logger LOG =  LoggerFactory.getLogger(CadPermissaoServiceImpl.class);
    
    @Autowired
    private CadPermissaoReposirory repository;
    
    @Override
    public CadPermissao persistir(CadPermissao permissao) {
        LOG.info("Salvando permissao : {}" + permissao);
       return this.repository.save(permissao);
    }

    @Override
    public Optional<CadPermissao> buscarPorDsPermissao(String nome) {
      return Optional.ofNullable(this.repository.findByDsPermissao(nome));
    }

    @Override
    public Optional<CadPermissao> buscarPorId(Integer id) {
        return Optional.ofNullable(this.repository.findByIdPermissao(id));
    }

   
    
}
