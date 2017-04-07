package Ejercicio2;

import java.util.*;

public class Directorio extends Elemento{

	List<Elemento> elementos;
	
	public Directorio(String nombre, int tama�o, String fC) {
		super(nombre, tama�o,fC );
		elementos = new ArrayList<Elemento>();
	}
	
	public void addElemento(Elemento e){
		elementos.add(e);
	}

	@Override
	public int getTama�o() {
		
		int retorno = 0;
		
		for(Elemento e : elementos) {
			retorno += e.getTama�o();
		}
		return retorno;
	}

	
	
}
