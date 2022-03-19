
package Polifase;
import java.io.*;
import proyecto1.*;

public class ordenamientoPol extends Polifase{
    
    public ordenamientoPol(String archivo) {
        
       String text = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(archivo));
            String temp = "", read;
            while((read = bf.readLine()) != null){
                temp = temp + read + "\n";
            }
            text = temp;
        }catch(IOException e){
            System.err.println("Dirección invalida");
        }
        
    }

    
    
    

    
    
    
    
}
