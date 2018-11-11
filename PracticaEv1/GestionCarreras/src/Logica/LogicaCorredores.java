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
    private HashSet<Corredor> corredores;

    public LogicaCorredores() {
        this.corredores = new HashSet<>();
    }

    public void altaCorredor(Corredor c) {
        corredores.add(c);
    }

    public void bajaCorredor(Corredor c) {        
        for (Corredor cor : corredores) {
            if (cor.equals(c)) {
                corredores.remove(cor);
                break;
            }
        }
    }
    
    public void modificaCorredor(Corredor corredor){
        for (Corredor c : corredores){
            if(c.equals(corredor)){
                c.setNombre(corredor.getNombre());
                c.setFechaNac(corredor.getFechaNac());
                c.setDireccion(corredor.getDireccion());
                c.setTelefono(corredor.getTelefono());
                
                break;
            }
        }    
    }
    
    public Corredor buscaCorredor(String dni) {
        Corredor corr = null;
        
        for (Corredor c : corredores){
            
            if(c.getDni().equalsIgnoreCase(dni)){
                //Prueba de busqueda
                System.out.println(c.toString());
                return c;
            }
        }
        
        System.out.println("No encontrado");
        return corr;
    }

    public HashSet<Corredor> verCorredores() {
        return corredores;
    }
    
    //Devuelve un listado de jugadores para mostrarlos antes de confirmar la importación
    public HashSet<Corredor> importarCorredores(File fichero) {
        HashSet<Corredor> listaCorrImport = new HashSet<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea = br.readLine();

            while (linea != null) {

                StringTokenizer st = new StringTokenizer(linea, ",");
                String nombre = st.nextToken();
                String dni = st.nextToken();
                Date fecha = FormatoFecha.parseFecha(st.nextToken());
                String direccion = st.nextToken();
                int telefono = Integer.parseInt(st.nextToken());

                Corredor c = new Corredor(nombre, dni, fecha, direccion, telefono);
                listaCorrImport.add(c);
                corredores.add(c);
                
                linea = br.readLine();

            }

            br.close();

        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero indicado.");
        } catch (IOException ex) {
            System.out.println("Se ha producido un error al leer el fichero");
        }
        
        return listaCorrImport;
    }
    
    /*public void selectImportFile(){
        boolean selectFich = true;

        while (selectFich) {
            //Seleccionamos el fichero desde el que importar
            
            JFileChooser importarArchivo = new JFileChooser();
            importarArchivo.showOpenDialog(this);
            //File archivo = importarArchivo.getSelectedFile();
            //JFileChooserFichImport jfc = new jFileChooserFichImport();
            File archivo = importarArchivo.getSelectedFile();

            //Solicitamos confirmacion para el fichero seleccionado
            int confirmar = JOptionPane.showConfirmDialog(this, "¿Confirmar el archivo?\n" + archivo.getName(), "Confirmar", JOptionPane.YES_NO_OPTION);

            //En caso de confirmar se muestran los corredores que se van a importar
            if (confirmar == JOptionPane.YES_OPTION) {
                selectFich = false;
                plc = new PantallaListaCorredores(this, true, listaCorredores.importarCorredores(archivo));
                plc.setVisible(true);

            } else if (confirmar == JOptionPane.NO_OPTION) {

                //Seleccionar un nuevo archivo si cancela el anterior o salir en caso contrario
                int nuevaEleccion = JOptionPane.showConfirmDialog(this, "¿Seleccionar otro fichero?", "Confirmar", JOptionPane.YES_NO_OPTION);
                
                if (nuevaEleccion == JOptionPane.NO_OPTION) {
                    selectFich = false;
                }
            }
        }
    }*/

    public void exportarCorredores(File f) {
        
    }
}
