package gui.modelosTabla;

import Dto.Carrera;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Clase que permite gestionar de forma genérica la tabla de carreras
 * 
 * @author dbarriof
 */
public class CarrerasTableModel extends AbstractTableModel{
    private ArrayList<Carrera> carreras;
    private final String[] columnas = {"Nombre","Lugar","Fecha","Participantes","Estado"};
    
    public CarrerasTableModel(ArrayList<Carrera> carreras) {
        this.carreras = (ArrayList) carreras;
    }
    
    public TableRowSorter ordenaTabla(AbstractTableModel dtm, int col){
       TableRowSorter ordenador = new TableRowSorter(dtm);     
       List<RowSorter.SortKey> sortKeys = new ArrayList<>();
       sortKeys.add(new RowSorter.SortKey(col, SortOrder.ASCENDING));
       ordenador.setSortKeys(sortKeys);
       
       return ordenador;
    }
    
    @Override
    public int getRowCount() {
        if(carreras.isEmpty()){
            return 0;
        }
        return carreras.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        String estado;
        switch(columna)
        {
            case 0:
                return carreras.get(fila).getNombre();
            case 1:
                return carreras.get(fila).getLugar();
            case 2:
                return carreras.get(fila).getFecha();
            case 3:               
                return String.valueOf(carreras.get(fila).getNumMaxParticipantes()); 
            case 4:    
                if(carreras.get(fila).isFinalizada()){
                    estado = "Finalizada";
                } else {
                    estado = "Planificada";
                }
                return estado;
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
