/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Recursos;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import org.openide.util.Exceptions;

/**
 *
 * @author dbarriof
 */
public class MostrarAyuda {
    private final File fichero = new File("help"+File.separator+"help_set.hs");
    private URL hsURL;
    private HelpSet helpset;
    private HelpBroker hb;
    
    
    public MostrarAyuda(javax.swing.JRootPane panel) {
        try {
            hsURL = fichero.toURI().toURL();
            helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            hb = helpset.createHelpBroker();
            mostrarAyudaF1(panel);
        } catch (MalformedURLException | HelpSetException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    public MostrarAyuda(javax.swing.JRootPane panel, JMenuItem boton) {
        try {
            hsURL = fichero.toURI().toURL();
            helpset = new HelpSet(getClass().getClassLoader(), hsURL);
            hb = helpset.createHelpBroker();
            mostrarAyudaF1(panel);
            mostrarAyudaBoton(boton);
        } catch (MalformedURLException | HelpSetException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    
    /**
     * Método que integra la ayuda en la tecla F1 para la pantalla pasada como parametro
     * @param panel 
     */
    private void mostrarAyudaF1(javax.swing.JRootPane panel){
            hb.enableHelpKey(panel,"aplicacion",helpset);       
    }
    
    /**
     * Método que integra la ayuda en un boton de la pantalla pasada como parametro
     * @param panel 
     */
    private void mostrarAyudaBoton(JMenuItem boton){
        hb.enableHelpOnButton(boton,"aplicacion",helpset);      
    }
}
