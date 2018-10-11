/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoExoplanetas;

/**
 *
 * @author dbarriof
 */
public class Exoplaneta {
    private String nombre;
    private double ejeMayor;
    private double periodoDias;
    private double excentricidad;

    public Exoplaneta(String nombre, Double ejeMayor, Double periodoDias, Double excentricidad) {
        this.nombre = nombre;
        this.ejeMayor = ejeMayor;
        this.periodoDias = periodoDias;
        this.excentricidad = excentricidad;
    }
    
    public Exoplaneta(String nombre, Double ejeMayor, Double periodoDias) {
        this.nombre = nombre;
        this.ejeMayor = ejeMayor;
        this.periodoDias = periodoDias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getEjeMayor() {
        return ejeMayor;
    }

    public void setEjeMayor(Double ejeMayor) {
        this.ejeMayor = ejeMayor;
    }

    public Double getPeriodoDias() {
        return periodoDias;
    }

    public void setPeriodoDias(Double periodoDias) {
        this.periodoDias = periodoDias;
    }

    public Double getExcentricidad() {
        return excentricidad;
    }

    public void setExcentricidad(Double excentricidad) {
        this.excentricidad = excentricidad;
    }

    @Override
    public String toString() {
        return "Exoplaneta{" + "nombre=" + nombre + ", ejeMayor=" + ejeMayor + ", periodoDias=" + periodoDias + ", excentricidad=" + excentricidad + '}';
    }
    
    
}
