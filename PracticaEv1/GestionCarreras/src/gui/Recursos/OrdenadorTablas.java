package gui.Recursos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Clase que permite crear un componente para ordenar tablas
 * 
 * @author dbarriof
 */
public class OrdenadorTablas extends TableRowSorter<TableModel>{
    
    /**
     * Metodo que permite implementar un sorter en la columna de la tabla pasada como parametro
     * @param dtm
     * @param col
     * @return 
     */
    public static TableRowSorter ordenaTabla(AbstractTableModel dtm, int col){
       TableRowSorter ordenador = new TableRowSorter(dtm);     
       List<RowSorter.SortKey> sortKeys = new ArrayList<>();
       sortKeys.add(new RowSorter.SortKey(col, SortOrder.ASCENDING));
       ordenador.setSortKeys(sortKeys);
       
       return ordenador;
    }
}
