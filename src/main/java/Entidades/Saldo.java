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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "saldo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saldo.findAll", query = "SELECT s FROM Saldo s")
    , @NamedQuery(name = "Saldo.findByIdSaldo", query = "SELECT s FROM Saldo s WHERE s.idSaldo = :idSaldo")
    , @NamedQuery(name = "Saldo.findByIdAdministrador", query = "SELECT s FROM Saldo s WHERE s.idAdministrador = :idAdministrador")
    , @NamedQuery(name = "Saldo.findByIdEstudiante", query = "SELECT s FROM Saldo s WHERE s.idEstudiante = :idEstudiante")
    , @NamedQuery(name = "Saldo.findBySaldo", query = "SELECT s FROM Saldo s WHERE s.saldo = :saldo")})
public class Saldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_saldo")
    private Integer idSaldo;
    @Column(name = "id_administrador")
    private Integer idAdministrador;
    @Column(name = "id_estudiante")
    private Integer idEstudiante;
    @Column(name = "saldo")
    private Integer saldo;

    public Saldo() {
    }

    public Saldo(Integer idSaldo) {
        this.idSaldo = idSaldo;
    }

    public Integer getIdSaldo() {
        return idSaldo;
    }

    public void setIdSaldo(Integer idSaldo) {
        this.idSaldo = idSaldo;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSaldo != null ? idSaldo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saldo)) {
            return false;
        }
        Saldo other = (Saldo) object;
        if ((this.idSaldo == null && other.idSaldo != null) || (this.idSaldo != null && !this.idSaldo.equals(other.idSaldo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Saldo[ idSaldo=" + idSaldo + " ]";
    }
    
}
