package Ejercicio2;

public class ArchivoComprimido extends Directorio{

	final static double TAZACOMPRESION = 0.8;
	
	public ArchivoComprimido(String nombre, int tamaño, String fC) {
		super(nombre, tamaño, fC);
		// TODO Auto-generated constructor stub
	}
	
	public int getTamaño(){
		return (int) (super.getTamaño() * TAZACOMPRESION);
	}
}
