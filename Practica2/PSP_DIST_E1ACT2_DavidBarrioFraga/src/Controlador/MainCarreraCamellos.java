package Controlador;

import LogicaAplicacion.Logica;
import Modelo.Camello;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author dbarriof
 */
public class MainCarreraCamellos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logica logicaAplicacon = new Logica();
        
        // Se solicita por consola el número de camellos que tendrá la carrera.
        System.out.println("Numero de camellos:");
        int numCammellos = sc.nextInt();
        
        // Se crea un contador con el número de camellos que participarán en la carrera.
        CountDownLatch contador = new CountDownLatch(numCammellos);
        
        // Generamos los camellos y damos comienzo a la carrera una vez se han creado todos.
        for(int i = 1 ; i <= numCammellos ; i++){           
            Camello camello = new Camello("C"+i,contador,logicaAplicacon);
            camello.start();
            contador.countDown();           
        }
    }    
}
