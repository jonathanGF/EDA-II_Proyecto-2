
package proyecto1;

import java.io.BufferedReader;
import java.io.FileReader;

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
            
        }catch(Exception e){
            System.err.println("Dirección invalida");
        }
        
        return text;
    }
}
