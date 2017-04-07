package Ejercicio3;

import java.util.Comparator;

public class ComparadorTitulo implements Comparator<Libro>{

	

	@Override
	public int compare(Libro a, Libro b) {
	
		return a.getTitulo().toLowerCase().compareTo(b.getTitulo().toLowerCase());
	}

	
	
}
