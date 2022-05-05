/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolEA;

/**
 *
 * @author jonat
 */
public class NodoPila {
    NodoArbol dato;
    NodoPila siguiente;
    
    public NodoPila(NodoArbol x){
        dato=x;
        siguiente=null;
    }
}
