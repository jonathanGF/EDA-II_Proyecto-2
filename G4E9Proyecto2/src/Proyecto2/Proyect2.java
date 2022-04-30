package Proyecto2;

import java.util.*;

public class Proyect2 {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner n =new Scanner(System.in);
        int op,lado=0,lastnumber=0;
        ArrayList<Integer> list=new ArrayList();
        ArrayList<Nodo> ot=new ArrayList();
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
                    /*if(first==0){
                        System.out.println("Ingresa tres numeros para crear el arbol: ");
                        for(int i=0;i<3;i++){
                            System.out.print("Ingresa numero: ");
                            list.add(n.nextInt());
                            nod= new Nodo(list.get(first));
                            ot.add(nod);
                            first++;
                        }
                        h = new Heap(ot.get(0));
                        h.añadir(ot.get(0), ot.get(1), 0);
                        h.añadir(ot.get(0), ot.get(2), 1);
                    }
                    //list.add(n.nextInt());//recibo el numero
                    //nod= new Nodo(list.get(first));//se hace nodo el numero de la lista
                    //ot.add(nod);//se añade el nodo a otra lista de nodos
                    /*if(first==0){
                        h= new Heap(ot.get(first));//se crea la raiz con el primer nodo
                        first++;
                    }
                    if (first % 2 == 1) {
                        h.añadir(ot.get(ot.size() / 2), ot.get(first), 0);//se añade lado izquierdo
                    }else{
                        h.añadir(ot.get(ot.size() / 2), ot.get(first), 1);//se añade lado derecho
                    }*/
                    System.out.print("Ingresa numero: ");
                    if(h.veri()==true){
                        nod = new Nodo(n.nextInt());
                        ot.add(nod);lastnumber++;
                        h = new Heap(nod);
                    }else{
                        if(lado==0){
                            nod = new Nodo(n.nextInt());
                            ot.add(nod);
                            h.añadir(ot.get((ot.size()/2)-1), nod, lado);
                            lastnumber++;lado++;
                        }else{
                            nod = new Nodo(n.nextInt());
                            ot.add(nod);
                            h.añadir(ot.get((ot.size()/2)-1), ot.get(lastnumber), lado);
                            lastnumber++;lado--;
                        }
                    }                  
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
