/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelosTabla;

import Dto.Corredor;
import Dto.FormatoFecha;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author dbarriof
 */
public class CorredoresTableModel extends AbstractTableModel{
    private List<Corredor> listaCorredores;
    private final String[] columnas = {"Nombre","Dni","Fecha Nac.","Dirección","Teléfono"};
    
    public CorredoresTableModel(ArrayList<Corredor> listaCorredores){        
        this.listaCorredores = (ArrayList) listaCorredores;       
    }   
    
    public TableRowSorter ordenaTabla(AbstractTableModel atm, int col){
        TableRowSorter ordenador = new TableRowSorter(atm);     
        List<SortKey> sortKeys = new ArrayList<>();       
        sortKeys.add(new SortKey(col, SortOrder.ASCENDING));                  
        ordenador.setSortKeys(sortKeys);      
        return ordenador;
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
