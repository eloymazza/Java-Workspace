package Ejercicio2;

public class Link extends Elemento{

	Elemento enlace;
	
	public Link(String nombre, int tama�o, String fC, Elemento enlace) {
		super(nombre, tama�o, fC);
		tama�o = 1;
		this.enlace = enlace;
	}
	
	@Override
	public int getTama�o() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public Elemento getEnlace(){
		return this.enlace;
	}

	
	
}
