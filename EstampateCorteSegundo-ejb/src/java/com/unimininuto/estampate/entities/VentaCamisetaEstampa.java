/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PRISTOPHER
 */
@Entity
@Table(name = "venta_camiseta_estampa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaCamisetaEstampa.findAll", query = "SELECT v FROM VentaCamisetaEstampa v")
    , @NamedQuery(name = "VentaCamisetaEstampa.findByIdventacamisetaestampa", query = "SELECT v FROM VentaCamisetaEstampa v WHERE v.idventacamisetaestampa = :idventacamisetaestampa")})
public class VentaCamisetaEstampa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idventacamisetaestampa")
    private Integer idventacamisetaestampa;
    @JoinColumn(name = "idestampa", referencedColumnName = "idestampas")
    @ManyToOne
    private Estampas idestampa;
    @JoinColumn(name = "idventacamiseta", referencedColumnName = "idventacamiseta")
    @ManyToOne
    private VentaCamiseta idventacamiseta;

    public VentaCamisetaEstampa() {
    }

    public VentaCamisetaEstampa(Integer idventacamisetaestampa) {
        this.idventacamisetaestampa = idventacamisetaestampa;
    }

    public Integer getIdventacamisetaestampa() {
        return idventacamisetaestampa;
    }

    public void setIdventacamisetaestampa(Integer idventacamisetaestampa) {
        this.idventacamisetaestampa = idventacamisetaestampa;
    }

    public Estampas getIdestampa() {
        return idestampa;
    }

    public void setIdestampa(Estampas idestampa) {
        this.idestampa = idestampa;
    }

    public VentaCamiseta getIdventacamiseta() {
        return idventacamiseta;
    }

    public void setIdventacamiseta(VentaCamiseta idventacamiseta) {
        this.idventacamiseta = idventacamiseta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventacamisetaestampa != null ? idventacamisetaestampa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaCamisetaEstampa)) {
            return false;
        }
        VentaCamisetaEstampa other = (VentaCamisetaEstampa) object;
        if ((this.idventacamisetaestampa == null && other.idventacamisetaestampa != null) || (this.idventacamisetaestampa != null && !this.idventacamisetaestampa.equals(other.idventacamisetaestampa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.VentaCamisetaEstampa[ idventacamisetaestampa=" + idventacamisetaestampa + " ]";
    }
    
}
