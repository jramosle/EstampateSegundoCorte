package com.unimininuto.estampate.ejb.interfaces;

import com.unimininuto.estampate.entities.Ciudad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PRISTOPHER
 */
@Local
public interface CiudadFacadeLocal {

    void create(Ciudad ciudad);

    void edit(Ciudad ciudad);

    void remove(Ciudad ciudad);

    Ciudad find(Object id);

    List<Ciudad> findAll();

    List<Ciudad> findRange(int[] range);

    int count();
    
}
