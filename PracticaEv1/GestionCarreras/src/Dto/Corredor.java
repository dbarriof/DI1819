package Dto;

import gui.Recursos.FormatoFecha;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Clase que representa a un corredor
 * 
 * @author dbarriof
 */
public class Corredor implements Serializable{
    private String nombre;
    private String dni;
    private Date fechaNac;
    private String direccion;
    private int telefono;

    public Corredor(String nombre, String dni, Date fechaNac, String direccion, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Corredor() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String[] arrayToStrings(){
        String [] datos = new String [5];
        datos[0] = getNombre();
        datos[1] = getDni();
        datos[2] = FormatoFecha.formatearFecha(getFechaNac());
        datos[3] = getDireccion();
        datos[4] = String.valueOf(getTelefono());
        
        return datos;
    }

    @Override
    public String toString() {
        return "Corredor{" + "nombre=" + nombre + ", dni=" + dni + ", fechaNac=" + fechaNac + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.dni);
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
        final Corredor other = (Corredor) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }
   
}
