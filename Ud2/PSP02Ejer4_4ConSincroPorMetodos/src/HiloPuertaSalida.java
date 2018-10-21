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

    public HiloPuertaSalida(String nombre) {
        this.setName(nombre);
    }
    
    @Override
    public void run() {
        Jardin.decrementarPersonas(1);
    }
}
