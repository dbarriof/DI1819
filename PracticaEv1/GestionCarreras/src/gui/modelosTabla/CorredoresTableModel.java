package gui.modelosTabla;

import Dto.Corredor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Clase que permite gestionar de forma genérica la tabla de corredores
 * 
 * @author dbarriof
 */
public class CorredoresTableModel extends AbstractTableModel{
    private List<Corredor> listaCorredores;
    private final String[] columnas = {"Nombre","Dni","Fecha Nac.","Dirección","Teléfono"};
    
    public CorredoresTableModel(ArrayList<Corredor> listaCorredores){        
        this.listaCorredores = (ArrayList) listaCorredores;       
    }   

    @Override
    public int getRowCount() {
        if(listaCorredores.isEmpty()){
            return 0;
        }
        return listaCorredores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        switch(columna)
        {
            case 0:
                return listaCorredores.get(fila).getNombre();
            case 1:
                return listaCorredores.get(fila).getDni();
            case 2:                
                return listaCorredores.get(fila).getFechaNac();
            case 3:               
                return listaCorredores.get(fila).getDireccion();                         
            case 4:               
                return listaCorredores.get(fila).getTelefono();               
        }
        return null;
    }
    
    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        if(i == 2){
            return Date.class;
        }
        return super.getColumnClass(i);
    } 
       
}
