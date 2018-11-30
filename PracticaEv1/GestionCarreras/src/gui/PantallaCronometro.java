package gui;

import Dto.Carrera;
import Dto.Participante;
import Logica.LogicaAplicacion;
import gui.Recursos.FormatoHoraTabla;
import gui.Recursos.OrdenadorTablas;
import gui.modelosTabla.ParticipantesTableModel;
import jLabelCronometro.CorredorLlegado;
import jLabelCronometro.CronometroListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author dbarriof
 */
public class PantallaCronometro extends javax.swing.JDialog {

    private LogicaAplicacion logicaAplicacion;
    private List<Participante> listaClasificacion;
    private Carrera carreraEnDisputa;
    private int numParticipantes;
    private int participantesRestantes;
    
    /**
     * Creates new form NewJDialog
     *
     * @param parent
     * @param modal
     */
    public PantallaCronometro(java.awt.Frame parent, boolean modal, LogicaAplicacion logicaAplicacion) {
        super(parent, modal);
        this.logicaAplicacion = logicaAplicacion;
        listaClasificacion = new ArrayList<>();
              
        initComponents();
        jButtonIniciar.setEnabled(false); 
        jButtonCancelarCarrera.setEnabled(false);
        cronometro.addCronometroListener(new CronometroListener() {
            @Override
            public void llegaCorredor(CorredorLlegado corredorLlegado) {
                actualizarClasificacion(corredorLlegado);
            }           
        });             
    }

    //Metodo que devuelve un modelo para el spinner que selecciona las carreras
    public ComboBoxModel<String> cargarCarreras() {
        DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<>();
        for (Carrera carrera : logicaAplicacion.verCarreras()) {
            if(!carrera.isFinalizada()){
                dcm.addElement(carrera.getNombre()); 
            }
        }
        return dcm;
    }

    public void cargarTablaParticipantes(List<Participante> clasificacionParticipantes) {
        ParticipantesTableModel ptm = new ParticipantesTableModel(listaClasificacion);
        jTableParticipantes.setModel(ptm);
        jTableParticipantes.setRowSorter(OrdenadorTablas.ordenaTabla(ptm, 4));
        jTableParticipantes.getColumnModel().getColumn(3).setCellRenderer(new FormatoHoraTabla());
    }

    public void actualizarClasificacion(CorredorLlegado corredor) {      
        Participante participanteFinalizado = logicaAplicacion.buscaDorsal(carreraEnDisputa, corredor.getDorsal());
        if (corredor.getDorsal() <= numParticipantes && corredor.getDorsal() > 0) {
            if (participanteFinalizado.getTiempo() == null) {
                listaClasificacion.add(participanteFinalizado);
                participanteFinalizado.setPosicion(listaClasificacion.size());
                participanteFinalizado.setTiempo(corredor.getTiempo());            
                participantesRestantes--;
            } else {
                int confirmar = JOptionPane.showConfirmDialog(this, "El dorsal indicado ya ha llegado a meta\n¿Corregir dorsal indicado?", "Error", JOptionPane.YES_NO_OPTION);
                if(confirmar == JOptionPane.YES_OPTION){
                int dorsalNuevo = Integer.parseInt(JOptionPane.showInputDialog(this, "Indique el dorsal correcto", "Nuevo dorsal", JOptionPane.OK_OPTION));
                CorredorLlegado corredorLlegado = corredor;
                corredorLlegado.setDorsal(dorsalNuevo);
                actualizarClasificacion(corredorLlegado);
                }  
            }
            if (participantesRestantes <= 0) {
                cronometro.pausarCronometro();
                carreraEnDisputa.setParticipantes(listaClasificacion);
                cargarTablaParticipantes(listaClasificacion);
                carreraEnDisputa.setFinalizada(true);
                JOptionPane.showMessageDialog(PantallaCronometro.this, "Ha llegado el último participante\nSe ha generado el informe de clasificación", "Finalización de carrera", JOptionPane.INFORMATION_MESSAGE);
                logicaAplicacion.generarInforme(carreraEnDisputa);
                jButtonVolver.setEnabled(true);
            }
        } else {
            int confirmar = JOptionPane.showConfirmDialog(this, "El dorsal indicado no existe\n¿Indicar un nuevo dorsal?", "Error", JOptionPane.YES_NO_OPTION);
            if(confirmar == JOptionPane.YES_OPTION){
                int dorsalNuevo = Integer.parseInt(JOptionPane.showInputDialog(this, "Indique el dorsal correcto", "Nuevo dorsal", JOptionPane.OK_OPTION));
                CorredorLlegado corredorLlegado = corredor;
                corredorLlegado.setDorsal(dorsalNuevo);
                actualizarClasificacion(corredorLlegado);
            }
        }
        cargarTablaParticipantes(listaClasificacion);
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
        jButtonIniciar = new javax.swing.JButton();
        cronometro = new jLabelCronometro.Cronometro();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelNombreCarrera = new javax.swing.JLabel();
        jButtonSeleccionar = new javax.swing.JButton();
        jButtonCancelarCarrera = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPaneParticipantes = new javax.swing.JScrollPane();
        jTableParticipantes = new javax.swing.JTable();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Celebración de carrera");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icono.jpg")).getImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control de carrera", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jButtonIniciar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonIniciar.setForeground(new java.awt.Color(0, 153, 0));
        jButtonIniciar.setText("Iniciar la carrera");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        cronometro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cronometro.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(cargarCarreras());
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabelNombreCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombreCarrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreCarrera.setText("Selecciona la carrera:");

        jButtonSeleccionar.setText("Seleccionar carrera");
        jButtonSeleccionar.setMargin(new java.awt.Insets(5, 14, 0, 14));
        jButtonSeleccionar.setPreferredSize(new java.awt.Dimension(125, 29));
        jButtonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarActionPerformed(evt);
            }
        });

        jButtonCancelarCarrera.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonCancelarCarrera.setForeground(new java.awt.Color(153, 0, 51));
        jButtonCancelarCarrera.setText("Cancelar carrera");
        jButtonCancelarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                            .addComponent(cronometro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonCancelarCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                            .addComponent(jButtonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(100, 100, 100)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabelNombreCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clasifiicacion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableParticipantes.setEditingColumn(0);
        jTableParticipantes.setEditingRow(0);
        jScrollPaneParticipantes.setViewportView(jTableParticipantes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPaneParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPaneParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jButtonVolver.setText("volver");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVolver)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonVolver)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que inicia el cronometro de la carrera
     *
     * @param evt
     */
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        jButtonVolver.setEnabled(false);
        cronometro.iniciarCarrera();
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
         
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarActionPerformed
        carreraEnDisputa = logicaAplicacion.buscaCarrera((String) jComboBox1.getSelectedItem());
        numParticipantes = carreraEnDisputa.getParticipantes().size();
        participantesRestantes = numParticipantes;
        jComboBox1.setEnabled(false);
        jButtonIniciar.setEnabled(true);
        jButtonCancelarCarrera.setEnabled(true);
    }//GEN-LAST:event_jButtonSeleccionarActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonCancelarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCarreraActionPerformed
        int cancelar = JOptionPane.showConfirmDialog(this, "Cancelar la carrera suspendera la misma,\nle hará volver al menú principal sin\nproducir cambios en los datos de la carrera.", "Cancelar carrera", JOptionPane.YES_NO_OPTION);
        if(cancelar == JOptionPane.YES_OPTION){
            logicaAplicacion.cancelarCarrera(carreraEnDisputa);
            cronometro.pausarCronometro();       
            JOptionPane.showMessageDialog(PantallaCronometro.this, "Se ha suspendido la carrera.", "Carrera cancelada", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } 
    }//GEN-LAST:event_jButtonCancelarCarreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jLabelCronometro.Cronometro cronometro;
    private javax.swing.JButton jButtonCancelarCarrera;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelNombreCarrera;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneParticipantes;
    private javax.swing.JTable jTableParticipantes;
    // End of variables declaration//GEN-END:variables
}
