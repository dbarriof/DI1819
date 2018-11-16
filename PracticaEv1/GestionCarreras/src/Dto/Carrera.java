/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author dbarriof
 */
public class Carrera implements Serializable{
    private String nombre;
    private Date fecha;
    private String lugar;
    private int numMaxParticipantes;
    private List<Participante> participantes;
    private List<Integer> dorsales;

    //Constructor
    public Carrera(String nombre, Date fecha, String lugar, int numMaxParticipantes, ArrayList<Participante> participantes, ArrayList<Integer> dorsales) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.numMaxParticipantes = numMaxParticipantes;
        this.participantes = participantes;
        this.dorsales = dorsales;          
    }

    public Carrera() {
        participantes = new ArrayList<>();
        dorsales = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getNumMaxParticipantes() {
        return numMaxParticipantes;
    }

    public void setNumMaxParticipantes(int numMaxParticipantes) {
        this.numMaxParticipantes = numMaxParticipantes;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Integer> getDorsales() {        
        return dorsales;
    }

    public void setDorsales(ArrayList<Integer> dorsales) {
        this.dorsales = dorsales;
    }
    
   public String[] arrayToStrings(){
        String [] datos = new String [5];
        datos[0] = getNombre();
        datos[1] = getLugar();
        datos[2] = FormatoFecha.formatFecha(getFecha());
        datos[4] = String.valueOf(getNumMaxParticipantes());
        
        return datos;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar + ", numMaxParticipantes=" + numMaxParticipantes + ", participantes=" + participantes + ", dorsales=" + dorsales + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + Objects.hashCode(this.lugar);
        hash = 17 * hash + this.numMaxParticipantes;
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
        final Carrera other = (Carrera) obj;
        if (this.numMaxParticipantes != other.numMaxParticipantes) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.lugar, other.lugar)) {
            return false;
        }
        return true;
    }
    
    
}
