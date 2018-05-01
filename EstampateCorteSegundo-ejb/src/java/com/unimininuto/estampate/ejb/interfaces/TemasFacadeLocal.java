/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unimininuto.estampate.ejb.interfaces;

import com.unimininuto.estampate.entities.Temas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PRISTOPHER
 */
@Local
public interface TemasFacadeLocal {

    void create(Temas temas);

    void edit(Temas temas);

    void remove(Temas temas);

    Temas find(Object id);

    List<Temas> findAll();

    List<Temas> findRange(int[] range);

    int count();
    
}
