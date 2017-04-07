package Ejercicio3;

import java.util.*;

public class Biblioteca {
	
	List <Libro> libros;
	Comparator<Libro> c1 = new ComparadorISBN();

	public Biblioteca() {

		libros = new ArrayList<Libro>();		
		
	}
	
	public void addLibro(Libro l){
		
		libros.add(l);
		Collections.sort(libros, c1);
		
	}
	
	public String imprimirLibros(){
		
		String resultado = "";
		
		for (Libro libro : libros) {
			resultado += libro.imprimirLibro() + "\n";
		}
		
		return resultado;
		
	}
	
	public List<Libro> ordenarDescendente(Comparator<Libro> c){
		
		List<Libro> copiaLibros = libros;
		
		Collections.sort(copiaLibros, c);
		
		return copiaLibros;
		
	}
	
	public List<Libro> ordenarAscendente(Comparator<Libro> c){
		
		List<Libro> copiaLibros = ordenarDescendente(c);
		
		Collections.reverse(copiaLibros);
		
		return copiaLibros;
		
	}
	
	
	

}
