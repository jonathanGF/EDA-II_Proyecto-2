
package Polifase;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import proyecto1.*;

public class ordenamientoPol extends Polifase{

    public void fase1(String texto) {

        String arrNombres[] = texto.split(",");
        int arrNumeros[] = new int[arrNombres.length];
        for (int i = 0; i < arrNombres.length - 1; i++) {
            arrNumeros[i] = Integer.parseInt(arrNombres[i]);
        }
    }
    int aux1[][], aux2[][];
    
    public void bloques(int arrNumeros[], int aux1[][], int aux2[][]){
        
        int cont = 0, x = 0, y=0;
        boolean z = true;
        for(int i = 0; i< arrNumeros.length; i++){
            cont ++;
            if(z== true){
                aux1[x][i] = arrNumeros[i];
            }else{
                aux2[y][i] = arrNumeros[i];
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

    
    
    

    
    
    
    

