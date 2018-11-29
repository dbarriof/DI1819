/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Dto.Corredor;
import Logica.LogicaAplicacion;
import java.awt.Color;
import java.util.Date;
import javax.swing.JOptionPane;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author dbarriof
 */
public class PantallaDatosCorredor extends javax.swing.JDialog {

    private LogicaAplicacion logicaAplicacion;
    private ValidationGroup group;
    private Corredor corredor;
    
    //Constructor para dar de alta un corredor
    public PantallaDatosCorredor(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion) {
        super(parent, modal);
        setTitle("Alta corredor");
        this.logicaAplicacion = logicaAplicacion;
        initComponents();
        validador();
        
        
        jButtonAceptarMoficacion.setVisible(false);
        jButtonEliminarCorredor.setVisible(false);
    }
    
    //Constructor para modificar un corredor
    public PantallaDatosCorredor(java.awt.Frame parent, boolean modal, Corredor c) {
        super(parent, modal);
        setTitle("Modificar corredor");
        initComponents();
        validador();
        
        //Detalles de pantalla
        jLabelAltaCorredor.setText("Modifica los campos necesarios:");
        
        
        //Instanciamos corredor a modificar
        corredor = c;
        
        jTextFieldNombre.setText(c.getNombre());
        jTextFieldDni.setText(c.getDni());
        jTextFieldDni.setEditable(false);
        jTextFieldDni.setToolTipText("No es posible modificar el Dni");
        jTextFieldDni.setForeground(Color.GRAY);
        jSpinnerFechaNac.setValue(c.getFechaNac());
        jTextAreaDireccion.setText(c.getDireccion());
        jTextFieldTelefono.setText(String.valueOf(c.getTelefono()));
        
        jButtonAceptarAlta.setVisible(false);
        jButtonEliminarCorredor.setVisible(false);
    }
    
    //Constructor para eliminar un corredor
    public PantallaDatosCorredor(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion, Corredor c) {
        super(parent, modal);
        setTitle("Eliminar corredor");
        this.logicaAplicacion = logicaAplicacion;
        initComponents();
        validador();
        
        //Detalles de pantalla
        jLabelAltaCorredor.setText("Datos del corredor:");
        
        //Cargamos datos del corredor
        jTextFieldNombre.setText(c.getNombre());
        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.setForeground(Color.GRAY);
        jTextFieldDni.setText(c.getDni());
        jTextFieldDni.setEditable(false);
        jTextFieldDni.setForeground(Color.GRAY);
        jSpinnerFechaNac.setValue(c.getFechaNac());
        jSpinnerFechaNac.setEnabled(false);
        jSpinnerFechaNac.setForeground(Color.GRAY);
        jTextAreaDireccion.setText(c.getDireccion());
        jTextAreaDireccion.setEditable(false);
        jTextAreaDireccion.setForeground(Color.GRAY);
        jTextFieldTelefono.setText(String.valueOf(c.getTelefono()));
        jTextFieldTelefono.setEditable(false);
        jTextFieldTelefono.setForeground(Color.GRAY);
        
        jButtonAceptarMoficacion.setVisible(false);
        jButtonAceptarAlta.setVisible(false);
    }
    
    public void validador(){
        //Validación de campos de entrada
        group = validationPanelValidacionDatos.getValidationGroup();
        
        group.add(jTextFieldTelefono, StringValidators.REQUIRE_VALID_INTEGER);
        group.add(jTextFieldTelefono, StringValidators.minLength(9));
        group.add(jTextFieldTelefono, StringValidators.maxLength(12));
        group.add(jTextAreaDireccion, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextAreaDireccion, StringValidators.maxLength(150));
        group.add(jTextFieldDni, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldDni, StringValidators.maxLength(9));
        group.add(jTextFieldDni, StringValidators.minLength(9));
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldNombre, StringValidators.maxLength(50));
        
        
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDatosCorredor = new javax.swing.JPanel();
        jLabelAltaCorredor = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelDni = new javax.swing.JLabel();
        jLabelFechaNac = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldDni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDireccion = new javax.swing.JTextArea();
        jTextFieldTelefono = new javax.swing.JTextField();
        jSpinnerFechaNac = new javax.swing.JSpinner();
        validationPanelValidacionDatos = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jButtonAceptarAlta = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptarMoficacion = new javax.swing.JButton();
        jButtonEliminarCorredor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos del corredor");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icono.jpg")).getImage());

        jLabelAltaCorredor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelAltaCorredor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAltaCorredor.setText("Datos del corredor:");

        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNombre.setText("Nombre:");

        jLabelDni.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDni.setText("Dni:");

        jLabelFechaNac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFechaNac.setText("Fecha de Nacimiento:");

        jLabelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDireccion.setText("Dirección:");

        jLabelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTelefono.setText("Teléfono:");

        jTextFieldNombre.setToolTipText("Espacio para insertar nombre del corredor");
        jTextFieldNombre.setName("Nombre"); // NOI18N
        jTextFieldNombre.setNextFocusableComponent(jTextFieldDni);
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldDni.setToolTipText("Espacio para insertar el dni del corredor");
        jTextFieldDni.setName("Dni"); // NOI18N
        jTextFieldDni.setNextFocusableComponent(jSpinnerFechaNac);

        jTextAreaDireccion.setColumns(20);
        jTextAreaDireccion.setRows(5);
        jTextAreaDireccion.setToolTipText("Espacio para insertar la dirección del corredor");
        jTextAreaDireccion.setName("Dirección"); // NOI18N
        jTextAreaDireccion.setNextFocusableComponent(jTextFieldTelefono);
        jScrollPane1.setViewportView(jTextAreaDireccion);

        jTextFieldTelefono.setToolTipText("Espacio para insertar el teléfono del corredor");
        jTextFieldTelefono.setName("Telefóno"); // NOI18N

        jSpinnerFechaNac.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerFechaNac.setToolTipText("Selecciona la fecha de nacimiento del corredor");
        jSpinnerFechaNac.setName("Fecha de nacimiento"); // NOI18N

        javax.swing.GroupLayout jPanelDatosCorredorLayout = new javax.swing.GroupLayout(jPanelDatosCorredor);
        jPanelDatosCorredor.setLayout(jPanelDatosCorredorLayout);
        jPanelDatosCorredorLayout.setHorizontalGroup(
            jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCorredorLayout.createSequentialGroup()
                .addGroup(jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAltaCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jTextFieldDni)
                    .addComponent(jTextFieldTelefono)
                    .addComponent(jSpinnerFechaNac)
                    .addComponent(validationPanelValidacionDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)))
        );
        jPanelDatosCorredorLayout.setVerticalGroup(
            jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCorredorLayout.createSequentialGroup()
                .addGroup(jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validationPanelValidacionDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAltaCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDni, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanelDatosCorredorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 100, Short.MAX_VALUE))
        );

        jButtonAceptarAlta.setText("Aceptar");
        jButtonAceptarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarAltaActionPerformed(evt);
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
        jButtonAceptarMoficacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarMoficacionActionPerformed(evt);
            }
        });

        jButtonEliminarCorredor.setText("Eliminar");
        jButtonEliminarCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCorredorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDatosCorredor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAceptarMoficacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonEliminarCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAceptarAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatosCorredor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEliminarCorredor)
                    .addComponent(jButtonAceptarMoficacion)
                    .addComponent(jButtonAceptarAlta)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAceptarMoficacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarMoficacionActionPerformed
        if (group.performValidation() == null) {
            //Mostrar dialogo de confirmacion
            int aceptar = JOptionPane.showConfirmDialog(this, "¿Confirmar cambios?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (aceptar == JOptionPane.YES_OPTION) {
                
                corredor.setNombre(jTextFieldNombre.getText());
                corredor.setFechaNac((Date) jSpinnerFechaNac.getValue());
                corredor.setDireccion(jTextAreaDireccion.getText());
                corredor.setTelefono(Integer.parseInt(jTextFieldTelefono.getText()));
                
                JOptionPane.showConfirmDialog(this, "Cambios realizados con éxito.", "Confirmación", JOptionPane.CLOSED_OPTION);

                dispose();
            } else if (aceptar == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Se han cancelado los cambios", "Confirmación", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(this, "No se ha rellenado el formulario correctamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptarMoficacionActionPerformed

    private void jButtonAceptarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarAltaActionPerformed
        if (group.performValidation() == null) {
            //Mostrar dialogo de confirmacion
            int aceptar = JOptionPane.showConfirmDialog(this, "¿Confirmar alta?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (aceptar == JOptionPane.YES_OPTION) {

                String nombre = jTextFieldNombre.getText();
                String dni = jTextFieldDni.getText();
                Date fecNac = (Date) jSpinnerFechaNac.getValue();
                String Direccion = jTextAreaDireccion.getText();
                int telefono = Integer.parseInt(jTextFieldTelefono.getText());

                Corredor c = new Corredor(nombre, dni, fecNac, Direccion, telefono);
                boolean resultado = logicaAplicacion.altaCorredor(c);
                
                if(resultado){
                    JOptionPane.showConfirmDialog(this, "Alta realizada con éxito.", "Confirmación", JOptionPane.CLOSED_OPTION);
                    dispose();
                } else {
                     JOptionPane.showMessageDialog(this, "El corredor ya esta dado de alta en la aplicación", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            } else if (aceptar == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Se ha cancelado la alta", "Mensaje", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(this, "No se ha rellenado el formulario correctamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptarAltaActionPerformed
    
    private void jButtonEliminarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCorredorActionPerformed
                 //Mostrar dialogo de confirmacion
            int aceptar = JOptionPane.showConfirmDialog(this, "¿Confirmar eliminación del corredor?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if (aceptar == JOptionPane.YES_OPTION) {
                
                String nombre = jTextFieldNombre.getText();
                String dni = jTextFieldDni.getText();
                Date fecNac = (Date) jSpinnerFechaNac.getValue();
                String Direccion = jTextAreaDireccion.getText();
                int telefono = Integer.parseInt(jTextFieldTelefono.getText());

                Corredor c = new Corredor(nombre, dni, fecNac, Direccion, telefono);
                logicaAplicacion.eliminarCorredor(c);

                JOptionPane.showConfirmDialog(this, "Se ha eliminado el corredor.", "Confirmación", JOptionPane.CLOSED_OPTION);

                dispose();
            } else if (aceptar == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(this, "Se ha cancelado la eliminación", "Confirmación", JOptionPane.WARNING_MESSAGE);

            }      
    }//GEN-LAST:event_jButtonEliminarCorredorActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed
    
     @Override

        public void setTitle(String title) {
            super.setTitle(title);
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarAlta;
    private javax.swing.JButton jButtonAceptarMoficacion;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminarCorredor;
    private javax.swing.JLabel jLabelAltaCorredor;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelFechaNac;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanelDatosCorredor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerFechaNac;
    private javax.swing.JTextArea jTextAreaDireccion;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelValidacionDatos;
    // End of variables declaration//GEN-END:variables
}
