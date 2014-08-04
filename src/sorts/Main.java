/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author manuelgomez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        Sorts s = new Sorts();  
        int i; 
        int j = 2000; /* CANTIDAD DE NUMEROS QUE SE DESEAN GENERAR HACIA EL ARCHIVO*/
        int cont = 0;
        
        int[] lista = new int[j];
        
        /* Creando el archivo de texto */ 
        File numerosAleatorios; 
        numerosAleatorios = new File("numeros.txt");    //EL ARCHIVO SE LLAMARA numeros.txt , PERO LA VARIABLE numerosAleatorios
        
        try {
            if (numerosAleatorios.createNewFile()) System.out.println("Se ha creado el archivo");
        }  catch (IOException e) {
            System.out.println("No se ha podido crear el archivo");
        }
        try{
            /* Escribiendo los numeros random en el archivo */
            FileWriter w = new FileWriter(numerosAleatorios); 
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            
            for (i=0; i<j; i++) {
                int r = randomInt(-1000,1000); //NUMEROS EN EL RANDO DE -1000,1000
                wr.append(Integer.toString(r) + "\r\n");
            }
            wr.close();
            bw.close();
            
            /* Leer los datos en el archivo */
            FileInputStream fstream = new FileInputStream(numerosAleatorios);
            DataInputStream entrada = new DataInputStream(fstream); 
            BufferedReader buffer = new BufferedReader (new InputStreamReader(entrada)); 
            String linea; 
            while ((linea = buffer.readLine()) != null){
                /* SE LEE UNA LINEA, SI ESTA TIENE ALGO, SE CONVIERTE A INTEGER Y SE AGREGA AL ARREGLO lista*/
                int largo = linea.length(); 
                String num = linea.substring(0,largo);
                lista[cont]=Integer.valueOf(num);
                cont += 1; 
            }
             entrada.close(); 
       
        } catch (IOException e) {}; 
        
        int[] listaQuick = new int[j];// lista para el quicksort
        int[] listaInsertion = new int[j];// lista para el insertion
        int[] listaMerge = new int[j];// lista para el merge
         int[] listaBubble = new int[j];// lista para el bubble
        
        for (i=0; i<cont; i++) {
            listaQuick[i]= lista[i];
            listaInsertion[i]= lista[i];
            listaMerge[i]= lista[i];
            listaBubble[i]= lista[i];
        }
        s.quickSort(listaQuick,0,1999); // ORDENA LA LISTA con QuickSort
        listaMerge = s.mergeSort(listaMerge);//ORDENA LA LISTA con Merge sort
        s.InsertionSort(listaInsertion,2000);//ORDENA LA LISTA con Insertion sort
        s.bubble(listaBubble,2000);//ORDENA LA LISTA con bubble sort 
        
        for (i=0; i<cont; i++) {
            System.out.print(listaQuick[i]); //MUESTRA LA LISTA ORDENADA
        }
        System.out.println("\n");
        for (i=0; i<cont; i++) {
            System.out.print(listaMerge[i]); //MUESTRA LA LISTA ORDENADA
        }
        System.out.println("\n");
        for (i=0; i<cont; i++) {
            System.out.print(listaInsertion[i]); //MUESTRA LA LISTA ORDENADA
        }
        System.out.println("\n");
        for (i=0; i<cont; i++) {
            System.out.print(listaBubble[i]); //MUESTRA LA LISTA ORDENADA
        }
        System.out.println("\n");
    }
    
    public static int randomInt(int min, int max) {
        //Genera numeros random entre los valores de min y max 
        Random rand = new Random(); 
        int randomNum = rand.nextInt((max-min)+1)+min;  
        return randomNum; 
