/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import SincroMens.SincronizaMensajes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

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

    public void aniadeUsuario(Persona persona){
        usuarios.add(persona);
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
        SincronizaMensajes.mostrarMensajes("Han entrado " + usuariosMujeres + " mujeres y " + usuariosHombres + " hombres.\n");
    }

    /**
     * Metodo que imprime en pantalla la secuencia de usuarios del baño en
     * funcion de la inicial de su sexo.
     */
    public void secuenciaUsuarios() {
        SincronizaMensajes.mostrarMensajes("Secuencia de personas: ");
        for (Persona u : usuarios) {
            SincronizaMensajes.mostrarMensajes(" " + u.getSexo());
        }
        SincronizaMensajes.mostrarMensajes("\n");
        
    }
    
}
