/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoExoplanetas;

/**
 *
 * @author dbarriof
 */
public class Controlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcionalidad planetario = new Funcionalidad();
        System.out.println("La media del ejeMayor de los planetas es: "+planetario.mediaEjeMayor());
        System.out.println("El número de planetas de los que no se conoce su excentricidad es: "+planetario.planetaConExcentricidad());
        System.out.println("El número de planetas con orbita superior a 30 días es: "+planetario.planetaOrbitaMas30());
        System.out.println("El número de planetas descubiertos por la sonda Kepler son: "+planetario.planetaKepler());
        planetario.ordenaPlanetas();
        
    }
    
}
