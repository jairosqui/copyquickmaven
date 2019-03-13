/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "usuario_administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioAdministrador.findAll", query = "SELECT u FROM UsuarioAdministrador u")
    , @NamedQuery(name = "UsuarioAdministrador.findByIdUsuarioAdministrador", query = "SELECT u FROM UsuarioAdministrador u WHERE u.idUsuarioAdministrador = :idUsuarioAdministrador")
    , @NamedQuery(name = "UsuarioAdministrador.findByNomUsuario", query = "SELECT u FROM UsuarioAdministrador u WHERE u.nomUsuario = :nomUsuario")
    , @NamedQuery(name = "UsuarioAdministrador.findByIdAdministrador", query = "SELECT u FROM UsuarioAdministrador u WHERE u.idAdministrador = :idAdministrador")})
public class UsuarioAdministrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_administrador")
    private Integer idUsuarioAdministrador;
    @Size(max = 100)
    @Column(name = "nomUsuario")
    private String nomUsuario;
    @Column(name = "id_administrador")
    private Integer idAdministrador;

    public UsuarioAdministrador() {
    }

    public UsuarioAdministrador(Integer idUsuarioAdministrador) {
        this.idUsuarioAdministrador = idUsuarioAdministrador;
    }

    public Integer getIdUsuarioAdministrador() {
        return idUsuarioAdministrador;
    }

    public void setIdUsuarioAdministrador(Integer idUsuarioAdministrador) {
        this.idUsuarioAdministrador = idUsuarioAdministrador;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioAdministrador != null ? idUsuarioAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioAdministrador)) {
            return false;
        }
        UsuarioAdministrador other = (UsuarioAdministrador) object;
        if ((this.idUsuarioAdministrador == null && other.idUsuarioAdministrador != null) || (this.idUsuarioAdministrador != null && !this.idUsuarioAdministrador.equals(other.idUsuarioAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioAdministrador[ idUsuarioAdministrador=" + idUsuarioAdministrador + " ]";
    }
    
}
