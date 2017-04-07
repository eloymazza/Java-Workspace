package Ejercicio1;

import java.util.HashMap;

public class Pedido {

	HashMap<Object,Object> pedido;
	
	double tamaño;
	String color;
	double precio;
	String fechaFin;
	
	
	public Pedido(double tamaño, String color, double precio, String fechaFin){
		
		pedido = new HashMap<Object,Object>();
		
		pedido.put("tamaño", tamaño);
		pedido.put("color", color);
		pedido.put("precio", precio);
		pedido.put("fechaFin", fechaFin);
			
	}

	public HashMap<Object,Object> getPedido(){
		
		return this.pedido;
	}
		
	
	
}
