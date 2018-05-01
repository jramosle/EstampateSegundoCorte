/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb.interfaces;

import com.unimininuto.estampate.entities.Formadepago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PRISTOPHER
 */
@Local
public interface FormadepagoFacadeLocal {

    void create(Formadepago formadepago);

    void edit(Formadepago formadepago);

    void remove(Formadepago formadepago);

    Formadepago find(Object id);

    List<Formadepago> findAll();

    List<Formadepago> findRange(int[] range);

    int count();
    
}
