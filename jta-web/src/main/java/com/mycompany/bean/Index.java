/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.entity.Clase;
import com.mycompany.entity.Persona;
import com.mycompany.transaccion.TransaccionLocal;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

/**
 *
 * @author USER
 */
@Named
@RequestScoped
public class Index implements Serializable {

    private String nombre;
    private String nombreC;

    @EJB
    TransaccionLocal transaccion;

    public Index() {
        System.out.println("Entra cons");
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    Persona persona;
    private List<Persona> lista;

    Clase clase;
    private List<Clase> listaC;

    public void agregar() {

        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crear(per, c);
        System.out.println("agrego");

        /* System.out.println("nombre"+getNombre());
         System.out.println("nombreC"+getNombreC());*/
    }

    public void requestnew() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crear1(per, c);
        System.out.println("agrego");
    }

    public void supports() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crear2(per, c);
    }

    public void mandatory() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crear3(per, c);
    }

    public void notsupport() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crear4(per, c);
    }

    public void never() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crear5(per, c);
    }

    //Transaccionales
    public void agregarTransReq() {
        //entra al metodo y crea los dos objetos entitys
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        //son envíados al metodo en transaccional
        transaccion.crearTransaccional(per, c);
        System.out.println("agrego");
    }

    public void agregarTransReqNew() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crearTransaccionalReqNew(per, c);
        System.out.println("agrego");
    }
    
    public void agregarTransSup() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crearTransaccionalSupport(per, c);
        System.out.println("agrego");
    }
    
    public void agregarTransMand() {
        Persona per = new Persona(nombre);//por que envías el id si es auto incremental??? 
        Clase c = new Clase(nombreC);
        transaccion.crearTransaccionalMandatory(per, c);
        System.out.println("agrego");
    }
    
    public void agregarTransNotSup() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crearTransaccionalNotSup(per, c);
        System.out.println("agrego");
    }
    
    public void agregarTransNever() {
        Persona per = new Persona(nombre);
        Clase c = new Clase(nombreC);
        transaccion.crearTransaccionalNever(per, c);
        System.out.println("agrego");
    }

}
