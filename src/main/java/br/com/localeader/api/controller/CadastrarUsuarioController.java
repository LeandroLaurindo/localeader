/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.controller;

import br.com.localeader.api.dtos.CadastroUsuarioDto;
import br.com.localeader.api.model.CadCliente;
import br.com.localeader.api.model.CadDocumentos;
import br.com.localeader.api.model.CadEmail;
import br.com.localeader.api.model.CadEndereco;
import br.com.localeader.api.model.CadFornecedor;
import br.com.localeader.api.model.CadFuncionarios;
import br.com.localeader.api.model.CadGrupo;
import br.com.localeader.api.model.CadOcorrencias;
import br.com.localeader.api.model.CadPessoa;
import br.com.localeader.api.model.CadTelefone;
import br.com.localeader.api.model.CadVendedor;
import br.com.localeader.api.model.Usuario;
import br.com.localeader.api.model.UsuarioGrupo;
import br.com.localeader.api.response.Response;
import br.com.localeader.api.services.CadClienteService;
import br.com.localeader.api.services.CadDocumentosService;
import br.com.localeader.api.services.CadEmailService;
import br.com.localeader.api.services.CadEnderecoService;
import br.com.localeader.api.services.CadFornecedorService;
import br.com.localeader.api.services.CadFuncionariosService;
import br.com.localeader.api.services.CadGrupoService;
import br.com.localeader.api.services.CadPessoaService;
import br.com.localeader.api.services.CadTelefoneService;
import br.com.localeader.api.services.CadVendedorService;
import br.com.localeader.api.services.UsuarioGrupoService;
import br.com.localeader.api.services.UsuarioService;
import br.com.localeader.api.utils.PasswordUtils;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
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
@RequestMapping("/cadastrarusuario")
@CrossOrigin
public class CadastrarUsuarioController {
     
    private static final Logger LOG = LoggerFactory.getLogger(CadastroPessoaPJController.class);
    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
    
    @Autowired
    private CadDocumentosService cadDocumentosService;

    @Autowired
    private CadPessoaService cadPessoaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CadGrupoService grupoService;

    @Autowired
    private UsuarioGrupoService usuarioGrupoService;

    @Autowired
    private CadClienteService clienteService;

    @Autowired
    private CadVendedorService cadVendedorService;

    @Autowired
    private CadFuncionariosService funcionariosService;

    @Autowired
    private CadEmailService cadEmailService;

    @Autowired
    private CadFornecedorService cadFornecedorService;
    
    @Autowired
    private CadTelefoneService telefoneService;
    
    @Autowired
    private CadEnderecoService enderecoService;
    public CadastrarUsuarioController() {
    }

    @PostMapping
    public ResponseEntity<Response<CadastroUsuarioDto>> cadastrar(@Valid @RequestBody CadastroUsuarioDto usuarioDto,
            BindingResult result) throws NoSuchAlgorithmException {
        LOG.info("Iniciando cadastrar com usuario: {}" + usuarioDto.toString());
        Response<CadastroUsuarioDto> response = new Response<>();
        //verifica se o usuario ja existe
        validarDadosExistentes(usuarioDto, result);
        //salva um novo usuario
        
        Usuario usuario = this.converterDtoEmUsuario(usuarioDto);
        usuario = usuarioService.persistir(usuario);
        if (result.hasErrors()) {
            LOG.info("Erro de validação de dados:{}" + result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }
        //salva o grupo de acordo com a permissão
        UsuarioGrupo grupo = this.setarGrupoDePermissao(usuarioDto, usuario);
        grupo = usuarioGrupoService.persistir(grupo);
        //cadastra os dados da pessoa
        CadPessoa cadPessoa = this.converterDtoEmCadPessoa(usuarioDto);
        cadPessoa.setUsuarioFk(usuario);
        cadPessoa = cadPessoaService.persistir(cadPessoa);
        //salva os dados do documentos
        CadDocumentos documentos = this.converterDtoEmCadDocumentos(usuarioDto);
        documentos.setUsuarioFk(usuario.getIdUsuario());
        documentos.setPessoaFk(cadPessoa);
        documentos = cadDocumentosService.persistir(documentos);
        //salva os dados do telefone
        CadTelefone telefone = this.converterDtoEmCadTelefone(usuarioDto);
        telefone.setDocumentoFk(documentos);
        telefone.setUsuarioFk(usuario);
        telefone = telefoneService.persistir(telefone);

        //salva email
        CadEmail email = this.converterDtoEmCadEmail(usuarioDto);
        email.setDocumentoFk(documentos);
        email.setUsuarioFk(usuario);
        email = cadEmailService.persistir(email);

        //salva endereco
        CadEndereco cadEndereco = this.converterDtoEmCadEndereco(usuarioDto);
        cadEndereco.setDocumentoFk(documentos);
        cadEndereco.setUsuarioFk(usuario);
        cadEndereco = enderecoService.persistir(cadEndereco);

        //se for fonecedor salva um novo fornecedor
        if (usuarioDto.getTipoUsuario().equalsIgnoreCase("Fornecedor")) {
            CadFornecedor fornecedor = this.converterDtoEmCadFornecedor(usuarioDto);
            fornecedor.setDocumentoFk(documentos);
            fornecedor.setUsuarioFk(usuario);
            //fornecedor.setSegmentoFk();
            fornecedor = cadFornecedorService.persistir(fornecedor);
        }
        //se for cliente salva um novo cliente
        if (usuarioDto.getTipoUsuario().equalsIgnoreCase("Cliente")) {
            CadCliente cliente = this.converterDtoEmCadCliente(usuarioDto);
            cliente.setDocumentoFk(documentos);
            clienteService.persistir(cliente);
        }
        //se for funcionario salva um novo funcionario
        if (usuarioDto.getTipoUsuario().equalsIgnoreCase("Funcionario")) {
            CadFuncionarios funcionarios = this.converterDtoEmCadFuncionarios(usuarioDto);
            funcionarios.setUsuarioFk(usuario);
            funcionarios = funcionariosService.persistir(funcionarios);
        }
        //se for vendedor ja salva o vendendor
        if (usuarioDto.getTipoUsuario().equalsIgnoreCase("Vendedor")) {
            CadVendedor vendedor = converterDtoEmCadVendedor(usuarioDto);
            vendedor.setDocumentoFk(documentos);
            vendedor.setUsuarioFk(usuario);
            cadVendedorService.persitir(vendedor);
        }
        usuarioDto.setIdUsuario(usuario.getIdUsuario());
        response.setData(usuarioDto);
        return ResponseEntity.ok(response);
    }

    private void validarDadosExistentes(CadastroUsuarioDto usuarioDto, BindingResult result) {
        this.usuarioService.buscaUsuarioPorLogin(usuarioDto.getLogin()).ifPresent(emp -> result.addError(new ObjectError("Usuario", "Usuario já existe!")));

    }

    private Usuario converterDtoEmUsuario(CadastroUsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setAtivo("SIM");
        usuario.setLogin(usuarioDto.getLogin());
        usuario.setSenha(PasswordUtils.gerarBCrypt(usuarioDto.getSenha()));
        return usuario;
    }

    private CadEndereco converterDtoEmCadEndereco(CadastroUsuarioDto usuarioDto) {
        CadEndereco endereco = new CadEndereco();
        endereco.setBairro(usuarioDto.getBairro());
        endereco.setCep(usuarioDto.getCep());
        endereco.setComplemento(usuarioDto.getComplemento());
        endereco.setDataAlteracao(new Date());
        endereco.setDataInsercao(new Date());
        endereco.setLogradouro(usuarioDto.getLogradouro());
        endereco.setNumero(usuarioDto.getNumero());
        endereco.setUf(usuarioDto.getUf());
        return endereco;
    }

    private CadDocumentos converterDtoEmCadDocumentos(CadastroUsuarioDto usuarioDto) {
        CadDocumentos cadDocumentos = new CadDocumentos();
        cadDocumentos.setCnpj(usuarioDto.getCnpj());
        cadDocumentos.setCpf(usuarioDto.getCpf());
        cadDocumentos.setDataAlteracao(new Date());
        cadDocumentos.setDataInsercao(new Date());
        cadDocumentos.setInscricaoEstudal(usuarioDto.getInscricaoEstudal());
        cadDocumentos.setInscricaoMunicipal(usuarioDto.getInscricaoMunicipal());
        cadDocumentos.setPassaporte(usuarioDto.getPassaporte());
        try {
            cadDocumentos.setValidadePassaporte(formato.parse(usuarioDto.getValidadePassaporte()));
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadDocumentos;
    }

    private CadEmail converterDtoEmCadEmail(CadastroUsuarioDto usuarioDto) {
        CadEmail cadEmail = new CadEmail();
        cadEmail.setDataAlteracao(new Date());
        cadEmail.setDataInsercao(new Date());
        cadEmail.setObservacao(usuarioDto.getObservacao());
        cadEmail.setSite(usuarioDto.getSite());
        return cadEmail;
    }

    private CadFornecedor converterDtoEmCadFornecedor(CadastroUsuarioDto usuarioDto) {
        CadFornecedor fornecedor = new CadFornecedor();
        fornecedor.setAgencia(usuarioDto.getAgencia());
        fornecedor.setBanco(usuarioDto.getBanco());
        fornecedor.setDataAlteracao(new Date());
        fornecedor.setDataInsercao(new Date());
        return fornecedor;
    }

    private CadTelefone converterDtoEmCadTelefone(CadastroUsuarioDto usuarioDto) {
        CadTelefone telefone = new CadTelefone();
        telefone.setDataAlteracao(new Date());
        telefone.setDataInsercao(new Date());
        telefone.setDdd(usuarioDto.getDdd());
        telefone.setTelefone(usuarioDto.getTelefone());
        telefone.setWhatsapp(usuarioDto.getWhatsapp());
        return telefone;
    }

    private CadFuncionarios converterDtoEmCadFuncionarios(CadastroUsuarioDto usuarioDto) {
        CadFuncionarios funcionarios = new CadFuncionarios();
        funcionarios.setAtivo(true);
        funcionarios.setCargo(usuarioDto.getCargo());
        funcionarios.setCodigo(usuarioDto.getCodigo());
        try {
            if (!usuarioDto.getDataAdmissao().isEmpty()) {
                funcionarios.setDataAdmissao(formato.parse(usuarioDto.getDataAdmissao()));
            }
            if (!usuarioDto.getDataDemissao().isEmpty()) {
                funcionarios.setDataDemissao(formato.parse(usuarioDto.getDataDemissao()));
            }
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        funcionarios.setDataAlteracao(new Date());

        funcionarios.setDataInsercao(new Date());
        funcionarios.setGratificacao(new BigDecimal(usuarioDto.getGratificacao()));
        funcionarios.setQtdeDependentes(usuarioDto.getQtdeDependentes());
        funcionarios.setSalario(new BigDecimal(usuarioDto.getSalario()));
        funcionarios.setSetor(usuarioDto.getSetor());
        funcionarios.setSindicato(usuarioDto.getSindicato());
        funcionarios.setTipoFuncionario(usuarioDto.getTipoFuncionario());
        funcionarios.setValeTransporte(usuarioDto.isValeTransporte());
        return funcionarios;
    }

    private CadVendedor converterDtoEmCadVendedor(CadastroUsuarioDto usuarioDto) {
        CadVendedor cadVendedor = new CadVendedor();
        cadVendedor.setDataAlteracao(new Date());
        cadVendedor.setDataInsercao(new Date());
        return cadVendedor;
    }

    private CadCliente converterDtoEmCadCliente(CadastroUsuarioDto usuarioDto) {
        CadCliente cliente = new CadCliente();
        cliente.setLimiteCredito(new BigDecimal(usuarioDto.getLimiteCredito()));
        cliente.setObservacao(usuarioDto.getObservacao());
        cliente.setOrigemCliente(usuarioDto.getOrigemCliente());
        cliente.setPlanoPagto(usuarioDto.getPlanoPagto());
        return cliente;
    }

    private CadOcorrencias converterDtoEmCadOcorrencias(CadastroUsuarioDto usuarioDto) {
        CadOcorrencias ocorrencias = new CadOcorrencias();
        return ocorrencias;
    }

    private CadPessoa converterDtoEmCadPessoa(CadastroUsuarioDto usuarioDto) {
        CadPessoa cadPessoa = new CadPessoa();
        cadPessoa.setConjuge(usuarioDto.getConjuge());
        cadPessoa.setDataAlteracao(new Date());
        cadPessoa.setDataInsercao(new Date());
        try {
            cadPessoa.setDataNascimento(formato.parse(usuarioDto.getDataNascimento()));
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        cadPessoa.setEstadoCivil(usuarioDto.getEstadoCivil());
        cadPessoa.setEstrangeiro(usuarioDto.getEstrangeiro());
        cadPessoa.setNacionalidade(usuarioDto.getNacionalidade());
        cadPessoa.setNome(usuarioDto.getNome());
        cadPessoa.setPais(usuarioDto.getPais());
        cadPessoa.setProfissao(usuarioDto.getProfissao());
        cadPessoa.setRazaoSocial(usuarioDto.getRazaoSocial());
        cadPessoa.setSexo(usuarioDto.getSexo());
        cadPessoa.setSituacao(usuarioDto.getSituacao());
        cadPessoa.setTipoPessoa(usuarioDto.getTipoPessoa());

        return cadPessoa;
    }

    private UsuarioGrupo setarGrupoDePermissao(CadastroUsuarioDto usuarioDto, Usuario usuario) {
        UsuarioGrupo grupo = new UsuarioGrupo();
        if (usuario.getIdUsuario() != null) {
            grupo.setUsuarioFk(usuario);
            int nivel = 6;

            if (usuarioDto.getTipoUsuario().equalsIgnoreCase("Cliente")) {
                nivel = 5;
            }
            if (usuarioDto.getTipoUsuario().equalsIgnoreCase("Funcionario") || usuarioDto.getTipoUsuario().equalsIgnoreCase("Vendedor")) {
                nivel = 4;
            }

            if (usuarioDto.getTipoUsuario().equalsIgnoreCase("Administrador")) {
                nivel = 3;
            }
            if (usuarioDto.getTipoUsuario().equalsIgnoreCase("Master")) {
                nivel = 2;
            }
            Optional<CadGrupo> cadGrupo = grupoService.buscarPorIdGrupo(nivel);

            cadGrupo.ifPresent(cad -> grupo.setGrupoFk(cad));
        }
        return grupo;
    }
}
