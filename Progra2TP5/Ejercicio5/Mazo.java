package Ejercicio5;



import java.util.Iterator;

import Ejercicio4.Pila;

public class Mazo implements Iterable<Carta> {
	
	Pila mazo;
	
	public Mazo(){
		
		mazo = new Pila();
	}
	
	public void addCarta(Carta c){
		mazo.push(c);
	}
	
	public boolean quedanCartas(){
		return mazo.top() != null;
	}
	
	public Carta getCarta(){
		return (Carta) mazo.pop();
	}

	public Mazo copy() {
		
		Pila aux = mazo.copy();
		Mazo copia = new Mazo();
		
		while(aux.top() != null){
			
			copia.addCarta((Carta) aux.pop());
		}
		
		return copia;
	}

	public int size() {
		return mazo.size();
	}

	@Override
	public Iterator<Carta> iterator() {
		// TODO Auto-generated method stub
		return new IterarYSumar(this);
	}
	
	


}
