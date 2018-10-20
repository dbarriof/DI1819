
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
        System.out.println("ASIGNA PRIORIDAD MAXIMA A THREAD ACTUAL");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        
        System.out.println("CREO HILOS");
        MiHilo hiloLOW = new MiHilo(Thread.NORM_PRIORITY +2, "hiloLOW");
        MiHilo hiloHIGH = new MiHilo(Thread.NORM_PRIORITY -2, "hiloHIGH");
    
        System.out.println("INICIO HILOS SECUNDARIOS");
        hiloLOW.start();
        hiloHIGH.start();
        
        System.out.println("DUERMO HILO MAIN");
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {}
        
        System.out.println("PARO HILOS SECUNDARIOS");
        hiloLOW.stop();
        hiloHIGH.stop();
        
        System.err.println("ESTADO HILOS SECUNDARIOS");
        System.out.println(hiloLOW.t.isAlive());
        System.out.println(hiloHIGH.t.isAlive());
        
        System.out.println("ASIGNO CPU A HILO LOW");
        try {
            hiloLOW.t.join();
        } catch (InterruptedException ex) {}
        
        System.out.println("ASIGNO CPU A HILO HIGH");
        try {
            hiloHIGH.t.join();
        } catch (InterruptedException ex) {}
             
        System.err.println("ESTADO HILOS SECUNDARIOS");
        System.out.println(hiloLOW.t.isAlive());
        System.out.println(hiloHIGH.t.isAlive());
        
        System.err.println("ESTADO HILOS SECUNDARIOS");
        System.out.println(hiloLOW.t.getState());
        System.out.println(hiloHIGH.t.getState());
        
        System.err.println("CONTADOR DE EJECUCIONES");
        System.out.println( hiloLOW.contador );
        System.out.println( hiloHIGH.contador );
        
        
    }
    
}
