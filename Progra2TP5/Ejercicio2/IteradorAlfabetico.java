package Ejercicio2;

import java.util.*;

public class IteradorAlfabetico implements Iterator <String>{

	List<String> elementos;

	protected int pos = 0;

	public IteradorAlfabetico(List<String>palabrasUnicas){

	elementos = new ArrayList<String>(palabrasUnicas);
	
	Collections.sort(elementos);
	
	}
	

	public boolean hasNext() {
		
		return(pos<elementos.size());
		
	}

	public String next(){
		
	String s = elementos.get(pos);
	pos++;
	return s;
	
	}
	
}
