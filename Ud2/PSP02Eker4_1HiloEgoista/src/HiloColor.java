/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbarriof
 */

public class HiloColor extends Thread{
    String nomColor;
    
    public HiloColor(String nomColor) {
        this.nomColor = nomColor;
    }
    
    @Override
    public void run() {
        int i;
        for(i=1;i<=5;i++){
            System.out.println(nomColor+""+i);
        }
    }
    
}
