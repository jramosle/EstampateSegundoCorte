/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb.interfaces;

import com.unimininuto.estampate.entities.Tipocamisa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PRISTOPHER
 */
@Local
public interface TipocamisaFacadeLocal {

    void create(Tipocamisa tipocamisa);

    void edit(Tipocamisa tipocamisa);

    void remove(Tipocamisa tipocamisa);

    Tipocamisa find(Object id);

    List<Tipocamisa> findAll();

    List<Tipocamisa> findRange(int[] range);

    int count();
    
}
