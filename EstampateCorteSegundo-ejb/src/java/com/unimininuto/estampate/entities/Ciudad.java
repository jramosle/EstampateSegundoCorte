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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PRISTOPHER
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdcuidad", query = "SELECT c FROM Ciudad c WHERE c.idcuidad = :idcuidad")
    , @NamedQuery(name = "Ciudad.findByNombreciudad", query = "SELECT c FROM Ciudad c WHERE c.nombreciudad = :nombreciudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcuidad")
    private Integer idcuidad;
    @Column(name = "nombreciudad")
    private Integer nombreciudad;
    @OneToMany(mappedBy = "idciudadusuario")
    private List<Preorden> preordenList;

    public Ciudad() {
    }

    public Ciudad(Integer idcuidad) {
        this.idcuidad = idcuidad;
    }

    public Integer getIdcuidad() {
        return idcuidad;
    }

    public void setIdcuidad(Integer idcuidad) {
        this.idcuidad = idcuidad;
    }

    public Integer getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(Integer nombreciudad) {
        this.nombreciudad = nombreciudad;
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
        hash += (idcuidad != null ? idcuidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idcuidad == null && other.idcuidad != null) || (this.idcuidad != null && !this.idcuidad.equals(other.idcuidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.Ciudad[ idcuidad=" + idcuidad + " ]";
    }
    
}
