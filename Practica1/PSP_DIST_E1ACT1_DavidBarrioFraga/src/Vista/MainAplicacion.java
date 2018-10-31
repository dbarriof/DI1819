/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Controlador.SincronizaMensajes;
import static java.lang.Thread.sleep;
import java.util.*;
import modelo.Persona;
import modelo.Wc;

/**
 *
 * @author dbarriof
 */
public class MainAplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wc banio = new Wc();

        //Generamos los 10 (Hilos)usuarios que entraran al baño y los iniciamos
        for (int i = 1; i <= 10; i++) {
            Persona p = new Persona("p" + i, banio);
            p.start();

            //Implementamos un sleep que hara acudir de forma aleatoria a los (Hilos)usuarios al baño 
            try {
                Thread.sleep((int) (Math.random() * 2000) + 1000);
            } catch (InterruptedException ex) {
                SincronizaMensajes.mostrarMensajes("Se ha producido un error al dormir el hilo: " + ex.getMessage());
            }
        }
        
        //Comprobamos la secuencia de Hombres y Mujeres que asistieron al baño
        banio.secuenciaUsuarios();
    }

}
