/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */
public class MiHilo implements Runnable{
    Thread t;
    int contador = 0;
    private volatile boolean repetir = true;

    public MiHilo(int prioridad, String nombre) {
        t = new Thread(this);
        t.setPriority(prioridad);
    }
    
    public void start(){
        this.t.start();
    }
    
    public void stop(){
        this.repetir = false;
    }
    
    @Override
    public void run() {
        while(repetir){
            contador++;
            
        }
        System.out.println("Hilo "+this.t.getName()+" Contador= "+contador);
    }
    
}
