package Forma2;

/**
 *
 * @author Guile
 */
public class MiHiloMainForma2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i, tiempo;
                
        for(i=1;i<11;i++){
            tiempo= (int) (Math.random()*5000)+1000;
            //Instanciacion de objetos runnable
            MiHilo h = new MiHilo(i, tiempo);
            //instanciacion de un hilo con el objeto runnnable
            Thread hilo= new Thread(h);
            hilo.start();
        }
    }
    
}
