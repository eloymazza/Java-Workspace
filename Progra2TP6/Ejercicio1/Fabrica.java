package Ejercicio1;

import java.util.*;

public class Fabrica {
	
	String nombre;
	Fabrica fabricaSiguiente;
	List<HashMap<Object,Object>> pedidos;
	Politica politica;
	
	public Fabrica(String nombre){
		
		this.nombre = nombre;
		fabricaSiguiente = null;
		pedidos = new ArrayList<HashMap<Object,Object>>();
		politica = null;
	}
	
	public void cambiarPolitica(Politica pol){
		
		this.politica = pol;
		
	}
	public void setFabricaCercana(Fabrica f){
		
		fabricaSiguiente = f;
		
	}
	
	public void aceptarPedidos(HashMap<Object,Object> pedido){
			
		if(politica == null){
			pedidos.add(pedido);
			System.out.println("Pedido tomado con exito " + nombre);
		}
		else{
			
			if(politica.aceptarPedido(pedido)){			
				pedidos.add(pedido);
			}
			else{
				
				if(fabricaSiguiente != null)
				fabricaSiguiente.aceptarPedidos(pedido);
					else{
						System.out.println("ninguna fabrica quiere tomar este pedido");
						
					}
				}
				
			}
			
		}
		
	}

