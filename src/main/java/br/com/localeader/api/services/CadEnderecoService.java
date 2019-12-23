/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadEndereco;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadEnderecoService {
    
     CadEndereco persistir(CadEndereco endereco);
     
     Optional<CadEndereco> buscarPorIdEndereco(Integer id);
     
     List<CadEndereco> listarPorDocumentoFk(Integer documentoFk);
     
     List<CadEndereco> listarPorUsuarioFk(Integer usuarioFk);
}
