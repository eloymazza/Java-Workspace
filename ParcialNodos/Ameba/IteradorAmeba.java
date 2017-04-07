package Ameba;

import java.util.*;

public class IteradorAmeba implements Iterator<Ameba>{

	Ameba actual;
	int pos = 0;
	List <Ameba> amebas;
	
	public IteradorAmeba(Ameba a){
		
		actual = a;
		amebas = llenarLista(actual);
		
	}
	
	
	
	protected List<Ameba> llenarLista(Ameba actual) {
		
		List<Ameba> aux = new ArrayList<Ameba>();
		
		aux.add(actual);
		
		for (Ameba hijo : actual.getHijos()) {
			
			aux.addAll(llenarLista(hijo));
		}
		
		return aux;
	}



	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return pos<amebas.size();
	}

	@Override
	public Ameba next() {
		Ameba aux = amebas.get(pos);
		pos++;
		return aux;
	}

}
