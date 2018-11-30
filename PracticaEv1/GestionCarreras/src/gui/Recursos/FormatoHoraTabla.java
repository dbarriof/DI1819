package gui.Recursos;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Clase que permite aplicar un  formato a las horas de una columna en una jTable
 * 
 * @author dbarriof
 */
public class FormatoHoraTabla extends DefaultTableCellRenderer{
    Format formatoHora = new SimpleDateFormat("HH:mm:ss");
    
    public FormatoHoraTabla() {
        super();
    }
    
    @Override
    public void setValue(Object hora) { 
        if(hora != null) {
            setText(formatoHora.format(hora));
        }
    }
     
}
