package gui.modelosTabla;

import Dto.Participante;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 * Clase que permite gestionar de forma genérica la tabla de participantes
 * @author dbarriof
 */
public class ParticipantesTableModel extends AbstractTableModel{
    private List<Participante> listaParticipantes = new ArrayList<>();
    private final String[] columnas = {"Dorsal","Nombre","Dni","Tiempo","Pos. Final"};

    public ParticipantesTableModel() {
    }   
    
    public ParticipantesTableModel(List<Participante> listaParticipantes) {
        this.listaParticipantes = (ArrayList) listaParticipantes;
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
        if(!listaParticipantes.isEmpty()){
            System.out.println("retorno algo");
            System.out.println(listaParticipantes.size());
            return listaParticipantes.size();     
        }
        System.out.println("retorno 0");
        return 0;
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
                return listaParticipantes.get(fila).getDorsal();
            case 1:
                return listaParticipantes.get(fila).getCorredor().getNombre();
            case 2:
                return listaParticipantes.get(fila).getCorredor().getDni();
            case 3:
                if(listaParticipantes.get(fila).getTiempo() == null){
                    return null;
                } else {
                    return listaParticipantes.get(fila).getTiempo();
                }                         
            case 4:
                if(listaParticipantes.get(fila).getPosicion() == 0){
                    return "N/A";
                } else {
                    return listaParticipantes.get(fila).getPosicion();
                }
                
        }
        return null;
    }

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }
    
    @Override
    public Class<?> getColumnClass(int i) {
        if(i == 3){
            return Date.class;
        }
        return super.getColumnClass(i);
    }
}
