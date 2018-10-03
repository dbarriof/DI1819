package ControlPartidos;

import com.sun.glass.ui.SystemClipboard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Guile
 */
public class Funcionalidad {
    Scanner sc = new Scanner(System.in);
    private List<Partido> partidos;
    
    
    public Funcionalidad() {
        this.partidos = new ArrayList();
    } 
    
    public  void altaPartido(){
        
        //Datos del nuevo partido
        System.out.println("DATOS DEL PARTIDO");
        System.out.println("_________________");
        System.out.println("Equipo local:");
        String equipoLocal = sc.next();
        System.out.println("Equipo Visitante:");
        String equipoVisitante = sc.next();
        System.out.println("Division:");
        Partido.Division division = null;
        int div = Integer.parseInt(sc.next());
        switch(div){
            case 1 : 
                division = Partido.Division.primera ;
                break;
            case 2 : 
                division = Partido.Division.segunda ;
                break;
            case 3 : 
                division = Partido.Division.tercera ;
                break;
        }
        System.out.println("Resultado:");
        String resultado = sc.next();
        System.out.println("Fecha:");
        String fecha = sc.next();
        
        Partido p = new Partido(equipoLocal, equipoVisitante, division, resultado, fecha);
        
        //Alta del partido en la coleccion        
        partidos.add(p);
    }
    
    
    //Esto es una prueba de modificacion 123
    public void verPartidos(){
        for(Partido p : partidos){
            System.out.println(p.toString());
        }
    }
    
    public void borrarPartido(){
        
        //Datos del partido a borrar
        System.out.println("DATOS DEL PARTIDO");
        System.out.println("_________________");
        System.out.println("Equipo local:");
        String equipoLocal = sc.next();
        System.out.println("Equipo Visitante:");
        String equipoVisitante = sc.next();
        
        Partido p1 = new Partido(equipoLocal, equipoVisitante);
        
        //Borrado del partido si existe en la coleccion
        for (Partido p : partidos){
            if (p.equals(p1)){
                partidos.remove(p);
            }else{
                System.out.println("No existe el partido entre estos dos equipos");
            }
        }
    }
    
    public void ordenarAsc(){
        
    }
    
    public void ordenarDesc(){
        
    }
    
    public void mostrarDivision(){
        //Datos de la division a mostrar
        System.out.println("MOSTRAR PARTIDOS POR CATEGORIA");
        System.out.println("______________________________");
        System.out.println("Division :");
        String div = sc.next();
        
        //Resultado de la consulta
        System.out.println("LISTADO DE PARTIDOS DE "+div+" DIVISION");
        System.out.println("___________________________________________");
        for (Partido p : partidos){
            if (p.getDivision().toString().equalsIgnoreCase(div)){                
                System.out.println(p.toString());
            }
        }
    }
    
    public void cargaPartidos(){
        
    }
    
    public void guardaPartidos(){
        
    }
}
