/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.controller;

import br.com.localeader.api.dtos.CadastroJuridicaDto;
import br.com.localeader.api.model.CadPessoa;
import br.com.localeader.api.model.Usuario;
import br.com.localeader.api.response.Response;
import br.com.localeader.api.services.CadDocumentosService;
import br.com.localeader.api.services.CadEmailService;
import br.com.localeader.api.services.CadPessoaService;
import br.com.localeader.api.services.UsuarioService;
import java.util.Date;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Leandro Laurindo
 */
@RestController
@RequestMapping("/api/CadastrarPessoaPJ")
@CrossOrigin(origins = "*")
public class CadastroPessoaPJController {

    private static final Logger LOG = LoggerFactory.getLogger(CadastroPessoaPJController.class);

    @Autowired
    private CadDocumentosService documentosService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CadPessoaService pessoaService;

    
    @Autowired
    private CadEmailService emailService;
    
    public CadastroPessoaPJController() {
    }

    /**
     *
     * @param juridicaDto
     * @param result
     * @return
     */
    @PostMapping
    public ResponseEntity<Response<CadastroJuridicaDto>> cadastrar(@Valid @RequestBody CadastroJuridicaDto juridicaDto, BindingResult result) {
        LOG.info("Iniciando cadastrar com CadPessoa: {}" + juridicaDto.toString());
        Response<CadastroJuridicaDto> response = new Response<>();
        validarDadosExistentes(juridicaDto, result);
        CadPessoa cadPessoa =  this.converterDtoParaCadPessoa(juridicaDto);
        if (result.hasErrors()) {
            LOG.info("Erro validação no cadastro pessoa juridica : {}" + result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        this.pessoaService.persistir(cadPessoa);
        // response.setData(this.converterDataCadastroJuridicoDto(cadPessoa));
        return ResponseEntity.ok(response);

    }

    /**
     * Verifica se os dados ja existe
     */
    private void validarDadosExistentes(CadastroJuridicaDto juridicaDto, BindingResult result) {
        this.pessoaService.buscarPorNome(juridicaDto.getNome()).ifPresent(emp -> result.addError(new ObjectError("Pessoa", "CadPessoa já existe!")));
    }

    private Usuario converterDtoParaUsuario(CadastroJuridicaDto juridicaDto){
          Usuario usuario = new Usuario();
          usuario.setAtivo("SIM");
          usuario.setLogin(juridicaDto.getLogin());
          usuario.setCadEmailList(emailService.listarPorUsuarioFk(usuario.getIdUsuario()));
        return null;
    }
    
    private CadPessoa converterDtoParaCadPessoa(CadastroJuridicaDto juridicaDto) {
        CadPessoa pessoa = new CadPessoa();
        pessoa.setCadDocumentosList(documentosService.listarPorPessoa(juridicaDto.getIdPessoa()));
        pessoa.setUsuarioFk(juridicaDto.getUsuario());
        pessoa.setConjuge(juridicaDto.getConjuge());
        pessoa.setDataAlteracao(new Date());
        pessoa.setDataInsercao(new Date());
        pessoa.setDataNascimento(juridicaDto.getDataNasc());
        pessoa.setSituacao(juridicaDto.getSituacao());
        pessoa.setEstadoCivil(juridicaDto.getEstato_civel());
        if (juridicaDto.getPais().equalsIgnoreCase("Brasil")) {
            pessoa.setEstrangeiro(false);
        } else {
            pessoa.setEstrangeiro(false);
        }
        pessoa.setNacionalidade(juridicaDto.getNacionalidade());
        pessoa.setNome(juridicaDto.getNome());
        pessoa.setPais(juridicaDto.getPais());
        pessoa.setProfissao(juridicaDto.getProfissao());
        pessoa.setRazaoSocial(juridicaDto.getRazaoSocial());
        if (juridicaDto.getSexo().equalsIgnoreCase("Masculino")) {
            pessoa.setSexo("M");
        } else {
            pessoa.setSexo("F");
        }
        pessoa.setTipoPessoa(juridicaDto.getTipoPessoa());
        return pessoa;
    }

    private void converterDataCadastroJuridicoDto(CadPessoa cadPessoa) {

    }
}
