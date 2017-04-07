package Ejercicio2;
public abstract class Elemento {
	
	String nombre;
	String fechaDeCreacion;
	int tamaño;
	
	public Elemento(String nombre, int tamaño, String fecha){
		this.nombre = nombre;
		this.tamaño = tamaño;
		fechaDeCreacion = fecha;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getFecha() {
		return fechaDeCreacion;
	}

	public abstract int getTamaño();
	
	

}
