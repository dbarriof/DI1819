package Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un corredor cuando es participante de una carrera
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
        posicion = 0;
    }

    public Participante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if (String.valueOf(posicion) == null){datos[4] = "N/A";}else{ datos[4] = String.valueOf(posicion);}    
        
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
