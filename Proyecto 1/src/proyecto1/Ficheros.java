
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

    
}
