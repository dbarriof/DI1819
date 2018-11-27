/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jLabelCronometro;

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

/**
 *
 * @author dbarriof
 */
public class Cronometro extends JLabel implements Serializable{
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private Date cronometroDate;
    private Timer cronometro = new Timer();
    private TimerTask tarea = null;
    private int segundos = 0;
    private int minutos = 0;
    private int horas = 0;
    private CronometroListener cronometroListener;
    private CorredorLlegado corredorLlegado;
    
    public Cronometro() {
        String horaActual = String.valueOf(horas) + ":" + String.valueOf(minutos) + ":" + String.valueOf(segundos);
        try {

            cronometroDate = sdf.parse(horaActual);
        } catch (ParseException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
        setText(sdf.format(cronometroDate));
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
        if(tarea.scheduledExecutionTime() > 0){
           tarea.cancel();
        }
    }

    public void iniciarCarrera() {
                                   
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
        cronometro.schedule(tarea , 0, 1000);
    }        

    public void addCronometroListener (CronometroListener cronometroListener){
        this.cronometroListener = cronometroListener;
    }

    public void aniadirLlegada(MouseEvent me){
        //if(cronometroListener.llegaCorredor() != null){
            corredorLlegado = cronometroListener.llegaCorredor();
        //}
    }
 
    public void muestraCorredor(){
        //System.out.println(this.corredorLlegado.getDorsal()+" "+corredorLlegado.getTiempo());
    }
}
