/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadEmail;
import br.com.localeader.api.repositories.CadEmailRepository;
import br.com.localeader.api.services.CadEmailService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadEmailServiceImpl implements CadEmailService {

    @Autowired
    private CadEmailRepository repository;

    @Override
    public CadEmail persistir(CadEmail email) {
        return this.repository.save(email);
    }

    @Override
    public Optional<CadEmail> buscarPoIdEmail(Integer email) {
        return Optional.ofNullable(this.repository.findByIdEmail(email));
    }

    @Override
    public Optional<CadEmail> buscarPoEmail(String email) {
        return Optional.ofNullable(this.repository.findByEmail(email));
    }

    @Override
    public List<CadEmail> listarPorUsuarioFk(Integer ussuarioFk) {
        return this.repository.findByUsuarioFk(ussuarioFk);
    }

}
