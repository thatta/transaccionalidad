/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.transaccion;

import com.mycompany.entity.Clase;
import com.mycompany.interfaces.ClaseFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author USER
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class Transaccion2 implements Transaccion2Local {
    
    @EJB
    private ClaseFacadeLocal claseFacade;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Clase clase) {
        //lo recibimos en el segundo transaccional
        //como es de tipo required lo que va a hacer es unirse al transaccion anterior 
        //por lo que si falla, hace un rollback general, como si fuera una sola transaccion
        claseFacade.create(clase);

    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void crearReqNew(Clase clase){
        claseFacade.create(clase);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void crearSup(Clase clase){
        claseFacade.create(clase);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void crearMand(Clase clase){
        claseFacade.create(clase);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void crearNotSup(Clase clase){
        claseFacade.create(clase);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void crearNever(Clase clase){
        claseFacade.create(clase);
    }
}
