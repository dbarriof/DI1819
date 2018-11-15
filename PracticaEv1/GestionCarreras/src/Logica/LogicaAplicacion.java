/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Dto.Carrera;
import Dto.Corredor;
import Dto.FormatoFecha;
import Dto.Participante;
import java.io.*;
import java.util.*;

/**
 *
 * @author dbarriof
 */
public class LogicaAplicacion {

    private ArrayList<Corredor> corredores;
    private ArrayList<Carrera> carreras;

    public LogicaAplicacion() {
        this.corredores = new ArrayList<>();
        this.carreras = new ArrayList<>();
    }

    /**
     * Metodo para dar de alta un nuevo corredor
     *
     * @param corredor
     * @param c
     */
    public void altaCorredor(Corredor corredor) {
        if (!corredores.contains(corredor)) {
            corredores.add(corredor);
        }
    }

    /**
     * Metodo para eliminar un corredor
     *
     * @param corredor
     */
    public void eliminarCorredor(Corredor corredor) {
        for (Corredor cor : corredores) {
            if (cor.equals(corredor)) {
                corredores.remove(cor);
                break;
            }
        }
    }

    /**
     * Metodo para modificar los datos de un corredor
     *
     * @param corredor
     */
    public void modificaCorredor(Corredor corredor) {
        for (Corredor c : corredores) {
            if (c.equals(corredor)) {
                c.setNombre(corredor.getNombre());
                c.setFechaNac(corredor.getFechaNac());
                c.setDireccion(corredor.getDireccion());
                c.setTelefono(corredor.getTelefono());

                break;
            }
        }
    }

    /**
     * Metodo para buscar un corredor en funcion de su Dni
     *
     * @param dni
     * @return
     */
    public Corredor buscaCorredor(String dni) {
        Corredor corr = new Corredor();
        corr.setDni(dni);
        for (Corredor corredor : corredores) {
            if (corredor.equals(corr)) {
                return corredor;
            }
        }
        return corr;
    }

    /**
     * Metodo para recuperar el listado de corredores dados de alta
     *
     * @return
     */
    public ArrayList<Corredor> verCorredores() {
        return corredores;
    }

    /**
     * Metodo que devuelve un listado de jugadores para mostrarlos antes de
     * confirmar la importación
     *
     * @param fichero
     * @return
     */
    public ArrayList<Corredor> importarCorredores(File fichero) {
        ArrayList<Corredor> listaCorrImport = new ArrayList<>();

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
                altaCorredor(c);

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

    /*
    public void selectImportFile(){
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
    }
     */
    /**
     * Metodo para dar de alta una nueva carrera
     *
     * @param carrera
     */
    public void altaCarrera(Carrera carrera) {
        carreras.add(carrera);
    }

    /**
     * Metodo para eliminar una carrera existente
     *
     * @param carrera
     */
    public void eliminaCarrera(Carrera carrera) {
        for (Carrera car : carreras) {
            if (car.equals(carrera)) {
                carreras.remove(car);
                break;
            }
        }
    }

    /**
     * Metodo para modificar los datos de una carrera existente
     *
     * @param carrera
     */
    public void modificarCarrera(Carrera carrera) {
        for (Carrera car : carreras) {
            if (car.equals(carrera)) {
                car.setNombre(carrera.getNombre());
                car.setLugar(carrera.getLugar());
                car.setFecha(carrera.getFecha());
                car.setNumMaxParticipantes(carrera.getNumMaxParticipantes());

                break;
            }
        }
    }
    
    /**
     * Metodo para recuperar el listado de carreras
     * 
     * @return 
     */
    public ArrayList<Carrera> verCarreras() {
        return carreras;
    }

    /**
     * Metodo que carga la coleccion de dorsales en funcion del numero de
     * participantes de la carrera pasada como parametro
     *
     * @param carrera
     */
    public void cargarDorsales(Carrera carrera) {
        if (carrera.getDorsales().isEmpty()) {
            ArrayList dorsales = (ArrayList) carrera.getDorsales();
            for (int i = 1; i <= carrera.getNumMaxParticipantes(); i++) {
                dorsales.add(i);
            }
            carrera.setDorsales(dorsales);
        }

    }

    /**
     * Metodo que devuelve el numero de dorsal extrayendolo de la coleccion de
     * dorsales de la carrera pasada como parametro
     *
     * @param carrera
     * @return dorsalasignado
     */
    public int asignarDorsal(Carrera carrera) {
        int dorsal = carrera.getDorsales().get(0);
        carrera.getDorsales().remove(0);
        return dorsal;
    }

    /**
     * Metodo que recupera el numero de dorsal añadiendolo de nuevo a la
     * coleccion de dorsales de la carrera pasada como parametro
     *
     * @param carrera
     * @param dorsal
     */
    public void quitarDorsal(Carrera carrera, int dorsal) {
        carrera.getDorsales().add(dorsal);
    }

    /**
     * Metodo que añade a la lista de participantes el corredor pasado como
     * parametro
     *
     * @param carrera
     * @param corredor
     * @return
     */
    public boolean aniadirParticipante(Carrera carrera, Corredor corredor) {
        Participante participante = new Participante(corredor, carrera);
        if (!carrera.getParticipantes().contains(participante) || carrera.getParticipantes() == null) {
            participante.setDorsal(asignarDorsal(carrera));
            carrera.getParticipantes().add(participante);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que elimina un participante de una carrera
     *
     * @param carrera
     * @param participante
     * @return
     */
    public boolean eliminarParticipante(Carrera carrera, Participante participante) {
        if (!carrera.getParticipantes().contains(participante) || carrera.getParticipantes() != null) {
            quitarDorsal(carrera, participante.getDorsal());
            carrera.getParticipantes().remove(participante);
            return true;
        } else {
            return false;
        }
    }

    public Participante buscaParticipante(Carrera carrera, Participante participante) {
        for (Participante part : carrera.getParticipantes()) {
            if (participante.equals(part)) {
                return part;
            }
        }
        return null;
    }

    /**
     * Metodo que devuelve el listado de participantes de una carrera
     *
     * @param carrera
     * @return
     */
    public ArrayList<Participante> verParticipantes(Carrera carrera) {
        return (ArrayList<Participante>) carrera.getParticipantes();
    }

    public void guardarDatos() {

    }

    public void cargarDatos() {

    }

}
