/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





package gui;

import gui.modelosTabla.ModelosTabla;
import Dto.*;
import Logica.LogicaCarreras;
import Logica.LogicaCorredores;
import gui.modelosTabla.ParticipantesTableModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author dbarriof
 */


public class PantallaDatosCarrera extends javax.swing.JDialog {
    private PantallaListaCorredores plc;
    private LogicaCarreras logicaCarreras;
    private LogicaCorredores logicaCorredores;
    private List<Participante> participantes;
    private ValidationGroup group;
    private Carrera carrera;
    
    //Constructor para dar de alta una carrera
    public PantallaDatosCarrera(java.awt.Frame parent, boolean modal, LogicaCarreras logicaCarreras, LogicaCorredores listaCorredores) {
        super(parent, modal);
        setTitle("Nueva carrera");
        this.logicaCarreras = logicaCarreras;
        initComponents();
        validador();
        
        //Instanciamos la carrera y las colecciones asociadas (Participantes y dorsales)
        carrera= new Carrera();
        carrera.setParticipantes(new ArrayList<>());
        carrera.setDorsales(new ArrayList<>());
        //Instanciamos el listado de corredores para elegir participantes
        this.logicaCorredores = listaCorredores;
        
        //Instanciamos una coleccion para añadir participantes durante la creación de la carrera:       
        //participantes = new HashSet<>();
        
        jButtonAceptarMoficacion.setVisible(false);
        jButtonEliminarCarrera.setVisible(false);
    }
    
    //Constructor para modificar una carrera
    public PantallaDatosCarrera(java.awt.Frame parent, boolean modal, LogicaCarreras logicaCarreras, Carrera c) {
        super(parent, modal);
        setTitle("Modificar carrera");
        this.logicaCarreras = logicaCarreras;
        initComponents();
        validador();
        
        //Detalles de pantalla
        jLabelDatosCarrera.setText("Modifica los campos necesarios:");
        
        jTextFieldNombre.setText(c.getNombre());
        jTextFieldLugar.setText(c.getLugar());
        jSpinnerFecha.setValue(c.getFecha());
        jTextFieldNumPart.setText(String.valueOf(c.getNumMaxParticipantes()));
        
        jButtonAceptarCarrera.setVisible(false);
        jButtonEliminarCarrera.setVisible(false);
    }
    
    //Constructor para eliminar una carrera
    public PantallaDatosCarrera(java.awt.Frame parent, boolean modal, LogicaCarreras logicacarreras, Carrera c, boolean eliminar) {
        super(parent, modal);
        setTitle("Eliminar carrera");
        this.logicaCarreras = logicaCarreras;
        initComponents();
        validador();
        
        //Detalles de pantalla
        jLabelDatosCarrera.setText("Datos de la carrera:");
        
        jTextFieldNombre.setText(c.getNombre());
        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.setForeground(Color.GRAY);
        jTextFieldLugar.setText(c.getLugar());
        jTextFieldLugar.setEditable(false);
        jTextFieldLugar.setForeground(Color.GRAY);
        jSpinnerFecha.setValue(c.getFecha());
        jSpinnerFecha.setEnabled(false);
        jSpinnerFecha.setForeground(Color.GRAY);
        jTextFieldNumPart.setText(String.valueOf(c.getNumMaxParticipantes()));
        jTextFieldNumPart.setEditable(false);
        jTextFieldNumPart.setForeground(Color.GRAY);
        
        jButtonAceptarMoficacion.setVisible(false);
        jButtonAceptarCarrera.setVisible(false);
    }
    
    public void validador(){
        //Validación de campos de entrada
        group = validationPanelValidacionDatos.getValidationGroup();

        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldLugar, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldNumPart, StringValidators.REQUIRE_VALID_INTEGER);
        group.add(jTextFieldNumPart, StringValidators.maxLength(3));
    }
    
    public void cargarTabla(){
        /*jTableParticipantes.setModel(ModelosTabla.tablaParticipante());
        DefaultTableModel dtm = (DefaultTableModel)jTableParticipantes.getModel();        
        for(Participante p : carrera.getParticipantes()){
            dtm.addRow(p.arrayToStrings());
        }
        
        jTableParticipantes.setRowSorter(ModelosTabla.ordenaTabla(dtm,0));*/
        
        
        jTableParticipantes.setModel(new ParticipantesTableModel(participantes));
        for(Participante p : carrera.getParticipantes()){
            jTableParticipantes.
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

        jPanel1 = new javax.swing.JPanel();
        jLabelDatosCarrera = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelLugar = new javax.swing.JLabel();
        jLabelFechaNac = new javax.swing.JLabel();
        jLabelNumPart = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldLugar = new javax.swing.JTextField();
        jTextFieldNumPart = new javax.swing.JTextField();
        jSpinnerFecha = new javax.swing.JSpinner();
        validationPanelValidacionDatos = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jButtonAceptarCarrera = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptarMoficacion = new javax.swing.JButton();
        jButtonEliminarCarrera = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableParticipantes = new javax.swing.JTable();
        jButtonAniadirPart = new javax.swing.JButton();
        jButtonRefrescarTabla = new javax.swing.JButton();
        jButtonBorrarParticipante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de carrera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabelDatosCarrera.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelDatosCarrera.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDatosCarrera.setText("Datos del corredor:");

        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNombre.setText("Nombre :");

        jLabelLugar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLugar.setText("Lugar :");

        jLabelFechaNac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFechaNac.setText("Fecha :");
        jLabelFechaNac.setPreferredSize(new java.awt.Dimension(1004, 95));

        jLabelNumPart.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNumPart.setText("Número de participantes :");

        jTextFieldNombre.setToolTipText("Espacio para insertar nombre del corredor");
        jTextFieldNombre.setName("Nombre"); // NOI18N

        jTextFieldLugar.setToolTipText("Espacio para insertar el dni del corredor");
        jTextFieldLugar.setName("Dni"); // NOI18N

        jTextFieldNumPart.setToolTipText("Espacio para insertar el teléfono del corredor");
        jTextFieldNumPart.setName("Telefóno"); // NOI18N
        jTextFieldNumPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumPartActionPerformed(evt);
            }
        });

        jSpinnerFecha.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerFecha.setToolTipText("Selecciona la fecha de nacimiento del corredor");
        jSpinnerFecha.setName("Fecha de nacimiento"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNumPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jLabelLugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDatosCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jTextFieldLugar)
                    .addComponent(jTextFieldNumPart)
                    .addComponent(jSpinnerFecha)
                    .addComponent(validationPanelValidacionDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validationPanelValidacionDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabelDatosCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumPart, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonAceptarCarrera.setText("Aceptar");
        jButtonAceptarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarCarreraActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setMaximumSize(new java.awt.Dimension(71, 23));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAceptarMoficacion.setText("Aceptar");
        jButtonAceptarMoficacion.setToolTipText("");
        jButtonAceptarMoficacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarMoficacionActionPerformed(evt);
            }
        });

        jButtonEliminarCarrera.setText("Eliminar");
        jButtonEliminarCarrera.setToolTipText("");
        jButtonEliminarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCarreraActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Participantes inscritos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTableParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableParticipantes);

        jButtonAniadirPart.setText("Añadir participantes");
        jButtonAniadirPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAniadirPartActionPerformed(evt);
            }
        });

        jButtonRefrescarTabla.setText("Refrescar tabla");
        jButtonRefrescarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefrescarTablaActionPerformed(evt);
            }
        });

        jButtonBorrarParticipante.setText("Eliminar participante");
        jButtonBorrarParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarParticipanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButtonRefrescarTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAniadirPart, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBorrarParticipante))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAniadirPart)
                    .addComponent(jButtonRefrescarTabla)
                    .addComponent(jButtonBorrarParticipante))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAceptarMoficacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonEliminarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAceptarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEliminarCarrera)
                    .addComponent(jButtonAceptarMoficacion)
                    .addComponent(jButtonAceptarCarrera)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed
        
    //Metodo para validar datos modificados de una carrera existente
    private void jButtonAceptarMoficacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarMoficacionActionPerformed
        if (group.performValidation() == null) {
            //Mostrar dialogo de confirmacion
            int aceptar = JOptionPane.showConfirmDialog(this, "¿Confirmar cambios?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (aceptar == JOptionPane.YES_OPTION) {

                carrera.setNombre(jTextFieldNombre.getText());
                carrera.setFecha((Date) jSpinnerFecha.getValue());
                carrera.setLugar(jTextFieldLugar.getText());                              
                carrera.setNumMaxParticipantes(Integer.parseInt(jTextFieldNumPart.getText()));
                
                
                

                JOptionPane.showConfirmDialog(this, "Cambios realizados con éxito.", "Confirmación", JOptionPane.CLOSED_OPTION);

                dispose();
            } else if (aceptar == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Se han cancelado los cambios", "Confirmación", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(this, "No se ha rellenado el formulario correctamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptarMoficacionActionPerformed

    private void jButtonAceptarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarCarreraActionPerformed
        if (group.performValidation() == null) {
            //Mostrar dialogo de confirmacion
            int aceptar = JOptionPane.showConfirmDialog(this, "¿Confirmar nueva carrera?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (aceptar == JOptionPane.YES_OPTION) {             
                
                carrera.setNombre(jTextFieldNombre.getText());
                carrera.setFecha((Date) jSpinnerFecha.getValue());
                carrera.setLugar(jTextFieldLugar.getText());
                carrera.setNumMaxParticipantes(Integer.parseInt(jTextFieldNumPart.getText()));
                
                carrera.setParticipantes(participantes);
                
                logicaCarreras.altaCarrera(carrera);
                
                JOptionPane.showConfirmDialog(this, "Carrera creada con éxito.", "Confirmación", JOptionPane.CLOSED_OPTION);

                dispose();
            } else if (aceptar == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Se ha cancelado la creación", "Confirmación", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(this, "No se ha rellenado el formulario correctamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptarCarreraActionPerformed
    
    //Metodo para eliminar una carrera existente
    private void jButtonEliminarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCarreraActionPerformed
                 //Mostrar dialogo de confirmacion
            int aceptar = JOptionPane.showConfirmDialog(this, "¿Confirmar que quiere eliminar esta carrera?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (aceptar == JOptionPane.YES_OPTION) {

                carrera.setNombre(jTextFieldNombre.getText());
                carrera.setFecha((Date) jSpinnerFecha.getValue());
                carrera.setLugar(jTextFieldLugar.getText());                              
                carrera.setNumMaxParticipantes(Integer.parseInt(jTextFieldNumPart.getText()));               

                JOptionPane.showConfirmDialog(this, "Se ha eliminado la carrera.", "Confirmación", JOptionPane.CLOSED_OPTION);

                dispose();
            } else if (aceptar == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Se ha cancelado la eliminación", "Confirmación", JOptionPane.WARNING_MESSAGE);

            }      
    }//GEN-LAST:event_jButtonEliminarCarreraActionPerformed

    private void jButtonAniadirPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAniadirPartActionPerformed
        logicaCarreras.cargarDorsales(carrera, Integer.parseInt(jTextFieldNumPart.getText()));
        plc = new PantallaListaCorredores(this, true, logicaCarreras, logicaCorredores, carrera);
        plc.setVisible(true);
    }//GEN-LAST:event_jButtonAniadirPartActionPerformed

    private void jTextFieldNumPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumPartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumPartActionPerformed

    private void jButtonRefrescarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefrescarTablaActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jButtonRefrescarTablaActionPerformed

    private void jButtonBorrarParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarParticipanteActionPerformed
        /*int filaSeleccionada = jTableParticipantes.convertRowIndexToModel(jTableParticipantes.getSelectedRow());
        Corredor seleccionado = participantes.buscaCorredor(listaCorredores.verCorredores().get(filaSeleccionada).getDni());
        boolean resultado = logicaCarreras.(carrera, seleccionado);
        if(!resultado){
            JOptionPane.showMessageDialog(this, "El corredor seleccionado ya está inscrito en está carrera", "Confirmación", JOptionPane.WARNING_MESSAGE);
        } 
        */
    }//GEN-LAST:event_jButtonBorrarParticipanteActionPerformed
    
     @Override

        public void setTitle(String title) {
            super.setTitle(title);
        }
        
    /**
     * @param args the command line arguments
     */

    public PantallaDatosCarrera() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarCarrera;
    private javax.swing.JButton jButtonAceptarMoficacion;
    private javax.swing.JButton jButtonAniadirPart;
    private javax.swing.JButton jButtonBorrarParticipante;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminarCarrera;
    private javax.swing.JButton jButtonRefrescarTabla;
    private javax.swing.JLabel jLabelDatosCarrera;
    private javax.swing.JLabel jLabelFechaNac;
    private javax.swing.JLabel jLabelLugar;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumPart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerFecha;
    private javax.swing.JTable jTableParticipantes;
    private javax.swing.JTextField jTextFieldLugar;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumPart;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelValidacionDatos;
    // End of variables declaration//GEN-END:variables
}
