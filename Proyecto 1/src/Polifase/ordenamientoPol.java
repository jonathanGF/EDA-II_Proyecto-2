
package Polifase;
import java.io.*;
import proyecto1.*;

public class ordenamientoPol extends Polifase{
    String direccion;
    public void textoPol(String direccion){
        
        File prueba=new File(direccion);
        this.direccion=prueba.getAbsolutePath();
        System.out.println(this.direccion);
    }

  }

    
    
    

    
    
    
    

