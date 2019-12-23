/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadHabilitacao;
import br.com.localeader.api.repositories.CadHabilitacaoRepository;
import br.com.localeader.api.services.CadHabilitacaoService;
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
public class CadHabilitacaoServiceImpl implements CadHabilitacaoService{

    @Autowired
    private CadHabilitacaoRepository repository;
    @Override
    public CadHabilitacao persistit(CadHabilitacao habilitacao) {
       return this.repository.save(habilitacao);
    }

    @Override
    public Optional<CadHabilitacao> buscarPorIdHabilitacao(Integer idHabilitacao) {
        return Optional.ofNullable(this.repository.findByIdHabilitacao(idHabilitacao));
    }

    @Override
    public Optional<CadHabilitacao> buscarPorNumRegistro(String numRegistro) {
       return Optional.ofNullable(this.repository.findByNumRegistro(numRegistro));
    }

    @Override
    public List<CadHabilitacao> listarPorDocumentoFk(Integer documentoFk) {
       return this.repository.findByDocumentoFk(documentoFk);
    }
    
    @Override
    public Page<CadHabilitacao> listarPorDocumentoFk(Integer documentoFk, PageRequest pageRequest) {
       return this.repository.findByDocumentoFk(documentoFk, pageRequest);
    }
}
