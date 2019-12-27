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
@Table(name = "usuario_grupo", catalog = "localeader", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioGrupo.findAll", query = "SELECT u FROM UsuarioGrupo u")
    , @NamedQuery(name = "UsuarioGrupo.findByIdUsuGrupo", query = "SELECT u FROM UsuarioGrupo u WHERE u.idUsuGrupo = :idUsuGrupo")})
public class UsuarioGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usu_grupo")
    private Integer idUsuGrupo;
    @JoinColumn(name = "grupo_fk", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private CadGrupo grupoFk;
    @JoinColumn(name = "usuario_fk", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioFk;

    public UsuarioGrupo() {
    }

    public UsuarioGrupo(Integer idUsuGrupo) {
        this.idUsuGrupo = idUsuGrupo;
    }

    public Integer getIdUsuGrupo() {
        return idUsuGrupo;
    }

    public void setIdUsuGrupo(Integer idUsuGrupo) {
        this.idUsuGrupo = idUsuGrupo;
    }

    public CadGrupo getGrupoFk() {
        return grupoFk;
    }

    public void setGrupoFk(CadGrupo grupoFk) {
        this.grupoFk = grupoFk;
    }

    public Usuario getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(Usuario usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuGrupo != null ? idUsuGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioGrupo)) {
            return false;
        }
        UsuarioGrupo other = (UsuarioGrupo) object;
        if ((this.idUsuGrupo == null && other.idUsuGrupo != null) || (this.idUsuGrupo != null && !this.idUsuGrupo.equals(other.idUsuGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.localeader.api.model.UsuarioGrupo[ idUsuGrupo=" + idUsuGrupo + " ]";
    }
    
}
