package ControlPartidos;

import com.sun.glass.ui.SystemClipboard;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.Size2DSyntax;

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

    public void altaPartido() {

        //Datos del nuevo partido
        System.out.println("DATOS DEL PARTIDO");
        System.out.println("_________________");
        System.out.println("Equipo local:");
        String equipoLocal = sc.next();
        System.out.println("Equipo Visitante:");
        String equipoVisitante = sc.next();
        Division division = null;
        while (division==null){
            System.out.println("Division:");        
            division = null;
            int div = Integer.parseInt(sc.next());
            switch (div) {
                case 1:
                    division = Division.primera;
                    break;
                case 2:
                    division = Division.segunda;
                    break;
                case 3:
                    division = Division.tercera;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;    
            }
        }
        System.out.println("Puntos del " + equipoLocal + ":");
        int puntosLocal = sc.nextInt();
        System.out.println("Puntos del " + equipoVisitante + ":");
        int puntosVisitante = sc.nextInt();
        String resultado = Integer.toString(puntosLocal) + "-" + Integer.toString(puntosVisitante);
        System.out.println("Fecha(dd-MM-yyyy):");
        DateFormat fechaFormateada = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaPartido = null;
        try {
            fechaPartido = fechaFormateada.parse(sc.next());
        } catch (ParseException ex) {
            ex.getMessage();
        }

        Partido p = new Partido(equipoLocal, equipoVisitante, division, resultado, fechaPartido);

        //Alta del partido en la coleccion        
        partidos.add(p);
    }

    
    //Esto es una prueba de modificacion 123
    public void verPartidos() {
        if (!partidos.isEmpty()) {
            for (Partido p : partidos) {
                System.out.println(p.toString());
            }
        } else {
            System.out.println("No hay partidos en la colección actual");
        }
    }

    public void borrarPartido() {
        if (!partidos.isEmpty()) {
            int tamañoInicial = partidos.size();
            //Borrado del partido si existe en la coleccion
            
            //Datos del partido a borrar
            System.out.println("DATOS DEL PARTIDO");
            System.out.println("_________________");
            System.out.println("Equipo local:");
            String equipoLocal = sc.next();
            System.out.println("Equipo Visitante:");
            String equipoVisitante = sc.next();

            Partido p1 = new Partido(equipoLocal, equipoVisitante);
            
            Iterator<Partido> it = partidos.iterator();
            
            while (it.hasNext()){

                if (it.next().equals(p1)) {
                    try{
                        it.remove();
                    } finally {
                        System.out.println("Se ha eliminado el partido de forma correcta");
                    }               
                
                }
            }
            
            if (tamañoInicial==partidos.size()){
                System.out.println("No existe el partido indicado.");
            }
            
        } else {
            System.out.println("No hay partidos en la colección actual");
        }
    }

    public void ordenarAsc() {
        Collections.sort(partidos);
        for (Partido p : partidos) {
            System.out.println(p.toString());
        }
    }

    public void ordenarDesc() {
        Collections.reverse(partidos);
        for (Partido p : partidos) {
            System.out.println(p.toString());
        }
    }

    public void mostrarDivision() {
        //Datos de la division a mostrar
        System.out.println("MOSTRAR PARTIDOS POR CATEGORIA");
        System.out.println("______________________________");
        System.out.println("Division :");
        Division division = null;
        int div = Integer.parseInt(sc.next());
        while (division==null){
            
            switch (div) {
                case 1:
                    division = Division.primera;
                    break;
                case 2:
                    division = Division.segunda;
                    break;
                case 3:
                    division = Division.tercera;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;    
            }
        }
        //Resultado de la consulta
        System.out.println("LISTADO DE PARTIDOS DE " + div + " DIVISION");
        System.out.println("___________________________________________");
        for (Partido p : partidos) {
            if (p.getDivision().equals(division)) {
                System.out.println(p.toString());
            }
        }
    }

    public void cargaPartidos() {
        File f = new File("ListadoDePartidos.dat");
        FileInputStream fis= null; 
        BufferedInputStream bis = null;
        
            try {
                fis = new  FileInputStream(f);
                bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(fis);

                Partido p = (Partido) ois.readObject();
                partidos.add(p);
                
                    while( p != null){
                            p = (Partido) ois.readObject();
                            partidos.add(p);
                        }

                        bis.close();
                        fis.close();
                        System.out.println("Cargado listado de partidos existentes.");
                                                                
                
                    } catch (FileNotFoundException ex) {
                        System.out.println("No hay datos previos que cargar.");        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (EOFException ex) {
                        if(partidos.size()>0){
                            System.out.println("Finalizada lectura de datos.");
                        } else {
                            System.out.println("No se han cargado datos de partidos almacenados previamente");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
    }

    public void guardaPartidos() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        
        try {
            fos = new FileOutputStream("ListadoDePartidos.dat");
            bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            
            for (Partido p : partidos){
                oos.writeObject(p);
                
            }
            
            oos.flush();
            bos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
