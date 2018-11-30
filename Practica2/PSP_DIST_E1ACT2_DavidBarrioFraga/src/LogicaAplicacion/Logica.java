package LogicaAplicacion;

import Modelo.Camello;
/**
 *
 * @author dbarriof
 */
public class Logica {
    private boolean ganador = false;

    public Logica() {
    }
    
    /**
     * Método que simula la tirada del dado que posée el camello (En caso de compartir dado se debe sincronizar).
     * @param camello 
     */
    public void tirarDado(Camello camello){
        camello.getDado().setValor((int)(Math.random()*6+1));
    }
    
    /**
     * Método que imprime en pantalla las posiciones avanzadas por el camello (Se sincroniza para no solapar mensajes en la consola).
     * @param camello 
     */
    public synchronized void avanzarPosiciones(Camello camello){
        camello.setPosicionesAvanzadas(camello.getPosicionesAvanzadas() + camello.getDado().getValor());
        System.out.print("\n"+camello.getNombre()+": ");  
        for(int i = 1 ; i <= camello.getPosicionesAvanzadas() ; i++){
            System.out.print("-");                                    
        }
        notifyAll();
    }
    
    /**
     * Método que comprueba si el camello ha llegado a meta y en caso afirmativo si es el primero en hacerlo (Se sincroniza para no solapar mensajes en la consola).
     * @param camello 
     */
    public synchronized void compruebaGanador(Camello camello){
        if (camello.getPosicionesAvanzadas() >= 100 && ganador == false) {
                ganador = true;                
                System.out.print(" "+camello.getNombre()+" Llega a la meta GANADOR!!!!!!");
            } else if (camello.getPosicionesAvanzadas() >= 100) {
                System.out.print(" "+camello.getNombre()+" Llega a la meta");
            }
        notifyAll();
    }
}
