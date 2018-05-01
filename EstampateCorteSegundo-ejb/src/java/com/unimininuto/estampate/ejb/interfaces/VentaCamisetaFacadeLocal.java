/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb.interfaces;

import com.unimininuto.estampate.entities.VentaCamiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PRISTOPHER
 */
@Local
public interface VentaCamisetaFacadeLocal {

    void create(VentaCamiseta ventaCamiseta);

    void edit(VentaCamiseta ventaCamiseta);

    void remove(VentaCamiseta ventaCamiseta);

    VentaCamiseta find(Object id);

    List<VentaCamiseta> findAll();

    List<VentaCamiseta> findRange(int[] range);

    int count();
    
}
