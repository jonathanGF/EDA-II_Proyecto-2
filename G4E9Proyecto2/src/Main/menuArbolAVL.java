
package Main;

import ArbolesAVL.*;
import java.awt.BorderLayout;
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
                    + "4)BFS\n"
                    + "5)recorrido PreOrden\n"
                    + "6)Lista de Adyacencia\n"
                    + "7)Terminar\n");
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
                
                case 3:
                    System.out.println("Ingresa el valor que quieres eliminar:\n");
                    res2 = teclado.nextInt();
                    NodoAVL temp = arbol.search(res2, arbol.root);
                    int lado = arbol.lado(temp, res2);
                    arbol.delete(temp, lado);
                    
                    break;
                case 4:
                    System.out.println("BFS");
                    arbol.breadthFrist();
                    break;
                case 5:
                    System.out.println("PreOrden\n");
                    arbol.preOrden(arbol.root);
                    break;
                case 6:
                    System.out.println("Lista de adyacencia:\n");
                    arbol.Lista(arbol.root);
                    break;
                case 7:
                    key = false;
                    break;
                
            }

        }
    }
}
