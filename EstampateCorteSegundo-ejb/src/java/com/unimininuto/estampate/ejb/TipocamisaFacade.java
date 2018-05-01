/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb;

import com.unimininuto.estampate.ejb.interfaces.TipocamisaFacadeLocal;
import com.unimininuto.estampate.entities.Tipocamisa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PRISTOPHER
 */
@Stateless
public class TipocamisaFacade extends AbstractFacade<Tipocamisa> implements TipocamisaFacadeLocal {

    @PersistenceContext(unitName = "EstampateCorteSegundo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipocamisaFacade() {
        super(Tipocamisa.class);
    }
    
}
