/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dbarriof
 */
public class ModelosTabla {
    
    //Modelo de tabla para corredores
    public static DefaultTableModel tablaCorredor(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String [] {"Nombre","Dni","Fecha Nac.","Dirección","Teléfono"});
        return dtm;
    }
    
    //Modelo de tabla para carreras
    public static void tablaCarrera(){
        
    }
}
