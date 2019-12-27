/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadVendedor;
import br.com.localeader.api.repositories.CadVendedorRepository;
import br.com.localeader.api.services.CadVendedorService;
import br.com.localeader.api.services.CadVendedorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadVendedorServiceImpl implements CadVendedorService {

    @Autowired
    private CadVendedorRepository vendedorRepository;

    @Override
    public Optional<CadVendedor> buscarPorId(Integer idVendedor) {
        return Optional.ofNullable(this.vendedorRepository.findByIdVendedor(idVendedor));
    }

    @Override
    public List<CadVendedor> listarTodos() {
        return this.vendedorRepository.findAll();
    }

    @Override
    public CadVendedor persitir(CadVendedor cadVendedor) {
        return this.vendedorRepository.save(cadVendedor);
    }

    @Override
    public CadVendedor remover(CadVendedor cadVendedor) {
        this.vendedorRepository.delete(cadVendedor);
        return new CadVendedor();
    }

}
