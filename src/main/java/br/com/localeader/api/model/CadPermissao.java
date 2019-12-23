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
@Table(name = "cad_permissao", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadPermissao.findAll", query = "SELECT c FROM CadPermissao c")})
public class CadPermissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permissao")
    private Integer idPermissao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ds_permissao")
    private String dsPermissao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ds_descricao")
    private String dsDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPermissao")
    private Collection<PermissaoGrupo> permissaoGrupoCollection;

    public CadPermissao() {
    }

    public CadPermissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    public CadPermissao(Integer idPermissao, String dsPermissao, String dsDescricao) {
        this.idPermissao = idPermissao;
        this.dsPermissao = dsPermissao;
        this.dsDescricao = dsDescricao;
    }

    public Integer getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Integer idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getDsPermissao() {
        return dsPermissao;
    }

    public void setDsPermissao(String dsPermissao) {
        this.dsPermissao = dsPermissao;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissao != null ? idPermissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadPermissao)) {
            return false;
        }
        CadPermissao other = (CadPermissao) object;
        if ((this.idPermissao == null && other.idPermissao != null) || (this.idPermissao != null && !this.idPermissao.equals(other.idPermissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.api.model.CadPermissao[ idPermissao=" + idPermissao + " ]";
    }
    
}
