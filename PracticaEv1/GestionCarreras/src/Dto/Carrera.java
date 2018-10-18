/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.*;

/**
 *
 * @author dbarriof
 */
public class Carrera {
    private String nombre;
    private Date fecha;
    private String lugar;
    private int numMaxParticipantes;
    private Map corredores;

    public Carrera(String nombre, Date fecha, String lugar, int numMaxParticipantes, Map corredores) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.numMaxParticipantes = numMaxParticipantes;
        this.corredores = corredores;
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

    public Map getCorredores() {
        return corredores;
    }

    public void setCorredores(Map corredores) {
        this.corredores = corredores;
    }
    
    
}
