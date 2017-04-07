package Ejercicio2;

public class Link extends Elemento{

	Elemento enlace;
	
	public Link(String nombre, int tamaño, String fC, Elemento enlace) {
		super(nombre, tamaño, fC);
		tamaño = 1;
		this.enlace = enlace;
	}
	
	@Override
	public int getTamaño() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public Elemento getEnlace(){
		return this.enlace;
	}

	
	
}
