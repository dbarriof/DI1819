/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Funcionalidad.Logica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbarriof
 */
public class Cuenta {
    private double saldo;
    private List<MovimientoEconomico> movimientos;

    /*public Cuenta(List<MovimientoEconomico> movimientos) {
        this.saldo = 0;        
        this.movimientos = movimientos;
        for (MovimientoEconomico me : movimientos){
            this.saldo = me.getImporte()+this.saldo;
        }
    }*/

    public Cuenta(ArrayList<MovimientoEconomico> movimientos) {
        this.movimientos = movimientos;
        if (movimientos.isEmpty()){ 
            this.saldo = 0;
        } else {
            double balance = 0;
            for (MovimientoEconomico me : movimientos){
               balance = me.getImporte()+ balance;
            }
           this.saldo = balance;
        }
        
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<MovimientoEconomico> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientoEconomico> movimientos) {
        this.movimientos = movimientos;
        if (movimientos.isEmpty()){ 
            this.saldo = 0;
        } else {
            double balance = 0;
            for (MovimientoEconomico me : movimientos){
               balance = me.getImporte()+ balance;
            }
           this.saldo = balance;
        }
        
    }
    
    
}
