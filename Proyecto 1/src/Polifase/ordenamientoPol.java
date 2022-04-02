
package Polifase;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import proyecto1.*;

public class ordenamientoPol{
    int aux1[][] = new int [4][10], aux2[][] = new int[4][10];
    
    Ficheros f = new Ficheros();
    BubbleSort bs = new BubbleSort();
    public void fase1(String texto) {

        String arrNombres[] = texto.split(",");
        int arrNumeros[] = new int[arrNombres.length];
        for (int i = 0; i < arrNombres.length - 1; i++) {
            arrNumeros[i] = Integer.parseInt(arrNombres[i]);
        }
        //************************************************
        bloques(arrNumeros, aux1, aux2);
        System.out.println("aux1");
        f.printArray(aux1);
        
        System.out.println("aux2");
        f.printArray(aux2);
        
        System.out.println("aux1 ordenado");
        OrdenarBloques(aux1);
        
        OrdenarBloques(aux2);
        f.printArray(aux1);
        System.out.println("aux2 Ordenado");
        f.printArray(aux2);
        System.out.println("Intercalacion1");
        IntercalarBloques(aux1,aux2);
        
    }
    //0,0,0,0,0
    //0,0,0,0,0
    //0,0,0,0,0
    
    public void bloques(int arrNumeros[], int aux1[][], int aux2[][]){
        
        int cont = 0, x = 0, y=0;
        boolean z = true;
        for(int i = 0; i< arrNumeros.length; i++){
            cont ++;
            if(z== true){
                aux1[x][cont - 1] = arrNumeros[i];
            }
            if(z == false){
                aux2[y][cont - 11] = arrNumeros[i];
            }
            
            if(cont == 10){
                z = false;
                x ++;
            }
            if(cont == 20){
                z = true;
                y ++;
                cont = 0;
            }
        }
    }
    
    public void OrdenarBloques(int aux[][]){
       
        for(int i = 0; i < aux.length; i++){
            bs.bubbleSort(aux[i]);
        }
    }
    
    public void IntercalarBloques(int aux1[][], int aux2[][]){
        int aux3[][] = new int [4][20];
        int aux4[][];
        
        System.out.println("Inicio del for");
        for(int i = 0; i < aux1[0].length;i++){
            int arrx[] = intercalacion(aux1[i], aux2[i]);
            System.out.println("AYUDA");
            f.igualar(arrx, aux3, i);
        }
        f.printArray(aux3);
        
        
        
    }

    public int[] intercalacion(int aux1[], int aux2[]) {//Primera implememtacion aun falta cabiarlo para strigs
        int i, j, k;

        int arregloFinal[] = new int[aux1.length + aux2.length];
        i=0;
        j=0;
        for (k = 0; i < aux1.length && j < aux2.length; k++) {

            System.out.println(aux1[i]);
            System.out.println(aux2[j]);
            if (aux1[i] < aux2[j] && aux1[i] != 0) {
                arregloFinal[k] = aux1[i];
                i++;
            } else {
                if(aux1[i] > aux2[j] && aux1[i] != 0 && aux2[j] != 0){
                    
                    arregloFinal[k] = aux2[j];
                    j++;
                }
                if(aux1[i] == 0 && aux2[j] != 0){
                    
                    i++;
                    arregloFinal[k] = aux2[j];
                    j++;
                }
                if(aux2[j]== 0 && aux1[i] != 0){
                    
                    j++;
                    arregloFinal[k] = aux1[i];
                    i++;
                }
                if(aux1[i] == 0 && aux2[j] == 0){
                    
                    i++;
                    j++;
                }
               
            }
        }
        for (; i < aux1.length; i++, k++) {//para poner elemetos que no tengan con quien comparar 
            arregloFinal[k] = aux1[i];
        }
        for (; i < aux1.length; j++, k++) {//para poner elemetos que no tengan con quien comparar 
            arregloFinal[k] = aux2[j];
        }
        System.out.println(Arrays.toString(arregloFinal));
        return arregloFinal;
    }

}

    
    
    

    
    
    
    

