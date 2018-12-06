/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Recursos;

import java.sql.Array;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.openide.util.Exceptions;

/**
 * Clase que permite manejar y aplicar estilos visuales a la aplicacion
 * 
 * @author dbarriof
 */
public class EstilosVisuales {
    
    /**
     * Metodo que devuelve un array de los estilos disponibles para ser usados
     * @return 
     */
    public static String[] estilosInstalados(){
        
        String[] estilos = new String[UIManager.getInstalledLookAndFeels().length];
        
        int contador = 0;
        for(UIManager.LookAndFeelInfo estilo : UIManager.getInstalledLookAndFeels()){
            estilos[contador] = estilo.getName();
            contador++;
        }
        return estilos;
    }
    
    /**
     * Metodo que permite aplicar un estilo visual pasando su nombre como parametro
     * @param nombre 
     */
    public static void asignarEstilo(String nombre) {
        for(UIManager.LookAndFeelInfo estilo : UIManager.getInstalledLookAndFeels()){
            if(estilo.getName().equals(nombre)){
                try {
                    UIManager.setLookAndFeel(estilo.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }
    }
}
