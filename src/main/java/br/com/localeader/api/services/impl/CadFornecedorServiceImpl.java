/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadFornecedor;
import br.com.localeader.api.repositories.CadFornecedorRepository;
import br.com.localeader.api.services.CadFornecedorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadFornecedorServiceImpl implements CadFornecedorService {

    @Autowired
    private CadFornecedorRepository fornecedorRepository;

    @Override
    public Optional<CadFornecedor> buscarPorId(Integer idFornecedor) {
        return Optional.ofNullable(this.fornecedorRepository.findByIdFornecedor(idFornecedor));
    }


    @Override
    public List<CadFornecedor> listarTodos() {
        return this.fornecedorRepository.findAll();
    }

    @Override
    public CadFornecedor persistir(CadFornecedor fornecedor) {
        return this.fornecedorRepository.save(fornecedor);
    }

    @Override
    public CadFornecedor remover(CadFornecedor fornecedor) {
      this.fornecedorRepository.delete(fornecedor);
      return new CadFornecedor();
    }

}
