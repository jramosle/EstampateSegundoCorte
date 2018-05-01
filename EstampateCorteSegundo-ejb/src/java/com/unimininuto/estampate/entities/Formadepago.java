/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author PRISTOPHER
 */
@Entity
@Table(name = "formadepago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formadepago.findAll", query = "SELECT f FROM Formadepago f")
    , @NamedQuery(name = "Formadepago.findByIdformapago", query = "SELECT f FROM Formadepago f WHERE f.idformapago = :idformapago")
    , @NamedQuery(name = "Formadepago.findByNombreformapago", query = "SELECT f FROM Formadepago f WHERE f.nombreformapago = :nombreformapago")})
public class Formadepago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idformapago")
    private Integer idformapago;
    @Size(max = 50)
    @Column(name = "nombreformapago")
    private String nombreformapago;
    @OneToMany(mappedBy = "idformadepago")
    private List<Preorden> preordenList;

    public Formadepago() {
    }

    public Formadepago(Integer idformapago) {
        this.idformapago = idformapago;
    }

    public Integer getIdformapago() {
        return idformapago;
    }

    public void setIdformapago(Integer idformapago) {
        this.idformapago = idformapago;
    }

    public String getNombreformapago() {
        return nombreformapago;
    }

    public void setNombreformapago(String nombreformapago) {
        this.nombreformapago = nombreformapago;
    }

    @XmlTransient
    public List<Preorden> getPreordenList() {
        return preordenList;
    }

    public void setPreordenList(List<Preorden> preordenList) {
        this.preordenList = preordenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformapago != null ? idformapago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formadepago)) {
            return false;
        }
        Formadepago other = (Formadepago) object;
        if ((this.idformapago == null && other.idformapago != null) || (this.idformapago != null && !this.idformapago.equals(other.idformapago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.Formadepago[ idformapago=" + idformapago + " ]";
    }
    
}
