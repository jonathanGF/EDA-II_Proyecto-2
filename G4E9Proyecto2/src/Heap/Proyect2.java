package Heap;

import NODO.Nodo;
import java.util.*;

public class Proyect2 {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner n =new Scanner(System.in);
        int op,lado=0;
        ArrayList<Integer> list=new ArrayList();
        ArrayList<Nodo> lnodo=new ArrayList();
        Heap h = new Heap();
        Nodo nod,last;
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
                        lnodo.add(nod);//se agrega a lista de nodos y se aumenta el ultimo numero
                        h = new Heap(nod);//se crea un arbol con raiz del nodo
                    }else{
                        nod = new Nodo(n.nextInt());//se pide otro numero para hacerlo nodo
                        lnodo.add(nod);//se añade a la lista de nodos
                        /*if(mayoromenor(h.raiz,nod)==true){
                            h=acomodo(h,h.raiz,nod);//todo funciona bien
                        }else{
                            last= new Nodo(fondo(h,h.raiz).valor);
                            System.out.println("Ultimo nodo: "+last.valor);
                            h.añadir(last, nod);
                        }*/
                        h=acomodo(h,h.raiz,nod);
                        /*if(nod.valor>h.raiz.valor){
                            h=acomodo(h, h.raiz,nod);
                        }
                        /*
                        if(lado==0){//si lado es cero
                            h.añadir(lnodo.get((lnodo.size()/2)-1), nod, lado);//y se añade a su respectivo padre de lado izquierdo
                            lastnumber++;lado++;//se incrementa el tamaño de los ultimos numeros y para cambiar de lado
                        }else{
                            h.añadir(lnodo.get((lnodo.size()/2)-1), nod, lado);//se añade este ultimo nodo a su padre pero del lado derecho
                            lastnumber++;lado--;//se incrementa ultimo numero y se disminuye para cambiar el lado despues
                        }*/
                    }
                    //h=acomodo(h,lnodo.get(0));
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
    
    private static boolean mayoromenor(Nodo padre,Nodo hijo){
        if(padre.valor<hijo.valor){
            return true;
        }
        return false;
    }
    
    private static Heap acomodo(Heap h,Nodo padre,Nodo hijo){
        Nodo aux1,aux2,aux3,ult;
        aux1= new Nodo(padre.valor);
        aux2=padre.izq;
        aux3=padre.der;
        
        if(padre!=null && hijo!=null){
            if (mayoromenor(padre, hijo) == true) {
                if (padre == h.raiz) {
                    if (padre.izq == null && padre.der == null) {
                        h = new Heap(hijo);
                        h.añadir(hijo, padre);
                    } else if (padre.izq != null && padre.der == null) {
                        padre.setIzq(null);
                        h = new Heap(hijo);
                        h.añadir(hijo, aux2);
                        h.añadir(hijo, padre);
                    }
                } else {
                    if (padre.izq == null && padre.der == null) {
                        padre = hijo;
                        padre.setIzq(aux1);
                        padre.setDer(aux3);
                    } else if (padre.izq != null && padre.der == null) {
                        padre.setIzq(null);
                        padre = hijo;
                        h.añadir(padre, aux2);
                        h.añadir(padre, aux1);
                    }
                }
                h = recu(h, padre.izq, hijo);
                h = recu(h, padre.der, hijo);
            } else {
                ult = fondo(h, h.raiz);
                h.añadir(ult, hijo);
            }
        }
        return h;
    }
    
    private static Heap recu(Heap h,Nodo padre, Nodo hijo){
        if(mayoromenor(padre,hijo)==true){
            h=acomodo(h,padre,hijo);
        }
        return h;
    }
    
    private static Nodo fondo(Heap h,Nodo padre){
        Nodo x;
        if(padre.izq!=null && padre.der!=null){
            x= fondo(h,padre.der);
        }else if(padre.izq!=null && padre.der==null){
            x= padre;
        }else{
            x=padre;
        }
        System.out.println("Ultimo nodo: "+x.valor);
        return x;
    }
}
