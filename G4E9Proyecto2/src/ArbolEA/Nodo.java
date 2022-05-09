/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolEA;

/**
 *
 * @author jonat
 */
public class Nodo {
    Object elemento;
    Nodo izquierdo;
    Nodo derecho;
    
    public Nodo(Object x){
        elemento=x;
        izquierdo = null;
        derecho = null;
    }
}
