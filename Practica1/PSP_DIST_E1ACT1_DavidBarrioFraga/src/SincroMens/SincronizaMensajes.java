/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SincroMens;

/**
 *
 * @author dbarriof
 */
public class SincronizaMensajes {
    public static synchronized void mostrarMensajes(String mensaje) {
        System.out.print(mensaje);
    }
}
