package Ejercicio5;

import java.util.Iterator;

public class IterarYSumar implements Iterator<Carta> {
	
	Mazo mazo;
	
	public IterarYSumar(Mazo m){
		mazo = m.copy();
	}
	
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return mazo.quedanCartas();
	}

	@Override
	public Carta next() {
		// TODO Auto-generated method stub
		return mazo.getCarta();
	}

}
