package Ejercicio2;

public class ArchivoComprimido extends Directorio{

	final static double TAZACOMPRESION = 0.8;
	
	public ArchivoComprimido(String nombre, int tama�o, String fC) {
		super(nombre, tama�o, fC);
		// TODO Auto-generated constructor stub
	}
	
	public int getTama�o(){
		return (int) (super.getTama�o() * TAZACOMPRESION);
	}
}
