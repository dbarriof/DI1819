/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */
public class HiloPuertaEntrada extends Thread{
    
    public HiloPuertaEntrada(String nombre) {
        this.setName(nombre);
    }

    @Override
    public void run() {
        Jardin.incrementarPersonas(1);
    }
    
    
}
