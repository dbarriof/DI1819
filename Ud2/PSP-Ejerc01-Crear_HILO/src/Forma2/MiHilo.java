package Forma2;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Guile
 */
public class MiHilo implements Runnable{
    private int nombre;
    private int time;

    public MiHilo(int nombre, int time) {
        this.nombre = nombre;
        this.time = time;
    }
    
    @Override
    public void run(){
        System.out.println("HILO "+nombre+" SE VA A DORMIR");
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(MiHilo.class.getName()).log(Level.SEVERE, null, ex);
        }       
        System.out.println("HILO "+nombre+" SE HA DESPERTADO");
    }
    
}
