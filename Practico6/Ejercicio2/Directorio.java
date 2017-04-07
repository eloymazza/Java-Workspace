package Ejercicio2;

import java.util.*;

public class Directorio extends Elemento{

	List<Elemento> elementos;
	
	public Directorio(String nombre, int tamaño, String fC) {
		super(nombre, tamaño,fC );
		elementos = new ArrayList<Elemento>();
	}
	
	public void addElemento(Elemento e){
		elementos.add(e);
	}

	@Override
	public int getTamaño() {
		
		int retorno = 0;
		
		for(Elemento e : elementos) {
			retorno += e.getTamaño();
		}
		return retorno;
	}

	
	
}
