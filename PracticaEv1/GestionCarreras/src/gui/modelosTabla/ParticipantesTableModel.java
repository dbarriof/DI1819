/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modelosTabla;

import Dto.Participante;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dbarriof
 */
public class ParticipantesTableModel extends AbstractTableModel{
    private List<Participante> listaParticipantes;
    
    public ParticipantesTableModel(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }
    
    @Override
    public int getRowCount() {
        if(listaParticipantes.isEmpty()){
            return 1;
        }
        return listaParticipantes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
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
                return listaParticipantes.get(fila).getTiempo();
            case 4:
                return listaParticipantes.get(fila).getPosicion();
        }
        return null;
    }
    
}
