package gui;

import Dto.Carrera;
import Dto.Corredor;
import Dto.Participante;
import Logica.LogicaAplicacion;
import gui.modelosTabla.ParticipantesTableModel;
import jLabelCronometro.CorredorLlegado;
import jLabelCronometro.CronometroListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dbarriof
 */
public class PantallaCronometro extends javax.swing.JDialog {

    private LogicaAplicacion logicaAplicacion;
    private List<Participante> listaClasificacion;
    private Carrera carreraEnDisputa;
    private int numParticipantes;

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

        cronometro.addCronometroListener(new CronometroListener() {
            @Override
            public void llegaCorredor(CorredorLlegado corredorLlegado) {
                actualizarClasificacion(corredorLlegado);
            }
        });

        jButtonReiniciar.setEnabled(false);
    }

    //Metodo que devuelve un modelo para el spinner que selecciona las carreras
    public ComboBoxModel<String> cargarCarreras() {
        DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<>();
        for (Carrera carrera : logicaAplicacion.verCarreras()) {
            dcm.addElement(carrera.getNombre());
        }
        return dcm;
    }

    public void cargarTablaParticipantes(List<Participante> clasificacionParticipantes) {
        jTableParticipantes.setModel(new ParticipantesTableModel(listaClasificacion)); 
    }

    public void actualizarClasificacion(CorredorLlegado corredor) {
        System.out.println(carreraEnDisputa.getNombre());
        System.out.println(corredor.getDorsal() + " " + corredor.getPosicion() + " " + corredor.getTiempo());
        Participante participanteFinalizado = logicaAplicacion.buscaDorsal(carreraEnDisputa, corredor.getDorsal());
        if (participanteFinalizado.getTiempo() == null) {
            participanteFinalizado.setPosicion(corredor.getPosicion());
            //participanteFinalizado.setTiempo(Date.valueOf(corredor.getTiempo()));
            listaClasificacion.add(participanteFinalizado);
            numParticipantes--;
            if (numParticipantes <= 0) {
                cronometro.pausarCronometro();
                carreraEnDisputa.setParticipantes(listaClasificacion);
                JOptionPane.showMessageDialog(PantallaCronometro.this, "Ha llegado el último participante", "Finalización de carrera", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(PantallaCronometro.this, "El dorsal indicado ya habia llegado", "Error", JOptionPane.ERROR_MESSAGE);
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
        jButtonReiniciar = new javax.swing.JButton();
        jButtonPausar = new javax.swing.JButton();
        jButtonIniciar = new javax.swing.JButton();
        cronometro = new jLabelCronometro.Cronometro();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabelNombreCarrera = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPaneParticipantes = new javax.swing.JScrollPane();
        jTableParticipantes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Celebración de carrera");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icono.jpg")).getImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control de carrera", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jButtonReiniciar.setText("Reiniciar la carrera");
        jButtonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarActionPerformed(evt);
            }
        });

        jButtonPausar.setText("Pausar la carrera");
        jButtonPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPausarActionPerformed(evt);
            }
        });

        jButtonIniciar.setText("Iniciar la carrera");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        cronometro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cronometro.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N

        jComboBox1.setModel(cargarCarreras());

        jLabelNombreCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombreCarrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombreCarrera.setText("Selecciona la carrera:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cronometro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                    .addComponent(jButtonReiniciar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonIniciar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPausar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabelNombreCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPausar, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
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
            .addGap(0, 270, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPaneParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addContainerGap()))
        );

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que inicia el cronometro de la carrera
     *
     * @param evt
     */
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        carreraEnDisputa = logicaAplicacion.buscaCarrera((String) jComboBox1.getSelectedItem());
        numParticipantes = carreraEnDisputa.getParticipantes().size();

        jButtonIniciar.setEnabled(false);
        jButtonReiniciar.setEnabled(true);
        jComboBox1.setEnabled(false);
        cronometro.iniciarCarrera();
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    /**
     * Metodo que permite resetear a 0 el tiempo del cronometro
     *
     * @param evt
     */
    private void jButtonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarActionPerformed
        cronometro.pausarCronometro();
        cronometro.resetCronometro();
        jButtonIniciar.setEnabled(true);
        jButtonReiniciar.setEnabled(false);
    }//GEN-LAST:event_jButtonReiniciarActionPerformed

    /**
     * Metodo que permite pausar una carrera
     *
     * @param evt
     */
    private void jButtonPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPausarActionPerformed
        cronometro.pausarCronometro();
    }//GEN-LAST:event_jButtonPausarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jLabelCronometro.Cronometro cronometro;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonPausar;
    private javax.swing.JButton jButtonReiniciar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelNombreCarrera;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneParticipantes;
    private javax.swing.JTable jTableParticipantes;
    // End of variables declaration//GEN-END:variables
}
