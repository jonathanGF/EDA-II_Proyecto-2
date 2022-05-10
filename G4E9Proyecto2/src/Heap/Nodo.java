
package Heap;

/**
 *
 * @author ADMIN
 */
public class Nodo {
        
    public int valor;
    public Nodo izq = null;
    public Nodo der = null;
    
    public Nodo(){
        izq=der=null;//al crear un nodo tanto su sub arbol izquierdo como el derecho son nulos
    }
    public Nodo(int data){
        this(data,null,null);//se adhieren los datos a las "ramas"
    }
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;//el valor padre toma el valor data
        izq = lt;//su hijo izquierdo toma el valor lt
        der = rt;//el hijo derecho toma el valor de rt
    }   
    
    public void setIzq(Nodo izq) {
        this.izq = izq;//en caso de modificar se cambiar el valor izquiero por el que se encuentra aca
    }
    
    public void setDer(Nodo der) {
        this.der = der;//del mismo modo se modifica el lado derecho
    }

}
