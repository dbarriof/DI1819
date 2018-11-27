/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Dto.Carrera;
import Dto.Participante;
import Logica.LogicaAplicacion;
import gui.modelosTabla.CarrerasTableModel;
import gui.modelosTabla.FormatoFechaTabla;
import gui.modelosTabla.ParticipantesTableModel;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author dbarriof
 */
public class PantallaListaCarreras extends javax.swing.JDialog {

    private PantallaListaCorredores plc;
    private PantallaDatosCarrera pdc;
    private LogicaAplicacion logicaAplicacion;
    private int filaSeleccionadaCarrera;

    //Constructor para mostrar el listado de carreras
    public PantallaListaCarreras(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion) {
        super(parent, modal);
        this.logicaAplicacion = logicaAplicacion;
        initComponents();
        cargarTablaCarreras();
        jTableCarreras.addRowSelectionInterval(0, 0);
        cargarTablaParticipantes();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent we) {
                cargarTablaCarreras();
                if(filaSeleccionadaCarrera >= 0){                    
                    jTableCarreras.addRowSelectionInterval(filaSeleccionadaCarrera,filaSeleccionadaCarrera);
                } 
                cargarTablaParticipantes();

            }
        });

    }

    public void cargarTablaCarreras() {
        CarrerasTableModel ctm = new CarrerasTableModel(logicaAplicacion.verCarreras());
        jTableCarreras.setModel(ctm);
        jTableCarreras.setRowSorter(ctm.ordenaTabla(ctm, 0));
        jTableCarreras.getColumnModel().getColumn(2).setCellRenderer(new FormatoFechaTabla());
    }

    public void cargarTablaParticipantes() {
        if (!logicaAplicacion.verCarreras().isEmpty()) {
            int filaSeleccionada = jTableCarreras.convertRowIndexToModel(jTableCarreras.getSelectedRow());
            Carrera seleccionada = logicaAplicacion.verCarreras().get(filaSeleccionada);
            //if (!seleccionada.getParticipantes().isEmpty()) {
                jTableParticipantes.setModel(new ParticipantesTableModel(seleccionada.getParticipantes()));
            //}
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCarreras = new javax.swing.JPanel();
        jScrollPaneCarreras = new javax.swing.JScrollPane();
        jTableCarreras = new javax.swing.JTable();
        jButtonNuevaCarrera = new javax.swing.JButton();
        jButtonBorrarCarrera = new javax.swing.JButton();
        jButtonModificarCarrera = new javax.swing.JButton();
        jPanelParticipantes = new javax.swing.JPanel();
        jScrollPaneParticipantes = new javax.swing.JScrollPane();
        jTableParticipantes = new javax.swing.JTable();
        jButtonAniadirParticipante = new javax.swing.JButton();
        jButtonBorrarParticipante = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de carreras programadas");

        jPanelCarreras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carreras programadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTableCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableCarreras.setEditingColumn(0);
        jTableCarreras.setEditingRow(0);
        jTableCarreras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCarrerasMouseClicked(evt);
            }
        });
        jScrollPaneCarreras.setViewportView(jTableCarreras);

        jButtonNuevaCarrera.setText("Nueva carrera");
        jButtonNuevaCarrera.setMaximumSize(new java.awt.Dimension(129, 23));
        jButtonNuevaCarrera.setMinimumSize(new java.awt.Dimension(129, 23));
        jButtonNuevaCarrera.setPreferredSize(new java.awt.Dimension(129, 23));
        jButtonNuevaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaCarreraActionPerformed(evt);
            }
        });

        jButtonBorrarCarrera.setText("Eliminar seleccionada");
        jButtonBorrarCarrera.setMaximumSize(new java.awt.Dimension(129, 23));
        jButtonBorrarCarrera.setMinimumSize(new java.awt.Dimension(129, 23));
        jButtonBorrarCarrera.setPreferredSize(new java.awt.Dimension(129, 23));
        jButtonBorrarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarCarreraActionPerformed(evt);
            }
        });

        jButtonModificarCarrera.setText("Modificar seleccionada");
        jButtonModificarCarrera.setMaximumSize(new java.awt.Dimension(129, 23));
        jButtonModificarCarrera.setMinimumSize(new java.awt.Dimension(129, 23));
        jButtonModificarCarrera.setPreferredSize(new java.awt.Dimension(129, 23));
        jButtonModificarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCarrerasLayout = new javax.swing.GroupLayout(jPanelCarreras);
        jPanelCarreras.setLayout(jPanelCarrerasLayout);
        jPanelCarrerasLayout.setHorizontalGroup(
            jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarrerasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCarrerasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNuevaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonModificarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBorrarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCarrerasLayout.setVerticalGroup(
            jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarrerasLayout.createSequentialGroup()
                .addComponent(jScrollPaneCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBorrarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModificarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanelParticipantes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Participantes inscritos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTableParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableParticipantes.setEditingColumn(0);
        jTableParticipantes.setEditingRow(0);
        jScrollPaneParticipantes.setViewportView(jTableParticipantes);

        jButtonAniadirParticipante.setText("Añadir participantes");
        jButtonAniadirParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAniadirParticipanteActionPerformed(evt);
            }
        });

        jButtonBorrarParticipante.setText("Eliminar participante");
        jButtonBorrarParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarParticipanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelParticipantesLayout = new javax.swing.GroupLayout(jPanelParticipantes);
        jPanelParticipantes.setLayout(jPanelParticipantesLayout);
        jPanelParticipantesLayout.setHorizontalGroup(
            jPanelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParticipantesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelParticipantesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAniadirParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBorrarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelParticipantesLayout.setVerticalGroup(
            jPanelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParticipantesLayout.createSequentialGroup()
                .addComponent(jScrollPaneParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonBorrarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAniadirParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jButtonVolver.setText("Volver");
        jButtonVolver.setMaximumSize(new java.awt.Dimension(71, 23));
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelParticipantes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCarreras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    //Metodo que permite crear una nueva carrera
    private void jButtonNuevaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaCarreraActionPerformed
        pdc = new PantallaDatosCarrera((Frame) this.getParent(), true, logicaAplicacion);
        pdc.setVisible(true);
    }//GEN-LAST:event_jButtonNuevaCarreraActionPerformed

    private void jButtonBorrarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarCarreraActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar la carrera seleccionada?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int filaSeleccionada = jTableCarreras.convertRowIndexToModel(jTableCarreras.getSelectedRow());
            Carrera seleccionada = logicaAplicacion.verCarreras().get(filaSeleccionada);
            logicaAplicacion.eliminaCarrera(seleccionada);
            
            jTableCarreras.addRowSelectionInterval(0, 0);
            cargarTablaCarreras();
            //cargarTablaParticipantes();
        }

    }//GEN-LAST:event_jButtonBorrarCarreraActionPerformed

    private void jButtonAniadirParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAniadirParticipanteActionPerformed
        filaSeleccionadaCarrera = jTableCarreras.convertRowIndexToModel(jTableCarreras.getSelectedRow());
        Carrera seleccionada = logicaAplicacion.verCarreras().get(filaSeleccionadaCarrera);
        System.out.println(seleccionada.getDorsales());
        System.out.println("Fila seleccionada precarga"+filaSeleccionadaCarrera);
        
        if(filaSeleccionadaCarrera == logicaAplicacion.verCarreras().size()-1){
                    filaSeleccionadaCarrera = 0;
                } else if(filaSeleccionadaCarrera >= 0){
                    System.out.println(filaSeleccionadaCarrera);
                   filaSeleccionadaCarrera = filaSeleccionadaCarrera+1;
                } 
        
        System.out.println("Fila seleccionada a cargar"+filaSeleccionadaCarrera);
        
        if (seleccionada.getParticipantes().isEmpty() && seleccionada.getDorsales().isEmpty()) {
            logicaAplicacion.cargarDorsales(seleccionada);
        }
        
        plc = new PantallaListaCorredores(this, true, logicaAplicacion, seleccionada);

        plc.setVisible(true);
    }//GEN-LAST:event_jButtonAniadirParticipanteActionPerformed

    private void jButtonBorrarParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarParticipanteActionPerformed
        int carreraleccionada = jTableCarreras.convertRowIndexToModel(jTableCarreras.getSelectedRow());
        Carrera seleccionada = logicaAplicacion.verCarreras().get(carreraleccionada);
        if (!seleccionada.getParticipantes().isEmpty()) {
            int corredorSeleccionado = jTableParticipantes.convertRowIndexToModel(jTableParticipantes.getSelectedRow());
            Participante seleccionado = logicaAplicacion.verParticipantes(seleccionada).get(corredorSeleccionado);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el participante seleccionado?", "Eliminar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean resultado = logicaAplicacion.eliminarParticipante(seleccionada, seleccionado);
                cargarTablaParticipantes();
                if (resultado) {
                    JOptionPane.showMessageDialog(this, "El participante se ha eliminado correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay participantes inscritos todavía", "Confirmación", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBorrarParticipanteActionPerformed

    private void jTableCarrerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCarrerasMouseClicked
        cargarTablaParticipantes();
    }//GEN-LAST:event_jTableCarrerasMouseClicked

    private void jButtonModificarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModificarCarreraActionPerformed

    @Override

    public void setTitle(String title) {
        super.setTitle(title);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAniadirParticipante;
    private javax.swing.JButton jButtonBorrarCarrera;
    private javax.swing.JButton jButtonBorrarParticipante;
    private javax.swing.JButton jButtonModificarCarrera;
    private javax.swing.JButton jButtonNuevaCarrera;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JPanel jPanelCarreras;
    private javax.swing.JPanel jPanelParticipantes;
    private javax.swing.JScrollPane jScrollPaneCarreras;
    private javax.swing.JScrollPane jScrollPaneParticipantes;
    private javax.swing.JTable jTableCarreras;
    private javax.swing.JTable jTableParticipantes;
    // End of variables declaration//GEN-END:variables
}
