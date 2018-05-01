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
@Table(name = "preorden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preorden.findAll", query = "SELECT p FROM Preorden p")
    , @NamedQuery(name = "Preorden.findByIdpreorden", query = "SELECT p FROM Preorden p WHERE p.idpreorden = :idpreorden")
    , @NamedQuery(name = "Preorden.findByDireccionusuario", query = "SELECT p FROM Preorden p WHERE p.direccionusuario = :direccionusuario")
    , @NamedQuery(name = "Preorden.findByCodigopostal", query = "SELECT p FROM Preorden p WHERE p.codigopostal = :codigopostal")})
public class Preorden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpreorden")
    private Integer idpreorden;
    @Size(max = 200)
    @Column(name = "direccionusuario")
    private String direccionusuario;
    @Size(max = 50)
    @Column(name = "codigopostal")
    private String codigopostal;
    @JoinColumn(name = "idciudadusuario", referencedColumnName = "idcuidad")
    @ManyToOne
    private Ciudad idciudadusuario;
    @JoinColumn(name = "idformadepago", referencedColumnName = "idformapago")
    @ManyToOne
    private Formadepago idformadepago;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuarios idusuario;
    @OneToMany(mappedBy = "idpreorden")
    private List<Ventas> ventasList;

    public Preorden() {
    }

    public Preorden(Integer idpreorden) {
        this.idpreorden = idpreorden;
    }

    public Integer getIdpreorden() {
        return idpreorden;
    }

    public void setIdpreorden(Integer idpreorden) {
        this.idpreorden = idpreorden;
    }

    public String getDireccionusuario() {
        return direccionusuario;
    }

    public void setDireccionusuario(String direccionusuario) {
        this.direccionusuario = direccionusuario;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Ciudad getIdciudadusuario() {
        return idciudadusuario;
    }

    public void setIdciudadusuario(Ciudad idciudadusuario) {
        this.idciudadusuario = idciudadusuario;
    }

    public Formadepago getIdformadepago() {
        return idformadepago;
    }

    public void setIdformadepago(Formadepago idformadepago) {
        this.idformadepago = idformadepago;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpreorden != null ? idpreorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preorden)) {
            return false;
        }
        Preorden other = (Preorden) object;
        if ((this.idpreorden == null && other.idpreorden != null) || (this.idpreorden != null && !this.idpreorden.equals(other.idpreorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.Preorden[ idpreorden=" + idpreorden + " ]";
    }
    
}
