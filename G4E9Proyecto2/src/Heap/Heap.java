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
    ArrayList<Nodo> lnodo = new ArrayList();
    
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
        Nodo nod;
        do{
            System.out.print("¿Que deseas hacer?"
                    + "\n  1.-Ingresar clave."
                    + "\n   2.-Eliminar clave."
                    + "\n    3.-Mostrar árbol."
                    + "\n     0.-Regresar"
                    + "\n Op: ");
            op=n.nextInt();
            switch(op){
                case 1://agregar clave
                    System.out.print("Ingresa numero: ");
                    if(veri()==true){//si el arbol es nulo
                        nod = new Nodo(n.nextInt());//se agrega un numero y se convierte en nodo
                        lnodo.add(nod);
                        raiz=nod;//se añade nodo como la raiz principal
                        
                    }else{
                        nod = new Nodo(n.nextInt());//se pide otro numero para hacerlo nodo
                        lnodo.add(nod);
                        añadir(raiz,nod);
                    }
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
        
    private void acomodo(Nodo padre,Nodo hijo){
        Nodo tempr,tempIzq,tempDer,tempIIzq,tempIDer,tempDIzq,tempDDer;
        int r=padre.valor;
        tempIzq=padre.izq;
        tempDer=padre.der;
        
        if(padre!=null && hijo!=null){
            if (padre.izq == null && padre.der == null) {
                padre.valor = hijo.valor;
                añadir(padre, tempr=new Nodo(r));
                //añadir(padre, tempDer);
            } else if (padre.izq != null && padre.der == null) {
                padre.setIzq(null);
                padre.valor = hijo.valor;
                añadir(padre, tempIzq);
                añadir(padre, tempr=new Nodo(r));
            } else if (padre.izq == null && padre.der != null) {
                padre.setDer(null);
                padre.valor = hijo.valor;
                añadir(padre, tempr=new Nodo(r));
                añadir(padre, tempDer);
            } else {
                padre.setIzq(null);
                padre.setDer(null);
                padre.valor = hijo.valor;
                añadir(padre, tempr=new Nodo(r));
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
    
    public void delete(int x){
        Nodo aux = buscado(x,raiz);
        
    }
    
    public Nodo buscado(int x, Nodo padre){
        Nodo aux=null;
        if(padre.valor==x){
            aux=padre;
        }else{
            if(padre.izq!=null && padre.der==null){
                aux=buscado(x,padre.izq);
            }else if(padre.izq==null && padre.der!=null){
                aux=buscado(x,padre.der);
            }else{
                if(padre.izq.valor>x && padre.der.valor>x){
                    aux=buscado(x,padre.izq);
                    if(aux==null){
                        aux=buscado(x,padre.der);
                    }
                }else if(padre.izq.valor<x && padre.der.valor>x){
                    aux=buscado(x,padre.der);
                }else if(padre.izq.valor>x && padre.der.valor<x){
                    aux=buscado(x,padre.izq);
                }
            }
        }
                
        return aux;
    }
}
