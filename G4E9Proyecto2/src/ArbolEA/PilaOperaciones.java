/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolEA;

/**
 *
 * @author jonat
 */
public class PilaOperaciones {
    private ApPilaArbol top;

    public PilaOperaciones() {
        this.top = null;
    }
    
    public void agregar(Nodos numero){
        ApPilaArbol elementoNuevo;
        elementoNuevo=new ApPilaArbol(numero);
        elementoNuevo.apSiguiente=top;
        top=elementoNuevo;
    }
    
    public boolean estaVacia(){
        return top==null;
    }
    
    public Nodos MaxPila(){
        return top.numero;
    }
    
    public void ResetPila(){
        top=null;
    }
    
    public Nodos pop(){
        Nodos temp=null;
        if(!estaVacia()){
            temp=top.numero;
            top=top.apSiguiente;
        }
        return temp;
    }
    
    
}
