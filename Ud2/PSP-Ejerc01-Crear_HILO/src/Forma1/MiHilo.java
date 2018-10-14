package Forma1;


import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Monica
 */
public class MiHilo extends Thread{
    private int nombre;
    private int time;

    public MiHilo(int nombre, int time) {
        //super(nombre);
        this.nombre = nombre;
        this.time = time;
    }
    
    public void run(){
        System.out.println("HILO "+nombre+" SE VA A DORMIR");
        try {
            sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("HILO "+nombre+" SE HA DESPERTADO");
    }
    
}
