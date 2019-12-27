/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadServicos;
import br.com.localeader.api.repositories.CadServicosRepository;
import br.com.localeader.api.services.CadServicosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadServicosServiceImpl implements CadServicosService {

    @Autowired
    private CadServicosRepository servicosRepository;

    @Override
    public CadServicos persistir(CadServicos cadServicos) {
        return this.servicosRepository.save(cadServicos);
    }

    @Override
    public CadServicos remover(CadServicos cadServicos) {
        this.servicosRepository.delete(cadServicos);
        return new CadServicos();
    }

    @Override
    public Optional<CadServicos> buscarPorId(Integer idServico) {
        return Optional.ofNullable(this.servicosRepository.findByIdServico(idServico));
    }

    @Override
    public Optional<CadServicos> buscarPorCodServico(Integer codigoServico) {
        return Optional.ofNullable(this.servicosRepository.findByCodigoServico(codigoServico));
    }

    @Override
    public Optional<CadServicos> buscarPorTipoServico(String tipoServico) {
        return Optional.ofNullable(this.servicosRepository.findByTipoServico(tipoServico));
    }

    @Override
    public Optional<CadServicos> buscarPorDescricao(String descricao) {
        return Optional.ofNullable(this.servicosRepository.findByDescricao(descricao));
    }

    @Override
    public List<CadServicos> listarTodos() {
        return this.servicosRepository.findAll();
    }

    @Override
    public Optional<CadServicos> buscarPorNomeServico(String servico) {
        return Optional.ofNullable(this.servicosRepository.findByNomeServico(servico));
    }

}
