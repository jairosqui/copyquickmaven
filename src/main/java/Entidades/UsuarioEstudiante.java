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
@Table(name = "usuario_estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioEstudiante.findAll", query = "SELECT u FROM UsuarioEstudiante u")
    , @NamedQuery(name = "UsuarioEstudiante.findByIdUsuarioEstudiante", query = "SELECT u FROM UsuarioEstudiante u WHERE u.idUsuarioEstudiante = :idUsuarioEstudiante")
    , @NamedQuery(name = "UsuarioEstudiante.findByNomUsuario", query = "SELECT u FROM UsuarioEstudiante u WHERE u.nomUsuario = :nomUsuario")
    , @NamedQuery(name = "UsuarioEstudiante.findByIdEstudiante", query = "SELECT u FROM UsuarioEstudiante u WHERE u.idEstudiante = :idEstudiante")})
public class UsuarioEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_estudiante")
    private Integer idUsuarioEstudiante;
    @Size(max = 100)
    @Column(name = "nomUsuario")
    private String nomUsuario;
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    public UsuarioEstudiante() {
    }

    public UsuarioEstudiante(Integer idUsuarioEstudiante) {
        this.idUsuarioEstudiante = idUsuarioEstudiante;
    }

    public Integer getIdUsuarioEstudiante() {
        return idUsuarioEstudiante;
    }

    public void setIdUsuarioEstudiante(Integer idUsuarioEstudiante) {
        this.idUsuarioEstudiante = idUsuarioEstudiante;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioEstudiante != null ? idUsuarioEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioEstudiante)) {
            return false;
        }
        UsuarioEstudiante other = (UsuarioEstudiante) object;
        if ((this.idUsuarioEstudiante == null && other.idUsuarioEstudiante != null) || (this.idUsuarioEstudiante != null && !this.idUsuarioEstudiante.equals(other.idUsuarioEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioEstudiante[ idUsuarioEstudiante=" + idUsuarioEstudiante + " ]";
    }
    
}
