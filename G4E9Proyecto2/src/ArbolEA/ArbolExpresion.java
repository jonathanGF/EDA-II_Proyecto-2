
package ArbolEA;

public class ArbolExpresion {
    Nodo raiz;
    
    public ArbolExpresion(){
        raiz=null;
    }
    
    public ArbolExpresion(String cadena){
        raiz = creaArbolExp(cadena);
    }
    
    public Nodo creaSubArbol(Nodo operando2, Nodo operando1, Nodo operador){
        operador.izquierdo = operando2;
        operador.derecho = operando1;
        return operador;
    }
 
    private String posOrden(Nodo subArbol, String c){
       String cadena;
        cadena="";
        if(subArbol != null){
            cadena = c + posOrden(subArbol.izquierdo, c)+posOrden(subArbol.derecho, c)+subArbol.elemento.toString()+"\n";
        }
        return cadena; 
    }
    
    public String imprimir(){
        String cadena = "";
        return cadena=posOrden(raiz, cadena);
    }
    
    private int jerarquiaOperaciones(char c){
        int prioridad=50;
        switch (c) {
            case '^':
                prioridad=30;
                break;
            case '*':
            case '/':
                prioridad=20;
                break;
            case '+':
            case '-':
                prioridad=10;
                break;
            default:
                prioridad=0;//parentesis
        }
        return prioridad;
    }
    
    private boolean esOperador(char c){
        boolean resultado;
        switch (c) {
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
                resultado = false;
        }
        return resultado;
    }
    
    private Nodo creaArbolExp(String cadena){
        PilaArbolExp PilaOperadores;
        PilaArbolExp PilaExpresiones;
        Nodo token;
        Nodo op1;
        Nodo op2;
        Nodo op;
        PilaOperadores = new PilaArbolExp();
        PilaExpresiones = new PilaArbolExp();
        char caracterEvaluado;
        for(int i=0;i<cadena.length();i++){
            caracterEvaluado=cadena.charAt(i);
            token=new Nodo(caracterEvaluado);
            if(!esOperador(caracterEvaluado)){
                PilaExpresiones.push(token);
            }else{
                switch (caracterEvaluado) {
                    case '(':
                        PilaOperadores.push(token);
                        break;
                    case ')':
                        while (!PilaOperadores.estaVacia()&& !PilaOperadores.maxPila().elemento.equals('(')) {                            
                            op2= PilaExpresiones.pop();
                            op1= PilaExpresiones.pop();
                            op=PilaOperadores.pop();
                            op=creaSubArbol(op2, op1, op);
                            PilaExpresiones.push(op);
                        }
                        PilaOperadores.pop();
                        break;
                    default:
                       while(!PilaOperadores.estaVacia() && jerarquiaOperaciones(caracterEvaluado)<=jerarquiaOperaciones(PilaOperadores.maxPila().elemento.toString().charAt(0))){
                            op2= PilaExpresiones.pop();
                            op1= PilaExpresiones.pop();
                            op=PilaOperadores.pop();
                            op=creaSubArbol(op2, op1, op);
                            PilaExpresiones.push(op);
                         }
                       PilaOperadores.push(token);
                }
            }
        }
        while (!PilaOperadores.estaVacia()) {            
            op2= PilaExpresiones.pop();
            op1= PilaExpresiones.pop();
            op=PilaOperadores.pop();
            op=creaSubArbol(op2, op1, op);
            PilaExpresiones.push(op); 
        }
        op= PilaExpresiones.pop();
        return op;
    }
    
    public double EvaluaExpresion(){
        return resolverExpresion(raiz);
    }
    
    private double resolverExpresion(Nodo subArbol){
        double total =0;
        if(!esOperador(subArbol.elemento.toString().charAt(0))){
            return Double.parseDouble(subArbol.elemento.toString());
        }else{
            switch (subArbol.elemento.toString().charAt(0)) {
                case '^':
                    total= total + Math.pow(resolverExpresion(subArbol.izquierdo),resolverExpresion(subArbol.derecho));
                    break;
                case '*':
                    total = total + resolverExpresion(subArbol.izquierdo)* resolverExpresion(subArbol.derecho);
                    break;
                case '/':
                    total = total + resolverExpresion(subArbol.izquierdo)/resolverExpresion(subArbol.derecho);
                    break;
                case '+':
                    total = total + resolverExpresion(subArbol.izquierdo)+resolverExpresion(subArbol.derecho);
                    break;
                case '-':
                    total = total + resolverExpresion(subArbol.izquierdo)-resolverExpresion(subArbol.derecho);
                    break;
            }
        }
        return total;
    }
    
    
    
} 


