/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadServicos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Leandro Laurindo
 */
public interface CadServicosRepository extends JpaRepository<CadServicos, Integer> {

    CadServicos findByIdServico(Integer idServico);

    CadServicos findByNomeServico(String nomeServico);

    CadServicos findByCodigoServico(Integer codigoServico);

    CadServicos findByTipoServico(String tipoServico);

    CadServicos findByDescricao(String descricao);
}
