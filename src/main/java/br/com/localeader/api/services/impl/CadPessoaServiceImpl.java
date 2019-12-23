/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadPessoa;
import br.com.localeader.api.repositories.CadPessoaRepository;
import br.com.localeader.api.services.CadPessoaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadPessoaServiceImpl implements CadPessoaService {

    @Autowired
    private CadPessoaRepository repository;

    @Override
    public CadPessoa persistir(CadPessoa pessoa) {
        return this.repository.save(pessoa);
    }

    @Override
    public Optional<CadPessoa> buscarPorNome(String nome) {
        return Optional.ofNullable(this.repository.findByNome(nome));
    }

    @Override
    public Optional<CadPessoa> buscarPorRazaoSocial(String razao) {
        return Optional.ofNullable(this.repository.findByRazaoSocial(razao));
    }

    @Override
    public Optional<CadPessoa> buscarPorIdPessoa(Integer idPessoa) {
       return Optional.ofNullable(this.repository.findByIdPessoa(idPessoa));
    }

    @Override
    public List<CadPessoa> listarPorUsuarioFk(Integer usuarioFk) {
       return this.repository.findByUsuarioFk(usuarioFk);
    }

}
