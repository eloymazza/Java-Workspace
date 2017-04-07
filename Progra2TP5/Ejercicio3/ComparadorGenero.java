package Ejercicio3;

import java.util.Comparator;

public class ComparadorGenero implements Comparator<Libro>{

	@Override
	public int compare(Libro o1, Libro o2) {
		
		return o1.getGenero().compareToIgnoreCase(o2.getGenero());
	}

	
	
}
