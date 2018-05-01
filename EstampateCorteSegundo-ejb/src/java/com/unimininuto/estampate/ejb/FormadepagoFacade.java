/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb;

import com.unimininuto.estampate.ejb.interfaces.FormadepagoFacadeLocal;
import com.unimininuto.estampate.entities.Formadepago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PRISTOPHER
 */
@Stateless
public class FormadepagoFacade extends AbstractFacade<Formadepago> implements FormadepagoFacadeLocal {

    @PersistenceContext(unitName = "EstampateCorteSegundo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormadepagoFacade() {
        super(Formadepago.class);
    }
    
}
