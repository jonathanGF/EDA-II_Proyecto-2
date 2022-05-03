
package ArbolesAVL;

public class NodoAVL {
    int dato, fE;
    NodoAVL izq, der;
    
    public NodoAVL(int x){
        
        this.dato = x;
        this.fE = 0;
        this.der = null;
        this.izq = null;
    }
}
