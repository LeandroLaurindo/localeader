/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadPessoa;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadPessoaService {

    CadPessoa persistir(CadPessoa pessoa);
    
    Optional<CadPessoa> buscarPorRazaoSocial(String razaoSocial);
    
    Optional<CadPessoa> buscarPorIdPessoa(Integer idPessoa);
    
    Optional<CadPessoa> buscarPorNome(String nome);
    
    List<CadPessoa> listarPorUsuarioFk(Integer usuarioFk);
    
    Page<CadPessoa> listarPorUsuarioFk(Integer usuarioFk, PageRequest pageRequest);

}
