package Proyecto2;

import java.util.*;

public class Proyect2 {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner n =new Scanner(System.in);
        int op,first=0;
        ArrayList<Integer> list=new ArrayList();
        ArrayList<Nodo> ot=new ArrayList();
        Heap h=new Heap();
        Nodo nod;
        do{
            System.out.println("¿Que deseas hacer?"
                    + "\n  1.-Ingresar clave."
                    + "\n   2.-Eliminar calve."
                    + "\n    3.-Mostrar árbol."
                    + "\n     0.-Salir");
            op=n.nextInt();
            switch(op){
                case 1://agregar clave
                    /*System.out.println("¿Cuantos nodos deseas realizar?");
                    System.out.print("Numnodos: ");
                    numnodos=n.nextInt();
                    int lado=0;*/
                    /*
                    for(int i=0;i<numnodos;i++){
                        System.out.println("Ingresa el numero a añadir: ");
                        list.add(n.nextInt());
                    }
                    for(int j=0;j<list.size();j++){
                        nod=new Nodo(list.get(j));
                        ot.add(nod);
                    }*/
                    System.out.println("Ingresa el numero a añadir: ");
                    list.add(n.nextInt());//recibo el numero
                    nod= new Nodo(list.get(first));//se hace nodo el numero de la lista
                    ot.add(nod);//se añade el nodo a otra lista de nodos
                    if(first==0){
                        h= new Heap(ot.get(first));//se crea la raiz con el primer nodo
                        first++;
                    }
                    if (first % 2 == 1) {
                        h.añadir(ot.get(ot.size() / 2), ot.get(first), 0);//se añade lado izquierdo
                    }else{
                        h.añadir(ot.get(ot.size() / 2), ot.get(first), 1);//se añade lado derecho
                    }
                    
                    break;
                case 2://eliminar raiz
                    break;
                case 3://mostrar arbol
                    System.out.println(ot);
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }while(op!=0);
    }
    
    /*public ArrayList<Nodo> consarb(ArrayList<Nodo> ln,int x,Nodo tu,Heap h){
        if(x==0){
            ln.add(tu);//guardo el nodo en otra lista
            h = new Heap(ln.get(x));//se crea la raiz con el primer elemento
        }else{
            if(x%2==1){
                ln.add(tu);
                h.añadir(ln.get(ln.size()/2), ln.get(x), 0);
            }else{
                ln.add(tu);
                h.añadir(ln.get(ln.size()/2), ln.get(x), 1);
            }
        }
        return ln;
    }*/
}
