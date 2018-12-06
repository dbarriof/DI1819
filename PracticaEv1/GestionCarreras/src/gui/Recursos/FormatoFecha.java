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
     
    /**
     * Metodo que permite pasar un Date de una fecha a un String formateado
     * @param d
     * @return 
     */
    public static String formatearFecha(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(d);
    }
    
    /**
     * Metodo que permite pasar un String de una fecha a un Date formateado
     * @param s
     * @return 
     */
    public static Date parsearFecha(String s){
        Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fecha = sdf.parse(s);
        } catch (ParseException ex) {
            System.out.println(ex.getErrorOffset()+" - Error al convertir fecha.");
        }
        return fecha;
    }
    
    /**
     * Metodo que permite pasar un Date de una hora a un String formateado
     * @param d
     * @return 
     */
    public static String formatearTiempo(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(d);
    }
    
    /**
     * Metodo que permite pasar un String de una hora a un Date formateado
     * @param s
     * @return 
     */
    public static Date parsearTiempo(String s){
        Date fecha = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            fecha = sdf.parse(s);
        } catch (ParseException ex) {
            System.out.println(ex.getErrorOffset()+" - Error al convertir tiempo.");
        }
        return fecha;
    }   
}
