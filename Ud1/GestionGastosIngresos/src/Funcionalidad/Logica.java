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
    private ArrayList<MovimientoEconomico> movimientos;
    
    //Metodo que crea una nueva cuenta cargando movimientos previos en el fichero indicado.
    
    public Logica() {
        this.movimientos = new ArrayList();
        this.cuenta = new Cuenta(movimientos);
        
        File f = new File("movimientos.dat");
        
        
        //if (f.exists()){
            
            FileInputStream fis= null; 
            BufferedInputStream bis = null;
            
            try {
                fis = new  FileInputStream(f);
                bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(fis);
                
                
                MovimientoEconomico e = (MovimientoEconomico) ois.readObject();
                System.out.println(e.toString());
                 
                this.movimientos.add(e);
                
                
                
                
                
                while(e!=null){                   
                    
                    e = (MovimientoEconomico) ois.readObject();
                    this.movimientos.add(e);
                    System.out.println(e.toString());
                }                
                    
                    cuenta.setMovimientos(movimientos);
                
                for(MovimientoEconomico me : this.movimientos){
                    System.out.println(me.getConcepto());
                    System.out.println(me.getFecha());
                    System.out.println(me.getImporte());
                }
                
                        ois.close();
                        bis.close();
                        fis.close();
                        System.out.println("Cargado listado de partidos existentes.");
                                                                       
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.getStackTrace();
                        //System.out.println("Cargado listado de partidos existentes.");
                    }              
            
        /*} else {
            
            this.movimientos = new ArrayList();
            this.cuenta = new Cuenta(movimientos);
            System.out.println("No se cargan movimientos previos");
        }*/
    }
    
    public static double calcularSaldo(ArrayList<MovimientoEconomico> movimientos){
        double saldo = 0;
            for (MovimientoEconomico me : movimientos){
                saldo = me.getImporte()+saldo;
            }   
        return saldo;
    }
    
    public void aniadirMovimiento(MovimientoEconomico me){
        this.cuenta.getMovimientos().add(me);
    }
    
    
    public void mostrarMovimientos(){
        for(MovimientoEconomico me : this.cuenta.getMovimientos()){
            System.out.println(me.getConcepto());
            System.out.println(me.getFecha());
            System.out.println(me.getImporte());
        }
    }
    
    
    
    
    //Metodo que guarda todos los movimientos almacenados en el fichero indicado.  
    public void guardarMovimientos(){
        /*FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        System.out.println("intentando guardar");
        
        try {
            fos = new FileOutputStream("movimientos.dat",true);
            bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            
            for (MovimientoEconomico p : this.cuenta.getMovimientos()){
                System.out.println(p.toString());
                
            }
            
            for (MovimientoEconomico p : this.cuenta.getMovimientos()){
                oos.writeObject(p);
                
            }
            System.out.println("Datos guardados");
            
            oos.flush();
            bos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        }*/
            try {
                
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("movimientos.dat"));               
                for (MovimientoEconomico me : this.cuenta.getMovimientos()){
                    oos.writeObject(me);
                    System.out.println(me.toString());
                }
                System.out.println("Datos guardados");
                oos.close();
 
            } catch ( IOException ex) {
                ex.getStackTrace();
            }             
                    
        }
    
    
    
    
    
    
    public void cargaDatos(){
        
        File f = new File("movimientos.dat");
        FileInputStream fis= null; 
        BufferedInputStream bis = null;
        
            try {
                fis = new  FileInputStream(f);
                bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(fis);

                MovimientoEconomico p = (MovimientoEconomico) ois.readObject();
                movimientos.add(p);
                
                    while( p != null){
                            p = (MovimientoEconomico) ois.readObject();
                            movimientos.add(p);
                        }

                        bis.close();
                        fis.close();
                        this.cuenta.setMovimientos(movimientos);
                        System.out.println("Cargado listado de partidos existentes.");
                                                                
                
                    } catch (FileNotFoundException ex) {
                        System.out.println("No hay datos previos que cargar.");        
                    } catch (ClassNotFoundException ex) {
                        
                    } catch (EOFException ex) {
                        
                    } catch (IOException ex) {
                        
                    }
    }    
}
