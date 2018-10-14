package Forma1;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Monica
 */
public class MiHiloMainForma1B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i, tiempo;
        System.out.println("¿Cuantos hilos desea arrancar?");
        int numHilos = s.nextInt();
        
        for (i=1;i<numHilos+1;i++){
            tiempo=(int) (Math.random()*5000+1000);
            MiHilo h = new MiHilo(i, tiempo);
            h.start();
        }
    }
    
}
