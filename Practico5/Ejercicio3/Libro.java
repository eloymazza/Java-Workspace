package Ejercicio3;

public class Libro {
	
	int isbn;
	int anio;
	String titulo;
	String autor;
	String genero;
	
	public Libro(int isbn, int anio, String titulo, String autor, String genero) {
	
		this.isbn = isbn;
		this.anio = anio;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String imprimirLibro(){
		
		return isbn + " Titulo: '" + titulo + "' Autor: '" + autor + "'" + " Genero: " + genero;
		
	}
	

}
