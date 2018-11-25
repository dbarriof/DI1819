package Modelo;

import LogicaAplicacion.Logica;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guile
 */
public class Camello extends Thread {

    private String nombre;
    private Dado dado;
    private int posicionesAvanzadas;
    private CountDownLatch contador;
    private Logica logicaAplicacion;

    public Camello(String nombre, CountDownLatch contador) {
        this.nombre = nombre;
        dado = new Dado();
        posicionesAvanzadas = 0;
        this.contador = contador;
        logicaAplicacion = new Logica(this);

    }

    @Override
    public void run() {
        try {
            this.contador.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Camello.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (posicionesAvanzadas < 100) {
            logicaAplicacion.tirarDado(this);
            logicaAplicacion.avanzarPosiciones(this);
            logicaAplicacion.imprimirPosiciones(this);
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
