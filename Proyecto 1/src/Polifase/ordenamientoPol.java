
package Polifase;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import proyecto1.*;

public class ordenamientoPol{
    int aux1[][] = new int [2][4], aux2[][] = new int[2][4];
    
    Ficheros f = new Ficheros();
    
    public void fase1(String texto) {

        String arrNombres[] = texto.split(",");
        int arrNumeros[] = new int[arrNombres.length];
        for (int i = 0; i < arrNombres.length - 1; i++) {
            arrNumeros[i] = Integer.parseInt(arrNombres[i]);
        }
        bloques(arrNumeros, aux1, aux2);
        System.out.println("aux1");
        f.printArray(aux1);
        
        System.out.println("aux2");
        f.printArray(aux2);
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
                aux2[y][cont - 5] = arrNumeros[i];
                System.out.println("aux222");
            }
            
            if(cont == 4){
                z = false;
                x ++;
            }
            if(cont == 8){
                z = true;
                y ++;
                cont = 0;
            }
        }
    }

    public void intercalacion(int aux1[], int aux2[]) {//Primera implememtacion aun falta cabiarlo para strigs
        int i, j, k;

        int arregloFinal[] = new int[aux1.length + aux2.length];

        for (i = j = k = 0; i < aux1.length && j < aux2.length; k++) {
            if (aux1[i] > aux2[j]) {
                arregloFinal[k] = aux1[i];
                i++;
            } else {
                arregloFinal[k] = aux2[j];
                j++;
            }
        }
        for (; i < aux1.length; i++, k++) {//para poner elemetos que no tengan con quien comparar 
            arregloFinal[k] = aux1[i];
        }
        for (; i < aux1.length; j++, k++) {//para poner elemetos que no tengan con quien comparar 
            arregloFinal[k] = aux2[j];
        }
        System.out.println(Arrays.toString(arregloFinal));
    }

}

    
    
    

    
    
    
    

