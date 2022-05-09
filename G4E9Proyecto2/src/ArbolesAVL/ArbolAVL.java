
package ArbolesAVL;

import java.util.LinkedList;
import java.util.Queue;
//Constructor
public class ArbolAVL {
    public NodoAVL root;
    public int cont = 0;
    
    public ArbolAVL(){
        root = null;
    }
    
    public NodoAVL getRoot(){
        return root;
    }
    
    public int getFE(NodoAVL e){
        if( e == null){
            return -1;
        }else{
            return e.fE;
        }
              
    }
//Funciones
    
    //Insertar
    public void insertar(int dato) {
        NodoAVL nuevo = new NodoAVL(dato);
        //list[dato - 1] = nuevo;
        cont++;
        if (root == null) {
            root = nuevo;
        } else {
            root = addAVL(nuevo, root);
        }
    }
    public NodoAVL addAVL(NodoAVL nuevo, NodoAVL sub){
        NodoAVL nuevoPadre = sub;
        if(nuevo.dato < sub.dato){
            if(sub.izq == null){
                sub.izq = nuevo;
            }else{
                sub.izq = addAVL(nuevo, sub.izq);
                if((getFE(sub.izq) - getFE(sub.der)== 2)){
                    if(nuevo.dato < sub.izq.dato){
                        nuevoPadre = rotIzq(sub);
                    }else{
                        nuevoPadre = rotDobleIzq(sub);
                    }
                }
            }
        }else if(nuevo.dato > sub.dato){
            if(sub.der == null){
                sub.der = nuevo;
            }else{
                sub.der = addAVL(nuevo, sub.der);
                if((getFE(sub.der) - getFE(sub.izq) == 2)){
                    if(nuevo.dato > sub.der.dato){
                        nuevoPadre = rotDer(sub);
                    }else{
                        nuevoPadre = rotDobleDer(sub);
                    }
                }
            }
        }else{
            System.out.println("El Nodo ya existe");
        }
        //recalculando el factor de equilibrio
        if(sub.izq == null && sub.der != null){
            sub.fE = sub.der.fE +1 ;
        }else if(sub.der == null && sub.izq != null){
            sub.fE = sub.izq.fE + 1;
        }else{
            sub.fE = Math.max(getFE(sub.izq), getFE(sub.der)) + 1;
        }
        return nuevoPadre; 
    }
    
   
    //delete
    public void delete(NodoAVL padre, int lado){
   
      if(lado == 0){
          padre.setIzq(null);
      }else{
          padre.setDer(null);
      }
    }
    public NodoAVL search(int d, NodoAVL r){
        if(root == null){
            return null;
        }else if(r.dato == d){
            return r;
        }else if(r.dato < d){
            return search2(d,r.der,r);
        }else{
            return search2(d,r.izq,r);
        }
    }
    public NodoAVL search2(int d, NodoAVL root, NodoAVL padre){
        if(root == null){
            return null;
        }else if(root.dato == d){
            int ld = lado(padre, d);
            return padre;
            
        }else if(root.dato < d){
            return search2(d,root.der,root);
        }else{
            return search2(d,root.izq,root);
        }
    }
    
    public int lado(NodoAVL padre, int d){
        if(padre.der.dato == d){
            return 1;
        }else{
            return 0;
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
    
    //Imprimir Arbol
    public void preOrden(NodoAVL x){
        if(x != null){
            System.out.print(x.dato + ",");
            preOrden(x.izq);
            preOrden(x.der);
        }
    }
    public void Lista(NodoAVL x){
        if(x != null){
            System.out.print("Nodo temp: " +x.dato );
            if(x.der != null){
                System.out.println("\nder" + x.der.dato+"\n");
                
                
            }
            if(x.izq != null){
                System.out.println("izq" + x.izq.dato+"\n");
            }
            System.out.println("\n");
            Lista(x.izq);
            Lista(x.der);
        }
    }
   
    public void breadthFrist(){
        NodoAVL r = root;
	Queue<NodoAVL> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (NodoAVL)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
    }
    
    protected void visit(NodoAVL n){
        System.out.print(n.dato+", ");
    }	
}
