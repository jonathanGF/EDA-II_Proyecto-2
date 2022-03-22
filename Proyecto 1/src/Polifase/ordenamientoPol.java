
package Polifase;
import java.io.*;
import java.util.Arrays;
import proyecto1.*;

public class ordenamientoPol extends Polifase{
    
    public void textoPol(String texto){
        
       String arrNombres[]=texto.split(",");
       int arrNumeros[]=new int[arrNombres.length];
        for (int i = 0; i < arrNombres.length-1; i++) {
            arrNumeros[i]=Integer.parseInt(arrNombres[i]);
        }
        
        BubbleSort orden=new BubbleSort();
        int[] arregloordenado;
        arregloordenado = orden.bubbleSort(arrNumeros);
        System.out.println(Arrays.toString(arregloordenado));
        }   
      
    }
    
    
    
    
    

  

    
    
    

    
    
    
    

