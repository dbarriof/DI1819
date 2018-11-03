/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import LogicaAplicacion.WcUnicoUnisex;
import SincroMens.SincronizaMensajes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dbarriof
 */
public class Persona extends Thread {

    private String nombre;
    private char sexo;
    private WcUnicoUnisex banio;

    public Persona(String nombre, WcUnicoUnisex banio) {
        this.nombre = nombre;

        //Se genera el sexo de la persona de forma aleatoria
        int random = (int) (Math.random() * 2);
        if (random == 1) {
            sexo = 'H';
        } else {
            sexo = 'M';
        }

        this.banio = banio;
    }
    

    @Override
    public void run() {
        SincronizaMensajes.mostrarMensajes("La persona " + nombre + " va al baño.\n");
            banio.entrarBanio(this);
        
            //Simulación del tiempo de uso del baño
            try {
                sleep((int) (Math.random() * 2000) + 500);
            } catch (InterruptedException ex) {
                SincronizaMensajes.mostrarMensajes("Se ha producido un error al dormir el hilo: " + ex.getMessage()+".\n");
            }
        
            banio.salirBanio(this); 

        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public WcUnicoUnisex getBanio() {
        return banio;
    }

    public void setBanio(WcUnicoUnisex banio) {
        this.banio = banio;
    }

}
