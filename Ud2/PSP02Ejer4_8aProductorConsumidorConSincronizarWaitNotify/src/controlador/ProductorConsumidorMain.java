/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Consumidor;
import modelo.DatosCompartidos;
import modelo.Productor;

/**
 *
 * @author dbarriof
 */
public class ProductorConsumidorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosCompartidos compartido = new DatosCompartidos();
        
        Productor p = new Productor(compartido, "P1");
        Consumidor c = new Consumidor(compartido, "C1");
        
        p.start();
        c.start();
        
    }
    
}
