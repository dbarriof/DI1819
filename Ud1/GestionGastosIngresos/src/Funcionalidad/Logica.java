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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dbarriof
 */
public class Logica {
    private Cuenta cuenta;
       
    public Logica() {       
        this.cuenta = new Cuenta(cargaDatos());        
    }
    
    //Metodo que calcula el saldo actual
    public static double calcularSaldo(ArrayList<MovimientoEconomico> movimientos){
        double saldo = 0;
            for (MovimientoEconomico me : movimientos){
                saldo = me.getImporte()+saldo;
            }   
        return saldo;
    }
    
    //Metodo que añade un nuevo movimiento
    public void aniadirMovimiento(MovimientoEconomico me){
        this.cuenta.getMovimientos().add(me);
    }
    
    //Metodo que lista los movimientos almacenados
    public ArrayList<MovimientoEconomico> mostrarMovimientos(){        
        return  (ArrayList<MovimientoEconomico>) this.cuenta.getMovimientos();
    }
          
    //Metodo que guarda todos los movimientos almacenados en el fichero indicado.  
    public void guardarMovimientos(){
        FileOutputStream fos = null;       
        
        try {
            
            fos = new FileOutputStream("movimientos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));
            
            for (MovimientoEconomico me : this.cuenta.getMovimientos()){                
                oos.writeObject(me);                
            }
            
            System.out.println("Datos guardados.");            
            oos.flush();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido crear el fichero.");
        } catch (IOException ex) {
            System.out.println("Se ha producido un error de tipo IO.");
        }            
                    
    }
    
    //Metodo al que llama el constructor y que devuelve un ArrayList con los movimientos almacenados si existiesen para cargarlos al iniciar la aplicacion
    private ArrayList<MovimientoEconomico> cargaDatos(){   
        ArrayList<MovimientoEconomico> movimientos = new ArrayList();
        File f = new File("movimientos.dat");
                
        if (f.exists()){
                       
            try {
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new  FileInputStream(f)));
                                
                MovimientoEconomico e = (MovimientoEconomico) ois.readObject();
                movimientos.add(e);               
                
                while(e!=null){                                     
                    e = (MovimientoEconomico) ois.readObject();
                    movimientos.add(e);
                }                
                        ois.close();
                        System.out.println("Cargado listado de partidos existentes.");                                       
                                                                       
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.getStackTrace();
                        //System.out.println("Cargado listado de partidos existentes.");
                    }              
            
        } else {
            
            System.out.println("No se cargan movimientos previos");
        }
        
        return movimientos;
    }    
}
