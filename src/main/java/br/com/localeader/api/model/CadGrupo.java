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
@Table(name = "cad_grupo", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadGrupo.findAll", query = "SELECT c FROM CadGrupo c")})
public class CadGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ds_nome")
    private String dsNome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ds_descricao")
    private String dsDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkGrupo")
    private Collection<PermissaoGrupo> permissaoGrupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoFk")
    private Collection<UsuarioGrupo> usuarioGrupoCollection;

    public CadGrupo() {
    }

    public CadGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public CadGrupo(Integer idGrupo, String dsNome, String dsDescricao) {
        this.idGrupo = idGrupo;
        this.dsNome = dsNome;
        this.dsDescricao = dsDescricao;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getDsNome() {
        return dsNome;
    }

    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    @XmlTransient
    public Collection<PermissaoGrupo> getPermissaoGrupoCollection() {
        return permissaoGrupoCollection;
    }

    public void setPermissaoGrupoCollection(Collection<PermissaoGrupo> permissaoGrupoCollection) {
        this.permissaoGrupoCollection = permissaoGrupoCollection;
    }

    @XmlTransient
    public Collection<UsuarioGrupo> getUsuarioGrupoCollection() {
        return usuarioGrupoCollection;
    }

    public void setUsuarioGrupoCollection(Collection<UsuarioGrupo> usuarioGrupoCollection) {
        this.usuarioGrupoCollection = usuarioGrupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadGrupo)) {
            return false;
        }
        CadGrupo other = (CadGrupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.api.model.CadGrupo[ idGrupo=" + idGrupo + " ]";
    }
    
}
