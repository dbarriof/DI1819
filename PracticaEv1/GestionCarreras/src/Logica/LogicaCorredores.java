/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dto.Corredor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author dbarriof
 */
public class LogicaCorredores {

    private List<Corredor> corredores;

    public LogicaCorredores() {
        this.corredores = new ArrayList();
    }
    
    public void altaCorredor(Corredor c){
        corredores.add(c);
    }
    
    public void bajaCorredor(Corredor c){
        for(Corredor cor : corredores){
            if(cor.equals(c)){
                corredores.remove(cor);
            }
        }
        
    }
    
    public void ordenarCorredores(){
        Collections.sort(corredores);
    }
    
    public void modifCorredor(Corredor c){
        
    }
    
    public void verCorredor(Corredor c){
        
    }
    
    public void importarCorredores(){
        
    }
    
    public void exportarCorredores(){
        
    }
}
