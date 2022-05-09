/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolEA;

/**
 *
 * @author jonat
 */
public class PilaArbolExp {
    private NodosPila tope;
    
    public PilaArbolExp(){
        tope=null;
    }
    
    public void push(Nodo elemento){
        NodosPila nuevo=new NodosPila(elemento);
        nuevo.siguiente=tope;
        tope=nuevo;
    }
    
    public Nodo pop(){
        Nodo temp = null;
        if(!estaVacia()){
            temp = tope.dato;
            tope = tope.siguiente;
        }
        return temp;
    }
    
    public Nodo maxPila(){
        return tope.dato;
    }
    
    public void ReiniciarPila(){
        tope=null;
    }
    
     public boolean estaVacia(){
        return tope==null;
    }
    
}
