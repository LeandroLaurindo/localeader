/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadTelefone;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadTelefoneService {

    CadTelefone persistir(CadTelefone telefone);
    
    Optional<CadTelefone> findByIdTelefone(Integer numero);

    Optional<CadTelefone> findByTelefone(String numero);
    
    List<CadTelefone> listarPorUsuarioFk(Integer usuarioFk);
    
    List<CadTelefone> listarPorDocumentoFk(Integer documentoFk);
    

}
