package Ejercicio6;

import java.util.Vector;

public class CrearVector implements AccionEjecutable {

	Vector <Nodo> nodos;
	
	public CrearVector(){
		
		nodos = new Vector<Nodo>();
	}
	
	@Override
	public void ejecutarNodo(Nodo n) {
		nodos.add(n);
	}
	
	public Vector<Nodo>getNodos(){
		return nodos;
	}

}
