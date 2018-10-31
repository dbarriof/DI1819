/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.SincronizaMensajes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbarriof
 */
public class Wc {

    private boolean ocupado;
    private int usuariosHombres;
    private int usuariosMujeres;
    private List<Persona> usuarios;

    public Wc() {
        ocupado = false;
        usuariosHombres = 0;
        usuariosMujeres = 0;
        usuarios = new ArrayList();
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getUsuariosHombres() {
        return usuariosHombres;
    }

    public void setUsuariosHombres(int usuariosHombres) {
        this.usuariosHombres = usuariosHombres;
    }

    public int getUsuariosMujeres() {
        return usuariosMujeres;
    }

    public void setUsuariosMujeres(int usuariosMujeres) {
        this.usuariosMujeres = usuariosMujeres;
    }

    public List<Persona> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Persona> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Metodo que simula la entrada al baño de la persona recibida como
     * parametro
     *
     * @param persona
     */
    public synchronized void entrarBanio(Persona persona) {
        //Asignamos al baño la situacion de ocupado
        ocupado = true;

        //Añadimos el usuario a listado de personas que vinieron a este baño
        usuarios.add(persona);

        //Mostramos mensaje informativo de la accion realizada
        SincronizaMensajes.mostrarMensajes("++++ La persona " + persona.getNombre() + " " + persona.getSexo() + " entra en el baño - Baño ocupado");

        //Contabilizamos si se trata de un hombre o de una mujer
        cuentaUsuarios(persona);

        //Simulación del tiempo de uso del baño
        try {
            persona.sleep((int) (Math.random() * 2000) + 500);
        } catch (InterruptedException ex) {
            SincronizaMensajes.mostrarMensajes("Se ha producido un error al dormir el hilo: " + ex.getMessage());
        }
    }

    /**
     * Metodo que simula la salida del baño de la persona recibida como
     * parametro
     *
     * @param persona
     */
    public synchronized void salirBanio(Persona persona) {
        //Mostramos mensaje informativo de la accion realizada
        SincronizaMensajes.mostrarMensajes("---- La persona " + persona.getNombre() + " " + persona.getSexo() + " sale del Baño - Baño libre");

        //Asignamos al baño la situacion de libre
        ocupado = false;

        //Notificamos a los hilos bloqueados que pasen a ejecución de nuevo
        notifyAll();
    }

    /**
     * Metodo que contabiliza el numero de hombres y mujeres que han usado el
     * baño mostrando el numero de ellos de cada uno de los sexos
     *
     * @param persona
     */
    public void cuentaUsuarios(Persona persona) {
        if (persona.getSexo() == 'H') {
            usuariosHombres++;
        } else {
            usuariosMujeres++;
        }

        //Mostramos mensaje informativo de la accion realizada
        SincronizaMensajes.mostrarMensajes("Han entrado " + usuariosMujeres + " mujeres y " + usuariosHombres + " hombres.");
    }

    /**
     * Metodo que imprime en pantalla la secuencia de usuarios del baño en
     * funcion de la inicial de su sexo.
     */
    public void secuenciaUsuarios() {
        System.out.print("Secuencia de personas: ");
        for (Persona u : usuarios) {
            System.out.print(" " + u.getSexo());
        }
    }
}
