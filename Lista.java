package NotacionPolaca;

public class Lista {
	Cola inicio=null;
    Cola fin=null;
    
    public  void put (char dato) {
	Cola nuevo = nuevaCola(dato);
	if(isEmpty()) {
		inicio=nuevo;
		fin=nuevo;
            }else {
		nuevo.sig=inicio;
		inicio.ant=nuevo;
		inicio=nuevo;
		}
	}
    public char sacacola(){
        
        Cola aux=fin;
        char resultado = aux.dato;
        fin =fin.ant;
        fin.sig=null;
        aux.ant=null;
        
        return resultado;
        
    }
    public void sacainicio() {
    	Cola aux=inicio;
    	inicio=inicio.sig;
    	inicio.ant=null;
    	aux.sig=null;
    }
    public boolean isEmpty(){
        return inicio==null&&fin==null;
    }
    public Cola nuevaCola(char dato){
        Cola nuevo =  new Cola();
        nuevo.dato=dato;
        nuevo.sig=null;
        nuevo.ant=null;
        return nuevo;
    }
    public void recorre(){
        Cola aux = fin;
        while(aux!=null){
            System.out.print(aux.dato+" ");
            aux=aux.ant;
        }
    }
    public int largo() {
    int r=0;
	Cola aux=inicio;
	while(aux!=null) {
		r++;
		aux=aux.sig;
	}
	return r;
    }
}
