/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dto.Corredor;
import Dto.FormatoFecha;
import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

/**
 *
 * @author dbarriof
 */
public class LogicaCorredores {

    private List<Corredor> corredores;

    public LogicaCorredores() {
        this.corredores = new ArrayList();
    }

    public void altaCorredor(Corredor c) {
        corredores.add(c);
    }

    public void bajaCorredor(Corredor c) {
        for (Corredor cor : corredores) {
            if (cor.equals(c)) {
                corredores.remove(cor);
            }
        }
    }

    public void ordenarCorredores() {
        Collections.sort(corredores);
    }

    public void modifCorredor(Corredor c) {

    }

    public void verCorredor(Corredor c) {

    }

    public void importarCorredores(String fichero) {
        File f = new File(fichero);

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea = br.readLine();

            while (linea != null) {

                StringTokenizer st = new StringTokenizer(linea, ",");
                String nombre = st.nextToken();
                String dni = st.nextToken();
                Date fecha = FormatoFecha.parseFecha(st.nextToken());
                String direccion = st.nextToken();
                int telefono = Integer.parseInt(st.nextToken());

                Corredor c = new Corredor(nombre, dni, fecha, direccion, telefono);
                corredores.add(c);

                linea = br.readLine();

            }

            br.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero indicado.");
        } catch (IOException ex) {
            System.out.println("Se ha producido un error al leer el fichero");
        }
    }

    public void exportarCorredores(File f) {

    }
}