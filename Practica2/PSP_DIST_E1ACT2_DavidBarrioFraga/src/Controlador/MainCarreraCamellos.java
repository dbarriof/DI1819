/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import LogicaAplicacion.Logica;
import Modelo.Camello;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Guile
 */
public class MainCarreraCamellos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logica logicaAplicacon = new Logica();
        
        System.out.println("Numero de camellos:");
        int numCammellos = sc.nextInt();
        
        CountDownLatch contador = new CountDownLatch(numCammellos);
        
        for(int i = 1 ; i <= numCammellos ; i++){           
            Camello camello = new Camello("C"+i,contador,logicaAplicacon);
            camello.start();
            contador.countDown();           
        }
    }    
}
