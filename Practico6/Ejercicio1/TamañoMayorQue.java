package Ejercicio1;

import java.util.HashMap;

public class Tama�oMayorQue extends Politica {
	
	double tama�o;
	
	public Tama�oMayorQue(double d){
		
		tama�o = d;
		
	}
	



	@Override
	public boolean aceptarPedido(HashMap<Object, Object> pedido) {
		
		return (double)pedido.get("tama�o") > (double)this.tama�o; 
	}
	
	
}
