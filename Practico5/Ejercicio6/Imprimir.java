package Ejercicio6;

public class Imprimir implements AccionEjecutable{

	@Override
	public void ejecutarNodo(Nodo n) {
		
		System.out.println(n.toString());
	}

	
}
