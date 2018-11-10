/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author dbarriof
 */
public class Participante {
    private Corredor corredor;
    private int dorsal;
    private Carrera carrera;
    private int tiempo;
    private int posición;

    public Participante(Corredor corredor, int dorsal, Carrera carrera) {
        this.corredor = corredor;
        this.dorsal = dorsal;
        this.carrera = carrera;
        tiempo = 0;
        tiempo = 0;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Participante{" + "corredor=" + corredor + ", dorsal=" + dorsal + ", carrera=" + carrera + '}';
    }
    
    
}
