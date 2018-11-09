/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Logica.LogicaCarreras;
import Logica.LogicaCorredores;
import java.io.File;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author dbarriof
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    //Definicion de variables utilizadas
    LogicaCorredores listaCorredores;
    LogicaCarreras listaCarreras;
    //Definicion de variables de pantallas
    private PantallaDatosCorredor pac;
    private PantallaListaCorredores plc;
    private PantallaDatosCarrera pdc;
    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        listaCorredores = new LogicaCorredores();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserFichImport = new javax.swing.JFileChooser();
        jPanelPantallaPrincipal = new javax.swing.JPanel();
        jLabelImagen = new javax.swing.JLabel();
        jButtonCerrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCorredores = new javax.swing.JMenu();
        jMenuItemAlta = new javax.swing.JMenuItem();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jMenuItemVer = new javax.swing.JMenuItem();
        jMenuItemImportar = new javax.swing.JMenuItem();
        jMenuCarreras = new javax.swing.JMenu();
        jMenuItemNuevaCarrera = new javax.swing.JMenuItem();
        jMenuItemModificarCarrera = new javax.swing.JMenuItem();
        jMenuItemEliminarCarrera = new javax.swing.JMenuItem();
        jMenuItemVerCarrera = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Carreras");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanelPantallaPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        jPanelPantallaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/runners.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanelPantallaPrincipalLayout = new javax.swing.GroupLayout(jPanelPantallaPrincipal);
        jPanelPantallaPrincipal.setLayout(jPanelPantallaPrincipalLayout);
        jPanelPantallaPrincipalLayout.setHorizontalGroup(
            jPanelPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelPantallaPrincipalLayout.setVerticalGroup(
            jPanelPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButtonCerrar.setText("Salir");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jMenuBar1.setPreferredSize(new java.awt.Dimension(118, 42));

        jMenuCorredores.setBorder(null);
        jMenuCorredores.setText("Corredores");

        jMenuItemAlta.setText("Nuevo...");
        jMenuItemAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemAlta);

        jMenuItemModificar.setText("Modificar...");
        jMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemModificar);

        jMenuItemEliminar.setText("Eliminar...");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemEliminar);

        jMenuItemVer.setText("Ver...");
        jMenuItemVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemVer);

        jMenuItemImportar.setText("Importar...");
        jMenuItemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportarActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemImportar);

        jMenuBar1.add(jMenuCorredores);

        jMenuCarreras.setText("Carreras");

        jMenuItemNuevaCarrera.setText("Nueva...");
        jMenuItemNuevaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevaCarreraActionPerformed(evt);
            }
        });
        jMenuCarreras.add(jMenuItemNuevaCarrera);

        jMenuItemModificarCarrera.setText("Modificar...");
        jMenuCarreras.add(jMenuItemModificarCarrera);

        jMenuItemEliminarCarrera.setText("Eliminar...");
        jMenuCarreras.add(jMenuItemEliminarCarrera);

        jMenuItemVerCarrera.setText("Ver...");
        jMenuCarreras.add(jMenuItemVerCarrera);

        jMenuBar1.add(jMenuCarreras);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPantallaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPantallaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaActionPerformed
        pac = new PantallaDatosCorredor(this, true, listaCorredores);
        pac.setVisible(true);
    }//GEN-LAST:event_jMenuItemAltaActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        int salir = JOptionPane.showConfirmDialog(this, "¿Confirma que quiere salir de la aplicación?", "Cerrar aplicación", JOptionPane.YES_NO_OPTION);
        if (salir == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarActionPerformed
        boolean salir = false;
        while (!salir) {
            String modifCorredor = JOptionPane.showInputDialog(this, "Indique el DNI del corredor", "");
            if (modifCorredor == null) {
                salir = true;
            } else {
                if (listaCorredores.buscaCorredor(modifCorredor) != null) {
                    pac = new PantallaDatosCorredor(this, true, listaCorredores, listaCorredores.buscaCorredor(modifCorredor));
                    pac.setVisible(true);
                    salir = true;
                } else if (listaCorredores.buscaCorredor(modifCorredor) == null) {
                    int confirm = JOptionPane.showConfirmDialog(this, "No existe el corredor indicado \n ¿Realizar una nueva busqueda?", "Error al buscar", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.NO_OPTION) {
                        salir = true;
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItemModificarActionPerformed

    private void jMenuItemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportarActionPerformed
        boolean selectFich = true;

        while (selectFich) {
            //Seleccionamos el fichero desde el que importar

            JFileChooser importarArchivo = new JFileChooser();
            importarArchivo.showOpenDialog(this);
            //File archivo = importarArchivo.getSelectedFile();
            //JFileChooserFichImport jfc = new jFileChooserFichImport();
            File archivo = importarArchivo.getSelectedFile();

            //Solicitamos confirmacion para el fichero seleccionado
            int confirmar = JOptionPane.showConfirmDialog(this, "¿Confirmar el archivo seleccionado?" , "Confirmar", JOptionPane.YES_NO_OPTION);

            //En caso de confirmar se muestran los corredores que se van a importar
            if (confirmar == JOptionPane.YES_OPTION) {
                selectFich = false;
                plc = new PantallaListaCorredores(this, true, listaCorredores.importarCorredores(archivo),true);
                plc.setVisible(true);

            } else if (confirmar == JOptionPane.NO_OPTION) {

                //Seleccionar un nuevo archivo si cancela el anterior o salir en caso contrario
                int nuevaEleccion = JOptionPane.showConfirmDialog(this, "¿Seleccionar otro fichero?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (nuevaEleccion == JOptionPane.NO_OPTION) {
                    selectFich = false;
                }
            }
        }
    }//GEN-LAST:event_jMenuItemImportarActionPerformed

    private void jMenuItemVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerActionPerformed
        plc = new PantallaListaCorredores(this, true, listaCorredores.verCorredores());
        plc.setVisible(true);
    }//GEN-LAST:event_jMenuItemVerActionPerformed

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        boolean salir = false;
        while (!salir) {
            String elimCorredor = JOptionPane.showInputDialog(this, "Indique el DNI del corredor", "");
            if (elimCorredor == null) {
                salir = true;
            } else {
                if (listaCorredores.buscaCorredor(elimCorredor) != null) {
                    pac = new PantallaDatosCorredor(this, true, listaCorredores, listaCorredores.buscaCorredor(elimCorredor), true);
                    pac.setVisible(true);
                    salir = true;
                } else if (listaCorredores.buscaCorredor(elimCorredor) == null) {
                    int confirm = JOptionPane.showConfirmDialog(this, "No existe el corredor indicado \n ¿Realizar una nueva busqueda?", "Error al buscar", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.NO_OPTION) {
                        salir = true;
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    private void jMenuItemNuevaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevaCarreraActionPerformed
        pdc = new PantallaDatosCarrera(this, true, listaCarreras);
        pdc.setVisible(true);
    }//GEN-LAST:event_jMenuItemNuevaCarreraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Establecemos ubicacion de la aplicacion
                Locale.setDefault(new Locale("es","ES"));
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JFileChooser jFileChooserFichImport;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCarreras;
    private javax.swing.JMenu jMenuCorredores;
    private javax.swing.JMenuItem jMenuItemAlta;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemEliminarCarrera;
    private javax.swing.JMenuItem jMenuItemImportar;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JMenuItem jMenuItemModificarCarrera;
    private javax.swing.JMenuItem jMenuItemNuevaCarrera;
    private javax.swing.JMenuItem jMenuItemVer;
    private javax.swing.JMenuItem jMenuItemVerCarrera;
    private javax.swing.JPanel jPanelPantallaPrincipal;
    // End of variables declaration//GEN-END:variables
}
