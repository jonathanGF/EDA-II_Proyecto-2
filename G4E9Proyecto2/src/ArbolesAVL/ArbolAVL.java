
package ArbolesAVL;

public class ArbolAVL {
    public NodoAVL root;
    
    public ArbolAVL(){
        root = null;
    }
    
    public int getFE(NodoAVL e){
        if( e == null){
            return -1;
        }else{
            return e.fE;
        }
              
    }
    
    //rotaciones
    public NodoAVL rotIzq(NodoAVL c){
        NodoAVL aux = c.izq;
        c.izq = aux.der;
        aux.der = c;
        c.fE = Math.max(getFE(c.izq), getFE(c.der))+1;
        aux.fE = Math.max(getFE(aux.izq), getFE(aux.der))+1;
        return aux;
    }
    
    public NodoAVL rotDer(NodoAVL c){
        NodoAVL aux = c.der;
        c.der = aux.izq;
        aux.izq = c;
        c.fE = Math.max(getFE(c.izq), getFE(c.der))+1;
        aux.fE = Math.max(getFE(aux.izq), getFE(aux.der))+1;
        return aux;
    }
    
    public NodoAVL rotDobleIzq(NodoAVL c){
        NodoAVL aux;
        c.izq = rotDer(c.izq);
        aux = rotIzq(c);
        return aux;
    }
    
    public NodoAVL rotDobleDer(NodoAVL c){
        NodoAVL aux;
        c.der = rotIzq(c.der);
        aux = rotDer(c);
        return aux;
    }
}
