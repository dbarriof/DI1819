package gui;

import Dto.*;
import Logica.LogicaAplicacion;
import gui.Recursos.MostrarAyuda;
import gui.Recursos.OrdenadorTablas;
import gui.modelosTabla.ParticipantesTableModel;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author dbarriof
 */
public class PantallaDatosCarrera extends javax.swing.JDialog {

    private LogicaAplicacion logicaAplicacion;
    private ValidationGroup group;
    private Carrera carrera;

    //Constructor para dar de alta una carrera
    public PantallaDatosCarrera(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion) {
        super(parent, modal);
        setTitle("Nueva carrera");
        this.logicaAplicacion = logicaAplicacion;
        initComponents();
        MostrarAyuda ayuda = new MostrarAyuda(getRootPane());
        validador();

        //Instanciamos la carrera que vamos a crear para poder añadir elementos a sus colecciones antes de almacenarla en la colección de carreras.
        carrera = new Carrera();

        jButtonAceptarMoficacion.setVisible(false);
        jButtonEliminarCarrera.setVisible(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent we) {
                cargarTablaParticipantes();
                if(carrera.getParticipantes().size() == carrera.getNumMaxParticipantes() && carrera.getNumMaxParticipantes() > 0){
                    jButtonAniadirParticipante.setEnabled(false);
                } else {
                    jButtonAniadirParticipante.setEnabled(true);
                }
            }
        });
    }

    //Constructor para modificar una carrera
    public PantallaDatosCarrera(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion, Carrera carrera) {
        super(parent, modal);
        setTitle("Modificar carrera");
        this.logicaAplicacion = logicaAplicacion;
        this.carrera = carrera;
        initComponents();
        MostrarAyuda ayuda = new MostrarAyuda(getRootPane());
        validador();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent we) {
                cargarTablaParticipantes();
                if(carrera.getParticipantes().size() == carrera.getNumMaxParticipantes() && carrera.getNumMaxParticipantes() > 0){
                    jButtonAniadirParticipante.setEnabled(false);
                } else {
                    jButtonAniadirParticipante.setEnabled(true);
                }
            }
        });
        
        //Detalles de pantalla
        jLabelDatosCarrera.setText("Modifica los campos necesarios:");

        jTextFieldNombre.setText(carrera.getNombre());
        jTextFieldLugar.setText(carrera.getLugar());
        jSpinnerFecha.setValue(carrera.getFecha());
        jTextFieldNumPart.setText(String.valueOf(carrera.getNumMaxParticipantes()));

        jButtonAceptarCarrera.setVisible(false);
        jButtonEliminarCarrera.setVisible(false);
    }

    //Constructor para eliminar una carrera
    public PantallaDatosCarrera(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion, Carrera c, boolean eliminar) {
        super(parent, modal);
        setTitle("Eliminar carrera");
        this.logicaAplicacion = logicaAplicacion;
        initComponents();
        MostrarAyuda ayuda = new MostrarAyuda(getRootPane());
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

    private void validador() {
        //Validación de campos de entrada
        group = validationPanelValidacionDatos.getValidationGroup();

        group.add(jTextFieldNumPart, StringValidators.REQUIRE_VALID_INTEGER);
        group.add(jTextFieldNumPart, StringValidators.maxLength(3));
        group.add(jTextFieldNumPart, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldLugar, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldNombre, StringValidators.REQUIRE_NON_EMPTY_STRING);

    }

    public void cargarTablaParticipantes() {
        jTableParticipantes.setModel(new ParticipantesTableModel((ArrayList<Participante>) carrera.getParticipantes()));
        jTableParticipantes.setRowSorter(OrdenadorTablas.ordenaTabla((AbstractTableModel) jTableParticipantes.getModel(), 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDatosCarrera = new javax.swing.JPanel();
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
        jPanelParticipantes = new javax.swing.JPanel();
        jScrollPaneParticipantes = new javax.swing.JScrollPane();
        jTableParticipantes = new javax.swing.JTable();
        jButtonAniadirParticipante = new javax.swing.JButton();
        jButtonBorrarParticipante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos de la carrera");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icono.jpg")).getImage());

        jPanelDatosCarrera.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabelDatosCarrera.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelDatosCarrera.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDatosCarrera.setText("Datos de la carrera:");

        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNombre.setText("Nombre :");

        jLabelLugar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLugar.setText("Lugar :");

        jLabelFechaNac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFechaNac.setText("Fecha :");
        jLabelFechaNac.setPreferredSize(new java.awt.Dimension(1004, 95));

        jLabelNumPart.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNumPart.setText("Número de participantes :");
        jLabelNumPart.setName("Participantes"); // NOI18N

        jTextFieldNombre.setToolTipText("Espacio para insertar nombre del corredor");
        jTextFieldNombre.setName("Nombre"); // NOI18N
        jTextFieldNombre.setNextFocusableComponent(jTextFieldLugar);

        jTextFieldLugar.setToolTipText("Espacio para insertar el dni del corredor");
        jTextFieldLugar.setName("Lugar"); // NOI18N
        jTextFieldLugar.setNextFocusableComponent(jSpinnerFecha);

        jTextFieldNumPart.setToolTipText("Espacio para insertar el número máximo de participantes");
        jTextFieldNumPart.setAutoscrolls(false);
        jTextFieldNumPart.setName("Participantes"); // NOI18N
        jTextFieldNumPart.setNextFocusableComponent(jButtonAniadirParticipante);
        jTextFieldNumPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumPartActionPerformed(evt);
            }
        });

        jSpinnerFecha.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerFecha.setToolTipText("Selecciona la fecha de nacimiento del corredor");
        jSpinnerFecha.setName("Fecha de nacimiento"); // NOI18N
        jSpinnerFecha.setNextFocusableComponent(jTextFieldNumPart);

        javax.swing.GroupLayout jPanelDatosCarreraLayout = new javax.swing.GroupLayout(jPanelDatosCarrera);
        jPanelDatosCarrera.setLayout(jPanelDatosCarreraLayout);
        jPanelDatosCarreraLayout.setHorizontalGroup(
            jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCarreraLayout.createSequentialGroup()
                .addGroup(jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNumPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jLabelLugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDatosCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validationPanelValidacionDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosCarreraLayout.createSequentialGroup()
                        .addGroup(jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldNumPart, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldLugar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombre))
                        .addContainerGap())))
        );
        jPanelDatosCarreraLayout.setVerticalGroup(
            jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCarreraLayout.createSequentialGroup()
                .addGroup(jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validationPanelValidacionDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(jLabelDatosCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumPart, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonAceptarCarrera.setText("Aceptar");
        jButtonAceptarCarrera.setNextFocusableComponent(jButtonCancelar);
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
        jButtonAniadirParticipante.setNextFocusableComponent(jButtonBorrarParticipante);
        jButtonAniadirParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAniadirParticipanteActionPerformed(evt);
            }
        });

        jButtonBorrarParticipante.setText("Eliminar participante");
        jButtonBorrarParticipante.setNextFocusableComponent(jButtonAceptarCarrera);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBorrarParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneParticipantes, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelParticipantesLayout.setVerticalGroup(
            jPanelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParticipantesLayout.createSequentialGroup()
                .addComponent(jScrollPaneParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelParticipantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAniadirParticipante)
                    .addComponent(jButtonBorrarParticipante))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDatosCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAceptarMoficacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEliminarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAceptarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDatosCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEliminarCarrera)
                    .addComponent(jButtonAceptarMoficacion)
                    .addComponent(jButtonAceptarCarrera)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
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

                logicaAplicacion.altaCarrera(carrera);

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

                boolean resultado = logicaAplicacion.altaCarrera(carrera);
                if (resultado) {
                    JOptionPane.showConfirmDialog(this, "Carrera creada con éxito.", "Confirmación", JOptionPane.CLOSED_OPTION);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "La carrera que quiere crear ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                }

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

    //Metodo que permite desplegar la lista de corredores y añadirlos como participantes
    private void jButtonAniadirParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAniadirParticipanteActionPerformed
        //Asignamos la cantidad maxima de corredores según lo indicado en el campo correspondiente y generemaos los dorsales necesarios
        if(!jTextFieldNumPart.getText().equals("")){
        carrera.setNumMaxParticipantes(Integer.parseInt(jTextFieldNumPart.getText()));
        logicaAplicacion.cargarDorsales(carrera);
        PantallaListaCorredores plc = new PantallaListaCorredores((Frame) this.getParent(), true, logicaAplicacion, carrera);
        plc.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "La carrera no tiene especificado un número de participantes", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAniadirParticipanteActionPerformed

    private void jTextFieldNumPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumPartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumPartActionPerformed


    private void jButtonBorrarParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarParticipanteActionPerformed
        int filaSeleccionada;
        try{
            filaSeleccionada = jTableParticipantes.convertRowIndexToModel(jTableParticipantes.getSelectedRow());
        } catch (ArrayIndexOutOfBoundsException ex){
            filaSeleccionada = -1;
        }
        if (!carrera.getParticipantes().isEmpty() && filaSeleccionada != -1) {           
            Participante seleccionado = logicaAplicacion.buscaParticipante(carrera, carrera.getParticipantes().get(filaSeleccionada));
            boolean resultado = logicaAplicacion.eliminarParticipante(carrera, seleccionado);
            cargarTablaParticipantes();
            if (resultado) {
                JOptionPane.showMessageDialog(this, "El participante se ha eliminado correctamente", "Confirmación", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            if(carrera.getParticipantes().isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay participantes inscritos todavia", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un corredor para poder eliminarlo", "Error", JOptionPane.ERROR_MESSAGE);
            }      
        }

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
    private javax.swing.JButton jButtonAniadirParticipante;
    private javax.swing.JButton jButtonBorrarParticipante;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminarCarrera;
    private javax.swing.JLabel jLabelDatosCarrera;
    private javax.swing.JLabel jLabelFechaNac;
    private javax.swing.JLabel jLabelLugar;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumPart;
    private javax.swing.JPanel jPanelDatosCarrera;
    private javax.swing.JPanel jPanelParticipantes;
    private javax.swing.JScrollPane jScrollPaneParticipantes;
    private javax.swing.JSpinner jSpinnerFecha;
    private javax.swing.JTable jTableParticipantes;
    private javax.swing.JTextField jTextFieldLugar;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumPart;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanelValidacionDatos;
    // End of variables declaration//GEN-END:variables
}
