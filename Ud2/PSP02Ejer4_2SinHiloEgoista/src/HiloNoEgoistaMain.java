/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */
public class HiloNoEgoistaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HiloColor hrojo = new HiloColor("rojo");
        //HiloColor hazul = new HiloColor("azul");
        HiloColor hverde = new HiloColor("verde");
        
        hrojo.setPriority(Thread.MIN_PRIORITY);
        //hazul.setPriority(Thread.MIN_PRIORITY);
        hverde.setPriority(Thread.MIN_PRIORITY);
        
        
        hrojo.start();
        //hazul.start();
        hverde.start();
        
    }
    
}
