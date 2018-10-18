
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */
public class NewHilo implements Runnable{
    private Thread hilo;
    private String nombre;

    public NewHilo(String nombre) {
        this.nombre = nombre;
        this.start();
    }
       
    public void start() {
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        int i;
        for(i=1;i<=5;i++){
            System.out.println("Hilo "+i+" "+nombre+" iniciado.");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NewHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Saliendo el hilo: "+nombre);
        }
    }    
    
    
}
