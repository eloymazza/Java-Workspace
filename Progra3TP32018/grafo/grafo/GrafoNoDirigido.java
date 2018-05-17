package grafo;

import java.util.*;



public class GrafoNoDirigido extends GrafoDirigido{

	public GrafoNoDirigido(){
		cantV = 0;
		cantA = 0;
		vertices = new LinkedList<Vertice>();
		mapaAdyacencias = new HashMap<Integer,LinkedList<Arista>>();
	}
	
	
	@Override
	protected void agregarArista(Integer idVertOrigen, Arista arista) {
		
		Integer idDestino = arista.getDestino();
		
		if(vertices.contains(idVertOrigen) && vertices.contains(idDestino)){
			Arista nuevaArista = new Arista(idVertOrigen);
			mapaAdyacencias.get(idVertOrigen).add(arista);
			mapaAdyacencias.get(idDestino).add(nuevaArista);
		}
		
	}

	
	
}
