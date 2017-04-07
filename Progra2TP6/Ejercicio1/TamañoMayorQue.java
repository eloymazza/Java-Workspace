package Ejercicio1;

import java.util.HashMap;

public class TamañoMayorQue extends Politica {
	
	double tamaño;
	
	public TamañoMayorQue(double d){
		
		tamaño = d;
		
	}
	



	@Override
	public boolean aceptarPedido(HashMap<Object, Object> pedido) {
		
		return (double)pedido.get("tamaño") > (double)this.tamaño; 
	}
	
	
}
