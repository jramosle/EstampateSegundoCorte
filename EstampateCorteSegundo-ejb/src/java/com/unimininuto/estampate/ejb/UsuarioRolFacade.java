/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb;

import com.unimininuto.estampate.ejb.interfaces.UsuarioRolFacadeLocal;
import com.unimininuto.estampate.entities.UsuarioRol;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PRISTOPHER
 */
@Stateless
@LocalBean
public class UsuarioRolFacade extends AbstractFacade<UsuarioRol> implements UsuarioRolFacadeLocal {

    @PersistenceContext(unitName = "EstampateCorteSegundo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRolFacade() {
        super(UsuarioRol.class);
    }

    @Override
    public List<UsuarioRol> validateUserLogin(String usuarioAValidar, String passwordAValidar) {

        List<UsuarioRol> validarUsuario = em.createNamedQuery("UsuarioRol.findByUserAndPass", UsuarioRol.class)
                .setParameter("username", usuarioAValidar)
                .setParameter("pass", passwordAValidar).getResultList();        
    
        return validarUsuario;
        
        
    }
    
}
