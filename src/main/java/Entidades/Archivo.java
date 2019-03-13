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
import javax.persistence.Lob;
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
@Table(name = "archivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a")
    , @NamedQuery(name = "Archivo.findByIdArchivo", query = "SELECT a FROM Archivo a WHERE a.idArchivo = :idArchivo")
    , @NamedQuery(name = "Archivo.findByNombre", query = "SELECT a FROM Archivo a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Archivo.findByNomUsuario", query = "SELECT a FROM Archivo a WHERE a.nomUsuario = :nomUsuario")
    , @NamedQuery(name = "Archivo.findBySemestre", query = "SELECT a FROM Archivo a WHERE a.semestre = :semestre")
    , @NamedQuery(name = "Archivo.findByEscuela", query = "SELECT a FROM Archivo a WHERE a.escuela = :escuela")
    , @NamedQuery(name = "Archivo.findByPublico", query = "SELECT a FROM Archivo a WHERE a.publico = :publico")})
public class Archivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_archivo")
    private Integer idArchivo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "nomUsuario")
    private String nomUsuario;
    @Column(name = "semestre")
    private Integer semestre;
    @Size(max = 100)
    @Column(name = "escuela")
    private String escuela;
    @Column(name = "publico")
    private Boolean publico;
    @Lob
    @Column(name = "archivopdf")
    private byte[] archivopdf;

    public Archivo() {
    }

    public Archivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public Boolean getPublico() {
        return publico;
    }

    public void setPublico(Boolean publico) {
        this.publico = publico;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivo != null ? idArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.idArchivo == null && other.idArchivo != null) || (this.idArchivo != null && !this.idArchivo.equals(other.idArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Archivo[ idArchivo=" + idArchivo + " ]";
    }
    
}
