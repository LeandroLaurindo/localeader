/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.dtos;

import br.com.localeader.api.model.CadDocumentos;
import br.com.localeader.api.model.CadPessoa;
import br.com.localeader.api.model.Usuario;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Leandro Laurindo
 */
public class CadastroJuridicaDto {

    Integer idPessoa;
    String tipoPessoa = "JURÍDICA";
    String login;
    String nome;
    String razaoSocial;
    Date dataNasc;
    String estato_civel;
    String profissao;
    String sexo;
    String conjuge;
    boolean estrangeiro;
    String pais;
    String nacionalidade;
    String situacao;
    Date dataInsercao;
    Date dataAlteracao;
    List<CadDocumentos> documentos;
    Usuario usuario;

    public CadastroJuridicaDto() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @NotEmpty(message = "Nome não pode ser vazio.")
    @Length(min = 3, max = 150, message = "Nome deve conter entre 3 e 100 caracteres.")
    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "Razao Social não pode ser vazio.")
    @Length(min = 3, max = 150, message = "Nome deve conter entre 3 e 100 caracteres.")
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEstato_civel() {
        return estato_civel;
    }

    public void setEstato_civel(String estato_civel) {
        this.estato_civel = estato_civel;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public boolean isEstrangeiro() {
        return estrangeiro;
    }

    public void setEstrangeiro(boolean estrangeiro) {
        this.estrangeiro = estrangeiro;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @NotEmpty(message = "Documentos não pode ser vazio.")
    public List<CadDocumentos> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<CadDocumentos> documentos) {
        this.documentos = documentos;
    }

    @NotEmpty(message = "Usurio não pode ser vazio.")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
