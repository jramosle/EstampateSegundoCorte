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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PRISTOPHER
 */
@Entity
@Table(name = "estampas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estampas.findAll", query = "SELECT e FROM Estampas e")
    , @NamedQuery(name = "Estampas.findByIdestampas", query = "SELECT e FROM Estampas e WHERE e.idestampas = :idestampas")
    , @NamedQuery(name = "Estampas.findByNombreestampa", query = "SELECT e FROM Estampas e WHERE e.nombreestampa = :nombreestampa")
    , @NamedQuery(name = "Estampas.findByPopularidad", query = "SELECT e FROM Estampas e WHERE e.popularidad = :popularidad")
    , @NamedQuery(name = "Estampas.findByRating", query = "SELECT e FROM Estampas e WHERE e.rating = :rating")
    , @NamedQuery(name = "Estampas.findByUrl", query = "SELECT e FROM Estampas e WHERE e.url = :url")})
public class Estampas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestampas")
    private Integer idestampas;
    @Size(max = 100)
    @Column(name = "nombreestampa")
    private String nombreestampa;
    @Column(name = "popularidad")
    private Integer popularidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private Float rating;
    @Size(max = 300)
    @Column(name = "url")
    private String url;
    @OneToMany(mappedBy = "idestampa")
    private List<VentaCamisetaEstampa> ventaCamisetaEstampaList;
    @JoinColumn(name = "idartista", referencedColumnName = "idusuariorol")
    @ManyToOne
    private UsuarioRol idartista;
    @JoinColumn(name = "idtema", referencedColumnName = "idtemas")
    @ManyToOne
    private Temas idtema;

    public Estampas() {
    }

    public Estampas(Integer idestampas) {
        this.idestampas = idestampas;
    }

    public Integer getIdestampas() {
        return idestampas;
    }

    public void setIdestampas(Integer idestampas) {
        this.idestampas = idestampas;
    }

    public String getNombreestampa() {
        return nombreestampa;
    }

    public void setNombreestampa(String nombreestampa) {
        this.nombreestampa = nombreestampa;
    }

    public Integer getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(Integer popularidad) {
        this.popularidad = popularidad;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<VentaCamisetaEstampa> getVentaCamisetaEstampaList() {
        return ventaCamisetaEstampaList;
    }

    public void setVentaCamisetaEstampaList(List<VentaCamisetaEstampa> ventaCamisetaEstampaList) {
        this.ventaCamisetaEstampaList = ventaCamisetaEstampaList;
    }

    public UsuarioRol getIdartista() {
        return idartista;
    }

    public void setIdartista(UsuarioRol idartista) {
        this.idartista = idartista;
    }

    public Temas getIdtema() {
        return idtema;
    }

    public void setIdtema(Temas idtema) {
        this.idtema = idtema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestampas != null ? idestampas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estampas)) {
            return false;
        }
        Estampas other = (Estampas) object;
        if ((this.idestampas == null && other.idestampas != null) || (this.idestampas != null && !this.idestampas.equals(other.idestampas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.Estampas[ idestampas=" + idestampas + " ]";
    }
    
}
