/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadTelefone;
import br.com.localeader.api.repositories.CadTelefoneRepository;
import br.com.localeader.api.services.CadTelefoneService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadTelefoneServiceImpl implements CadTelefoneService{
    @Autowired
    private CadTelefoneRepository repository;

    @Override
    public CadTelefone persistir(CadTelefone telefone) {
        return this.repository.save(telefone);
    }

    @Override
    public Optional<CadTelefone> findByIdTelefone(Integer idTelefone) {
        return Optional.ofNullable(this.repository.findByIdTelefone(idTelefone));
    }

    @Override
    public Optional<CadTelefone> findByTelefone(String numero) {
        return Optional.ofNullable(this.repository.findByTelefone(numero));
    }

    @Override
    public List<CadTelefone> listarPorUsuarioFk(Integer IdUsuario) {
        return this.repository.findByUsuarioFk(IdUsuario);
    }

    @Override
    public List<CadTelefone> listarPorDocumentoFk(Integer IdDocumento) {
        return this.repository.findByDocumentoFk(IdDocumento);
    }    
    
}
