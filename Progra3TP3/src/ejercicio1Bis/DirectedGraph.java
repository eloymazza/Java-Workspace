package ejercicio1Bis;

import java.util.*;

import ejercicio1.NodeList;

public class DirectedGraph extends Graph {

	public DirectedGraph(int cantVertexes) {
		super(cantVertexes);
	}
	
	// Agrega un adjacente al vertice indicado
	public void addAdjacent(int origin, int destination) {

		int length = adjacents.length;
		if( (origin < length && origin >= 0) && (destination < length && destination >= 0)){

			if(adjacents[origin] == null){
				adjacents[origin] = new NodeList();
			}
			if(!hasEdge(origin, destination)){
				adjacents[origin].insertAtEnd(destination);		
			}
		}

	}
	
	// Imprime lista de adjacencia
	public String toString(){
		if(!isEmpty()){
			String aux = "";
			for (int i = 0; i < cantVertexes; i++) {
				aux += "Nodo " + i + ": " + adjacents[i] + "\n" ;
			}
			return aux;			
		}
		return null;
	}

	public static void main(String[] args) {

		Graph g = new DirectedGraph(8);

		g.addAdjacent(0, 3);
		g.addAdjacent(0, 4);
		g.addAdjacent(3, 2);
		g.addAdjacent(3, 1);
		g.addAdjacent(4, 7);
		g.addAdjacent(4, 5);
		g.addAdjacent(4, 3);
		g.addAdjacent(5, 6);
		g.addAdjacent(7, 6);
		
		System.out.println(g.toString());
		
		DFS dfs = new DFS(g);
		
		System.out.println(dfs.search(g));

	}


}
