/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */
public class HiloConSincronizacionPorMetodoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        
        //Creo el jardin
        Jardin jardin = new Jardin(100);
        
        //Simulo la entrada de 10 personas
        for(i=1;i<=10;i++){
            HiloPuertaEntrada entra = new HiloPuertaEntrada("Entra"+String.valueOf(i));
            entra.start();
        }
        
        //Simulo la salida de 15 personas
        for(i=1;i<=15;i++){
            HiloPuertaSalida sale = new HiloPuertaSalida("Sale"+String.valueOf(i));
            sale.start();
        }
    }
    
}
