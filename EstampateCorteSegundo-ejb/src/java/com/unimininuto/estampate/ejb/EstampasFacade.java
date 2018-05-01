/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb;

import com.unimininuto.estampate.ejb.interfaces.EstampasFacadeLocal;
import com.unimininuto.estampate.entities.Estampas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PRISTOPHER
 */
@Stateless
public class EstampasFacade extends AbstractFacade<Estampas> implements EstampasFacadeLocal {

    @PersistenceContext(unitName = "EstampateCorteSegundo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstampasFacade() {
        super(Estampas.class);
    }
    
}
