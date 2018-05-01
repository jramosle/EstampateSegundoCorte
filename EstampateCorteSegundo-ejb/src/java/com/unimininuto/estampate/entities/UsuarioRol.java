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
@Table(name = "usuario_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u")
    , @NamedQuery(name = "UsuarioRol.findByIdusuariorol", query = "SELECT u FROM UsuarioRol u WHERE u.idusuariorol = :idusuariorol")
    , @NamedQuery(name = "UsuarioRol.findByUsername", query = "SELECT u FROM UsuarioRol u WHERE u.username = :username")
    , @NamedQuery(name = "UsuarioRol.findByPass", query = "SELECT u FROM UsuarioRol u WHERE u.pass = :pass")
    , @NamedQuery(name = "UsuarioRol.findByUserAndPass", query = "SELECT u FROM UsuarioRol u WHERE u.username = :username and u.pass = :pass")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuariorol")
    private Integer idusuariorol;
    @Size(max = 50)
    @Column(name = "username")
    private String username;
    @Size(max = 200)
    @Column(name = "pass")
    private String pass;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private Roles idrol;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuarios idusuario;
    @OneToMany(mappedBy = "idartista")
    private List<Estampas> estampasList;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public Integer getIdusuariorol() {
        return idusuariorol;
    }

    public void setIdusuariorol(Integer idusuariorol) {
        this.idusuariorol = idusuariorol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Roles getIdrol() {
        return idrol;
    }

    public void setIdrol(Roles idrol) {
        this.idrol = idrol;
    }

    public Usuarios getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuarios idusuario) {
        this.idusuario = idusuario;
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
        hash += (idusuariorol != null ? idusuariorol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.idusuariorol == null && other.idusuariorol != null) || (this.idusuariorol != null && !this.idusuariorol.equals(other.idusuariorol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unimininuto.estampate.dao.UsuarioRol[ idusuariorol=" + idusuariorol + " ]";
    }
    
}
