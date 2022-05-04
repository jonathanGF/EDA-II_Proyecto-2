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
                    + "\n     0.-Salir"
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
                        lnodo.add(nod);//se añade a la lista de nodos
                        /*if(mayoromenor(h.raiz,nod)==true){
                            h=acomodo(h,h.raiz,nod);//todo funciona bien
                        }else{
                            last= new Nodo(fondo(h,h.raiz).valor);
                            System.out.println("Ultimo nodo: "+last.valor);
                            h.añadir(last, nod);
                        }*/
                        h=acomodo(h,raiz,nod);
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
    private Heap recu(Heap h,Nodo padre, Nodo hijo){
        if(mayoromenor(padre,hijo)==true){
            h=acomodo(h,padre,hijo);
        }
        return h;
    }
    
    private Nodo fondo(Heap h,Nodo padre){
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
    
    private boolean mayoromenor(Nodo padre,Nodo hijo){
        if(padre.valor<hijo.valor){
            return true;
        }
        return false;
    }
    
    private Heap acomodo(Heap h,Nodo padre,Nodo hijo){
        Nodo tempr,tempIzq,tempDer,ult;
        tempr=padre;
        tempIzq=padre.izq;
        tempDer=padre.der;
        
        if(padre!=null && hijo!=null){
            if (mayoromenor(padre, hijo) == true) {
                if (padre == h.raiz) {
                    if (padre.izq == null && padre.der == null) {
                        h = new Heap(hijo);
                        h.añadir(hijo, padre);
                    } else if (padre.izq != null && padre.der == null) {
                        padre.setIzq(null);
                        h = new Heap(hijo);
                        h.añadir(hijo, tempIzq);
                        h.añadir(hijo, padre);
                    }
                }
            } else {
                ult = fondo(h, h.raiz);
                h.añadir(ult, hijo);
            }
        }
        return h;
    }
}
