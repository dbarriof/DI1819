package Forma1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Monica
 */
public class MiHiloMainForma1A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i, tiempo;
        for (i=1;i<21;i++){
            tiempo=(int) (Math.random()*5000+1000);
            MiHilo h = new MiHilo(i, tiempo);
            h.start();
        }
    }
    
}
