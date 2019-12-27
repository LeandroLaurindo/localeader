/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.services;

import br.com.localeader.api.model.CadVendedor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadVendedorService {

    CadVendedor persitir(CadVendedor cadVendedor);

    CadVendedor remover(CadVendedor cadVendedor);

    Optional<CadVendedor> buscarPorId(Integer idVendedor);

    List<CadVendedor> listarTodos();
}
