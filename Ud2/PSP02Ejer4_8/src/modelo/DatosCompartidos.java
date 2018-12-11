/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dbarriof
 */
public class DatosCompartidos {
    String cadena;

    public DatosCompartidos() {
        this.cadena = null;
    }

    public synchronized String getCadena() {
        return cadena;
    }

    public synchronized void setCadena(String cadena) {
        this.cadena = cadena;
    }
        
}
