/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.api.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leandro Laurindo
 */
@Entity
@Table(name = "permissao_grupo", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissaoGrupo.findAll", query = "SELECT p FROM PermissaoGrupo p")
    , @NamedQuery(name = "PermissaoGrupo.findByIdPermGrupo", query = "SELECT p FROM PermissaoGrupo p WHERE p.idPermGrupo = :idPermGrupo")})
public class PermissaoGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perm_grupo")
    private Integer idPermGrupo;
    @JoinColumn(name = "fk_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private CadGrupo fkGrupo;
    @JoinColumn(name = "fk_permissao", referencedColumnName = "id_permissao")
    @ManyToOne(optional = false)
    private CadPermissao fkPermissao;

    public PermissaoGrupo() {
    }

    public PermissaoGrupo(Integer idPermGrupo) {
        this.idPermGrupo = idPermGrupo;
    }

    public Integer getIdPermGrupo() {
        return idPermGrupo;
    }

    public void setIdPermGrupo(Integer idPermGrupo) {
        this.idPermGrupo = idPermGrupo;
    }

    public CadGrupo getFkGrupo() {
        return fkGrupo;
    }

    public void setFkGrupo(CadGrupo fkGrupo) {
        this.fkGrupo = fkGrupo;
    }

    public CadPermissao getFkPermissao() {
        return fkPermissao;
    }

    public void setFkPermissao(CadPermissao fkPermissao) {
        this.fkPermissao = fkPermissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermGrupo != null ? idPermGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissaoGrupo)) {
            return false;
        }
        PermissaoGrupo other = (PermissaoGrupo) object;
        if ((this.idPermGrupo == null && other.idPermGrupo != null) || (this.idPermGrupo != null && !this.idPermGrupo.equals(other.idPermGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.api.model.PermissaoGrupo[ idPermGrupo=" + idPermGrupo + " ]";
    }
    
}
