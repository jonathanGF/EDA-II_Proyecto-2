
package ArbolEA;

public class Nodos {
  private Nodos padre;
  private Nodos hijoIzq;
  private Nodos hijoDer;
  private String operacionAl;

    public Nodos() {
        this.padre = null;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.operacionAl = "";
    }

    public Nodos(String operacionAl) {
        this.operacionAl = operacionAl;
        this.hijoDer=null;
        this.hijoIzq=null;
        this.padre= null;
    }

    public Nodos(Nodos operadorDer, String inf, Nodos operadorIzq) {
        this.padre = null;
        this.hijoIzq = operadorIzq;
        this.hijoDer = operadorDer;
        this.operacionAl = inf;
    }

    public Nodos getPadre() {
        return padre;
    }

    public void setPadre(Nodos padre) {
        this.padre = padre;
    }

    public Nodos getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodos hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodos getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodos hijoDer) {
        this.hijoDer = hijoDer;
    }

    public String getOperacionAl() {
        return operacionAl;
    }

    public void setOperacionAl(String operacionAl) {
        this.operacionAl = operacionAl;
    }
    
    
    
    
  
  
}
