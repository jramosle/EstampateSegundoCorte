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
@Table(name = "temas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Temas.findAll", query = "SELECT t FROM Temas t")
    , @NamedQuery(name = "Temas.findByIdtemas", query = "SELECT t FROM Temas t WHERE t.idtemas = :idtemas")
    , @NamedQuery(name = "Temas.findByNombretema", query = "SELECT t FROM Temas t WHERE t.nombretema = :nombretema")
    , @NamedQuery(name = "Temas.findByDescripciontema", query = "SELECT t FROM Temas t WHERE t.descripciontema = :descripciontema")})
public class Temas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtemas")
    private Integer idtemas;
    @Size(max = 100)
    @Column(name = "nombretema")
    private String nombretema;
    @Size(max = 300)
    @Column(name = "descripciontema")
    private String descripciontema;
    @OneToMany(mappedBy = "idtema")
    private List<Estampas> estampasList;

    public Temas() {
    }

    public Temas(Integer idtemas) {
        this.idtemas = idtemas;
    }

    public Integer getIdtemas() {
        return idtemas;
    }

    public void setIdtemas(Integer idtemas) {
        this.idtemas = idtemas;
    }

    public String getNombretema() {
        return nombretema;
    }

    public void setNombretema(String nombretema) {
        this.nombretema = nombretema;
    }

    public String getDescripciontema() {
        return descripciontema;
    }

    public void setDescripciontema(String descripciontema) {
        this.descripciontema = descripciontema;
    }

    @XmlTransient
    public List<Estampas> getEstampasList() {
        return estampasList;
    }

    public void setEstampasList(List<Estampas> estampasList) {
        this.estampasList = estampasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtemas != null ? idtemas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temas)) {
            return false;
        }
        Temas other = (Temas) object;
        if ((this.idtemas == null && other.idtemas != null) || (this.idtemas != null && !this.idtemas.equals(other.idtemas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.Temas[ idtemas=" + idtemas + " ]";
    }
    
}
