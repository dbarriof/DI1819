/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Recursos;

import javax.swing.JSpinner;

/**
 *
 * @author dbarriof
 */
public class FormatoFechaSpinners {

    public static JSpinner formatearFechaSpinner(JSpinner spinner) {
        //SpinnerDateModel sdm = new SpinnerDateModel();       
        spinner.setEditor(new JSpinner.DateEditor(spinner,"dd-MM-yyyy"));        
        return spinner;
    }
    
    
}
