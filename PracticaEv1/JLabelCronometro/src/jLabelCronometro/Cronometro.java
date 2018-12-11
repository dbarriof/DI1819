/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jLabelCronometro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author dbarriof
 */
public class Cronometro extends JLabel implements Serializable {

    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private Date cronometroDate;
    private Timer cronometro;
    private TimerTask tarea;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    private CronometroListener cronometroListener;
    private CorredorLlegado corredorLlegado;
    
    public Cronometro() {
        //Asignacion de valores iniciales al cronometro       
        String horaActual = String.valueOf(horas) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos);
        try {
            cronometroDate = sdf.parse(horaActual);
        } catch (ParseException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
        setText(sdf.format(cronometroDate));
        
        
        //Creacion de objeto a devolver por el componente y de posicion inicial
        CorredorLlegado corredor = new CorredorLlegado();
        
        // Evento de raton que permite llamar al listener y devolver el corredor que llega
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                //Controlamos que el evento lance el listener si la carrera se ha iniciado previamente
                if (!String.valueOf(sdf.format(getCronometroDate())).equals("00:00:00")) {
                    
                    boolean aniadirLlegada = true;
                    corredor.setTiempo(getCronometroDate());
                    while (aniadirLlegada) {
                        String dorsal = JOptionPane.showInputDialog(Cronometro.this, "Indique el dorsal del corredor", "");
                        if (dorsal == null) {
                            JOptionPane.showMessageDialog(Cronometro.this, "La operación se ha cancelado", "Error", JOptionPane.WARNING_MESSAGE);
                            aniadirLlegada = false;
                        } else {
                            if (!dorsal.isEmpty()) {
                                corredor.setDorsal(Integer.parseInt(dorsal));
                                aniadirLlegada = false;
                            } else {
                                int repetirEntrada = JOptionPane.showConfirmDialog(Cronometro.this, "No ha introducido ningún dorsal \n ?Introducir de nuevo?", "Error", JOptionPane.ERROR_MESSAGE);
                                if (repetirEntrada == JOptionPane.NO_OPTION) {
                                    JOptionPane.showMessageDialog(Cronometro.this, "La operación se ha cancelado", "Error", JOptionPane.WARNING_MESSAGE);
                                    aniadirLlegada = false;
                                }
                            }
                        }
                    }                   
                    cronometroListener.llegaCorredor(corredor);
                }
            }
        });   
    }

    public Date getCronometroDate() {
        return cronometroDate;
    }

    public void setCronometroDate(Date cronometroDate) {
        this.cronometroDate = cronometroDate;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void resetCronometro() {
        pausarCronometro();

        segundos = 0;
        minutos = 0;
        horas = 0;

        String horaActual = String.valueOf(horas) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos);
        try {
            cronometroDate = sdf.parse(horaActual);
        } catch (ParseException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
        setText(sdf.format(cronometroDate));
    }

    public void pausarCronometro() {
        if (tarea.scheduledExecutionTime() > 0) {
            tarea.cancel();
        }
        
    }

    public void iniciarCarrera() {
        cronometro = new Timer();
        tarea = new TimerTask() {
            @Override
            public void run() {
                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }
                if (minutos == 60) {
                    minutos = 0;
                    horas++;
                }

                String horaActual = String.valueOf(horas) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos);
                try {

                    cronometroDate = sdf.parse(horaActual);
                } catch (ParseException ex) {
                    Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                }
                setText(sdf.format(cronometroDate));
                segundos++;

            }
        };
        cronometro.schedule(tarea, 0, 1000);
    }

    public void addCronometroListener(CronometroListener cronometroListener) {
        this.cronometroListener = cronometroListener;
    }
}
