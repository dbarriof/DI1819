/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidad;

import Bean.Cuenta;
import Bean.MovimientoEconomico;
import java.io.*;
import java.util.*;

/**
 *
 * @author dbarriof
 */
public class Logica {
    private Cuenta cuenta;
    private ArrayList<MovimientoEconomico> movimientos;

    
    //Metodo que crea una nueva cuenta cargando movimientos previos en el fichero indicado.
    
    public Logica() {
        
        File f = new File ("movimientos.dat");
        
        if (f.exists()){
            
            
            ObjectInputStream ois = null;
                        
            try {
                
                ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
                MovimientoEconomico e = (MovimientoEconomico) ois.readObject();
                this.movimientos.add(e);
                
                while(e!=null){                   
                    this.movimientos.add(e);
                    e = (MovimientoEconomico) ois.readObject();
                }
                
                this.cuenta = new Cuenta(this.movimientos);
                
                ois.close();
 
            } catch ( IOException | ClassNotFoundException ex) {
                System.out.println("Cargados movimientos previos");;
            }               
            
        } else {
            
            this.movimientos = new ArrayList();
            this.cuenta = new Cuenta(movimientos);
            System.out.println("No se cargan movimientos previos");
        }
    }
    
    public static void calcularSaldo(){
        
    }
    
    public void ingresar(double cantidad){
        
    }
    
    
    
    
    
    
    
    //Metodo que guarda todos los movimientos almacenados en el fichero indicado.  
    public void guardarMovimientos(Cuenta c){
        
            try {
                
                ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("movimientos.dat")));
                
                for (MovimientoEconomico me : c.getMovimientos()){
                    oos.writeObject(me);
                }
                                
                oos.close();
 
            } catch ( IOException ex) {
                ex.getStackTrace();
            }               
                    
        }
    
    
    
}
