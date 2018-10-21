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
public class DatosCompartidos {
    String cadena;
    boolean hayDato = false;

    public synchronized void almacenarDato(String cadena){
        while(hayDato){
            try {
                Thread.yield();
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosCompartidos.class.getName()).log(Level.SEVERE, null, ex);
            }                  
        } 
        this.cadena = cadena;
        hayDato = true;
        notifyAll();  
        
}
    
    public synchronized String getDato(){
        while(!hayDato){
            try {                         
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosCompartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        hayDato = false;  
        notifyAll();
        return cadena;
    }    
}    
