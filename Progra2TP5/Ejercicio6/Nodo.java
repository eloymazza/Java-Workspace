package Ejercicio6;

public class Nodo {
	
	Nodo nodoIzq;
	Nodo nodoDer;
	Comparable elemento;
	
	public Nodo(Comparable c){
		
		nodoIzq = null;
		nodoDer = null;
		elemento = c;
	}

	public void addNodo(Comparable c){
		
		if(this.getElemento().compareTo(c) < 1){
			
			if(this.getNodoDer() != null){
				
				this.getNodoDer().addNodo(c);
			}
			else{
				nodoDer = new Nodo(c);
			}
		}
		else{
			
			if(this.getNodoIzq() != null){
				
				this.getNodoIzq().addNodo(c);
			}
			else{
				
				nodoIzq = new Nodo(c);
			}
			
		}
		
	}
	
	
	public void recorrer(AccionEjecutable acc){
		
		if(this.nodoIzq != null){
			nodoIzq.recorrer(acc);
		}
		
		acc.ejecutarNodo(this);
		
		if(this.nodoDer != null){
			nodoDer.recorrer(acc);
		}
		
	}
	
	public String toString(){
		return this.elemento.toString();
	}

	public Nodo getNodoIzq() {
		return nodoIzq;
	}

	public Nodo getNodoDer() {
		return nodoDer;
	}

	public Comparable getElemento() {
		return elemento;
	}
	
	public static void main(String[] args) {
		
		Nodo n1 = new Nodo(0);
		
		for (int i = 1; i < 20 ; i++) {
			n1.addNodo(i);
		}
		
		AccionEjecutable a1 = new Imprimir();
		AccionEjecutable a2 = new ContarNodos();
		AccionEjecutable a3 = new CrearVector();
		
		n1.recorrer(a1);
		n1.recorrer(a2);
		n1.recorrer(a3);
		
		ContarNodos a2a = (ContarNodos) a2;
		System.out.println("Cantdiad " + a2a.getCant());
		CrearVector a3a = (CrearVector) a3;
		
		for (Nodo n : a3a.getNodos()) {
			System.out.println(n.toString());
		}
	}
	
}
