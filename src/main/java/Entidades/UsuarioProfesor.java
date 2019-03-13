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
@Table(name = "usuario_profesor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioProfesor.findAll", query = "SELECT u FROM UsuarioProfesor u")
    , @NamedQuery(name = "UsuarioProfesor.findByIdUsuarioProfesor", query = "SELECT u FROM UsuarioProfesor u WHERE u.idUsuarioProfesor = :idUsuarioProfesor")
    , @NamedQuery(name = "UsuarioProfesor.findByNomUsuario", query = "SELECT u FROM UsuarioProfesor u WHERE u.nomUsuario = :nomUsuario")
    , @NamedQuery(name = "UsuarioProfesor.findByIdProfesor", query = "SELECT u FROM UsuarioProfesor u WHERE u.idProfesor = :idProfesor")})
public class UsuarioProfesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_profesor")
    private Integer idUsuarioProfesor;
    @Size(max = 100)
    @Column(name = "nomUsuario")
    private String nomUsuario;
    @Column(name = "id_profesor")
    private Integer idProfesor;

    public UsuarioProfesor() {
    }

    public UsuarioProfesor(Integer idUsuarioProfesor) {
        this.idUsuarioProfesor = idUsuarioProfesor;
    }

    public Integer getIdUsuarioProfesor() {
        return idUsuarioProfesor;
    }

    public void setIdUsuarioProfesor(Integer idUsuarioProfesor) {
        this.idUsuarioProfesor = idUsuarioProfesor;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioProfesor != null ? idUsuarioProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioProfesor)) {
            return false;
        }
        UsuarioProfesor other = (UsuarioProfesor) object;
        if ((this.idUsuarioProfesor == null && other.idUsuarioProfesor != null) || (this.idUsuarioProfesor != null && !this.idUsuarioProfesor.equals(other.idUsuarioProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioProfesor[ idUsuarioProfesor=" + idUsuarioProfesor + " ]";
    }
    
}
