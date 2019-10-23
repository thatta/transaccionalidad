/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.transaccion;

import com.mycompany.entity.Clase;
import com.mycompany.entity.Persona;
import javax.ejb.Local;

/**
 *
 * @author USER
 */
@Local
public interface TransaccionLocal {

    public void crear(Persona persona, Clase clase);

    public void crear1(Persona persona, Clase clase);

    public void crear2(Persona persona, Clase clase);

    public void crear3(Persona persona, Clase clase);

    public void crear4(Persona persona, Clase clase);

    public void crear5(Persona persona, Clase clase);
    
    void crearTransaccional(Persona persona, Clase clase);
    
    void crearTransaccionalReqNew(Persona persona, Clase clase);
    
    void crearTransaccionalSupport(Persona persona, Clase clase);
    
    void crearTransaccionalMandatory(Persona persona, Clase clase);
    
    void crearTransaccionalNotSup(Persona persona, Clase clase);
    
    void crearTransaccionalNever(Persona persona, Clase clase);
}
