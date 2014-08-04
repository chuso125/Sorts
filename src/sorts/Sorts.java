/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorts;

/**
 *
 * @author manuelgomez
 */
public class Sorts {
    public Sorts() { } 
    
    public static void swap(int data[],int i, int j){
        int temp;
        temp = data[i];
        data[i]=data[j];
        data[j] = temp;
    }

    public static int particion(int data[], int izquierda, int derecha){
        while (true){
            while (izquierda< derecha && data[izquierda]< data[derecha]) derecha--;
            if (izquierda < derecha) swap(data,izquierda++,derecha);
            else return izquierda;

            while (izquierda< derecha && data[izquierda]< data[derecha]) izquierda++;
            if (izquierda < derecha) swap(data,izquierda,derecha--);
            else return derecha;
        }
    }

    public static void quickSort(int data[],int izquierda, int derecha){
        int pivote;
        if(izquierda>= derecha) return;
        pivote = particion(data,izquierda,derecha);
        quickSort(data,izquierda,pivote-1);
        quickSort(data,pivote+1,derecha);
    }
    public static void InsertionSort(int data[], int n)
	{
			int numSorted = 1;
			int index;
			while (numSorted < n)
			{
				int temp = data[numSorted];
				for (index =numSorted; index > 0; index--)
				{
					if(temp<data[index-1])
					{
						data[index] = data[index-1];
					}
					else
					{
						break;
					}
				}
				data[index] = temp;
				numSorted++;
			}
	}
    
    public int[] mergeSort(int[] lista){
        int c = lista.length;
        int c1 = c/2, c2 = c - c1; 
        int i,j;
        if (c>2){
            /*SPLIT*/
            int[] bajo = new int[c1]; 
            int[] alto = new int [c2];
            for (i=0; i<c1; i++) bajo[i] = lista[i];
            for (i=c1; i<c; i++) alto[i-c1]=lista[i]; 
            bajo = mergeSort(bajo);
            alto = mergeSort(alto);
            lista = merge(bajo,alto);
        } 
        else {
            if (c==2) {
            if (lista[1]<lista[0]){
                j = lista[0]; 
                lista[0] = lista[1]; 
                lista[1] = j; 
            }
            }
            
        }
        return lista; 
    }
    
    public int[] merge(int[] v1, int[] v2){
        int t1 = v1.length; 
        int t2 = v2.length; 
        int t = t1 + t2; 
        int[] v3 = new int[t];
        int k = 0,l = 0,c3 = 0; 
        while ((k<t1)&&(l<t2)) {
            if (v1[k]<v2[l]) {
                v3[c3]=v1[k]; 
                c3 += 1; 
                k += 1; 
            }
            else {
                v3[c3]=v2[l]; 
                c3 += 1; 
                l += 1; 
            }    
        }
        while (k<t1){
            v3[c3]=v1[k]; 
            c3 += 1; 
            k += 1;
        }
        while (l<t2){
            v3[c3]=v2[l]; 
            c3 += 1; 
            l += 1;
        }
        return v3; 
    }
    
}