/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.Objects;

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

    public Participante(Corredor corredor, Carrera carrera) {
        this.corredor = corredor;
        this.dorsal = 0;
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
    
    public String[] arrayToStrings(){
        String [] datos = new String [5];
        datos[0] = String.valueOf(getDorsal());
        datos[1] = corredor.getNombre();
        datos[2] = corredor.getDni();
        if (tiempo == 0){datos[3] = "N/A";}else{ datos[3] = String.valueOf(tiempo);}
        if (posición == 0){datos[4] = "N/A";}else{ datos[4] = String.valueOf(posición);}    
        
        return datos;
    }

    @Override
    public String toString() {
        return "Participante{" + "corredor=" + corredor + ", dorsal=" + dorsal + ", carrera=" + carrera + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.corredor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participante other = (Participante) obj;
        if (!Objects.equals(this.corredor, other.corredor)) {
            return false;
        }
        return true;
    }
    
    
}
