/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */
public class HiloPuertaSalida extends Thread{
    Jardin j;
    
    public HiloPuertaSalida(String nombre, Jardin j) {
        this.setName(nombre);
        this.j = j;
    }
    
    @Override
    public void run() {
        synchronized(j){       
        Jardin.decrementarPersonas(1);
        }
    }
    
}
