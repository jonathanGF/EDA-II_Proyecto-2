/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Heap;

import NODO.Nodo;
import java.util.LinkedList;
import java.util.Queue;

public class Heap {
    Nodo raiz;
    
    public Heap(){
        raiz=null;
    }
    
    public Heap(int valor){
        raiz=new Nodo(valor);
    }
    
    public Heap(Nodo raiz){
        this.raiz=raiz;
    }
    
    public void añadir(Nodo padre, Nodo hijo){
        if(padre.izq==null && padre.der==null){
            padre.setIzq(hijo);
        }else if(padre.izq==null && padre.der!=null){
            padre.setIzq(hijo);
        }else if(padre.izq!=null && padre.der==null){
            padre.setDer(hijo);
        }else{
            añadir(padre.izq,hijo);
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
}
