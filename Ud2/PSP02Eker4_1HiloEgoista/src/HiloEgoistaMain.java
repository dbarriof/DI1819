/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */
public class HiloEgoistaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HiloColor hrojo = new HiloColor("Rojo");
        HiloColor hazul = new HiloColor("Azul");
        HiloColor hverde = new HiloColor("Verde");
        
        hrojo.start();
        hazul.start();
        hverde.start();
    }
    
}
