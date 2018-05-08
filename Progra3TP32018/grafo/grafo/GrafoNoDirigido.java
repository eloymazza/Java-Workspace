package grafo;

import java.util.HashMap;

import nodeList.NodeList;

public class GrafoNoDirigido extends GrafoDirigido{

	public GrafoNoDirigido(){
		cantV = 0;
		cantA = 0;
		vertices = new NodeList();
		mapaAdyacencias = new HashMap<Integer,NodeList>();
	}
	
	
	@Override
	protected void agregarArista(Integer idVertOrigen, Arista arista) {
		
		Integer idDestino = arista.getDestino();
		
		if(vertices.contains(idVertOrigen) && vertices.contains(idDestino)){
			Arista nuevaArista = new Arista(idVertOrigen);
			mapaAdyacencias.get(idVertOrigen).insertAtEnd(arista);
			mapaAdyacencias.get(idDestino).insertAtEnd(nuevaArista);
		}
		
	}
	
	
	
}
