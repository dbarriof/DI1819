
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dto.Carrera;
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
    
    
}
