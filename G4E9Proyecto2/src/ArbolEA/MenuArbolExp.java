/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolEA;


import Main.menuArbolAVL;
import java.util.Scanner;

/**
 *
 * @author jonat
 */
public class MenuArbolExp {
   
    
    Scanner teclado = new Scanner(System.in);
    int opcion;
    
    public void menuArbolEx(){
        do{
            System.out.println("\n1.Arboles AVL\n2.Heap\n3.Arbol expresion aritmetica\n4.Salir\n");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:
                    
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                   
                    
                    break;
                case 4:
                    System.out.println("Salir");
                    
                    break;
                default:
                    if (opcion>4 || opcion <1){
                        System.out.println("Opción inválida.");
                    }
                    break;
            }
        }while(opcion!=4);
        
        
    
        
    
    }
    
}
