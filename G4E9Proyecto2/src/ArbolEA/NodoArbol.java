/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolEA;

/**
 *
 * @author jonat
 */
public class NodoArbol {
    Object dato;
    NodoArbol izquierdo;
    NodoArbol derecho;
    
    public NodoArbol(Object x){
        dato=x;
        izquierdo = null;
        derecho = null;
    }
}
