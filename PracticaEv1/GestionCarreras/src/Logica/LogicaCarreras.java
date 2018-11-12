
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dto.Carrera;
import Dto.Corredor;
import Dto.Participante;
import java.util.HashSet;

/**
 *
 * @author dbarriof
 */
public class LogicaCarreras {
    private HashSet<Carrera> carreras;
    
    public LogicaCarreras() {
        this.carreras = new HashSet<>();
    }
    
    public void altaCarrera(Carrera c){
        carreras.add(c);
    }
    
    public void eliminaCarrera(Carrera c) {        
        for (Carrera cor : carreras) {
            if (cor.equals(c)) {
                carreras.remove(cor);
                break;
                
            }
        }
    }
    
    public void cargarDorsales(Carrera carrera, int numDeParticipantes){
        for(int i=1; i <= numDeParticipantes ; i++){
            carrera.getDorsales().add(i);
        }
    }
    
    public int asignarDorsal(Carrera carrera){
        int dorsal = carrera.getDorsales().get(0);
        carrera.getDorsales().remove(0);
        return dorsal;
    }
    
    public void devolverDorsal(Carrera carrera , int dorsal){
        carrera.getDorsales().add(dorsal,dorsal);
    }
    
    public boolean aniadirParticipante(Carrera carrera, Corredor corredor){
        Participante participante = new Participante(corredor,carrera);
        if(!carrera.getParticipantes().contains(participante) || carrera.getParticipantes()==null){
            participante.setDorsal(asignarDorsal(carrera));
            carrera.getParticipantes().add(participante);
            return true;
        } else {
            return false;
        }             
    }
    
    public boolean eliminarParticipante(Carrera carrera, Participante participante){
        Participante participante = new Participante(corredor,carrera);
        if(!carrera.getParticipantes().contains(participante) || carrera.getParticipantes()==null){
            participante.setDorsal(asignarDorsal(carrera));
            carrera.getParticipantes().add(participante);
            return true;
        } else {
            return false;
        }             
    }
    
    

}
