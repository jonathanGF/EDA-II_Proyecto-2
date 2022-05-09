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
    ArrayList<Nodo> lnodo=new ArrayList();
    
    public void menuH(){
        int op;
        Nodo nod;
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
                        lnodo.add(nod);
                        raiz=nod;
                    }else{
                        nod = new Nodo(n.nextInt());//se pide otro numero para hacerlo nodo
                        lnodo.add(nod);
                        añadir(raiz,nod);
                    }
                    break;
                case 2://eliminar raiz
                    System.out.print("Dame el número a eliminar: ");
                    delete(n.nextInt());
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
        if(hijo!=null){
            if (padre.valor > hijo.valor) {
                if (padre.izq == null && padre.der == null) {
                    padre.setIzq(hijo);
                    message(padre, hijo);
                } else if (padre.izq == null && padre.der != null) {
                    padre.setIzq(hijo);
                    message(padre, hijo);
                } else if (padre.izq != null && padre.der == null) {
                    padre.setDer(hijo);
                    message(padre, hijo);
                } else {
                    añadir(padre.izq, hijo);
                }
            } else {
                acomodo(padre, hijo);
            }
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
        Nodo tempr,tempIzq,tempDer;
        int r=padre.valor;
        tempIzq=padre.izq;
        tempDer=padre.der;
        
        if(padre!=null && hijo!=null){
            if(padre.izq==null && padre.der==null){
                padre.valor=hijo.valor;
                añadir(padre,tempr=new Nodo(r));
            }else if(padre.izq!=null && padre.der==null){
                padre.setIzq(null);
                padre.valor=hijo.valor;
                añadir(padre,tempIzq);
                añadir(padre,tempr=new Nodo(r));
            }else if(padre.izq==null && padre.der!=null){
                padre.setDer(null);
                padre.valor=hijo.valor;
                añadir(padre,tempr=new Nodo(r));
                añadir(padre,tempDer);
            }else{
                padre.setIzq(null);
                padre.setDer(null);
                padre.valor=hijo.valor;
                añadir(padre,tempr= new Nodo(r));
                añadir(padre,tempDer);
                añadir(padre.izq,tempIzq);
            }
        }
    }
    
    public void message(Nodo padre,Nodo hijo){
        if(padre.izq==hijo || padre.der==hijo){
            System.out.println("Se añadio correctamente");
        }
    }
    
    public void delete(int x){
        Nodo buscado=new Nodo(x);
        Nodo aux=buscar(buscado,raiz);
        
            if (raiz.valor == x) {
                if (raiz.izq == null && raiz.der == null) {
                    raiz = null;
                } else if (raiz.izq != null && raiz.der == null) {
                    Nodo tempIzq = lnodo.get(lnodo.indexOf(raiz.izq));
                
                    raiz.setIzq(null);
                    raiz = tempIzq;
                } else if (raiz.izq == null && raiz.der != null) {
                    Nodo tempDer = lnodo.get(lnodo.indexOf(raiz.der));
                    raiz.setDer(null);
                    raiz = tempDer;
                } else {
                    Nodo tempIzq = lnodo.get(lnodo.indexOf(raiz.izq));
                    Nodo tempDer = lnodo.get(lnodo.indexOf(raiz.der));
                    if (raiz.izq.valor > raiz.der.valor) {
                        raiz.setIzq(null);
                        raiz.setDer(null);
                        if (tempIzq.izq == null && tempIzq.der == null) {
                            raiz = tempIzq;
                            añadir(raiz, tempDer);
                        } else if (tempIzq.izq != null && tempIzq.der == null) {
                            raiz = tempIzq;
                            añadir(raiz, tempDer);
                        } else if (tempIzq.izq == null && tempIzq.der != null) {
                            Nodo hijoDer = lnodo.get(lnodo.indexOf(tempIzq.izq));
                            tempIzq.setDer(null);
                            raiz = tempIzq;
                            añadir(raiz, hijoDer);
                            añadir(raiz, tempDer);
                        } else {
                            Nodo hijoIzq = lnodo.get(lnodo.indexOf(tempIzq.izq));
                            Nodo hijoDer = lnodo.get(lnodo.indexOf(tempIzq.der));
                            tempIzq.setIzq(null);
                            tempIzq.setDer(null);
                            raiz = tempIzq;
                            añadir(raiz, hijoIzq);
                            añadir(raiz, tempDer);
                            añadir(hijoIzq, hijoDer);
                        }
                    }else{
                        raiz.setIzq(null);
                        raiz.setDer(null);
                        if (tempDer.izq == null && tempDer.der == null) {
                            raiz = tempDer;
                            añadir(raiz, tempIzq);
                        } else if (tempDer.izq != null && tempDer.der == null) {
                            Nodo hijoIzq=lnodo.get(lnodo.indexOf(tempDer.izq));
                            tempDer.setIzq(null);
                            raiz = tempDer;
                            añadir(raiz, tempIzq);
                            añadir(raiz,hijoIzq);
                        } else if (tempIzq.izq == null && tempIzq.der != null) {
                            raiz = tempDer;
                            añadir(raiz, tempIzq);
                        } else {
                            Nodo hijoIzq = lnodo.get(lnodo.indexOf(tempDer.izq));
                            Nodo hijoDer = lnodo.get(lnodo.indexOf(tempDer.der));
                            tempDer.setIzq(null);
                            tempDer.setDer(null);
                            raiz = tempDer;
                            añadir(raiz, tempDer);
                            añadir(raiz, hijoIzq);
                            añadir(hijoIzq, hijoDer);
                        }
                    }
                }
            }
        if(aux!=null){
            
                if(aux.izq.valor==x){
                    if(aux.izq.izq==null && aux.izq.der==null){
                        aux.setIzq(null);
                    }else if(aux.izq.izq!=null && aux.izq.der==null){
                        Nodo hhi = lnodo.get(lnodo.indexOf(aux.izq.izq));
                        aux.izq.setIzq(null);
                        aux.setIzq(null);
                        añadir(aux,hhi);
                    }else if(aux.izq.izq==null && aux.izq.der!=null){
                        Nodo hhd = lnodo.get(lnodo.indexOf(aux.izq.der));
                        aux.izq.setDer(null);
                        aux.setDer(null);
                        añadir(aux,hhd);
                    }else{
                        if(aux.izq.izq.valor>aux.izq.der.valor){
                            Nodo hhi,hhd;
                            hhi = lnodo.get(lnodo.indexOf(aux.izq.izq));
                            hhd = lnodo.get(lnodo.indexOf(aux.izq.der));
                            aux.izq.setIzq(null);
                            aux.izq.setDer(null);
                            aux.setIzq(null);
                            añadir(aux,hhi);
                            añadir(hhi,hhd);
                        }else{
                            Nodo hhi,hhd;
                            hhi = lnodo.get(lnodo.indexOf(aux.izq.izq));
                            hhd = lnodo.get(lnodo.indexOf(aux.izq.der));
                            aux.der.setIzq(null);
                            aux.der.setDer(null);
                            aux.setDer(null);
                            añadir(aux,hhi);
                            añadir(hhi,hhd);
                        }
                    }
                }else{
                    if(aux.der.izq==null && aux.der.der==null){
                        aux.setDer(null);
                    }else if(aux.der.izq!=null && aux.der.der==null){
                        Nodo hhi = lnodo.get(lnodo.indexOf(aux.der.izq));
                        aux.der.setIzq(null);
                        aux.setDer(null);
                        añadir(aux,hhi);
                    }else if(aux.izq.izq==null && aux.izq.der!=null){
                        Nodo hhd = lnodo.get(lnodo.indexOf(aux.der.der));
                        aux.der.setDer(null);
                        aux.setDer(null);
                        añadir(aux,hhd);
                    }else{
                        if(aux.der.izq.valor>aux.der.der.valor){
                            Nodo hhi,hhd;
                            hhi = lnodo.get(lnodo.indexOf(aux.izq.izq));
                            hhd = lnodo.get(lnodo.indexOf(aux.izq.der));
                            aux.der.setIzq(null);
                            aux.der.setDer(null);
                            aux.setIzq(null);
                            añadir(aux,hhi);
                            añadir(hhi,hhd);
                        }else{
                            Nodo hhi,hhd;
                            hhi = lnodo.get(lnodo.indexOf(aux.izq.izq));
                            hhd = lnodo.get(lnodo.indexOf(aux.izq.der));
                            aux.der.setIzq(null);
                            aux.der.setDer(null);
                            aux.setDer(null);
                            añadir(aux,hhi);
                            añadir(hhi,hhd);
                        }
                    }
                }
            
            //lnodo.remove(lnodo.indexOf(buscado.valor));
        }else{
            System.out.println("No se encontro el nodo a eliminar");
        }
    }
    
    public Nodo buscar(Nodo x,Nodo padre){
        Nodo apoyo=null;
        if(padre.izq!=null && padre.der!=null){
            if (padre.izq == x) {
                apoyo = padre;
            } else if (padre.der == x) {
                apoyo = padre;
            } else {
                if (padre.izq.valor > x.valor && padre.der.valor > x.valor) {
                    apoyo = buscar(x, padre.izq);
                    if (apoyo == null) {
                        apoyo = buscar(x, padre.der);
                    }
                } else if (padre.izq.valor < x.valor && padre.der.valor > x.valor) {
                    apoyo = buscar(x, padre.der);
                } else if (padre.izq.valor > x.valor && padre.der.valor < x.valor) {
                    apoyo = buscar(x, padre.izq);
                }
            }
        }else if(padre.izq!=null && padre.der==null){
            if (padre.izq.valor== x.valor) {
                apoyo = padre;
            }else{
                if(padre.izq.valor>x.valor){
                    apoyo=buscar(x,padre.izq);
                }
            }
        }else if(padre.izq==null && padre.der!=null){
            if(padre.der.valor==x.valor){
                apoyo=padre;
            }else if(padre.der.valor>x.valor){
                apoyo=buscar(x,padre.der);
            }
        }else {
            apoyo= padre;
        }
        return apoyo;
    }
    
}
