/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelosTabla;

import Dto.FormatoFecha;
import Dto.Participante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dbarriof
 */
public class ParticipantesTableModel extends AbstractTableModel{
    private List<Participante> listaParticipantes;
    private final String[] columnas = {"Dorsal","Nombre","Dni","Tiempo","Pos. Final"};
    
    public ParticipantesTableModel(List<Participante> listaParticipantes) {
        this.listaParticipantes = (ArrayList) listaParticipantes;
    }
    
    @Override
    public int getRowCount() {
        if(listaParticipantes.isEmpty()){
            return 0;
        }
        return listaParticipantes.size();
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
                    return FormatoFecha.formatTiempo(listaParticipantes.get(fila).getTiempo());
                }                         
            case 4:
                if(listaParticipantes.get(fila).getPosicion() == 0){
                    return null;
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
    
    
}
