package grafo;
import java.util.HashMap;

import nodeList.*;

public abstract class Grafo {
	
	protected Integer cantV;
	protected Integer cantA;
	protected NodeList vertices;
	protected HashMap<Integer,NodeList> mapaAdyacencias; 
	
	protected  Integer getCantV(){
		return cantV;
	}
	protected Integer cantA(){
		return cantA;
	}
	protected  NodeList getVertices(){
		return vertices;
	}
	protected void agregarVertice(Vertice nuevoVertice){
		vertices.insertAtEnd(nuevoVertice);
	}
	
	protected abstract void agregarArista(Integer idVertOrigen, Arista arista);
	protected abstract Vertice obtenerVertice(Integer idVert);
	protected abstract boolean existeArista(Integer vertOrigenID, Integer vertFinID);
	protected abstract NodeList obtenerAdyacentes(Integer idVert);

	
}
