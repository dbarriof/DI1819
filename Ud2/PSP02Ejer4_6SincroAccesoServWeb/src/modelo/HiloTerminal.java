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
public class HiloTerminal extends Thread{
    String nombre;
    Servidor serv;

    public HiloTerminal(String nombre, Servidor serv) {
        this.nombre = nombre;
        this.setName(nombre);
        this.serv = serv;
    }

    @Override
    public void run() {
        //synchronized (serv){
        serv.nuevoAcceso();
        //}
    }
    
    
}
