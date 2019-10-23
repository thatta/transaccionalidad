/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.transaccion;

import com.mycompany.entity.Clase;
import com.mycompany.entity.Persona;
import com.mycompany.interfaces.ClaseFacadeLocal;
import com.mycompany.interfaces.PersonaFacadeLocal;
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
public class Transaccion implements TransaccionLocal {

    @EJB
    private PersonaFacadeLocal personaFacade;

    @EJB
    private ClaseFacadeLocal claseFacade;
    
    @EJB
    Transaccion2Local transaccionLocal;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crear(Persona persona, Clase clase) {

        claseFacade.create(clase);
        personaFacade.create(persona);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

    public void crear1(Persona persona, Clase clase) {

        claseFacade.create(clase);
        personaFacade.create(persona);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public void crear2(Persona persona, Clase clase) {

        claseFacade.create(clase);
        personaFacade.create(persona);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)

    public void crear3(Persona persona, Clase clase) {

        claseFacade.create(clase);
        personaFacade.create(persona);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)

    public void crear4(Persona persona, Clase clase) {

        claseFacade.create(clase);
        personaFacade.create(persona);

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)

    public void crear5(Persona persona, Clase clase) {

        claseFacade.create(clase);
        personaFacade.create(persona);

    }
    
    //Metodos transaccionales
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccional(Persona persona, Clase clase) {
        //acá los recibimos del controlador y persona se crea en este transaccional 
        //clase se crea en el siguiente transaccional
        //si falla acá no hace cambios en la BD
        personaFacade.create(persona);
        //envía el objeto entity de clase al otro transaccional
        transaccionLocal.crear(clase);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalReqNew(Persona persona, Clase clase){
        transaccionLocal.crearReqNew(clase);
        personaFacade.create(persona);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalSupport(Persona persona, Clase clase){
        personaFacade.create(persona);
        transaccionLocal.crearSup(clase);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalMandatory(Persona persona, Clase clase){
        personaFacade.create(persona);
        transaccionLocal.crearMand(clase);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalNotSup(Persona persona, Clase clase){
        personaFacade.create(persona);
        transaccionLocal.crearNotSup(clase);
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void crearTransaccionalNever(Persona persona, Clase clase){
        personaFacade.create(persona);
        transaccionLocal.crearNever(clase);
    }
}
