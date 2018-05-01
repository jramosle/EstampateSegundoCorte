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
@Table(name = "tipocamisa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocamisa.findAll", query = "SELECT t FROM Tipocamisa t")
    , @NamedQuery(name = "Tipocamisa.findByIdtipocamisa", query = "SELECT t FROM Tipocamisa t WHERE t.idtipocamisa = :idtipocamisa")
    , @NamedQuery(name = "Tipocamisa.findByNombretipocamisa", query = "SELECT t FROM Tipocamisa t WHERE t.nombretipocamisa = :nombretipocamisa")})
public class Tipocamisa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipocamisa")
    private Integer idtipocamisa;
    @Size(max = 100)
    @Column(name = "nombretipocamisa")
    private String nombretipocamisa;
    @OneToMany(mappedBy = "idtipocamiseta")
    private List<VentaCamiseta> ventaCamisetaList;

    public Tipocamisa() {
    }

    public Tipocamisa(Integer idtipocamisa) {
        this.idtipocamisa = idtipocamisa;
    }

    public Integer getIdtipocamisa() {
        return idtipocamisa;
    }

    public void setIdtipocamisa(Integer idtipocamisa) {
        this.idtipocamisa = idtipocamisa;
    }

    public String getNombretipocamisa() {
        return nombretipocamisa;
    }

    public void setNombretipocamisa(String nombretipocamisa) {
        this.nombretipocamisa = nombretipocamisa;
    }

    @XmlTransient
    public List<VentaCamiseta> getVentaCamisetaList() {
        return ventaCamisetaList;
    }

    public void setVentaCamisetaList(List<VentaCamiseta> ventaCamisetaList) {
        this.ventaCamisetaList = ventaCamisetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipocamisa != null ? idtipocamisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocamisa)) {
            return false;
        }
        Tipocamisa other = (Tipocamisa) object;
        if ((this.idtipocamisa == null && other.idtipocamisa != null) || (this.idtipocamisa != null && !this.idtipocamisa.equals(other.idtipocamisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.Tipocamisa[ idtipocamisa=" + idtipocamisa + " ]";
    }
    
}
