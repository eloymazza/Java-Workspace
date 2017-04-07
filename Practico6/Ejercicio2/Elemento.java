package Ejercicio2;
public abstract class Elemento {
	
	String nombre;
	String fechaDeCreacion;
	int tama�o;
	
	public Elemento(String nombre, int tama�o, String fecha){
		this.nombre = nombre;
		this.tama�o = tama�o;
		fechaDeCreacion = fecha;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getFecha() {
		return fechaDeCreacion;
	}

	public abstract int getTama�o();
	
	

}
