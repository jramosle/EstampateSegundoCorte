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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "venta_camiseta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaCamiseta.findAll", query = "SELECT v FROM VentaCamiseta v")
    , @NamedQuery(name = "VentaCamiseta.findByIdventacamiseta", query = "SELECT v FROM VentaCamiseta v WHERE v.idventacamiseta = :idventacamiseta")})
public class VentaCamiseta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idventacamiseta")
    private Integer idventacamiseta;
    @OneToMany(mappedBy = "idventacamiseta")
    private List<VentaCamisetaEstampa> ventaCamisetaEstampaList;
    @JoinColumn(name = "idtipocamiseta", referencedColumnName = "idtipocamisa")
    @ManyToOne
    private Tipocamisa idtipocamiseta;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    @ManyToOne
    private Ventas idventa;

    public VentaCamiseta() {
    }

    public VentaCamiseta(Integer idventacamiseta) {
        this.idventacamiseta = idventacamiseta;
    }

    public Integer getIdventacamiseta() {
        return idventacamiseta;
    }

    public void setIdventacamiseta(Integer idventacamiseta) {
        this.idventacamiseta = idventacamiseta;
    }

    @XmlTransient
    public List<VentaCamisetaEstampa> getVentaCamisetaEstampaList() {
        return ventaCamisetaEstampaList;
    }

    public void setVentaCamisetaEstampaList(List<VentaCamisetaEstampa> ventaCamisetaEstampaList) {
        this.ventaCamisetaEstampaList = ventaCamisetaEstampaList;
    }

    public Tipocamisa getIdtipocamiseta() {
        return idtipocamiseta;
    }

    public void setIdtipocamiseta(Tipocamisa idtipocamiseta) {
        this.idtipocamiseta = idtipocamiseta;
    }

    public Ventas getIdventa() {
        return idventa;
    }

    public void setIdventa(Ventas idventa) {
        this.idventa = idventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventacamiseta != null ? idventacamiseta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaCamiseta)) {
            return false;
        }
        VentaCamiseta other = (VentaCamiseta) object;
        if ((this.idventacamiseta == null && other.idventacamiseta != null) || (this.idventacamiseta != null && !this.idventacamiseta.equals(other.idventacamiseta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.VentaCamiseta[ idventacamiseta=" + idventacamiseta + " ]";
    }
    
}
