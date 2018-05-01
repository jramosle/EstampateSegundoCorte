/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb.interfaces;

import com.unimininuto.estampate.entities.Preorden;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PRISTOPHER
 */
@Local
public interface PreordenFacadeLocal {

    void create(Preorden preorden);

    void edit(Preorden preorden);

    void remove(Preorden preorden);

    Preorden find(Object id);

    List<Preorden> findAll();

    List<Preorden> findRange(int[] range);

    int count();
    
}
