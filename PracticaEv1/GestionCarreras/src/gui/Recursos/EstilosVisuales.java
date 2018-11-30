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
 *
 * @author dbarriof
 */
public class EstilosVisuales {

    public static String[] estilosInstalados(){
        
        String[] estilos = new String[UIManager.getInstalledLookAndFeels().length];
        
        int contador = 0;
        for(UIManager.LookAndFeelInfo estilo : UIManager.getInstalledLookAndFeels()){
            estilos[contador] = estilo.getName();
            contador++;
        }
        return estilos;
    }
    
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
