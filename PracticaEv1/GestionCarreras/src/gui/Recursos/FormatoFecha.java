package gui.Recursos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que permite aplicar formato y casting a fechas y horas
 * 
 * @author dbarriof
 */
public class FormatoFecha {
     
    public static String formatearFecha(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(d);
    }

    public static Date parsearFecha(String s){
        Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fecha = sdf.parse(s);
        } catch (ParseException ex) {
            System.out.println("Error al convertir fecha.");
        }
        return fecha;
    }
    
    public static String formatearTiempo(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(d);
    }
    
    public static Date parsearTiempo(String s){
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
