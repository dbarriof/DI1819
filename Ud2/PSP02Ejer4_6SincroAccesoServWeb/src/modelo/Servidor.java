/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dbarriof
 */
public class Servidor {
    private int accesos;

    public Servidor() {
        accesos = 0;
    }
    
    public synchronized void nuevoAcceso(){
        accesos++;
    }

    public int getAccesos() {
        return accesos;
    }

    public void setAccesos(int accesos) {
        this.accesos = accesos;
    }
    
    
}
