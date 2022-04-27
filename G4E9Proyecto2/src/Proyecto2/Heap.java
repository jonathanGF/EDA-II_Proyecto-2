/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto2;

/**
 *
 * @author ADMIN
 */
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
    
    public void añadir(Nodo padre, Nodo hijo, int lado){
        if(lado==0){
            padre.setIzq(hijo);
        }else{
            padre.setDer(hijo);
        }
    }
}
