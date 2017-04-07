package Ejercicio6;

public class ContarNodos implements AccionEjecutable{

	int cant = 0;
	
	@Override
	public void ejecutarNodo(Nodo n) {
		cant++;
	}
	
	public int getCant(){
		return cant;
	}

}
