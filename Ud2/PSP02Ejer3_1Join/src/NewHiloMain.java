
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
public class NewHiloMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaracion de hilos
        NewHilo h1 = new NewHilo("hilo1");
        NewHilo h2 = new NewHilo("hilo2");
        NewHilo h3 = new NewHilo("hilo3");
        
        //comprobacion del hilo activo:
        System.out.println(Thread.currentThread().getName());
        
        //Comprobacion hilos secundarios habilitados:
        System.out.println(h1.hilo.isAlive());
        System.out.println(h2.hilo.isAlive());
        System.out.println(h3.hilo.isAlive());
        
        //Cediendo control del hilo principal a los hilos indicados hasta su finalizacion
        try {
            h1.hilo.join();
            h2.hilo.join();
            h3.hilo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(NewHiloMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Recupera la ejecucion el hilo principal: 
        System.out.println(Thread.currentThread().getName());
        
        //Comprobacion hilos secundarios habilitados:
        System.out.println(h1.hilo.isAlive());
        System.out.println(h2.hilo.isAlive());
        System.out.println(h3.hilo.isAlive());
        
    }
    
}
