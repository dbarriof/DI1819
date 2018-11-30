package Modelo;

import LogicaAplicacion.Logica;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author dbarriof
 */
public class Camello extends Thread {

    private String nombre;
    private Dado dado;
    private int posicionesAvanzadas;
    private CountDownLatch contador;
    private Logica logicaAplicacion;

    public Camello(String nombre, CountDownLatch contador, Logica logicaAplicacon) {
        this.nombre = nombre;
        dado = new Dado();
        posicionesAvanzadas = 0;
        this.contador = contador;
        this.logicaAplicacion = logicaAplicacon;

    }

    @Override
    public void run() {
        try {
            
            // Se ordena al hilo esperar indicaciones para comenzar a correr.
            this.contador.await();
        
            // Se repetirán las acciones indicadas hasta que se verifique la condición, trñas lo que el hilo morirá
        while (posicionesAvanzadas < 100) { 
            
            logicaAplicacion.tirarDado(this);
            
            // Se añade un retardo simulando el tiempo que el camello tarda en avanzar las posiciones (Esto hace que los mensajes en consola se simulen de forma más sincronizada).
            sleep(200);
            
            logicaAplicacion.avanzarPosiciones(this);
            logicaAplicacion.compruebaGanador(this);
        }
        
        } catch (InterruptedException ex) {
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public int getPosicionesAvanzadas() {
        return posicionesAvanzadas;
    }

    public void setPosicionesAvanzadas(int posicionesAvanzadas) {
        this.posicionesAvanzadas = posicionesAvanzadas;
    }

}
