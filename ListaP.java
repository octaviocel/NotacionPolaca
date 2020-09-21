package NotacionPolaca;

public class ListaP {
	 Pila inicio=null;
	    
	    public void push(char dato){
	        Pila nuevo= nuevaPila(dato);
	        if(!isEmpty()){
	            nuevo.sig = inicio;
	        }
	        inicio = nuevo;
	    }
	    
	    public char pop(){
	        char resultado=inicio.dato;
	        Pila aux = inicio;
	        inicio=inicio.sig;
	        aux.sig = null;
	        return resultado;
	    }
	    
	    public char pick(){
	        return inicio.dato;
	    }
	    
	    public boolean isEmpty(){
	        return inicio==null;
	    }
	    
	    public Pila nuevaPila(char dato){
	        Pila nuevo =  new Pila();
	        nuevo.dato=dato;
	        nuevo.sig=null;
	        return nuevo;
	    }
}
