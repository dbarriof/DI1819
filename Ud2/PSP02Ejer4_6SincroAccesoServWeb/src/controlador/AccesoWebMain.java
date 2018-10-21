/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.HiloTerminal;
import modelo.Servidor;

/**
 *
 * @author dbarriof
 */
public class AccesoWebMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int i;
        
       Servidor servidor = new Servidor();
       
       for(i=0;i<=20;i++){
           HiloTerminal t = new HiloTerminal("terminal"+String.valueOf(i), servidor);
           t.start();
           //System.out.println("El numero de accesos al servidor ha aumentado a: "+servidor.getAccesos());
       }            
        System.out.println("El numero de accesos al servidor ha sido: "+servidor.getAccesos());
    }
    
}
