/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadFuncionarios;
import br.com.localeader.api.repositories.CadFuncionariosRepository;
import br.com.localeader.api.services.CadFuncionariosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadFuncionariosServiceImpl implements CadFuncionariosService {
    
    @Autowired
    private CadFuncionariosRepository funcionariosRepository;
    
    @Override
    public Optional<CadFuncionarios> buscarPorId(Integer idFuncionario) {
       return Optional.ofNullable(this.funcionariosRepository.findByIdFuncionario(idFuncionario));
    }
    
    @Override
    public List<CadFuncionarios> listarTodos() {
       return this.funcionariosRepository.findAll();
    }
    
    @Override
    public CadFuncionarios persistir(CadFuncionarios cadFuncionarios) {
        return this.funcionariosRepository.save(cadFuncionarios);
    }
    
    @Override
    public CadFuncionarios remover(CadFuncionarios cadFuncionarios) {
        this.funcionariosRepository.delete(cadFuncionarios);
        return new CadFuncionarios();
    }
    
}
