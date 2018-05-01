/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb.interfaces;

import com.unimininuto.estampate.entities.Estampas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PRISTOPHER
 */
@Local
public interface EstampasFacadeLocal {

    void create(Estampas estampas);

    void edit(Estampas estampas);

    void remove(Estampas estampas);

    Estampas find(Object id);

    List<Estampas> findAll();

    List<Estampas> findRange(int[] range);

    int count();
    
}
