package gui.Recursos;


import Logica.LogicaAplicacion;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Clase que permite crear un temporizador y configurar sus acciones 
 * 
 * @author dbarriof
 */
public class TemporizadorGuardadoAutomatico implements Serializable{
    Timer temporizador;
    TimerTask tarea;
    private ListenerTemporizadorGuardado listenerTemporizadorGuardado;
    
    public TemporizadorGuardadoAutomatico() {               
    }
    
    public TemporizadorGuardadoAutomatico(LogicaAplicacion logicaAplicacion) {        
        temporizador = new Timer();
        tarea = new TimerTask() {
            @Override
            public void run() {
                logicaAplicacion.guardarDatos();
                System.out.println("Se han guardado los datos.");
            }        
        };
        temporizador.schedule(tarea, 0,600000 );
    }

    public TemporizadorGuardadoAutomatico(LogicaAplicacion logicaAplicacion, int tiempoProgramado) {                   
        temporizador = new Timer();
        tarea = new TimerTask() {
            @Override
            public void run() {  
                logicaAplicacion.guardarDatos();
                System.out.println("Se han guardado los datos.");
            }        
        };
        temporizador.schedule(tarea, 0,tiempoProgramado * 60000);
    }

    public Timer getTemporizador() {
        return temporizador;
    }

    public void setTemporizador(Timer temporizador) {
        this.temporizador = temporizador;
    }

    public TimerTask getTarea() {
        return tarea;
    }

    public void setTarea(TimerTask tarea) {
        this.tarea = tarea;
    }
    
    public void addListenerTemporizadorGuardado(ListenerTemporizadorGuardado listenerTemporizadorGuardado){
        this.listenerTemporizadorGuardado = listenerTemporizadorGuardado;
    }
    
}
