
package proyecto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros {
   
    public String Read(String direccion){
        
        String text = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "", read;
            while((read = bf.readLine()) != null){
                temp = temp + read + "\n";
            }
            text = temp;
        }catch(IOException e){
            System.err.println(e);
        }
     
        return text;
    } 
    
    public void printArray(int arr[][]){
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("\n");
        }
    }
}
