/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb.interfaces;

import com.unimininuto.estampate.entities.VentaCamisetaEstampa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PRISTOPHER
 */
@Local
public interface VentaCamisetaEstampaFacadeLocal {

    void create(VentaCamisetaEstampa ventaCamisetaEstampa);

    void edit(VentaCamisetaEstampa ventaCamisetaEstampa);

    void remove(VentaCamisetaEstampa ventaCamisetaEstampa);

    VentaCamisetaEstampa find(Object id);

    List<VentaCamisetaEstampa> findAll();

    List<VentaCamisetaEstampa> findRange(int[] range);

    int count();
    
}
