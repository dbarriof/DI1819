package gui.Recursos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * 
 * @author dbarriof
 */
public class OrdenadorTablas extends TableRowSorter<TableModel>{
    
    public static TableRowSorter ordenaTabla(AbstractTableModel dtm, int col){
       TableRowSorter ordenador = new TableRowSorter(dtm);     
       List<RowSorter.SortKey> sortKeys = new ArrayList<>();
       sortKeys.add(new RowSorter.SortKey(col, SortOrder.ASCENDING));
       ordenador.setSortKeys(sortKeys);
       
       return ordenador;
    }
}
