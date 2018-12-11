/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */
public class Jardin {
    static int contPersonas;

    public Jardin(int contPersonas) {
        this.contPersonas = contPersonas;
    }
    
    public static void incrementarPersonas(int i) {
        contPersonas = contPersonas + i;
        System.out.println("Hilo "+Thread.currentThread().getName()+" ----Entra en jardin");
        System.out.println(contPersonas+" en jardin");
    }
    
    public static void decrementarPersonas(int i) {
        contPersonas = contPersonas - i;
        System.out.println("Hilo "+Thread.currentThread().getName()+" ----Sale de jardin");
        System.out.println(contPersonas+" en jardin");
    }
    
}
