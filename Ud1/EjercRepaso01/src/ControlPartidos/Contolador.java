package ControlPartidos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Guile
 */
public class Contolador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir=false;
        Funcionalidad partidos = new Funcionalidad();
        
        while(!salir){
            System.out.println("       MENU PARTIDOS       ");
            System.out.println("_____________________________");
            System.out.println("1- Insertar un partido");
            System.out.println("2- Mostrar listado de partidos");
            System.out.println("3- Borrar un partido");
            System.out.println("4- Mostrar partidos por fecha ascendente");
            System.out.println("5- Mostrar partidos por fecha descendente");            
            System.out.println("6- Mostrar partidos por division");
            System.out.println("7- Salir");
            System.out.println("");
            System.out.println("Elige una opcion:");
            int opcion=sc.nextInt();
            
            switch(opcion){
                case 1:
                    partidos.altaPartido();
                    break;
                case 2:
                    partidos.verPartidos();
                    System.out.println("Hola mundo");
                    break;
                case 3:
                    partidos.borrarPartido();
                    break;
                case 4:
                    partidos.ordenarAsc();
                    break;
                case 5:
                    partidos.ordenarDesc();
                    break;
                case 6:
                    partidos.mostrarDivision();
                    break;
                case 7:
                    salir = true;
                    break;
            }
        }
    }
}