package Ejercicio1;

import java.util.HashMap;

public class Pedido {

	HashMap<Object,Object> pedido;
	
	double tama�o;
	String color;
	double precio;
	String fechaFin;
	
	
	public Pedido(double tama�o, String color, double precio, String fechaFin){
		
		pedido = new HashMap<Object,Object>();
		
		pedido.put("tama�o", tama�o);
		pedido.put("color", color);
		pedido.put("precio", precio);
		pedido.put("fechaFin", fechaFin);
			
	}

	public HashMap<Object,Object> getPedido(){
		
		return this.pedido;
	}
		
	
	
}
