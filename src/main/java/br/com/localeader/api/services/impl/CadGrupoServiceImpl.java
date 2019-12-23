package br.com.localeader.api.services.impl;

import br.com.localeader.api.model.CadGrupo;
import br.com.localeader.api.repositories.CadGrupoRepository;
import br.com.localeader.api.services.CadGrupoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leandro Laurindo
 */
@Service
public class CadGrupoServiceImpl implements CadGrupoService{

    @Autowired
    private CadGrupoRepository repository;
    
    @Override
    public CadGrupo persistir(CadGrupo grupo) {
     return this.repository.save(grupo);
    }

    @Override
    public Optional<CadGrupo> buscarPorIdGrupo(Integer idGrupo) {
      return Optional.ofNullable(this.repository.findByIdGrupo(idGrupo));
    }

    @Override
    public Optional<CadGrupo> buscarPorDsNome(String dsNome) {
        return Optional.ofNullable(this.repository.findByDsNome(dsNome));
    }
    
}
