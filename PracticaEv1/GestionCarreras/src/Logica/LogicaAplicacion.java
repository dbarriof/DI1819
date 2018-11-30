package Logica;

import Dto.Carrera;
import Dto.Corredor;
import gui.Recursos.FormatoFecha;
import Dto.Participante;
import java.io.*;
import java.util.*;
import org.openide.util.Exceptions;

/**
 * Clase que engloba los métodos que operan en la aplicación
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
     * @return
     */
    public boolean altaCorredor(Corredor corredor) {
        if (!corredores.contains(corredor)) {
            corredores.add(corredor);
            return true;
        }
        return false;
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
                Date fecha = FormatoFecha.parsearFecha(st.nextToken());
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

    /**
     * Metodo para dar de alta una nueva carrera
     *
     * @param carrera
     * @return
     */
    public boolean altaCarrera(Carrera carrera) {
        if (!carreras.contains(carrera)) {
            carreras.add(carrera);
            return true;
        }
        return false;

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
     * Metodo para buscar una carrera en funcion de su nombre
     * @param nombre
     * @return 
     */
    public Carrera buscaCarrera(String nombre) {
        for (Carrera carrera : carreras) {
            if (carrera.getNombre().equals(nombre)) {
                return carrera;
            }
        }
        return null;
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
     * Metodo que permite cargar un array de corredores disponibles para añadir a una carrera
     * @return ArrayList
     */
    public ArrayList<Corredor> verCorredoresDisponibles(){
        ArrayList<Corredor> corredoresDisponibles = new ArrayList<>();
        for(Corredor corredor : corredores){
            corredoresDisponibles.add(corredor);
        }
        return corredoresDisponibles;
    }
    
    /**
     * Metodo que permite borrar un corredor de la lista de corredores disponibles para añadir a una carrera
     * @param corredoresDisponibles
     * @param corredor
     * @return ArrayList
     */
    public ArrayList<Corredor> eliminarCorredorDisponible(ArrayList<Corredor> corredoresDisponibles, Corredor corredor){
        for (Corredor corr : corredoresDisponibles) {
            if (corredor.equals(corr)) {
                corredoresDisponibles.remove(corr);
                break;
            }
        }
        return corredoresDisponibles;
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

    /**
     * Metodo que devuelve un participante buscado dentro de una carrera si esta
     * inscrito
     *
     * @param carrera
     * @param participante
     * @return
     */
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
    
    
    public void cancelarCarrera(Carrera carrera){
        for(Participante participante : carrera.getParticipantes()){
            participante.setTiempo(null);
            participante.setPosicion(0);
        }
    }
    
    /**
     * Metodo que permite crear clonar una carrera para un posible backup si se cancela la disputa
     * @param carrera
     * @return 
     */
    public Carrera clonarCarrera(Carrera carrera) {
        Carrera backupCarrera = new Carrera();
        backupCarrera.setNumMaxParticipantes(carrera.getNumMaxParticipantes());
        cargarDorsales(backupCarrera);
        
        ArrayList<Participante> participantesBackup = new ArrayList<>();
        for(Participante participante : carrera.getParticipantes()){
            Participante part = new Participante(participante.getCorredor(),carrera);
            participantesBackup.add(part);
        }
        ArrayList<Integer> dorsalesBackup = new ArrayList<>();
        for(int dorsal : carrera.getDorsales()){
            dorsalesBackup.add(dorsal);
        }
        backupCarrera = new Carrera(carrera.getNombre(), carrera.getFecha(),carrera.getLugar(), carrera.getNumMaxParticipantes(), participantesBackup, (ArrayList<Integer>) carrera.getDorsales());
        return backupCarrera;
    }
    
    /**
     * Metodo que permite seleccionar un participante mediante su dorsal
     * @param carrera
     * @param dorsal
     * @return 
     */
    public Participante buscaDorsal(Carrera carrera, int dorsal){
        for(Participante participante: carrera.getParticipantes()){
            if(participante.getDorsal() == dorsal){
                return participante;
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite guardar los datos existentes en la aplicacion
     */
    public void guardarDatos() {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            //Escritura de carreras
            fos = new FileOutputStream("ListadoDeCarreras.dat");
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            for (Carrera carrera : carreras) {
                oos.writeObject(carrera);
            }

            oos.flush();
            bos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        try {
            //Escritura de corredores
            fos = new FileOutputStream("ListadoDeCorredores.dat");
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            for (Corredor corredor : corredores) {
                oos.writeObject(corredor);
            }

            oos.flush();
            bos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
    
    /**
     * Metodo que permite cargar los datos almacenados tras el ultimo uso de la aplicacion
     */
    public void cargarDatos() {
        File fCarreras = new File("ListadoDeCarreras.dat");
        File fCorredores = new File("ListadoDeCorredores.dat");
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            //Lectura de los datos de carreras

            fis = new FileInputStream(fCarreras);
            bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Carrera carrera = (Carrera) ois.readObject();
            carreras.add(carrera);

            while (carrera != null) {
                carrera = (Carrera) ois.readObject();
                carreras.add(carrera);
            }

            bis.close();
            fis.close();
            System.out.println("Cargado listado de carreras.");

        } catch (FileNotFoundException ex) {
            System.out.println("No hay datos previos que cargar.");
        } catch (EOFException ex) {
            if (carreras.size() > 0) {
                System.out.println("Finalizada lectura de datos.");
            } else {
                System.out.println("No se han cargado datos de carreras almacenadas previamente");
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }

        try {
            //Lectura de los datos de corredores

            fis = new FileInputStream(fCorredores);
            bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Corredor corredor = (Corredor) ois.readObject();
            corredores.add(corredor);

            while (corredor != null) {
                corredor = (Corredor) ois.readObject();
                corredores.add(corredor);
            }

            bis.close();
            fis.close();
            System.out.println("Cargado listado de corredores.");

        } catch (FileNotFoundException ex) {
            System.out.println("No hay datos previos que cargar.");
        } catch (EOFException ex) {
            if (carreras.size() > 0) {
                System.out.println("Finalizada lectura de datos.");
            } else {
                System.out.println("No se han cargado datos de corredores almacenados previamente");
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ClassNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    /**
     * Metodo que genera un informe de la carrera en formato txt
     * @param carrera 
     */
    public void generarInforme(Carrera carrera){
        FileWriter informe = null;
        try {
            informe = new FileWriter(new File("Informe "+carrera.getNombre()+".txt"));
            informe.write(carrera.getNombre()+"\r\n");
            informe.write(String.valueOf(carrera.getFecha()+"\r\n"));
                for (Participante participante : carrera.getParticipantes()) {
                    informe.write(participante.getDorsal()+"/"+FormatoFecha.formatearFecha(participante.getTiempo())+"/"+participante.getCorredor().getNombre()+"\r\n");
                }
            informe.flush();
            informe.close();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
            
}
