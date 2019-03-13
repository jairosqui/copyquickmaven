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
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByIdEstudiante", query = "SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante")
    , @NamedQuery(name = "Estudiante.findByCarrera", query = "SELECT e FROM Estudiante e WHERE e.carrera = :carrera")
    , @NamedQuery(name = "Estudiante.findBySemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :semestre")
    , @NamedQuery(name = "Estudiante.findBySaldo", query = "SELECT e FROM Estudiante e WHERE e.saldo = :saldo")
    , @NamedQuery(name = "Estudiante.findByCorreo", query = "SELECT e FROM Estudiante e WHERE e.correo = :correo")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Size(max = 255)
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "semestre")
    private Integer semestre;
    @Column(name = "saldo")
    private Integer saldo;
    @Size(max = 255)
    @Column(name = "correo")
    private String correo;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudiante != null ? idEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idEstudiante == null && other.idEstudiante != null) || (this.idEstudiante != null && !this.idEstudiante.equals(other.idEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estudiante[ idEstudiante=" + idEstudiante + " ]";
    }
    
}
