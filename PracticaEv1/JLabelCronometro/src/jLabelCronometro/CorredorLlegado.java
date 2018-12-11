/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jLabelCronometro;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author dbarriof
 */
public class CorredorLlegado implements Serializable{
    private int Dorsal;
    private Date tiempo;
    
    public CorredorLlegado() {        
    }

    public int getDorsal() {
        return Dorsal;
    }

    public void setDorsal(int Dorsal) {
        this.Dorsal = Dorsal;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }
    
}
