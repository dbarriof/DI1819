package LogicaAplicacion;

import Modelo.Camello;
import SincroMens.SincronizaMensajes;
import static java.lang.Thread.yield;

/**
 *
 * @author dbarriof
 */
public class Logica {
    private boolean ganador = false;

    public Logica() {
    }
    
    public void tirarDado(Camello camello){
        camello.getDado().setValor((int)(Math.random()*6+1));
        yield();
    }
    
    public synchronized void avanzarPosiciones(Camello camello){
        camello.setPosicionesAvanzadas(camello.getPosicionesAvanzadas() + camello.getDado().getValor());
        notifyAll();
        yield();
    }
    
    public synchronized void imprimirPosiciones(Camello camello){
        //SincronizaMensajes.mostrarMensajes("\n"+camello.getNombre()+": ");
        System.out.print("\n"+camello.getNombre()+": ");
        for(int i = 1 ; i <= camello.getPosicionesAvanzadas() ; i++){
            System.out.print("-");
            //SincronizaMensajes.mostrarMensajes("-");           
        }
        if (camello.getPosicionesAvanzadas() >= 100 && ganador == false) {
                ganador = true;               
                //SincronizaMensajes.mostrarMensajes(camello.getNombre() + "Llega a la meta GANADOR!!!!!!");
                System.out.print(" "+camello.getNombre()+" Llega a la meta GANADOR!!!!!!");
            } else if (camello.getPosicionesAvanzadas() >= 100) {
                //SincronizaMensajes.mostrarMensajes(" "+camello.getNombre() + " Llega a la meta");
                System.out.print(" "+camello.getNombre()+" Llega a la meta");
            }
        notifyAll();
        yield();              
    }
    
    
    //Prueba
    public synchronized void compruebaGanador(Camello camello){
        if (camello.getPosicionesAvanzadas() >= 100 && ganador == false) {
                ganador = true;               
                SincronizaMensajes.mostrarMensajes(" "+camello.getNombre() + " Llega a la meta GANADOR!!!!!!");
                //System.out.print(" "+camello.getNombre()+" Llega a la meta GANADOR!!!!!!");
            } else if (camello.getPosicionesAvanzadas() >= 100) {
                SincronizaMensajes.mostrarMensajes(" "+camello.getNombre() + " Llega a la meta");
                //System.out.print(" "+camello.getNombre()+" Llega a la meta");
            }
        notifyAll();
        yield();
    }
}
