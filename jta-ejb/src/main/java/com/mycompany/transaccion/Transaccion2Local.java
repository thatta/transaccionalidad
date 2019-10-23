/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.transaccion;

import com.mycompany.entity.Clase;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface Transaccion2Local {
    void crear(Clase clase);
    
    void crearReqNew(Clase clase);
    
    void crearSup(Clase clase);
    
    void crearMand(Clase clase);
    
    void crearNotSup(Clase clase);
    
    void crearNever(Clase clase);
}
