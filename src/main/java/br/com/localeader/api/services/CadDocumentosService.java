/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadDocumentos;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadDocumentosService {

    CadDocumentos persistir(CadDocumentos documentos);

    Optional<CadDocumentos> buscarPoCpf(String cpf);

    Optional<CadDocumentos> buscarPoCnpj(String cpf);

    Optional<CadDocumentos> buscarPoUsuarioFk(Integer id);

    List<CadDocumentos> listarPorPessoa(Integer id);
    
    Page<CadDocumentos> listarPorPessoa(Integer id, PageRequest pageRequest);
}
