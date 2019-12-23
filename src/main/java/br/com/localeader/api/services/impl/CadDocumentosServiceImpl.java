/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadDocumentos;
import br.com.localeader.api.repositories.CadDocumentosRepository;
import br.com.localeader.api.services.CadDocumentosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadDocumentosServiceImpl implements CadDocumentosService{

    @Autowired
    private CadDocumentosRepository  repository;
    
    @Override
    public CadDocumentos persistir(CadDocumentos documentos) {
      return this.repository.save(documentos);
    }

    @Override
    public Optional<CadDocumentos> buscarPoCpf(String cpf) {
      return Optional.ofNullable(this.repository.findByCpf(cpf));
    }

    @Override
    public Optional<CadDocumentos> buscarPoCnpj(String cpf) {
    return Optional.ofNullable(this.repository.findByCnpj(cpf));
    }

    @Override
    public Optional<CadDocumentos> buscarPoUsuarioFk(Integer id) {
     return Optional.ofNullable(this.repository.findByUsuarioFk(id));
    }

    @Override
    public List<CadDocumentos> listarPorPessoa(Integer id) {
     return this.repository.findByPessoaFk(id);  
    }
    
}
