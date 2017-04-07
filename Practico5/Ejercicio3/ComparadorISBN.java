package Ejercicio3;

import java.util.Comparator;

public class ComparadorISBN implements Comparator<Libro> {

	@Override
	public int compare(Libro o1, Libro o2) {
		
		return o1.getIsbn() - o2.getIsbn();
	}


}
