/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadEndereco;
import br.com.localeader.api.repositories.CadEnderecoRepository;
import br.com.localeader.api.services.CadEnderecoService;
import java.util.List;
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
public class CadEnderecoServiceImpl implements CadEnderecoService{
    
    private static final Logger LOG =  LoggerFactory.getLogger(CadEnderecoServiceImpl.class);
    
    @Autowired
    private CadEnderecoRepository repository;
    
    @Override
    public CadEndereco persistir(CadEndereco endereco) {
        LOG.info("Salvando endereco : {}" + endereco);
       return this.repository.save(endereco);
    }

    @Override
    public Optional<CadEndereco> buscarPorIdEndereco(Integer id) {
     return  Optional.ofNullable(this.repository.findByIdEndereco(id));
    }

    @Override
    public List<CadEndereco> listarPorUsuarioFk(Integer usuarioFk) {
        return this.repository.findByUsuarioFk(usuarioFk);
    }

    @Override
    public List<CadEndereco> listarPorDocumentoFk(Integer documentoFk) {
        return this.repository.findByDocumentoFk(documentoFk);
    }
    
}
