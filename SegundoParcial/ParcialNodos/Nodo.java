package ParcialNodos;

import java.util.Iterator;

public class Nodo implements Iterable{

	Comparable objeto;
	Nodo siguiente;
	
	public Nodo(Comparable c){
		
		objeto = c;
		
	}
	
	public void setVinculo(Nodo v){
		
		siguiente = v;
		
	}
	
	public void insertarNodo(Comparable c){
		
		if(siguiente == null){
			
			Nodo nodoNuevo = new Nodo(c);
			setVinculo(nodoNuevo);
			
		}
		else{
			
			siguiente.insertarNodo(c);
			
		}
		
	}
	
	public void imprimirNodos(){
		
		System.out.println(objeto.toString());
		if(siguiente != null){
			siguiente.imprimirNodos();
		}
		
	}
	
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		
		 Nodo listaVinculada = new Nodo("a");
		 Comparable c1 = "b";
		 Comparable c2 = "c";
		 Comparable c3 = "d";
		
		 listaVinculada.insertarNodo(c1);
		 listaVinculada.insertarNodo(c2);
		 listaVinculada.insertarNodo(c3);
		 
		 listaVinculada.imprimirNodos();
		 
		 
	}


	

	
	
}
