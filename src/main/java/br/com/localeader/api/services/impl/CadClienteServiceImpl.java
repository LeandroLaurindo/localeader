/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadCliente;
import br.com.localeader.api.repositories.CadClienteRepository;
import br.com.localeader.api.services.CadClienteService;
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
public class CadClienteServiceImpl implements CadClienteService{

    @Autowired
    private CadClienteRepository repository;
    
    @Override
    public CadCliente persistir(CadCliente cliente) {
      return this.repository.save(cliente);
    }

    @Override
    public Optional<CadCliente> buscarPorRepresentanteLegal(Integer id) {
       return Optional.ofNullable(this.repository.findByRepresentanteLegalFk(id));
    }

    @Override
    public Optional<CadCliente> buscarPorVendedor(Integer id) {
     return Optional.ofNullable(this.repository.findByVendedorFk(id));
    }

    @Override
    public Optional<CadCliente> buscarPorTabelaPreco(Integer id) {
    return Optional.ofNullable(this.repository.findByTabelaPrecoFk(id));    
    }

    @Override
    public Optional<CadCliente> buscarPorSegmento(Integer id) {
    return Optional.ofNullable(this.repository.findBySegmentoFk(id));   
    }

    @Override
    public Optional<CadCliente> buscarPorClassificacao(Integer id) {
    return Optional.ofNullable(this.repository.findByClassificacaoFk(id));  
    }

    @Override
    public List<CadCliente> buscarPorDocumento(Integer id) {
     return this.repository.findByDocumentoFk(id);
    }
    
    @Override
    public Page<CadCliente> buscarPorDocumento(Integer id, PageRequest pageRequest){
     return this.repository.findByDocumentoFk(id, pageRequest);
    }
}
