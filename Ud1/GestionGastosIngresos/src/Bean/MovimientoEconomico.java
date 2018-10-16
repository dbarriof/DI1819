/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

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

    @Override
    public String toString() {
        return "MovimientoEconomico{" + "fecha=" + fecha + ", concepto=" + concepto + ", importe=" + importe + '}';
    }
    
    
}
