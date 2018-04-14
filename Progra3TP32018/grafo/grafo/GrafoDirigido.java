package grafo;

import java.util.*;

import nodeList.NodeList;

public class GrafoDirigido extends Grafo{
	
	
	public GrafoDirigido(){
		cantV = 0;
		cantA = 0;
		vertices = new NodeList();
		mapaAdyacencias = new HashMap<Integer,NodeList>();
	}
	
	protected void agregarArista(Integer idVertOrigen,  Arista arista){	
		
		if(!mapaAdyacencias.containsKey(idVertOrigen)){
			NodeList listaNueva = new NodeList();
			listaNueva.insertAtEnd(arista);
			mapaAdyacencias.put(idVertOrigen, listaNueva);
		}
		else{
			mapaAdyacencias.get(idVertOrigen).insertAtEnd(arista);
		}
		cantA++;
	}
	
	// Mejor hacerlo con iterator
	protected Vertice obtenerVertice(Integer idVert) {
		
		Vertice currentV;
		for (int i = 0; i < cantV; i++) {
			currentV = ((Vertice) vertices.getElementAt(i));
			if(idVert == currentV.getID()){
				return currentV;
			}
		}
		return null;
	}
	@Override
	protected boolean existeArista(Integer vertOrigenID, Integer vertFinID) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected NodeList obtenerAdyacentes(Integer idVert) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
