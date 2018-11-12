/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;

/**
 *
 * @author dbarriof
 */
public class FormatoFecha {
    public static String formatFecha(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(d);
    }

    public static Date parseFecha(String s){
        Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fecha = sdf.parse(s);
        } catch (ParseException ex) {
            System.out.println("Error al convertir fecha.");
        }
        return fecha;
    }
    
    public static String formatTiempo(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(d);
    }

    public static Date parseTiempo(String s){
        Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            fecha = sdf.parse(s);
        } catch (ParseException ex) {
            System.out.println("Error al convertir fecha.");
        }
        return fecha;
    }
    
}
