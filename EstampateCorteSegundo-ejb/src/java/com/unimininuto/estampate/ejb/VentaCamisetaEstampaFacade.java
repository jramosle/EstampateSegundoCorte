/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb;

import com.unimininuto.estampate.ejb.interfaces.VentaCamisetaEstampaFacadeLocal;
import com.unimininuto.estampate.entities.VentaCamisetaEstampa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PRISTOPHER
 */
@Stateless
public class VentaCamisetaEstampaFacade extends AbstractFacade<VentaCamisetaEstampa> implements VentaCamisetaEstampaFacadeLocal {

    @PersistenceContext(unitName = "EstampateCorteSegundo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaCamisetaEstampaFacade() {
        super(VentaCamisetaEstampa.class);
    }
    
}
