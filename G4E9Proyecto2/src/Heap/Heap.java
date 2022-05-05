/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heap;

import NODO.Nodo;
import java.util.*;

public class Heap {
    Nodo raiz;
    Scanner n=new Scanner(System.in);
    
    public Heap(){
        raiz=null;
    }
    
    public Heap(int valor){
        raiz=new Nodo(valor);
    }
    
    public Heap(Nodo raiz){
        this.raiz=raiz;
    }
    
    public void menuH(){
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
                    + "\n     0.-Regresar"
                    + "\n Op: ");
            op=n.nextInt();
            switch(op){
                case 1://agregar clave
                    System.out.print("Ingresa numero: ");
                    if(veri()==true){//si el arbol es nulo
                        nod = new Nodo(n.nextInt());//se agrega un numero y se convierte en nodo
                        raiz=nod;//se agrega a lista de nodos y se aumenta el ultimo numero
                        //se crea un arbol con raiz del nodo
                    }else{
                        nod = new Nodo(n.nextInt());//se pide otro numero para hacerlo nodo
                        /*if(mayoromenor(h.raiz,nod)==true){
                            h=acomodo(h,h.raiz,nod);//todo funciona bien
                        }else{
                            last= new Nodo(fondo(h,h.raiz).valor);
                            System.out.println("Ultimo nodo: "+last.valor);
                            h.añadir(last, nod);
                        }*/
                        añadir(raiz,nod);
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
                    breadthFrist();
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
    
    public void añadir(Nodo padre, Nodo hijo){
        if(padre.valor>hijo.valor){
            if (padre.izq == null && padre.der == null) {
                padre.setIzq(hijo);
                message(padre,hijo);
            } else if (padre.izq == null && padre.der != null) {
                padre.setIzq(hijo);
                message(padre,hijo);
            } else if (padre.izq != null && padre.der == null) {
                padre.setDer(hijo);
                message(padre,hijo);
            } else {
                añadir(padre.izq, hijo);
            }
        }else{
            acomodo(padre,hijo);
        }
    }
    
    public void breadthFrist(){
        Nodo r = raiz;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		visitados(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }
    
    protected void visitados(Nodo n){
        System.out.println(n.valor+" ");
    }
    
    public boolean veri(){
        if(raiz==null){
            return true;
        }
        return false;
    }
    /*private Heap recu(Heap h,Nodo padre, Nodo hijo){
        if(mayoromenor(padre,hijo)==true){
            h=acomodo(h,padre,hijo);
        }
        return h;
    }*/
    
    /*private Nodo fondo(Heap h,Nodo padre){
        Nodo x;
        if(padre.izq!=null && padre.der!=null){
            x= fondo(h,padre.der);
        }else if(padre.izq!=null && padre.der==null){
            x= padre;
        }else{
            x=padre;
        }
        return x;
    }*/
    
    /*private boolean mayoromenor(Nodo padre,Nodo hijo){
        if(padre.valor<hijo.valor){
            return true;
        }
        return false;
    }*/
    
    private void acomodo(Nodo padre,Nodo hijo){
        Nodo tempr,tempIzq,tempDer,tempIIzq,tempIDer,tempDIzq,tempDDer;
        tempr=padre;
        tempIzq=padre.izq;
        tempDer=padre.der;
        tempIIzq=padre.izq.izq;
        tempIDer=padre.izq.der;
        tempDIzq=padre.der.izq;
        tempDDer=padre.der.der;
        
        if(padre!=null && hijo!=null){
            if (padre.izq == null && padre.der == null) {
                padre = hijo;
                añadir(padre, tempr);
                añadir(padre, tempDer);
            } else if (padre.izq != null && padre.der == null) {
                padre.setIzq(null);
                padre = hijo;
                añadir(padre, tempIzq);
                añadir(padre, tempr);
            } else if (padre.izq == null && padre.izq == null) {
                padre.setDer(null);
                padre = hijo;
                añadir(padre, tempr);
                añadir(padre, tempDer);
            } else {
                padre.setIzq(null);
                padre.setDer(null);
                padre = hijo;
                añadir(padre, tempr);
                añadir(padre, tempDer);
                añadir(padre.izq, tempIzq);
            }
        }
    }
    
    public void message(Nodo padre,Nodo hijo){
        if(padre.izq==hijo || padre.der==hijo){
            System.out.println("Se añadio correctamente");
        }
    }
}
