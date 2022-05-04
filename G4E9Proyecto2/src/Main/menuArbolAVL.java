
package Main;

import ArbolesAVL.*;
import java.util.Scanner;

public class menuArbolAVL {
    int res, res2;
    boolean key = true;
    
    Scanner teclado = new Scanner(System.in);
    ArbolAVL arbol = new ArbolAVL();
    
    public void menuAVL(){
        
        
        while(key){
            System.out.println("\nIngresa la opcion que deseas realizar\n"
                    + "1)Crear Arbol\n"
                    + "2)Agregar Nodo\n"
                    + "3)Elimnar Nodo\n"
                    + "4)Recorrido InOrden\n");
            res = teclado.nextInt();

            switch (res) {
                case 1:
                    
                    System.out.println("Ingresa el valor de la raiz:\n");
                    res2 = teclado.nextInt();
                    arbol.insertar(res2);
                    break;
                
                case 2:
                    System.out.println("Ingresar el valor del nodo:\n");
                    res2 = teclado.nextInt();
                    arbol.insertar(res2);
                    break;
                
                case 4:
                    arbol.preOrden(arbol.root);
                    break;
            }

        }
    }
}
