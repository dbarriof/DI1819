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
public class Persona extends Thread {

    private String nombre;
    private char sexo;
    private Wc banio;

    public Persona(String nombre, Wc banio) {
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
        System.out.println("La persona " + nombre + " va al baño.");
        banio.entrarBanio(this);
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

    public Wc getBanio() {
        return banio;
    }

    public void setBanio(Wc banio) {
        this.banio = banio;
    }

}
