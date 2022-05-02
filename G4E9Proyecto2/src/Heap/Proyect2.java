package Heap;

import NODO.Nodo;
import java.util.*;

public class Proyect2 {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner n =new Scanner(System.in);
        int op,lado=0,lastnumber=0;
        ArrayList<Integer> list=new ArrayList();
        ArrayList<Nodo> lnodo=new ArrayList();
        Heap h = new Heap();
        Nodo nod;
        do{
            System.out.print("¿Que deseas hacer?"
                    + "\n  1.-Ingresar clave."
                    + "\n   2.-Eliminar calve."
                    + "\n    3.-Mostrar árbol."
                    + "\n     0.-Salir"
                    + "\n Op: ");
            op=n.nextInt();
            switch(op){
                case 1://agregar clave
                    System.out.print("Ingresa numero: ");
                    if(h.veri()==true){//si el arbol es nulo
                        nod = new Nodo(n.nextInt());//se agrega un numero y se convierte en nodo
                        lnodo.add(nod);lastnumber++;//se agrega a lista de nodos y se aumenta el ultimo numero
                        h = new Heap(nod);//se crea un arbol con raiz del nodo
                    }else{
                        nod = new Nodo(n.nextInt());//se pide otro numero para hacerlo nodo
                        lnodo.add(nod);//se añade a la lista de nodos
                        if(nod.valor>h.raiz.valor){
                            h=acomodo(h, h.raiz);
                        }
                        
                        if(lado==0){//si lado es cero
                            h.añadir(lnodo.get((lnodo.size()/2)-1), nod, lado);//y se añade a su respectivo padre de lado izquierdo
                            lastnumber++;lado++;//se incrementa el tamaño de los ultimos numeros y para cambiar de lado
                        }else{
                            h.añadir(lnodo.get((lnodo.size()/2)-1), nod, lado);//se añade este ultimo nodo a su padre pero del lado derecho
                            lastnumber++;lado--;//se incrementa ultimo numero y se disminuye para cambiar el lado despues
                        }
                    }
                    h=acomodo(h,lnodo.get(0));
                    break;
                case 2://eliminar raiz
                    break;
                case 3://mostrar arbol
                    h.breadthFrist();
                    break;
                case 0:
                    System.out.println("Hasta la proxima");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }while(op!=0);
    }
    
    private static Heap acomodo(Heap h,Nodo padre){
        Nodo aux1,aux2;
        if(padre==h.raiz){
            if (padre.izq != null && padre.der == null) {
                if (padre.valor < padre.izq.valor) {
                    aux1=padre.izq;
                    h.añadir(aux1, padre, 0);
                    padre.setDer(padre.izq.der);
                    padre.setIzq(padre.izq.izq);
                    h = new Heap(aux1);
                }
            } else if (padre.der != null && padre.izq == null) {
                if (padre.valor < padre.der.valor) {
                    aux1=padre.der;
                    h.añadir(aux1, padre, 0);
                    padre.setIzq(padre.der.izq);
                    padre.setDer(padre.der.der);
                    h = new Heap(aux1);
                }
            } else if (padre.izq != null && padre.der != null) {
                if (padre.izq.valor > padre.der.valor) {
                    if (padre.valor < padre.izq.valor) {
                        aux1 = padre.izq;
                        h.añadir(aux1, padre, 0);
                        padre.setDer(padre.izq.der);
                        padre.setIzq(padre.izq.izq);
                        h = new Heap(aux1);
                    }
                } else {
                    if (padre.valor < padre.der.valor) {
                        aux1 = padre.der;
                        h.añadir(aux1, padre, 0);
                        padre.setIzq(padre.der.izq);
                        padre.setDer(padre.der.der);
                        h = new Heap(aux1);
                    }
                }
            }
        }else{
            
        }
        
        return h;
    }
}
