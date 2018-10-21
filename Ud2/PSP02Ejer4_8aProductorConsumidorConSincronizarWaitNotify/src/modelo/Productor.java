/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dbarriof
 */
public class Productor extends Thread {

    DatosCompartidos compartido;
    String nombre;

    public Productor(DatosCompartidos compartido, String nombre) {
        this.compartido = compartido;
        this.nombre = nombre;
        this.setName(nombre);
    }

    @Override
    public void run() {
        int i;
        for (i = 1; i <= 5; i++) {          
            compartido.almacenarDato(nombre + String.valueOf(i));
            System.out.println("Productor: " + nombre + " Iteración: " + i); 
            //Thread.yield();
        } 
    }
}
    


