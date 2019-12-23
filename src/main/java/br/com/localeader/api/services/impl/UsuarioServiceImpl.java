/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.Usuario;
import br.com.localeader.api.repositories.UsuarioRepository;
import br.com.localeader.api.services.UsuarioService;
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
public class UsuarioServiceImpl implements UsuarioService{

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    
    @Autowired
    private UsuarioRepository repository;
    
    @Override
    public Optional<Usuario> buscaUsuarioPorLogin(String login) {
        LOG.info("BUSCANDO USUARIO");
        return Optional.ofNullable(this.repository.findByLogin(login));
    }

    @Override
    public Usuario persistir(Usuario usuario) {
      LOG.info("salvando USUARIO");
      return  this.repository.save(usuario);
    }
    
}
    