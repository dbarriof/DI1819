/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forma3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monica
 */
public class MiHilo implements Runnable {
        private String nombre;
        private int time;

    public MiHilo(int nombre) {
        this.nombre = String.valueOf(nombre);
        this.time = (int) ((Math.random()*5000)+1000);
    }
              
    public void start(){       
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    @Override
    public void run() {
        System.out.println("Hilo "+nombre+" se va a dormir "+time/1000+" segundos.");
        try {
            //Thread.s
            sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Hilo "+nombre+" se ha despertado.");
    }
    
}
