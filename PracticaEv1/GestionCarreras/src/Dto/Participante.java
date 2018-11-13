/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author dbarriof
 */
public class Participante implements Serializable{
    private Corredor corredor;
    private int dorsal;
    private Carrera carrera;
    private Date tiempo;
    private int posicion;

    public Participante(Corredor corredor, Carrera carrera) {
        this.corredor = corredor;
        this.dorsal = 0;
        this.carrera = carrera;
        tiempo = null;
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

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    
    
    public String[] arrayToStrings(){
        String [] datos = new String [5];
        datos[0] = String.valueOf(getDorsal());
        datos[1] = corredor.getNombre();
        datos[2] = corredor.getDni();
        if (tiempo == null){datos[3] = "N/A";}else{ datos[3] = String.valueOf(tiempo);}
        if (posicion == 0){datos[4] = "N/A";}else{ datos[4] = String.valueOf(posicion);}    
        
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
