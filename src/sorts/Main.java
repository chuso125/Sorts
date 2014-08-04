/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorts;

import java.util.Random;

/**
 *
 * @author manuelgomez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sorts s = new Sorts();  
        int i; 
        int j = 2000; 
        int[] lista = new int[j];
        
        for (i=0; i<j; i++){
            lista[i] = randomInt(-1000,1000); 
            System.out.print(lista[i]+" ");
        }
        System.out.print("\n");
        
        s.quickSort(lista,0,1999);
        
        for (i=0; i<j; i++){
            System.out.print(lista[i]+" ");
        }
        System.out.print("\n");
    }
    
    public static int randomInt(int min, int max) {
        //Genera numeros random entre los valores de min y max 
        Random rand = new Random(); 
        int randomNum = rand.nextInt((max-min)+1)+min;  
        return randomNum; 
    }
    }
