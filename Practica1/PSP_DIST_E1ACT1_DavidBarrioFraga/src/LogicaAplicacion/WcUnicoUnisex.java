/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaAplicacion;

import SincroMens.SincronizaMensajes;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;
import modelo.Wc;

/**
 *
 * @author dbarriof
 */
public class WcUnicoUnisex {

    private Wc banio;

    public WcUnicoUnisex() {
        banio = new Wc();
    }

    
    /**
     * Metodo que simula la entrada al baño de la persona recibida como
     * parametro
     *
     * @param persona
     */
    public synchronized void entrarBanio(Persona persona) {
            while(banio.isOcupado()){
                SincronizaMensajes.mostrarMensajes(persona.getNombre() + " intenta entrar en el baño, pero baño ocupado, " + persona.getNombre() + " ESPERANDO.\n");
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Wc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
            //Asignamos al baño la situacion de ocupado
            banio.setOcupado(true);

            //Añadimos el usuario a listado de personas que vinieron a este baño
            banio.aniadeUsuario(persona);

            //Mostramos mensaje informativo de la accion realizada
            SincronizaMensajes.mostrarMensajes("++++ La persona " + persona.getNombre() + " " + persona.getSexo() + " entra en el baño - Baño ocupado.\n");

                notifyAll();         
        
    }

    /**
     * Metodo que simula la salida del baño de la persona recibida como
     * parametro
     *
     * @param persona
     */
    public synchronized void salirBanio(Persona persona) {       
        //Mostramos mensaje informativo de la accion realizada
        SincronizaMensajes.mostrarMensajes("---- La persona " + persona.getNombre() + " " + persona.getSexo() + " sale del Baño - Baño libre.\n");

        //Asignamos al baño la situacion de libre
        banio.setOcupado(false);

        //Contabilizamos si se trata de un hombre o de una mujer y mostramos el resultado y la secuencia
            banio.cuentaUsuarios(persona);
            banio.secuenciaUsuarios();
            
        //Notificamos a los hilos bloqueados que pasen a ejecución de nuevo
        notifyAll();
    }

}    