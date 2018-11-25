package LogicaAplicacion;

import Modelo.Camello;
import SincroMens.SincronizaMensajes;

/**
 *
 * @author dbarriof
 */
public class Logica {
    private Camello camello;

    public Logica(Camello camello) {
        this.camello = camello;
    }
    
    public void tirarDado(Camello camello){
        camello.getDado().setValor((int)(Math.random()*6+1));
    }
    
    public void avanzarPosiciones(Camello camello){
        camello.setPosicionesAvanzadas(camello.getPosicionesAvanzadas() + camello.getDado().getValor());      
    }
    
    public void imprimirPosiciones(Camello camello){
        SincronizaMensajes.mostrarMensajes("\n"+camello.getNombre()+": ");
        for(int i = 1 ; i <= camello.getPosicionesAvanzadas() ; i++){
            SincronizaMensajes.mostrarMensajes("-");           
        }
    }
}
