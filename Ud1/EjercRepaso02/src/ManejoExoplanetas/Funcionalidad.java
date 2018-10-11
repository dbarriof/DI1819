/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoExoplanetas;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dbarriof
 */
public class Funcionalidad {
    private List<Exoplaneta> planetas;

    public Funcionalidad() {
        //Instanciamos un Arraylist para almacenar los planetas incluidos en el fichero CSV
        this.planetas = new ArrayList();
        
        //Leemos el fichero CSV y cargamos los registros en nuestro Arraylist
        try {
            FileReader f = new FileReader(new File("exoplanetas.csv"));
            BufferedReader br = new BufferedReader(f);
            
            //Declaramos la linea a tokenizar y cargamos la cabecera paraq descartarla al generar los objetos.
            String linea = br.readLine();
            
            while((linea = br.readLine()) != null){
                               
                StringTokenizer st = new StringTokenizer(linea,",");            
            
                while(st.hasMoreTokens()){
                    String nombre = st.nextToken();                    
                    double ejeMayor;
                    double periodoDias;
                    double excentricidad;
                    
                    if(st.hasMoreTokens()){
                        ejeMayor = Double.parseDouble(st.nextToken());
                    } else {
                        ejeMayor = -1;
                    }
                    
                    if(st.hasMoreTokens()){
                        periodoDias = Double.parseDouble(st.nextToken());
                    } else {
                        periodoDias = -1;
                    }
                    
                    if(st.hasMoreTokens()){
                        excentricidad = Double.parseDouble(st.nextToken());
                    } else {
                        excentricidad = -1;
                    }
                    
                    //Creamos el objeto planeta leido del fichero y lo añadimos a la colección
                    Exoplaneta p = new Exoplaneta(nombre, ejeMayor, periodoDias, excentricidad);
                    
                    planetas.add(p);
                    
                }
                
            }                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);       
        } catch (IOException ex) {
            Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double mediaEjeMayor(){
        double media;
        double suma = 0;
        int divisor = 0;
       
        for (Exoplaneta e : planetas) {
            divisor++;
            if (e.getEjeMayor()>=0){
                suma = suma + e.getEjeMayor();
            }
        }       
        //return media = suma/divisor;
        return divisor;
    }
    
    public int planetaConExcentricidad(){
        int total = 0;
        
        for (Exoplaneta e : planetas){
            if(e.getExcentricidad()!=-1){
                total++;
            }
        }
        
        return total;
    }
    
    public int planetaOrbitaMas30(){
        int total = 0;
        
        for (Exoplaneta e : planetas){
            if (e.getPeriodoDias()>30){
                total++;
            }
        }
        
        return total;
    }
    
    public int planetaKepler(){
        int total = 0;        
        Pattern patron = Pattern.compile("Kepler");
        Matcher mat;
        
        for (Exoplaneta e : planetas){
            mat = patron.matcher(e.getNombre());
            if (mat.find()){
                total++;
            }
        }
        
        return total;
    }
    
    public void ordenaPlanetas(){
        
        planetas.sort( new Comparator<Exoplaneta>() {
            
            @Override
            public int compare(Exoplaneta t, Exoplaneta t1) {
                int equal = 0;
                if(t.getEjeMayor()>t1.getEjeMayor()){
                    equal = -1;
                }
                if(Objects.equals(t.getEjeMayor(), t1.getEjeMayor())){
                    equal = 0;
                }
                if(t.getEjeMayor()<t1.getEjeMayor()){
                    equal = 1;
                }
                return equal;
            }
        });
        
    }
    
    public void escribirOrdenados(){
        File f = new File ("planetasOrdenados.csv");
        FileWriter fw = null;
        
        try {
            
            fw = new FileWriter(f);
                     
            for (Exoplaneta e : planetas){
                StringBuffer sb = new StringBuffer();
                sb.append(e.getNombre());
                sb.append(",");
                sb.append(e.getEjeMayor());
                sb.append(",");
                sb.append(e.getPeriodoDias());
                sb.append(",");
                if(e.getExcentricidad()!=-1){
                    sb.append(e.getExcentricidad());
                } else {
                    sb.append("");
                }
                sb.append('\n');
                fw.write(sb.toString());
            }
                    
        } catch (IOException ex) {
            Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
