/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelosTabla;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author dbarriof
 */
public class FormatoFechaTabla extends DefaultTableCellRenderer{
    Format formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
    
    public FormatoFechaTabla() {
        super();
    }
    
    @Override
    public void setValue(Object fecha) { 
        if(fecha != null) {
            setText(formatoFecha.format(fecha));
        }
    }
    
    
}
