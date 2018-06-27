package ConexionPcs;

import java.util.HashMap;
import java.util.LinkedList;

import grafo.*;

public class Conexion {
	
	HashMap<Integer, State> visitados;
	Integer pcInicio;
	Integer pcDestino;
	Integer roto;
	GrafoDirigido g;
	
	public Conexion(GrafoDirigido g, Integer a, Integer b){
		this.g = g;
		pcInicio = a;
		pcDestino = b;
		
	}
	
	public LinkedList<Integer> getConexion(Integer roto){
		
		this.roto = roto;
		visitados = new HashMap<Integer, State>();
		LinkedList<Integer> camino = new LinkedList<Integer>(); 
		return conectar(pcInicio,camino);
		
	}


	private LinkedList<Integer> conectar(Integer actual, LinkedList<Integer> camino) {
		
		visitados.put(actual, State.visiting);
		camino.add(actual);
		if(actual.equals(pcDestino)){
			return camino;
		}
		else{
			LinkedList<Arista> adyacentes = g.obtenerAdyacentes(actual);
			Integer destino;
			LinkedList<Integer> conexion;
			for (Arista ady : adyacentes) {
				destino = ady.getDestino();
				if(!destino.equals(roto) && visitados.get(destino) == null || visitados.get(destino) == State.unvisited ){
					conexion = conectar(destino, camino);
					if(conexion != null){
						return conexion;
					}
				}
			}
		}
		visitados.put(actual, State.visited);
		camino.remove(actual);
		return null;
	}

	public static void main(String[] args) {
		
		GrafoDirigido g = new GrafoDirigido();

		
		g.agregarVertice(0);
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		
		g.agregarArista(0, 1);
		g.agregarArista(0, 2);
		g.agregarArista(0, 3);
		g.agregarArista(2, 1);
		g.agregarArista(3, 2);
		g.agregarArista(3, 4);
		
		Conexion c = new Conexion(g,0,4);
		System.out.println(c.getConexion(1));
	}
}
