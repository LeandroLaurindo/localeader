/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.repositories;

import br.com.localeader.api.model.CadEmail;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leandro Laurindo
 */
@Repository
@Transactional(readOnly = true)
public interface CadEmailRepository extends JpaRepository<CadEmail, Integer> {

    CadEmail findByIdEmail(Integer idEmail);
    
    CadEmail findByEmail(String email);

    List<CadEmail> findByUsuarioFk(Integer usuarioFk);

    Page<CadEmail> findByUsuarioFk(Integer usuarioFk, Pageable pageable);
}
