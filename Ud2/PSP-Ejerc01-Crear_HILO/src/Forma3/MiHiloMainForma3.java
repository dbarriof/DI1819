/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forma3;

/**
 *
 * @author dbarriof
 */
public class MiHiloMainForma3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        
        for (i=1;i<=20;i++){            
            MiHilo hilo = new MiHilo(i);
            hilo.start();            
        }
    }
    
}
