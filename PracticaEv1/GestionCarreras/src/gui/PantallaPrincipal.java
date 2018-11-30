package gui;

import Logica.LogicaAplicacion;
import gui.Recursos.ListenerTemporizadorGuardado;
import gui.Recursos.TemporizadorGuardadoAutomatico;
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
    private LogicaAplicacion logicaAplicacion;

    //Definicion de variables de pantallas
    private PantallaDatosCorredor pdco;
    private PantallaListaCorredores plco;
    private PantallaDatosCarrera pdca;
    private PantallaListaCarreras plca;
    private PantallaCronometro pic;
    private TemporizadorGuardadoAutomatico temporizador = new TemporizadorGuardadoAutomatico();

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        logicaAplicacion = new LogicaAplicacion();
        logicaAplicacion.cargarDatos();
        initComponents();

        temporizador.addListenerTemporizadorGuardado(new ListenerTemporizadorGuardado() {
            @Override
            public void guardarDatos(Object object) {
                temporizador = new TemporizadorGuardadoAutomatico(logicaAplicacion);
            }
        });

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
        jMenuAplicacion = new javax.swing.JMenuBar();
        jMenuCorredores = new javax.swing.JMenu();
        jMenuItemAltaCorredor = new javax.swing.JMenuItem();
        jMenuItemModificarCorredor = new javax.swing.JMenuItem();
        jMenuItemEliminarCorredor = new javax.swing.JMenuItem();
        jMenuItemVerCorredores = new javax.swing.JMenuItem();
        jMenuItemImportarCorredores = new javax.swing.JMenuItem();
        jMenuCarreras = new javax.swing.JMenu();
        jMenuItemNuevaCarrera = new javax.swing.JMenuItem();
        jMenuItemVerCarreras = new javax.swing.JMenuItem();
        jMenuItemIniciarCarrera = new javax.swing.JMenuItem();
        jMenuOpciones = new javax.swing.JMenu();
        jMenuItemGuardado = new javax.swing.JMenuItem();
        jMenuItemCambiarAspecto = new javax.swing.JMenuItem();
        jMenuAyuda = new javax.swing.JMenu();
        jMenuItemAbrirAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Carreras v1.0");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icono.jpg")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelPantallaPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        jPanelPantallaPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/runners.jpg"))); // NOI18N
        jLabelImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelPantallaPrincipalLayout = new javax.swing.GroupLayout(jPanelPantallaPrincipal);
        jPanelPantallaPrincipal.setLayout(jPanelPantallaPrincipalLayout);
        jPanelPantallaPrincipalLayout.setHorizontalGroup(
            jPanelPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen)
        );
        jPanelPantallaPrincipalLayout.setVerticalGroup(
            jPanelPantallaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen)
        );

        jButtonCerrar.setText("Salir");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jMenuAplicacion.setPreferredSize(new java.awt.Dimension(118, 42));

        jMenuCorredores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuCorredores.setText("Corredores");
        jMenuCorredores.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuCorredores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuCorredores.setPreferredSize(new java.awt.Dimension(75, 19));

        jMenuItemAltaCorredor.setText("Nuevo...");
        jMenuItemAltaCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAltaCorredorActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemAltaCorredor);

        jMenuItemModificarCorredor.setText("Modificar...");
        jMenuItemModificarCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarCorredorActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemModificarCorredor);

        jMenuItemEliminarCorredor.setText("Eliminar...");
        jMenuItemEliminarCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarCorredorActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemEliminarCorredor);

        jMenuItemVerCorredores.setText("Ver...");
        jMenuItemVerCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerCorredoresActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemVerCorredores);

        jMenuItemImportarCorredores.setText("Importar...");
        jMenuItemImportarCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportarCorredoresActionPerformed(evt);
            }
        });
        jMenuCorredores.add(jMenuItemImportarCorredores);

        jMenuAplicacion.add(jMenuCorredores);

        jMenuCarreras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuCarreras.setText("Carreras");
        jMenuCarreras.setFont(jMenuCarreras.getFont());
        jMenuCarreras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuCarreras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuCarreras.setPreferredSize(new java.awt.Dimension(75, 19));

        jMenuItemNuevaCarrera.setText("Nueva...");
        jMenuItemNuevaCarrera.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuItemNuevaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevaCarreraActionPerformed(evt);
            }
        });
        jMenuCarreras.add(jMenuItemNuevaCarrera);

        jMenuItemVerCarreras.setText("Ver...");
        jMenuItemVerCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerCarrerasActionPerformed(evt);
            }
        });
        jMenuCarreras.add(jMenuItemVerCarreras);

        jMenuItemIniciarCarrera.setText("Iniciar...");
        jMenuItemIniciarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIniciarCarreraActionPerformed(evt);
            }
        });
        jMenuCarreras.add(jMenuItemIniciarCarrera);

        jMenuAplicacion.add(jMenuCarreras);

        jMenuOpciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuOpciones.setText("Opciones");
        jMenuOpciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuOpciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuOpciones.setPreferredSize(new java.awt.Dimension(75, 19));

        jMenuItemGuardado.setText("Configurar guardado automático");
        jMenuItemGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardadoActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuItemGuardado);

        jMenuItemCambiarAspecto.setText("Cambiar aspecto visual");
        jMenuItemCambiarAspecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCambiarAspectoActionPerformed(evt);
            }
        });
        jMenuOpciones.add(jMenuItemCambiarAspecto);

        jMenuAplicacion.add(jMenuOpciones);

        jMenuAyuda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuAyuda.setText("Ayuda");
        jMenuAyuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuAyuda.setPreferredSize(new java.awt.Dimension(75, 19));

        jMenuItemAbrirAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemAbrirAyuda.setText("Abrir...");
        jMenuItemAbrirAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirAyudaActionPerformed(evt);
            }
        });
        jMenuAyuda.add(jMenuItemAbrirAyuda);

        jMenuAplicacion.add(jMenuAyuda);

        setJMenuBar(jMenuAplicacion);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton para acceder al formulario de alta un nuevo corredor
     *
     * @param evt
     */
    private void jMenuItemAltaCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAltaCorredorActionPerformed
        pdco = new PantallaDatosCorredor(this, true, logicaAplicacion);
        pdco.setVisible(true);
    }//GEN-LAST:event_jMenuItemAltaCorredorActionPerformed
    /**
     * Boton para cerrar la aplicacion solicitando aceptacion
     *
     * @param evt
     */
    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        int salir = JOptionPane.showConfirmDialog(this, "¿Confirma que quiere salir de la aplicación?", "Cerrar aplicación", JOptionPane.YES_NO_OPTION);
        if (salir == JOptionPane.YES_OPTION) {
            logicaAplicacion.guardarDatos();
            dispose();
        }
    }//GEN-LAST:event_jButtonCerrarActionPerformed
    /**
     * Boton para acceder al formulario de modificar los datos de un corredor
     *
     * @param evt
     */
    private void jMenuItemModificarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarCorredorActionPerformed
        if (!logicaAplicacion.verCorredores().isEmpty()) {
            boolean salir = false;
            while (!salir) {
                String modifCorredor = null;
                try {
                    modifCorredor = JOptionPane.showInputDialog(this, "Indique el DNI del corredor", "");
                    if (logicaAplicacion.buscaCorredor(modifCorredor) != null) {
                        pdco = new PantallaDatosCorredor(this, true, logicaAplicacion.buscaCorredor(modifCorredor));
                        pdco.setVisible(true);
                        salir = true;
                    } else if (logicaAplicacion.buscaCorredor(modifCorredor) == null) {
                        int confirm = JOptionPane.showConfirmDialog(this, "No existe el corredor indicado \n ¿Realizar una nueva busqueda?", "Error al buscar", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.NO_OPTION) {
                            salir = true;
                        }
                    }                 
                } catch (IllegalArgumentException ex) {
                    if(modifCorredor == null){
                        //JOptionPane.showMessageDialog(this, "No ha introducido un DNI válido", "Error", JOptionPane.ERROR_MESSAGE);
                        salir = true;
                    } else {
                    JOptionPane.showMessageDialog(this, "No ha introducido un DNI válido", "Error", JOptionPane.ERROR_MESSAGE);
                    salir = true;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay corredores inscritos todavía", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemModificarCorredorActionPerformed
    /**
     * Boton para seleccionar un fichero de donde importar corredores
     *
     * @param evt
     */
    private void jMenuItemImportarCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportarCorredoresActionPerformed
        boolean selectFich = true;

        while (selectFich) {
            //Seleccionamos el fichero desde el que importar

            JFileChooser importarArchivo = new JFileChooser();
            importarArchivo.showOpenDialog(this);
            File archivo = importarArchivo.getSelectedFile();

            //Comprobamos que el fichero seleccionado no es null
            if (archivo == null) {
                selectFich = false;
            } else if (!archivo.getName().endsWith("csv")) {
                JOptionPane.showMessageDialog(this, "El fichero debe tener extension CSV y formato:\nNOMBRE, DNI, FECHA DE NACIMIENTO(DD-MM-YYYY), DIRECCION, TELEFONO", "Error al importar", JOptionPane.ERROR_MESSAGE);
            } else {
                //Solicitamos confirmacion para el fichero seleccionado
                int confirmar = JOptionPane.showConfirmDialog(this, "¿Confirmar el archivo seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION);

                //En caso de confirmar se muestran los corredores que se van a importar
                if (confirmar == JOptionPane.YES_OPTION) {
                    selectFich = false;
                    plco = new PantallaListaCorredores(this, true, logicaAplicacion, archivo);
                    plco.setVisible(true);

                } else if (confirmar == JOptionPane.NO_OPTION) {

                    //Seleccionar un nuevo archivo si cancela el anterior o salir en caso contrario
                    int nuevaEleccion = JOptionPane.showConfirmDialog(this, "¿Seleccionar otro fichero?", "Confirmar", JOptionPane.YES_NO_OPTION);

                    if (nuevaEleccion == JOptionPane.NO_OPTION) {
                        selectFich = false;
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItemImportarCorredoresActionPerformed

    private void jMenuItemVerCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerCorredoresActionPerformed
        if (!logicaAplicacion.verCorredores().isEmpty()) {
            plco = new PantallaListaCorredores(this, true, logicaAplicacion);
            plco.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay corredores inscritos todavía", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItemVerCorredoresActionPerformed

    private void jMenuItemEliminarCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarCorredorActionPerformed
        if (!logicaAplicacion.verCorredores().isEmpty()) {
            boolean salir = false;
            while (!salir) {
                String elimCorredor = null;
                try {
                    elimCorredor = JOptionPane.showInputDialog(this, "Indique el DNI del corredor", "");
                    if (logicaAplicacion.buscaCorredor(elimCorredor) != null) {
                        pdco = new PantallaDatosCorredor(this, true, logicaAplicacion, logicaAplicacion.buscaCorredor(elimCorredor));
                        pdco.setVisible(true);
                        salir = true;
                    } else if (logicaAplicacion.buscaCorredor(elimCorredor) == null) {
                        int confirm = JOptionPane.showConfirmDialog(this, "No existe el corredor indicado \n ¿Realizar una nueva busqueda?", "Error al buscar", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.NO_OPTION) {
                            salir = true;
                        }
                    }    
                } catch (IllegalArgumentException ex){
                    if(elimCorredor == null){
                        //JOptionPane.showMessageDialog(this, "No ha introducido un DNI válido", "Error", JOptionPane.ERROR_MESSAGE);
                        salir = true;
                    } else {
                    JOptionPane.showMessageDialog(this, "No ha introducido un DNI válido", "Error", JOptionPane.ERROR_MESSAGE);
                    salir = true;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay corredores inscritos todavía", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemEliminarCorredorActionPerformed

    private void jMenuItemNuevaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevaCarreraActionPerformed
        pdca = new PantallaDatosCarrera(this, true, logicaAplicacion);
        pdca.setVisible(true);
    }//GEN-LAST:event_jMenuItemNuevaCarreraActionPerformed

    private void jMenuItemVerCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerCarrerasActionPerformed
        if (!logicaAplicacion.verCarreras().isEmpty()) {
            plca = new PantallaListaCarreras(this, true, logicaAplicacion);
            plca.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay carreras creadas todavía", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemVerCarrerasActionPerformed

    private void jMenuItemIniciarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIniciarCarreraActionPerformed
        if (!logicaAplicacion.verCarreras().isEmpty()) {
            pic = new PantallaCronometro(this, true, logicaAplicacion);
            pic.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay carreras creadas todavía", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemIniciarCarreraActionPerformed

    /**
     * Metodo que permite guardar los datos en caso de cieere de la aplicacion
     * mediante X
     *
     * @param evt
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logicaAplicacion.guardarDatos();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardadoActionPerformed
        String tiempo;
        //Solicitamos el tiempo que se asignará a guardado automático        
        tiempo = JOptionPane.showInputDialog(this, "¿Cada cuanto tiempo quieres guardar los datos?\n(En minutos)", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
        try{
            int tiempoProgramado = Integer.parseInt(tiempo);
            if (tiempoProgramado == 0){
                JOptionPane.showMessageDialog(this, "Debe introducir un valor mayor de 0,\nel tiempo definido por defecto es 10 minutos", "Guardado automático", JOptionPane.INFORMATION_MESSAGE);
            } else {
                temporizador = new TemporizadorGuardadoAutomatico(logicaAplicacion, tiempoProgramado);
                JOptionPane.showMessageDialog(this, "Guardado automático cada " + tiempo + " minutos\nconfigurado correctamente.", "Guardado automático", JOptionPane.INFORMATION_MESSAGE);  
            }      
            } catch (NumberFormatException ex ){
                JOptionPane.showMessageDialog(this, "Debe introducir un valor numérico,\nel tiempo definido por defecto es 10 minutos", "Guardado automático", JOptionPane.INFORMATION_MESSAGE);               
            }      
    }//GEN-LAST:event_jMenuItemGuardadoActionPerformed

    private void jMenuItemAbrirAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirAyudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemAbrirAyudaActionPerformed

    private void jMenuItemCambiarAspectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCambiarAspectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemCambiarAspectoActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            //Establecemos ubicacion de la aplicacion
            Locale.setDefault(new Locale("es", "ES"));
            new PantallaPrincipal().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JFileChooser jFileChooserFichImport;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JMenuBar jMenuAplicacion;
    private javax.swing.JMenu jMenuAyuda;
    private javax.swing.JMenu jMenuCarreras;
    private javax.swing.JMenu jMenuCorredores;
    private javax.swing.JMenuItem jMenuItemAbrirAyuda;
    private javax.swing.JMenuItem jMenuItemAltaCorredor;
    private javax.swing.JMenuItem jMenuItemCambiarAspecto;
    private javax.swing.JMenuItem jMenuItemEliminarCorredor;
    private javax.swing.JMenuItem jMenuItemGuardado;
    private javax.swing.JMenuItem jMenuItemImportarCorredores;
    private javax.swing.JMenuItem jMenuItemIniciarCarrera;
    private javax.swing.JMenuItem jMenuItemModificarCorredor;
    private javax.swing.JMenuItem jMenuItemNuevaCarrera;
    private javax.swing.JMenuItem jMenuItemVerCarreras;
    private javax.swing.JMenuItem jMenuItemVerCorredores;
    private javax.swing.JMenu jMenuOpciones;
    private javax.swing.JPanel jPanelPantallaPrincipal;
    // End of variables declaration//GEN-END:variables
}
