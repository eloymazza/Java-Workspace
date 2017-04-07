package Ejercicio3;

import java.util.Comparator;

public class Play {

	public static void main(String[] args) {
		
		Libro l1 = new Libro(1, 2005, "Harry Potter", "JK Rowling", "Fantasia");
		Libro l2 = new Libro(2, 2003, "El señor de los anillos", "JR Tolkien", "Fantasia");
		Libro l3 = new Libro(3, 1999, "Mujercitas", "David", "Romantico");
		Libro l4 = new Libro(4, 2004, "Como conquistar a una mujer en dos miradas", "Alfredo Bollati", "Autoayuda");
		Libro l5 = new Libro(5, 2015, "Zaraza sobre que el universo conspira a tu favor", "Paulo Coelho", "Autoayuda");
		
		Biblioteca biblio = new Biblioteca();
		
		biblio.addLibro(l1);
		biblio.addLibro(l2);
		biblio.addLibro(l3);
		biblio.addLibro(l4);
		biblio.addLibro(l5);
		
	//	System.out.println(biblio.imprimirLibros());
		
		Comparator<Libro> comparador1 = new ComparadorISBN();
		Comparator<Libro> comparador2 = new ComparadorAnio();
		Comparator<Libro> comparador3 = new ComparadorTitulo();
		Comparator<Libro> comparador4 = new ComparadorGenero();
		
		biblio.ordenarAscendente(comparador1);
		biblio.ordenarAscendente(comparador2);
		biblio.ordenarDescendente(comparador3);
		biblio.ordenarDescendente(comparador4);
		
		System.out.println(biblio.imprimirLibros());
		
		
	
		
	}

}
