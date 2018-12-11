/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Funcionalidad.FormatarFecha;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author dbarriof
 */
public class MovimientoEconomico implements Serializable{   
    private Date fecha;
    private String concepto;
    private double importe;

    public MovimientoEconomico(Date fecha, String concepto, double importe) {        
        this.fecha = fecha;
        this.concepto = concepto;
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String[] arrayToStrings(){
        String [] datos = new String [4];
        datos[0] = getConcepto();
        datos[1] = FormatarFecha.formatFecha(getFecha());
        datos[2] = Double.toString(getImporte());
        
        return datos;
    }
            
    @Override
    public String toString() {
        return "MovimientoEconomico{" + "fecha=" + fecha + ", concepto=" + concepto + ", importe=" + importe + '}';
    }
    
    
}
