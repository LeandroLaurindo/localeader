/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leandro Laurindo
 */
@Entity
@Table(name = "usuario", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "senha")
    private String senha;
    @Size(max = 3)
    @Column(name = "ativo")
    private String ativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private Collection<CadEmail> cadEmailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private Collection<UsuarioGrupo> usuarioGrupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private Collection<CadTelefone> cadTelefoneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private Collection<CadPessoa> cadPessoaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFk")
    private Collection<CadEndereco> cadEnderecoCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String login, String senha) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    @XmlTransient
    public Collection<CadEmail> getCadEmailCollection() {
        return cadEmailCollection;
    }

    public void setCadEmailCollection(Collection<CadEmail> cadEmailCollection) {
        this.cadEmailCollection = cadEmailCollection;
    }

    @XmlTransient
    public Collection<UsuarioGrupo> getUsuarioGrupoCollection() {
        return usuarioGrupoCollection;
    }

    public void setUsuarioGrupoCollection(Collection<UsuarioGrupo> usuarioGrupoCollection) {
        this.usuarioGrupoCollection = usuarioGrupoCollection;
    }

    @XmlTransient
    public Collection<CadTelefone> getCadTelefoneCollection() {
        return cadTelefoneCollection;
    }

    public void setCadTelefoneCollection(Collection<CadTelefone> cadTelefoneCollection) {
        this.cadTelefoneCollection = cadTelefoneCollection;
    }

    @XmlTransient
    public Collection<CadPessoa> getCadPessoaCollection() {
        return cadPessoaCollection;
    }

    public void setCadPessoaCollection(Collection<CadPessoa> cadPessoaCollection) {
        this.cadPessoaCollection = cadPessoaCollection;
    }

    @XmlTransient
    public Collection<CadEndereco> getCadEnderecoCollection() {
        return cadEnderecoCollection;
    }

    public void setCadEnderecoCollection(Collection<CadEndereco> cadEnderecoCollection) {
        this.cadEnderecoCollection = cadEnderecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.api.model.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
