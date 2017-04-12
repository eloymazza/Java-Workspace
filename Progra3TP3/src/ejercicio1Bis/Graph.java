package ejercicio1Bis;

import java.util.ArrayList;

import ejercicio1.NodeList;

public abstract class Graph {
	
	ArrayList<Vertex> vertexes;
	NodeList []adjacents;
	int cantVertexes;
	
	public Graph(int cantVertexes){
		
		this.cantVertexes = cantVertexes;
		adjacents = new NodeList[cantVertexes];
		vertexes = new ArrayList <Vertex>();
		
		for (int i = 0; i < cantVertexes; i++) {
			vertexes.add(new Vertex(i));
		}

	}
	
	// Pregutna si el grafo no tiene vertices
	public boolean isEmpty(){	
		return cantVertexes == 0;	
	}
	
	// Comprueba si la arista ya existe
	public boolean hasEdge(int origin, int destination){	
		return adjacents[origin].contains(destination);	
	}
	
	// Retorna la cantidad total de vertices del grafo
	public int getCantVertexes(){
		return cantVertexes;
	}
	
	// Retorna los vertices del grafo
	public ArrayList<Vertex> getVertexes() {
		return vertexes;
	}
	
	// Retorna los adjacentes del grafo
	public NodeList[] getAdjacentList() {
		return adjacents;
	}
	// Agrega un adjacente a determinado vertice. Cambia segun si el grafo es Dirigido o no
	public abstract void addAdjacent(int origin, int destination);


	
}
