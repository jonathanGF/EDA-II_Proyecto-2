/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolEA;
/**
 *
 * @author jonat
 */
public class ArbolDeExpresiones {
    Nodos root;

    public ArbolDeExpresiones() {
        root=null;
     
    }

    public ArbolDeExpresiones(String expresion) {
        root=crearArbolEX(expresion);
    }
    
    private int jerarquiaOperaciones(char simbolo){
       int prioridad=200;
        switch (simbolo) {
            case '^':
                prioridad=130;
                break;
            case '*':
            case '/':
                prioridad=120;
                break;
            case '+':
            case '-':
                prioridad=110;
                break;
            default:
                prioridad=0;
        }
        return prioridad;
    }
    
    private boolean esOperador(char o){
       boolean resultado;
        switch (o) {
            case '(':
            case ')':
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                resultado=true;
                break;
            default:
                resultado=false;
        }
        return resultado;
    }
    
    
    private Nodos crearArbolEX(String expresion){
        PilaOperaciones pilaOperadores;
        PilaOperaciones pilaExpresiones;
        Nodos token;
        Nodos operando1;
        Nodos operando2;
        Nodos operador;
        pilaOperadores=new PilaOperaciones();
        pilaExpresiones=new PilaOperaciones();
        char evaluandoCaracter;
        for (int i = 0; i < expresion.length(); i++) {
            evaluandoCaracter=expresion.charAt(i);
            token=new Nodos(evaluandoCaracter);
            if(!esOperador(evaluandoCaracter)){
                pilaExpresiones.agregar(token);
            }else{
                switch (evaluandoCaracter) {
                    case '(':
                        pilaOperadores.agregar(token);
                        break;
                    case ')':
                        while (!pilaOperadores.estaVacia()&& !pilaOperadores.MaxPila().numero.equals('(')) {                            
                          operando2=pilaExpresiones.pop();
                          operando1=pilaExpresiones.pop();
                          operador=pilaExpresiones.pop();
                          operador=SubArbol(operando1, operando2, operador);
                          pilaExpresiones.agregar(operador);
                        }
                        pilaOperadores.pop();
                        break;
                    default:
                       while(pilaOperadores.estaVacia() && jerarquiaOperaciones(evaluandoCaracter)<=jerarquiaOperaciones(pilaOperadores.MaxPila().numero.toString().charAt(0))){
                          operando2=pilaExpresiones.pop();
                          operando1=pilaExpresiones.pop();
                          operador=pilaExpresiones.pop();
                          operador=SubArbol(operando1, operando2, operador);
                          pilaExpresiones.agregar(operador);    
                               
                       }
                       pilaOperadores.agregar(token);
                        
                }
            }
        }
        while (!pilaOperadores.estaVacia()) {            
           operando2=pilaExpresiones.pop();
            operando1=pilaExpresiones.pop();
            operador=pilaExpresiones.pop();
            operador=SubArbol(operando1, operando2, operador);
            pilaExpresiones.agregar(operador);  
        }
        operador=pilaExpresiones.pop();
        return operador;
        
    }
    
    public double evaluandoExp(){
        return evaluacion(root);
    }
    
    private double evaluacion(Nodos subArbol){
        double total=0;
        if(!esOperador(subArbol.numero.toString().charAt(0))){
            return Double.parseDouble(subArbol.numero.toString());
        }else{
            switch (subArbol.numero.toString().charAt(0)) {
                case '^':
                    total=total + Math.pow(evaluacion(subArbol.hijoIzq), evaluacion(subArbol.hijoDer));
                    break;
                case '*':
                    total=total + evaluacion(subArbol.hijoIzq)*evaluacion(subArbol.hijoDer);
                    break;
                case '/':
                    total=total + evaluacion(subArbol.hijoIzq)/ evaluacion(subArbol.hijoDer);
                    break;
                case '+':
                    total=total + evaluacion(subArbol.hijoIzq)+ evaluacion(subArbol.hijoDer);
                    break;
                case '-':
                    total=total + evaluacion(subArbol.hijoIzq)- evaluacion(subArbol.hijoDer);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return total;
    }
    public Nodos crearArbol(){
        return root;
    }
    
    public void  resetArbolEX(){
        root=null;
    }
    
    public void generarNodo(Object numero){
        root=new Nodos(numero);
    }
    
    public Nodos SubArbol(Nodos elemento1,Nodos elemento2,Nodos operador){
        operador.hijoIzq=elemento1;
        operador.hijoDer=elemento2;
        return operador;
    }
    
    public boolean esVacio(){
        return root==null;
    }
    
    private String preOrden(Nodos subArbol,String exp){
        String expresion;
        expresion="";
        if(subArbol !=null){
            expresion= exp + subArbol.numero.toString()+"\n"+preOrden(subArbol.hijoIzq, exp)+preOrden(subArbol.hijoDer, exp);
        }
        return expresion;
    }
    private String inOrden(Nodos subArbol,String exp){
        String expresion;
        expresion="";
        if(subArbol !=null){
            expresion= exp + inOrden(subArbol.hijoIzq, exp)+ subArbol.numero.toString()+"\n"+inOrden(subArbol.hijoDer, exp);
        }
        return expresion;
    }
    
    private String postOrden(Nodos subArbol,String exp){
        String expresion;
        expresion="";
        if(subArbol !=null){
            expresion= exp + postOrden(subArbol.hijoIzq, exp)+postOrden(subArbol.hijoDer, exp)+subArbol.numero.toString()+"\n";
        }
        return expresion;
    }
    
    
    
    
}