
package ArbolEA;


import Main.menuArbolAVL;
import java.util.Scanner;


public class MenuArbolExp {
   
    
    Scanner teclado = new Scanner(System.in);
    int opcion;
    String expresion;
   
    public void menuArbolEx(){
        do{
            System.out.println("\n1.Ingresa Expresion\n2.Mostrar Arbol\n3.ResolverExpresion\n4.Salir\n");
            opcion=teclado.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("INGRESE SU EXPRESION:");
                    String expresion = teclado.next();
                    this.expresion=expresion;
                    break;
                case 2:
                    System.out.println("Mostrar Arbol");
                    ArbolExpresion arbol1= new ArbolExpresion(this.expresion);
                    System.out.println(arbol1.imprimir());
                    break;
                case 3:
                    System.out.println("Resultado de la expresion:");
                   ArbolExpresion arbol= new ArbolExpresion(this.expresion);
                    System.out.println(arbol.EvaluaExpresion());
                    
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
