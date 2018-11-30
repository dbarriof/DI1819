package gui.Recursos;

import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase que permite aplicar un  formato a las fechas de una columna en una jTable
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
